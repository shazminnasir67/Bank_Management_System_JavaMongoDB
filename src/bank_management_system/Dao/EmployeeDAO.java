package bank_management_system.Dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Consumer;

public class EmployeeDAO extends Component {
    private MongoDatabase mongoDatabase;

    public EmployeeDAO() {
        this.mongoDatabase =DatabaseConnection.getConnection();
    }

    public void extractEmployeesIntoTable(JTable table) {

        SwingUtilities.invokeLater(() -> {
            MongoCollection<Document> employeesCollection = mongoDatabase.getCollection("employee");

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            try {

                employeesCollection.find().forEach((Consumer<Document>) document -> {
                    int employeeID = document.getInteger("EmployeeID");
                    String firstName = document.getString("FirstName");
                    double salary = document.getDouble("Salary");
                    String email = document.getString("Email");
                    String username = document.getString("Username");
                    String password = document.getString("Password");
                    String jobTitle = document.getString("JobTitle");
                    java.util.Date hireDate =  document.getDate("HireDate");
                    String formattedHireDate = SimpleDateFormat.getDateInstance().format(hireDate);
                    model.addRow(new Object[]{employeeID, firstName, salary, email, username, password, jobTitle, formattedHireDate});
                });
            }catch(Exception e){
                e.printStackTrace();
            }

        });
    }

    public void deleteEmployee(int employeeID) {
        MongoCollection<Document> employeesCollection = mongoDatabase.getCollection("employee");

        Document query = new Document("EmployeeID", employeeID);
        employeesCollection.deleteOne(query);
    }

    public void updateCellValue(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();
        int selectedColumn = table.getSelectedColumn();

        if (selectedRow == -1 || selectedColumn == -1) {
            JOptionPane.showMessageDialog(null, "Please select a cell to update.");
            return;
        }

        String newValue = JOptionPane.showInputDialog(null, "Enter new value:");

        if (newValue != null) {
            int documentId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
            MongoCollection<Document> collection = mongoDatabase.getCollection("employee");

            // Retrieve the entire document based on EmployeeID
            Document existingDocument = collection.find(new Document("EmployeeID", documentId)).first();

            if (existingDocument != null) {
                // Modify the specific field in the document
                existingDocument.put(table.getColumnName(selectedColumn), newValue);

                System.out.println("Before MongoDB Update - Collection Data: " + collection.find().into(new ArrayList<>()));

                try {
                    // Update the MongoDB document
                    collection.replaceOne(new Document("EmployeeID", documentId), existingDocument);

                    // Update the JTable model
                    model.setValueAt(newValue, selectedRow, selectedColumn);

                    // Repaint the table
                    table.repaint();

                    System.out.println("After MongoDB Update - Collection Data: " + collection.find().into(new ArrayList<>()));
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating MongoDB document: " + e.getMessage());
                }
            } else {
                System.out.println("Document with EmployeeID " + documentId + " not found in the collection.");
            }
        }
    }


    public void searchEmployees(JTable table, int searchField, String searchValue) {
        MongoCollection<Document> employeesCollection = mongoDatabase.getCollection("employee");

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data in the table

        String fieldName;
        switch (searchField) {
            case 0: // Search by ID
                fieldName = "EmployeeID";
                break;
            case 1: // Search by Name
                fieldName = "FirstName";
                break;
            case 2: // Search by Username
                fieldName = "Username";
                break;
            case 3: // Search by Last Name
                fieldName = "LastName";
                break;
            case 4: // Search by Job Title
                fieldName = "JobTitle";
                break;
            default:
                // Handle the case for an invalid searchField value
                return;
        }

        Document query;
        if (fieldName.equals("EmployeeID")) {
            // If searching by EmployeeID, parse the searchValue as an integer
            try {
                int employeeID = Integer.parseInt(searchValue);
                query = new Document(fieldName, employeeID);
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid integer
                System.err.println("Invalid EmployeeID format");
                return;
            }
        } else {
            query = new Document(fieldName, searchValue);
        }

        // Print debug information
        System.out.println("Search Field: " + fieldName);
        System.out.println("Search Value: " + searchValue);
        System.out.println("Query: " + query.toJson());

        System.out.println("Before loop");

        employeesCollection.find(query).forEach((Consumer<Document>) document -> {
            System.out.println("Inside loop");

            // Print debug information for each document
            System.out.println("Found document: " + document.toJson());

            int employeeID = document.getInteger("EmployeeID");
            String firstName = document.getString("FirstName");
            String lastName = document.getString("LastName");
            String username = document.getString("Username");
            String jobTitle = document.getString("JobTitle");
            String salary = document.get("Salary", Double.class).toString(); // Convert Double to String
            String email = document.getString("Email");
            String password = document.getString("Password");

            // Add the data to the table
            model.addRow(new Object[]{employeeID, firstName, salary, email, username, password, jobTitle});

            // Notify the table model that the data has changed
            SwingUtilities.invokeLater(() -> model.fireTableRowsInserted(model.getRowCount() - 1, model.getRowCount() - 1));
        });

    }

}
