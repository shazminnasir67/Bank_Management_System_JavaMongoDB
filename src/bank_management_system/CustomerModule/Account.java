package bank_management_system.CustomerModule;

import bank_management_system.Dao.DatabaseConnection;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Account {


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    // Instance variables
    private int accountId;
    private String firstName;
    private String lastName;
    private double balance;
    private String cardNumber;
    private String accounttype;

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }


    private int custid;




    // Constructor
    public Account() {

    }

    // Getters and setters for cardNumber
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }
    private void insertCustomer() {
        try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("yourDBName");
            MongoCollection<Document> collection = database.getCollection("Accounts");

            Document document = new Document()
                    .append("AccountNumber", getAccountId())
                    .append("AccountType", getAccounttype())
                    .append("Balance", getBalance())
                    .append("CustomerID", getCustid())
                    .append("AccountHolderName", getFirstName())
                    .append("CardNumber", getCardNumber());

            collection.insertOne(document);
            System.out.println("Document inserted successfully.");
        }
    }

    }

    // ... rest of the class methods (deposit, withdraw, displayAccountInfo) remain the same

