package com.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Author {
    //Fields
    private int authorId;
    private String authorName;
    private String country;
    private java.sql.Date birthDate;
    private int numberOfPublications;

    // Constructors

    // Parameterized constructor to create an Author object with specified values.
    public Author(String authorName, String country, String birthDate, int numberOfPublications) {
        this.authorName = authorName;
        this.country = country;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = dateFormat.parse(birthDate);
            this.birthDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the ParseException as needed
        }
        this.numberOfPublications = numberOfPublications;
    }

    public Author() {
        // Default constructor with no arguments
    }

    // Getter and Setter methods for accessing and modifying details of Authors table

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Formats and returns the birthDate in "yyyy-MM-dd" format.
    public String getFormattedBirthDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(birthDate);
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getNumberOfPublications() {
        return numberOfPublications;
    }

    public void setNumberOfPublications(int numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }
}