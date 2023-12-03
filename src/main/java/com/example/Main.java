package com.example;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main menu
        int mainChoice;
        do {
            printMainMenu();
            mainChoice = scanner.nextInt();
            switch (mainChoice) {
                case 1:
                    // Retrieve operations
                    handleRetrieveMenu(scanner);
                    break;
                case 2:
                    // Insert operations
                    handleInsertMenu(scanner);
                    break;
                case 3:
                    // Update operations
                    handleUpdateMenu(scanner);
                    break;
                case 4:
                    // Delete operations
                    handleDeleteMenu(scanner);
                    break;
                case 5:
                    // Metadata
                    Metadata.displayTableInfo();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (mainChoice != 0);

        scanner.close();
    }

    // Helper method to print the main menu
    private static void printMainMenu() {
        System.out.println("What operation do you want to choose?");
        System.out.println("1 - Retrieve");
        System.out.println("2 - Insert");
        System.out.println("3 - Update");
        System.out.println("4 - Delete");
        System.out.println("5 - Metadata");
        System.out.println("0 - Exit");
        System.out.print("Enter your choice: ");
    }
    // ***************************************************RETRIEVE OPERATIONS***************************************************
    // Helper method to handle the retrieve menu
    private static void handleRetrieveMenu(Scanner scanner) {
        int retrieveChoice = 0;
            printRetrieveMenu();
            retrieveChoice = scanner.nextInt();
            switch (retrieveChoice) {
                case 1:
                    // Retrieve book table
                    retrieveAllBooks();
                    break;
                case 2:
                    // Retrieve order table using bookid
                    handleRetrieveOrdersByBookId(scanner);
                    break;
                case 3:
                    // Retrieve author table
                    retrieveAllAuthors();
                    break;
                case 4:
                    // Retrieve customer table
                    retrieveAllCustomers();
                    break;
                case 5:
                    // Retrieve order table
                    retrieveAllOrders();
                    break;
                case 0:
                    System.out.println("Exiting the Retrieve menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
    }

    // Helper method to print the retrieve menu
    private static void printRetrieveMenu() {
        System.out.println("Which table do you want to retrieve?");
        System.out.println("1 - Book table");
        System.out.println("2 - Order table using bookid");
        System.out.println("3 - Author table");
        System.out.println("4 - Customer table");
        System.out.println("5 - Order table");
        System.out.println("0 - Back to main menu");
        System.out.print("Enter your choice: ");
    }

    private static void handleRetrieveOrdersByBookId(Scanner scanner) {
        Retrieve retrieve = new Retrieve();
        System.out.print("Enter Book ID to retrieve orders: ");
        int bookId = scanner.nextInt();
        // Call the method to retrieve orders by bookid
        List<Order> ordersForBookId = retrieve.retrieveOrdersByBookId(bookId);
        // Print the retrieved orders
        if (ordersForBookId.isEmpty()) {
            System.out.println("No orders found for Book ID: " + bookId);
        } else {
            System.out.println("Orders for Book ID: " + bookId);
            for (Order order : ordersForBookId) {
                System.out.println(order);
            }
        }
        System.out.println("-----------------------------");
    }

    private static void retrieveAllBooks() {
       Retrieve retrieve = new Retrieve();
       List<Book> books = retrieve.retrieveAllBooks();
        for (Book book : books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Edition: " + book.getEdition());
            // Retrieve the Author object from the Book
            Author author = book.getAuthor();
            if (author != null) {
                System.out.println("Author ID: " + author.getAuthorId());
                System.out.println("Author Name: " + author.getAuthorName());
            }
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Stock Quantity: " + book.getStockQuantity());
            System.out.println("-----------------------------");
        }
    }

    private static void retrieveAllAuthors() {
        Retrieve retrieve = new Retrieve();
        List<Author> authors = retrieve.retrieveAllAuthors();
        for (Author author : authors) {
            System.out.println("Author ID: " + author.getAuthorId());
            System.out.println("Author Name: " + author.getAuthorName());
            System.out.println("Country: " + author.getCountry());
            System.out.println("Birth Date: " + author.getFormattedBirthDate());
            System.out.println("Number of Publications: " + author.getNumberOfPublications());
            System.out.println("-----------------------------");
        }
    }

    private static void retrieveAllCustomers() {
        Retrieve retrieve = new Retrieve();
        List<Customer> customers = retrieve.retrieveAllCustomers();
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Customer Name: " + customer.getCustomerName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone Number: " + customer.getPhoneNumber());
            System.out.println("-----------------------------");
        }    
    }

    private static void retrieveAllOrders() {
        Retrieve retrieve = new Retrieve();
        List<Order> orders = retrieve.retrieveAllOrders();
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Book ID: " + order.getBookId());
            System.out.println("Customer ID: " + order.getCustomerId());
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Number of Ordered Books: " + order.getNumberOfOrderedBooks());
            System.out.println("Total Amount: " + order.getTotalAmount());
            System.out.println("-----------------------------");
        }    }

    // ***************************************************INSERT OPERATIONS***************************************************
    // Implement your code for the insert menu here
    private static void handleInsertMenu(Scanner scanner) {
        Transaction transaction = new Transaction();
        int insertChoice;
            printInsertMenu();
            insertChoice = scanner.nextInt();
            scanner.nextLine();
            switch (insertChoice) {
                case 1:
                    insertBookFromUI(scanner);
                    break;
                case 2:
                    insertAuthorFromUI(scanner);
                    break;
                case 3:
                    insertCustomerFromUI(scanner);
                    break;
                case 4:
                    transaction.insertOrderTransaction();
                    break;
                case 0:
                    System.out.println("Exiting the Insert menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

            String answer;    
            System.out.println("Do you want to retrieve the inserted table?");
            answer = scanner.nextLine();
            if ("Yes".equalsIgnoreCase(answer)) {
                handleRetrieveMenu(scanner);
            } else {
                System.out.println("Okay");
            }
            System.out.println("-----------------------------");
    }

    // Helper method to print the insert menu
    private static void printInsertMenu() {
        System.out.println("Which table do you want to insert?");
        System.out.println("1 - Book table");
        System.out.println("2 - Author table");
        System.out.println("3 - Customer table");
        System.out.println("4 - Order table (TRANSACTION PROCESS)");
        System.out.println("0 - Back to main menu");
        System.out.print("Enter your choice: ");
    }

    private static void insertBookFromUI(Scanner scanner) {
        System.out.println("Enter book details:");
        scanner.nextLine(); // Consume the newline character left from previous input
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Edition: ");
        String edition = scanner.nextLine();
        System.out.print("Author ID: ");
        int authorId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Stock Quantity: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        Insert insert = new Insert();
        Book book = new Book(title, isbn, edition, authorId, genre, price, stockQuantity);
        // Inserting new book record
        insert.insertBook(book);    
    }

    private static void insertAuthorFromUI(Scanner scanner) {
        System.out.println("Enter author details:");
        scanner.nextLine();
        System.out.print("Author Name: ");
        String authorName = scanner.nextLine();
        System.out.print("Country: ");
        String country = scanner.nextLine();
        System.out.print("Birth Date (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        System.out.print("Number of Publications: ");
        int numberOfPublications = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Insert insert = new Insert();
        Author author = new Author(authorName, country, birthDate, numberOfPublications);
        insert.insertAuthor(author);
    }

    private static void insertCustomerFromUI(Scanner scanner) {
        System.out.println("Enter customer details:");
        scanner.nextLine();
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Insert insert = new Insert();
        Customer customer = new Customer(customerName, email, phoneNumber);
        insert.insertCustomer(customer);
    }

    // ***************************************************UPDATE OPERATIONS***************************************************
    private static void handleUpdateMenu(Scanner scanner) {
        int updateChoice;
            printUpdateMenu();
            updateChoice = scanner.nextInt();
            scanner.nextLine();
            switch (updateChoice) {
                case 1:
                    updateBook(scanner);
                    break;
                case 2:
                    updateAuthor(scanner);
                    break;
                case 3:
                    updateCustomer(scanner);
                    break;
                case 4:
                    updateOrder(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the Update menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

            String answer;    
            System.out.println("Do you want to retrieve the updated table?");
            answer = scanner.nextLine();
            if ("Yes".equalsIgnoreCase(answer)) {
                handleRetrieveMenu(scanner);
            } else {
                System.out.println("Okay");
            }
            System.out.println("-----------------------------");
    }

    // Helper method to print the insert menu
    private static void printUpdateMenu() {
        System.out.println("Which table do you want to update?");
        System.out.println("1 - Book table");
        System.out.println("2 - Author table");
        System.out.println("3 - Customer table");
        System.out.println("4 - Order table");
        System.out.println("0 - Back to main menu");
        System.out.print("Enter your choice: ");
    }

    private static void updateBook(Scanner scanner) {
        System.out.println("Enter book details to update:");
        System.out.print("Book ID: ");
        int bookId = scanner.nextInt();
        System.out.print("New Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  
        Update update = new Update();
        Book updatedBook = new Book();
        updatedBook.setPrice(price);  
        updatedBook.setBookId(bookId);
        update.updateBook(updatedBook);
    }

    private static void updateAuthor(Scanner scanner) {
        System.out.println("Enter author details to update:");
        System.out.print("Author ID: ");
        int authorId = scanner.nextInt();
        System.out.print("New Number of publications: ");
        int numberOfPublications = scanner.nextInt();
        scanner.nextLine();  
        Update update = new Update();
        Author updatedAuthor = new Author();
        updatedAuthor.setNumberOfPublications(numberOfPublications);
        updatedAuthor.setAuthorId(authorId);
        update.updateAuthor(updatedAuthor);
    }

    private static void updateCustomer(Scanner scanner) {
        System.out.println("Enter customer details to update:");
        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New Phone Number: ");
        String phoneNumber = scanner.nextLine();
        Update update = new Update();
        Customer updatedCustomer = new Customer();
        updatedCustomer.setPhoneNumber(phoneNumber);
        updatedCustomer.setCustomerId(customerId);
        update.updateCustomer(updatedCustomer);
    }

    private static void updateOrder(Scanner scanner) {
        System.out.println("Enter order details to update:");
        System.out.print("Order ID: ");
        int orderId = scanner.nextInt();
        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Update update = new Update();
        Order updatedOrder = new Order();
        updatedOrder.setCustomerId(customerId);
        updatedOrder.setOrderId(orderId);
        update.updateOrder(updatedOrder);
    }

        // ***************************************************DELETE OPERATIONS***************************************************
        private static void handleDeleteMenu(Scanner scanner) {
        int deleteChoice;
            printDeleteMenu();
            deleteChoice = scanner.nextInt();
            scanner.nextLine();
            switch (deleteChoice) {
                case 1:
                    deleteBook(scanner);
                    break;
                case 2:
                    deleteAuthor(scanner);
                    break;
                case 3:
                    deleteCustomer(scanner);
                    break;
                case 4:
                    deleteOrder(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the Delete menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

            String answer;    
            System.out.println("Do you want to retrieve the deleted table?");
            answer = scanner.nextLine();
            if ("Yes".equalsIgnoreCase(answer)) {
                handleRetrieveMenu(scanner);
            } else {
                System.out.println("Okay");
            }
            System.out.println("-----------------------------");
    }

    // Helper method to print the insert menu
    private static void printDeleteMenu() {
        System.out.println("From which table do you want to delete?");
        System.out.println("1 - Book table");
        System.out.println("2 - Author table");
        System.out.println("3 - Customer table");
        System.out.println("4 - Order table");
        System.out.println("0 - Back to main menu");
        System.out.print("Enter your choice: ");
    }

    private static void deleteBook(Scanner scanner) {
        Delete delete = new Delete();
        System.out.print("Enter Book ID to delete: ");
        int bookIdToDelete = scanner.nextInt();
        scanner.nextLine();
        Book bookToDelete = new Book();
        bookToDelete.setBookId(bookIdToDelete);
        delete.deleteBook(bookToDelete);
    }

    private static void deleteAuthor(Scanner scanner) {
        Delete delete = new Delete();
        System.out.print("Enter Author ID to delete: ");
        int authorIdToDelete = scanner.nextInt();
        scanner.nextLine();
        Author authorToDelete = new Author();
        authorToDelete.setAuthorId(authorIdToDelete);
        delete.deleteAuthor(authorToDelete);
    }

    private static void deleteCustomer(Scanner scanner) {
        Delete delete = new Delete();
        System.out.print("Enter Customer ID to delete: ");
        int customerIdToDelete = scanner.nextInt();
        scanner.nextLine();
        Customer customerToDelete = new Customer();
        customerToDelete.setCustomerId(customerIdToDelete);
        delete.deleteCustomer(customerToDelete);
    }

    private static void deleteOrder(Scanner scanner) {
        Delete delete = new Delete();
        System.out.print("Enter Order ID to delete: ");
        int orderIdToDelete = scanner.nextInt();
        scanner.nextLine();
        Order orderToDelete = new Order();
        orderToDelete.setOrderId(orderIdToDelete);
        delete.deleteOrder(orderToDelete);
    }
}