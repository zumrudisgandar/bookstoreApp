Setting Up and Running the Application

1.	Clone the Repository:
•	Clone the repository to your local machine using the following command:
•	git clone <repository-url> 

2.	Database Configuration:
•	Make sure you have a compatible relational database installed (e.g., PostgreSQL).
•	Set up the database by executing the SQL script provided in the “zumrud_isgandarli_assignment2_sqlqueries.DOCX”  file. This script includes the necessary table structures and initial data.
3.	JDBC Connection Configuration:
•	Open the config.properties file in the src/main/resources directory.
•	Update the URL, USER, and PASSWORD properties to match your database configuration.

4.	Compile and Build:
•	Build the project using your IDE or a build tool like Maven.

5.	Run the Application:
•	Run the Main class in the com.example package. This class contains the main method to start the application.

6.	Navigate Through the Application:
•	The application provides a console-based menu system.
•	Choose operations by entering the corresponding number:
•	Enter “1” to retrieve data from tables (Books, Authors, Customers, Orders).
•	Enter “2” to insert new records into tables (Books, Authors, Customers, Orders).
•	Enter “3” to update existing records in tables (Books, Authors, Customers, Orders).
•	Enter “4” to delete records from tables (Books, Authors, Customers, Orders).
•	Enter “5” to view metadata about the database tables.
•	Enter “0” to exit the application.


7.	Retrieve Operations:
•	Choose option 1 to retrieve data from tables:
•	Enter “1” to retrieve books.
•	Enter “2” to retrieve orders using a book ID.
•	Enter “3” to retrieve authors.
•	Enter “4” to retrieve customers.
•	Enter “5” to retrieve all orders.
•	Enter “0” to go back to the main menu.


8.	Insert Operations:
•	Choose option “2” to insert new records into tables:
•	Enter “1” to insert a new book.
•	Enter “2” to insert a new author.
•	Enter “3” to insert a new customer.
•	Enter “4” to insert a new order (TRANSACTION PROCESS IS INSIDE OF THIS OPERATION).
•	Enter “0” to go back to the main menu.

Fill required attribute information to insert new record to the tables.

9.	Update Operations:

•	Choose option “3” to update existing records in tables:
•	Enter “1” to update a book's price.
•	Enter “2” to update an author's number of publications.
•	Enter “3” to update a customer's phone number.
•	Enter “4” to update an order's customer ID.
•	Enter “0” to go back to the main menu.


10.	Delete Operations:
•	Choose option “4” to delete records from tables:
•	Enter “1” to delete a book.
•	Enter “2” to delete an author.
•	Enter “3” to delete a customer.
•	Enter “4” to delete an order.
•	Enter “0” to go back to the main menu.

11.	Metadata Operation:
•	Choose option “5” to view metadata about the database tables.

12.	Exiting the Application:
•	Enter “0” to exit the application when you are done.


13.	Note:
•	Ensure that your database server is running before executing the application.
•	The application uses JDBC for database connectivity.
•	Make sure to insert appropriate inputs in each step; especially, use existing values while inserting, updating, and deleting records.

14.	Enjoy using the Bookstore Management System!
Note: The above instructions assume a basic familiarity with Java, databases, and development environments.

