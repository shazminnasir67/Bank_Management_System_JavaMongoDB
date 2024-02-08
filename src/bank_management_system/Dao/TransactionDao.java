package bank_management_system.Dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class TransactionDao {
    private MongoDatabase mongoDatabase;

    public TransactionDao() {
        this.mongoDatabase = DatabaseConnection.getConnection();
    }

    public void extractTransactionsIntoTable(JTable table) {
        MongoCollection<Document> transactionsCollection = mongoDatabase.getCollection("transaction");

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data in the table

        transactionsCollection.find().forEach((Consumer<Document>) document -> {
            int transactionID = document.getInteger("TransactionID");
            int accountNumber = document.getInteger("AccountNumber");
            String transactionType = document.getString("TransactionType");
            double amount = document.getDouble("Amount");
            Date dateAndTime = document.getDate("DateAndTime");
            int accountFrom = document.getInteger("AccountFrom");
            int accountTo = document.getInteger("AccountTo");
            String transactionStatus = document.getString("TransactionStatus");
            String transactionCategory = document.getString("TransactionCategory");

            model.addRow(new Object[]{
                    transactionID, accountNumber, transactionType, amount, transactionStatus,
                    accountFrom, accountTo, dateAndTime, transactionCategory
            });
        });
    }

    public void searchTransactions(JTable table, int searchField, String searchValue) {
        MongoCollection<Document> transactionsCollection = mongoDatabase.getCollection("transaction");

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data in the table

        String fieldName;
        switch (searchField) {
            case 0: // Search by ID
                fieldName = "TransactionID";
                break;
            case 1: // Search by Account ID
                fieldName = "AccountNumber";
                break;
            case 2: // Search by Status
                fieldName = "TransactionStatus";
                break;
            case 3: // Search by Category
                fieldName = "TransactionCategory";
                break;
            default:
                // Handle the case for an invalid searchField value
                return;
        }

        Document query;
        if (fieldName.equals("TransactionID") || fieldName.equals("AccountNumber")) {
            // If searching by numeric fields, parse the searchValue as an integer
            try {
                int fieldValue = Integer.parseInt(searchValue);
                query = new Document(fieldName, fieldValue);
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid integer
                System.err.println("Invalid numeric field format");
                return;
            }
        } else {
            // For non-numeric fields, treat as a string
            query = new Document(fieldName, searchValue);
        }

        // Print debug information
        System.out.println("Search Field: " + fieldName);
        System.out.println("Search Value: " + searchValue);
        System.out.println("Query: " + query.toJson());

        System.out.println("Before loop");

        transactionsCollection.find(query).forEach((Consumer<Document>) document -> {
            System.out.println("Inside loop");

            // Print debug information for each document
            System.out.println("Found document: " + document.toJson());

            int transactionID = document.getInteger("TransactionID");
            int accountNumber = document.getInteger("AccountNumber");
            String status = document.getString("TransactionStatus");
            String category = document.getString("TransactionCategory");
            double amount = document.getDouble("Amount");
            String transactionType = document.getString("TransactionType");

            // Format date and time using SimpleDateFormat
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateAndTime = dateFormat.format(document.getDate("DateAndTime"));

            int accountFrom = document.getInteger("AccountFrom");
            int accountTo = document.getInteger("AccountTo");

            // Add the data to the table
            model.addRow(new Object[]{transactionID, accountNumber, transactionType, amount, status, accountFrom, accountTo, category, dateAndTime});

            // Notify the table model that the data has changed
            SwingUtilities.invokeLater(() -> model.fireTableRowsInserted(model.getRowCount() - 1, model.getRowCount() - 1));
        });

        System.out.println("After loop");
    }

    public void deleteTransaction(int transactionID) {
        MongoCollection<Document> transactionsCollection = mongoDatabase.getCollection("transaction");

        Document query = new Document("TransactionID", transactionID);
        transactionsCollection.deleteOne(query);
    }
}
