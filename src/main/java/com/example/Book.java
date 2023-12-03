package com.example;

public class Book  {
    // Fields
    private int bookId;
    private String title;
    private String isbn;
    private String edition;
    private int authorId;
    private Author author;
    private String genre;
    private double price;
    private int stockQuantity;

    // Constructors

    // Parameterized constructor to create a Book object with specified values.
    public Book(String title, String isbn, String edition, int authorId, String genre, double price, int stockQuantity) {
        this.title = title;
        this.isbn = isbn;
        this.edition = edition;
        this.authorId = authorId;
        this.genre = genre;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Book() {
        // Default constructor with no arguments
    }

    // Getter and Setter methods for accessing and modifying details of Books table
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

     // Returns the associated Author object
    public Author getAuthor() {
        return author;
    }

    // Sets the associated Author object.
    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}