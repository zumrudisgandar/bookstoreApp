package com.example;

public class Customer {
    //Fields
    private int customerId;
    private String customerName;
    private String email;
    private String phoneNumber;

    // Constructors
    // Parameterized constructor to create an Customer object with specified values.
    public Customer(String customerName, String email, String phoneNumber) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
        // Default constructor with no arguments
    }
    
    // Getter and Setter methods for accessing and modifying details of Customers table

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}