package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Retrieve extends Operations {

    
    //Retrieves all books along with their authors from the database.
    //@return List of Book objects.
     
    public List<Book> retrieveAllBooks() {
        List<Book> books = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT bookid, title, isbn, edition, author, genre, price, stockquantity, authorname FROM books JOIN authors ON books.author = authors.authorid";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {
                while (resultSet.next()) {
                    Book book = new Book();
                    Author author = new Author();
                    author.setAuthorId(resultSet.getInt("author"));
                    author.setAuthorName(resultSet.getString("authorname"));

                    // Order order = new Order();
                    book.setBookId(resultSet.getInt("bookid"));
                    book.setTitle(resultSet.getString("title"));
                    book.setIsbn(resultSet.getString("isbn"));
                    book.setEdition(resultSet.getString("edition"));
                    book.setAuthor(author); // Set the Author object
                    book.setGenre(resultSet.getString("genre"));
                    book.setPrice(resultSet.getDouble("price"));
                    book.setStockQuantity(resultSet.getInt("stockquantity"));

                    books.add(book);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return books;
    }

     /* Retrieves orders for a given book ID from the database.
     * @param bookId The ID of the book to retrieve orders for.
     * @return List of Order objects.
     */

    public List<Order> retrieveOrdersByBookId(int bookId) {
    List<Order> orders = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String selectQuery = "SELECT * FROM orders WHERE bookid = ?";

        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, bookId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setOrderId(resultSet.getInt("orderid"));
                    order.setBookId(resultSet.getInt("bookid"));
                    order.setCustomerId(resultSet.getInt("customerid"));
                    order.setOrderDate(resultSet.getDate("orderdate"));
                    order.setNumberOfOrderedBooks(resultSet.getInt("numberoforderedbook"));
                    order.setTotalAmount(resultSet.getDouble("totalamount"));

                    orders.add(order);
                }
            }
        }
    } catch (SQLException e) {
        handleSQLException(e);
    }

    return orders;
    }


    /*
     * Retrieves all authors from the database.
     * @return List of Author objects.
     */

    public List<Author> retrieveAllAuthors() {
        List<Author> authors = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM authors";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {
                while (resultSet.next()) {
                    Author author = new Author();
                    author.setAuthorId(resultSet.getInt("authorid"));
                    author.setAuthorName(resultSet.getString("authorname"));
                    author.setCountry(resultSet.getString("country"));
                    author.setBirthDate(resultSet.getDate("birthdate"));
                    author.setNumberOfPublications(resultSet.getInt("numberofpublications"));

                    authors.add(author);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return authors;

    }

    /*
     * Retrieves all customers from the database.
     * @return List of Customer objects.
     */

    public List<Customer> retrieveAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM customers";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerId(resultSet.getInt("customerid"));
                    customer.setCustomerName(resultSet.getString("customername"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setPhoneNumber(resultSet.getString("phonenumber"));

                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return customers;
    }

    /*
     * Retrieves all orders from the database.
     * @return List of Order objects.
     */    
    
        public List<Order> retrieveAllOrders() {

        List<Order> orders = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM orders";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setOrderId(resultSet.getInt("orderid"));
                    order.setBookId(resultSet.getInt("bookid"));
                    order.setCustomerId(resultSet.getInt("customerid"));
                    order.setOrderDate(resultSet.getDate("orderdate"));
                    order.setNumberOfOrderedBooks(resultSet.getInt("numberoforderedbook"));
                    order.setTotalAmount(resultSet.getDouble("totalamount"));

                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return orders;
    }
}