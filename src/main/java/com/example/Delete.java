package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends Operations {

    // Delete method for Book entity
    public void deleteBook(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Define delete query for books
            String deleteQuery = "DELETE FROM books WHERE bookid = ?";
    
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                // Set the parameter value for bookid
                preparedStatement.setInt(1, book.getBookId());
    
                // Execute the delete query
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the result and print appropriate message
                if (rowsAffected > 0) {
                    System.out.println("Book deleted successfully!");
                } else {
                    System.out.println("Failed to delete book. Book ID not found.");
                }
            }
        // Handle SQL exception
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // Delete method for Author entity
    public void deleteAuthor(Author author) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Define delete query for authors
            String deleteQuery = "DELETE FROM authors WHERE authorid = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                // Set the parameter value for authorid
                preparedStatement.setInt(1, author.getAuthorId());

                // Execute the delete query
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the result and print appropriate message
                if (rowsAffected > 0) {
                    System.out.println("Author deleted successfully!");
                } else {
                    System.out.println("Failed to delete author. Author ID not found.");
                }
            }
        } catch (SQLException e) {
            // Handle SQL exception
            handleSQLException(e);
        }
    }

    // Delete method for Customer entity
    public void deleteCustomer(Customer customer) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String deleteQuery = "DELETE FROM customers WHERE customerid = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, customer.getCustomerId());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Customer deleted successfully!");
                } else {
                    System.out.println("Failed to delete customer. Customer ID not found.");
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // Delete method for Order entity
    public void deleteOrder(Order order) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String deleteQuery = "DELETE FROM orders WHERE orderid = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, order.getOrderId());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Order deleted successfully!");
                } else {
                    System.out.println("Failed to delete order. Order ID not found.");
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }
}