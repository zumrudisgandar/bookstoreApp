package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

public class Transaction extends Operations {

    private static final Scanner scanner = new Scanner(System.in);

    // Create (Insert) operation Orders
    public void insertOrderTransaction() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Disable auto-commit to start a transaction
            connection.setAutoCommit(false);

            // Get user input for order details
            System.out.println("Enter Order Details:");
            System.out.print("Book ID: ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Order Date (YYYY-MM-DD): ");
            String orderDate = scanner.nextLine();
            System.out.print("Number of Ordered Books: ");
            int numberOfOrderedBooks = scanner.nextInt();

            // Fetch the price of the book
            double price = fetchBookPrice(connection, bookId);

            // Check if there are enough books in the inventory
            if (areEnoughBooksAvailable(connection, bookId, numberOfOrderedBooks)) {
                // Insert into Orders
                String insertOrderQuery = "INSERT INTO orders (bookid, customerid, orderdate, numberoforderedbook, totalamount) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement orderStatement = connection.prepareStatement(insertOrderQuery, Statement.RETURN_GENERATED_KEYS)) {
                    java.sql.Date sqlDateOrder = convertStringToDate(orderDate);

                    orderStatement.setInt(1, bookId);
                    orderStatement.setInt(2, customerId);
                    orderStatement.setDate(3, sqlDateOrder);
                    orderStatement.setInt(4, numberOfOrderedBooks);

                    // Calculate total amount dynamically
                    double totalAmount = price * numberOfOrderedBooks;
                    orderStatement.setDouble(5, totalAmount);

                    int rowsAffectedOrder = orderStatement.executeUpdate();

                    if (rowsAffectedOrder > 0) {
                        System.out.println("Order inserted successfully!");

                        // Update the Books table
                        updateBooksInventory(connection, bookId, numberOfOrderedBooks);

                        // Commit the transaction
                        connection.commit();
                    } else {
                        System.out.println("Failed to insert order.");
                        // Rollback the transaction if insertion fails
                        connection.rollback();
                    }
                }
            } else {
                System.out.println("Not enough books available in the inventory.");
                // Rollback the transaction if there are not enough books
                connection.rollback();
            }
        } catch (SQLException | ParseException e) {
            handleSQLException(e);
        }
    }

    // Fetch the price of the book
    private double fetchBookPrice(Connection connection, int bookid) throws SQLException {
        String selectQuery = "SELECT price FROM books WHERE bookid = ?";
        try (PreparedStatement priceStatement = connection.prepareStatement(selectQuery)) {
            priceStatement.setInt(1, bookid);
            try (ResultSet resultSet = priceStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("price");
                }
            }
        }
        return 0; // Default value if price is not found
    }

    // Check if there are enough books available in the inventory
    private boolean areEnoughBooksAvailable(Connection connection, int bookid, int numberoforderedbook) throws SQLException {
        String selectQuery = "SELECT stockquantity FROM books WHERE bookid = ?";
        try (PreparedStatement stockStatement = connection.prepareStatement(selectQuery)) {
            stockStatement.setInt(1, bookid);
            try (ResultSet resultSet = stockStatement.executeQuery()) {
                if (resultSet.next()) {
                    int stockQuantity = resultSet.getInt("stockquantity");
                    return stockQuantity >= numberoforderedbook;
                }
            }
        }
        return false;
    }

    // Update the Books table to reduce the stock quantity after placing an order
    private void updateBooksInventory(Connection connection, int bookid, int numberoforderedbook) throws SQLException {
        String updateQuery = "UPDATE books SET stockquantity = stockquantity - ? WHERE bookid = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setInt(1, numberoforderedbook);
            updateStatement.setInt(2, bookid);
            updateStatement.executeUpdate();
        }
    }
}
