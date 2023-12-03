package com.example;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Operations {

    // JDBC URL, username, and password of PostgreSQL server
    protected static final String URL = "jdbc:postgresql://localhost:5432/bookstore";
    protected static final String USER = "postgres";
    protected static final String PASSWORD = "zumrud";

    /**
     * Converts a string representation of a date to a java.sql.Date object.
     * @param dateString String representing a date in "yyyy-MM-dd" format.
     * @return java.sql.Date object representing the parsed date.
     * @throws ParseException If the parsing of the date string fails.
     */

    // Common methods related to database operations (if needed)
    protected static java.sql.Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = dateFormat.parse(dateString);
        return new java.sql.Date(parsedDate.getTime());
    }

    /**
     * Handles SQLException by printing error information.
     * @param e Exception representing the SQLException.
     */

    protected static void handleSQLException(Exception e) {
        System.err.println("SQLException: " + e.getMessage());
        System.err.println("SQLState: " + ((SQLException) e).getSQLState());
        System.err.println("VendorError: " + ((SQLException) e).getErrorCode());
    }
}