package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

public class Insert extends Operations {
    // Insert method for Book entity
    public void insertBook(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Define insert query for books
            String insertQuery = "INSERT INTO books (title, isbn, edition, author, genre, price, stockquantity) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set parameters for the book
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getIsbn());
                preparedStatement.setString(3, book.getEdition());
                preparedStatement.setInt(4, book.getAuthorId());
                preparedStatement.setString(5, book.getGenre());
                preparedStatement.setDouble(6, book.getPrice());
                preparedStatement.setInt(7, book.getStockQuantity());

                 // Execute the insert query
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the result and print appropriate message
                if (rowsAffected > 0) {
                    System.out.println("Book inserted successfully!");
                } else {
                    System.out.println("Failed to insert book.");
                }
            }
        } catch (SQLException e) {
             // Handle SQL exception
            handleSQLException(e);
        }
    }

    // Insert method for Author entity
    public void insertAuthor(Author author) {
        try {
            // Convert formatted birth date string to SQL date
            String birthDateString = author.getFormattedBirthDate();
            java.sql.Date sqlDate = Operations.convertStringToDate(birthDateString);
           
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                // Define insert query for authors
                String insertQuery = "INSERT INTO authors (authorname, country, birthdate, numberofpublications) VALUES (?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set parameters for the author
                    preparedStatement.setString(1, author.getAuthorName());
                    preparedStatement.setString(2, author.getCountry());
                    preparedStatement.setDate(3, sqlDate);
                    preparedStatement.setInt(4, author.getNumberOfPublications());

                    // Execute the insert query
                    int rowsAffected = preparedStatement.executeUpdate();

                    // Check the result and print appropriate message
                    if (rowsAffected > 0) {
                        System.out.println("Author inserted successfully!");
                    } else {
                        System.out.println("Failed to insert author.");
                    }
                }
            }
        } catch (SQLException | ParseException e) {
            // Handle SQL exception or date parsing exception
            handleSQLException(e);
        }
    }

    // Insert method for Customer entity
    public void insertCustomer(Customer customer) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Define insert query for customers
            String insertQuery = "INSERT INTO customers (customername, email, phonenumber) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set parameters for the customer
                preparedStatement.setString(1, customer.getCustomerName());
                preparedStatement.setString(2, customer.getEmail());
                preparedStatement.setString(3, customer.getPhoneNumber());

                // Execute the insert query
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the result and print appropriate message
                if (rowsAffected > 0) {
                    System.out.println("Customer inserted successfully!");
                } else {
                    System.out.println("Failed to insert customer.");
                }
            }
        } catch (SQLException e) {
            // Handle SQL exception
            handleSQLException(e);
        }
    }

    // Insert method for Order entity
    public void insertOrder(Order order) {
        try {
            // Convert order date string to SQL date
            String orderDateString = order.getOrderDate();
            java.sql.Date sqlDateOrder = Operations.convertStringToDate(orderDateString);
    
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        // Define insert query for orders
        String insertQuery = "INSERT INTO orders (bookid, customerid, orderdate, numberoforderedbook, totalamount) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
           // Set parameters for the order
            preparedStatement.setInt(1, order.getBookId());
            preparedStatement.setInt(2, order.getCustomerId());
            preparedStatement.setDate(3, sqlDateOrder);
            preparedStatement.setInt(4, order.getNumberOfOrderedBooks());
            preparedStatement.setDouble(5, order.getTotalAmount());

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check the result and print appropriate message
            if (rowsAffected > 0) {
                System.out.println("Order inserted successfully!");
            } else {
                System.out.println("Failed to insert order.");
            }
        }
    }
    } catch (SQLException | ParseException e) {
        // Handle SQL exception or date parsing exception
        handleSQLException(e);
    } 
    }
}