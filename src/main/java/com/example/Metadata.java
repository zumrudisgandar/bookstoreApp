package com.example;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metadata extends Operations {


    // Displays information about the tables in the database, including columns, primary keys, and foreign keys.
    public static void displayTableInfo() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            DatabaseMetaData metaData = connection.getMetaData();

            // Display information for each entity (table)
            displayTableInfoForEntity(metaData, "books");
            displayTableInfoForEntity(metaData, "authors");
            displayTableInfoForEntity(metaData, "customers");
            displayTableInfoForEntity(metaData, "orders");

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

     /**
     * Displays detailed information about a specific table, including columns, primary keys, and foreign keys.
     * @param metaData  DatabaseMetaData object for the database connection.
     * @param tableName Name of the table to display information for.
     */

    private static void displayTableInfoForEntity(DatabaseMetaData metaData, String tableName) {
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            // Display general table information
            System.out.println("Table Name: " + tableName);
            displayColumnsInfo(columns);
            displayPrimaryKeysInfo(metaData, tableName);
            displayForeignKeysInfo(metaData, tableName);
            System.out.println("-----------------------------");
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    /**
     * Displays information about the columns of a table, including column name, type, and size.
     * @param columns ResultSet containing column information.
     */

    private static void displayColumnsInfo(ResultSet columns) {
        try {
            System.out.println("Columns:");
            // Display information for each column
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                int columnSize = columns.getInt("COLUMN_SIZE");

                System.out.println("  - Name: " + columnName + ", Type: " + columnType + ", Size: " + columnSize);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    /**
     * Displays information about the primary keys of a table.
     * @param metaData  DatabaseMetaData object for the database connection.
     * @param tableName Name of the table to display primary key information for.
     */

    private static void displayPrimaryKeysInfo(DatabaseMetaData metaData, String tableName) {
        try (ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName)) {
            System.out.println("Primary Keys:");
            // Display information for each primary key
            while (primaryKeys.next()) {
                String primaryKeyColumnName = primaryKeys.getString("COLUMN_NAME");
                System.out.println("  - " + primaryKeyColumnName);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    /**
     * Displays information about the foreign keys of a table.
     * @param metaData  DatabaseMetaData object for the database connection.
     * @param tableName Name of the table to display foreign key information for.
     */

    private static void displayForeignKeysInfo(DatabaseMetaData metaData, String tableName) {
        try (ResultSet foreignKeys = metaData.getImportedKeys(null, null, tableName)) {
            System.out.println("Foreign Keys:");
            // Display information for each foreign key
            while (foreignKeys.next()) {
                String foreignKeyColumnName = foreignKeys.getString("FKCOLUMN_NAME");
                String referencedTableName = foreignKeys.getString("PKTABLE_NAME");
                String referencedColumnName = foreignKeys.getString("PKCOLUMN_NAME");

                System.out.println("  - " + foreignKeyColumnName + " references " + referencedTableName + "(" + referencedColumnName + ")");
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }
}
