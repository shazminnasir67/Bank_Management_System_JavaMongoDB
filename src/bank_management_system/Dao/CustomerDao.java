package bank_management_system.Dao;

import bank_management_system.CustomerModule.Customer;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.function.Consumer;

public class CustomerDao {
    private static final MongoDatabase mongoDatabase = DatabaseConnection.getConnection();


    public CustomerDao() {

    }

    public Customer searchCustomerByCustomerID(int customerID) {
        Customer customer = null;

        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        Document query = new Document("CustomerID", customerID);
        Document result = customersCollection.find(query).first();

        if (result != null) {
            customer = new Customer();
            customer.setCUSTID(result.getInteger("CustomerID"));
            customer.setFirstName(result.getString("FirstName"));
            customer.setLastName(result.getString("LastName"));
            customer.setCNIC(result.getString("CNIC"));
            customer.setEmail(result.getString("Email"));
            customer.setPhoneNo(result.getString("PhoneNumber"));
            customer.setUsername(result.getString("Username"));
        }

        return customer;
    }

    public boolean createCustomer(Customer customer) {
        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        Document document = new Document();
        document.append("CustomerID", customer.getCUSTID());
        document.append("FirstName", customer.getFirstName());
        document.append("LastName", customer.getLastName());
        document.append("Username", customer.getUsername());
        document.append("Password", customer.getPassoword());
        document.append("CNIC", customer.getCNIC());
        document.append("Email", customer.getEmail());
        document.append("PhoneNumber", customer.getPhoneNo());
        document.append("Gender", customer.getGender());

        customersCollection.insertOne(document);

        return true; // Assume the insertion is successful
    }

    public boolean updatePasswordByCNIC(String cnic, String newPassword) {
        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        Document query = new Document("CNIC", cnic);
        Document update = new Document("$set", new Document("Password", newPassword));

        customersCollection.updateOne(query, update);

        return true; // Assume the update is successful
    }

    public boolean forgotPassword(String email, String cnic) {
        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        Document query = new Document("Email", email).append("CNIC", cnic);
        Document result = customersCollection.find(query).first();

        return result != null;
    }

    public static Customer getCustomerByUsername(String username) {
        Customer customer = null;

        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        Document query = new Document("Username", username);
        Document result = customersCollection.find(query).first();

        if (result != null) {
            customer = new Customer();
            customer.setFirstName(result.getString("FirstName"));
            customer.setCUSTID(result.getInteger("CustomerID"));
        } else {
            System.out.println("No results found for username: " + username);
        }

        return customer;
    }

    public void updateCustomerInfo(int updateType, String newValue, String customerID, String cnic) {
        // MongoDB doesn't use SQL, so updates are handled differently
        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        Document query = new Document("CustomerID", Integer.parseInt(customerID)).append("CNIC", cnic);
        Document update = new Document();

        switch (updateType) {
            case 1: // Update First Name
                update.append("$set", new Document("FirstName", newValue));
                break;
            case 2: // Update Username
                update.append("$set", new Document("Username", newValue));
                break;
            case 3: // Update Phone Number
                update.append("$set", new Document("PhoneNumber", newValue));
                break;
            case 4: // Update Other Data (Modify as needed)
                update.append("$set", new Document("Password", newValue));
                break;
            default:
                // Handle invalid update type
                break;
        }

        customersCollection.updateOne(query, update);
    }

    public void loadCustomers(JTable jTable) {
        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        customersCollection.find().forEach((Consumer<Document>) document -> {
            int custID = document.getInteger("CustomerID");
            String firstName = document.getString("FirstName");
            String lastName = document.getString("LastName");
            String email = document.getString("Email");
            String username = document.getString("Username");
            String password = document.getString("Password");
            String gender = document.getString("Gender");
            String cnic = document.getString("CNIC");

            model.addRow(new Object[]{custID, firstName, lastName, email, username, password, gender, cnic});
        });
    }

    public void deleteCustomer(int customerID) {
        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        Document query = new Document("CustomerID", customerID);
        customersCollection.deleteOne(query);
    }

    public void searchCustomers(javax.swing.JTable table, int searchCriteria, String keyword) {
        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        if (searchCriteria == 0) {
            try {
                int customerID = Integer.parseInt(keyword);
                Customer customer = searchCustomerByCustomerID(customerID);
                if (customer != null) {
                    // Add the data to the table
                    model.addRow(new Object[]{customer.getCUSTID(), customer.getFirstName(), customer.getLastName(),
                            customer.getEmail(), customer.getUsername(), "****", customer.getGender(), customer.getCNIC()});
                }
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid integer
                System.err.println("Invalid CustomerID format");
            }
        } else {
            // H
        Bson filter = createFilter(searchCriteria, keyword);
        try (MongoCursor<Document> cursor = customersCollection.find(filter).iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                int custID = document.getInteger("CustomerID");
                String firstName = document.getString("FirstName");
                String lastName = document.getString("LastName");
                String email = document.getString("Email");
                String username = document.getString("Username");
                String password = document.getString("Password");
                String gender = document.getString("Gender");
                String cnic = document.getString("CNIC");

                model.addRow(new Object[]{custID, firstName, lastName, email, username, password, gender, cnic});
            }

                // Notify the table model that the data has changed
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        model.fireTableDataChanged();
                    }
                });

            }
        }
    }

    // Helper method to create a filter based on the selected search criteria and keyword
    private Bson createFilter(int searchCriteria, String keyword) {
        String field;
        switch (searchCriteria) {
            case 0:
                field = "CustomerID";
                break;
            case 1:
                field = "FirstName";
                break;
            case 2:
                field = "LastName";
                break;
            case 3:
                field = "Username";
                break;
            default:
                throw new IllegalArgumentException("Invalid search criteria");
        }

        // Use a regex filter to perform a case-insensitive search
        return Filters.regex(field, keyword, "i");
    }


    private Customer extractCustomerFromDocument(Document document) {
        Customer customer = new Customer();
        customer.setCUSTID(document.getInteger("CustomerID"));
        customer.setFirstName(document.getString("FirstName"));
        customer.setLastName(document.getString("LastName"));
        customer.setUsername(document.getString("Username"));
        customer.setPassoword(document.getString("Password"));
        customer.setCNIC(document.getString("CNIC"));
        customer.setEmail(document.getString("Email"));
        customer.setPhoneNo(document.getString("PhoneNumber"));
        customer.setGender(document.getString("Gender"));
        return customer;
    }

    public boolean authenticateUser(String username, String password) {
        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        Document query = new Document("Username", username).append("Password", password);
        Document result = customersCollection.find(query).first();

        return result != null;
    }

    public static int countTotalCustomers() {
        MongoCollection<Document> customersCollection = mongoDatabase.getCollection("customers");

        // Use the countDocuments method to count all documents in the collection
        int totalCustomersCount = (int) customersCollection.countDocuments();

        return totalCustomersCount;
    }
}
