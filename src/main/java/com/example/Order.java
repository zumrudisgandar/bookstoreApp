package com.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Order {
    // Fields
    private int orderId;
    private int bookId;
    private int customerId;
    private java.sql.Date orderDate;
    private int numberOfOrderedBooks;
    private double totalAmount;

    // Constructors

    // Parameterized constructor to create an Order object with specified values.
    
    public Order(int bookId, int customerId, String orderDate, int numberOfOrderedBooks) {
        this.bookId = bookId;
        this.customerId = customerId;
         // Convert the String representation of the date to a Date object
         try {
            SimpleDateFormat dateFormatOrder = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = dateFormatOrder.parse(orderDate);
            this.orderDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the ParseException as needed
        }
        this.numberOfOrderedBooks = numberOfOrderedBooks;
        this.totalAmount = calculateTotalAmount();    
    }

    // Returns a formatted string representation of the Order object.
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Order ID: " + orderId +
               ", Book ID: " + bookId +
               ", Customer ID: " + customerId +
               ", Order Date: " + dateFormat.format(orderDate) +
               ", Number of Ordered Books: " + numberOfOrderedBooks +
               ", Total Amount: " + totalAmount;
    }

    public Order() {
        // Default constructor with no arguments
    }

    // Getter and Setter methods for accessing and modifying details of Orders table

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Formats and returns the orderDate in "yyyy-MM-dd" format.
    public String getOrderDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(orderDate);
    }

    public void setOrderDate(java.sql.Date orderDate) {
        this.orderDate = orderDate;
    }


    public int getNumberOfOrderedBooks() {
        return numberOfOrderedBooks;
    }

    public void setNumberOfOrderedBooks(int numberOfOrderedBooks) {
        this.numberOfOrderedBooks = numberOfOrderedBooks;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Method to calculate totalAmount based on bookId and numberOfOrderedBooks
    private double calculateTotalAmount() {
        double bookPrice = fetchBookPriceFromDatabase(bookId);
        return bookPrice * numberOfOrderedBooks;
    }
    
    // Implement this method to fetch the book price from the database based on bookId
    private double fetchBookPriceFromDatabase(int bookId) {
        return 0.0;
    }
}