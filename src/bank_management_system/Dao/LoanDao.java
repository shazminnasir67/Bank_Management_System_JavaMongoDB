package bank_management_system.Dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class LoanDao {
    private static final MongoDatabase mongoDatabase = DatabaseConnection.getConnection();


    public LoanDao() {

    }

    public void extractLoansIntoTable(JTable table) {
        MongoCollection<Document> loansCollection = mongoDatabase.getCollection("loans");

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data in the table

        loansCollection.find().forEach((Consumer<Document>) document -> {
            int loanID = document.getInteger("LoanID");
            int accountNumber = document.getInteger("AccountNumber");
            int customerID = document.getInteger("CustomerID");
            double loanAmount = document.getDouble("LoanAmount");
            double interestRate = document.getDouble("InterestRate");
            int loanTerm = document.getInteger("LoanTerm");
            Date startDate = document.getDate("StartDate");
            Date endDate = document.getDate("EndDate");
            String status = document.getString("Status");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Adjust the date format pattern

            model.addRow(new Object[]{
                    loanID, accountNumber, customerID, loanAmount, interestRate, loanTerm, dateFormat.format(startDate), dateFormat.format(endDate), status
            });
        });
    }

    public void searchLoans(JTable table, int searchField, String searchValue) {
        MongoCollection<Document> loansCollection = mongoDatabase.getCollection("loans");
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data in the table

        String fieldName;
        switch (searchField) {
            case 0: // Search by ID
                fieldName = "LoanID";
                break;
            case 1: // Search by Customer ID
                fieldName = "CustomerID";
                break;
            case 2: // Search by Account ID
                fieldName = "AccountNumber";
                break;
            case 3: // Search by Loan Status
                fieldName = "Status";
                break;
            default:
                return;
        }

        Document query;
        if (fieldName.equals("LoanID") || fieldName.equals("CustomerID") || fieldName.equals("AccountNumber")) {
            // If searching by numeric fields, parse the searchValue as an integer
            try {
                int fieldValue = Integer.parseInt(searchValue);
                query = new Document(fieldName, fieldValue);
            } catch (NumberFormatException e) {
                System.err.println("Invalid numeric field format");
                return;
            }
        } else {
            // For non-numeric fields, treat as a string
            query = new Document(fieldName, searchValue);
        }
        loansCollection.find(query).forEach((Consumer<Document>) document -> {
            int loanID = document.getInteger("LoanID");
            int customerID = document.getInteger("CustomerID");
            int accountNumber = document.getInteger("AccountNumber");
            String loanStatus = document.getString("Status");
            Double amount = document.getDouble("LoanAmount");
            Double interestRATE = document.getDouble("InterestRate");
            int terms = document.getInteger("LoanTerm");

            Date startDate = document.getDate("StartDate");
            Date endDate = document.getDate("EndDate");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDateFormatted = dateFormat.format(startDate);
            String endDateFormatted = dateFormat.format(endDate);

            // Add the data to the table
            model.addRow(new Object[]{loanID, accountNumber, customerID, amount, interestRATE, terms, startDateFormatted, endDateFormatted, loanStatus});

            // Notify the table model that the data has changed
            SwingUtilities.invokeLater(() -> model.fireTableRowsInserted(model.getRowCount() - 1, model.getRowCount() - 1));
        });

    }

    public static int countLoanAccounts() {
        int totalLoanAccounts = 0;
        MongoCollection<Document> loansCollection = mongoDatabase.getCollection("loans");

        totalLoanAccounts = (int) loansCollection.countDocuments();

        return totalLoanAccounts;
    }

    public void deleteLoan(int loanID) {
        MongoCollection<Document> loansCollection = mongoDatabase.getCollection("loans");

        Document query = new Document("LoanID", loanID);
        loansCollection.deleteOne(query);
    }
    public static int countClosedLoans() {
        MongoCollection<Document> loansCollection = mongoDatabase.getCollection("loans");

        // Build the query to count closed loans
        Document query = new Document("Status", "Closed");

        // Use the countDocuments method to count the matching documents
        int closedLoansCount = (int) loansCollection.countDocuments(query);

        return closedLoansCount;
    }

    public static int calculatePendingLoanAmount() {
        MongoCollection<Document> loansCollection = mongoDatabase.getCollection("loans");

        Document query = new Document("Status", "Active");

        try (MongoCursor<Document> cursor = loansCollection.find(query).iterator()) {
            double totalPendingAmount = 0.0;

            while (cursor.hasNext()) {
                Document document = cursor.next();
                double loanAmount = document.getDouble("LoanAmount");

                totalPendingAmount += loanAmount;
            }
            System.out.println(totalPendingAmount);

            return (int) totalPendingAmount;
        }
    }


}
