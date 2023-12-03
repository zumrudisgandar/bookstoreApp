package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update extends Operations {

    // Update method for Book entity
    public void updateBook(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String updateQuery = "UPDATE books SET price = ? WHERE bookid = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setDouble(1, book.getPrice());
                preparedStatement.setInt(2, book.getBookId());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Book updated successfully!");
                } else {
                    System.out.println("Failed to update book.");
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // Update method for Author entity
    public void updateAuthor(Author author) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String updateQuery = "UPDATE authors SET numberofpublications = ? WHERE authorid = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, author.getNumberOfPublications());
                preparedStatement.setInt(2, author.getAuthorId());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Author updated successfully!");
                } else {
                    System.out.println("Failed to update author.");
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // Update method for Customer entity
    public void updateCustomer(Customer customer) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String updateQuery = "UPDATE customers SET phonenumber = ? WHERE customerid = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, customer.getPhoneNumber());
                preparedStatement.setInt(2, customer.getCustomerId());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Customer updated successfully!");
                } else {
                    System.out.println("Failed to update customer.");
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // Update method for Order entity
    public void updateOrder(Order order) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String updateQuery = "UPDATE orders SET customerid = ? WHERE orderid = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, order.getCustomerId());
                preparedStatement.setInt(2, order.getOrderId());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Order updated successfully!");
                } else {
                    System.out.println("Failed to update order.");
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }
}