package bank_management_system.Dao;

import bank_management_system.Components.ModelChart;
import bank_management_system.CustomerModule.Account;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.bson.Document;

import java.awt.*;
import java.util.*;
import java.util.List;

public class AccountDao {
    private static final String DB_NAME = "BankSystem";
    private static MongoDatabase mongoDatabase;  // MongoDB database instance

    static {
        // Initialize MongoDB connection when the class is loaded
        mongoDatabase = DatabaseConnection.getConnection();
    }

    public double getAccountBalance(int custId) {
        double balance = 0.0;

        MongoCollection<Document> accountsCollection = mongoDatabase.getCollection("accounts");

        Document query = new Document("CustomerID", custId);
        Document result = accountsCollection.find(query).first();

        if (result != null) {
            balance = result.getDouble("Balance");
        }

        return balance;
    }




    public static int getAccountCount(String accountType) {
        int accountCount = 0;

        MongoCollection<Document> accountsCollection = mongoDatabase.getCollection("accounts");

        Document query = new Document();
        if (accountType != null && !accountType.isEmpty()) {
            query.append("AccountType", accountType);
        }

        accountCount = (int) accountsCollection.countDocuments(query);

        return accountCount;
    }

    public boolean updateAccountBalance(int accountId, double newBalance) {
        MongoCollection<Document> accountsCollection = mongoDatabase.getCollection("accounts");

        Document filter = new Document("AccountNumber", accountId);
        Document update = new Document("$set", new Document("Balance", newBalance));

        accountsCollection.updateOne(filter, update);

        return true; // Assuming successful update
    }

    // Other methods remain the same, but use AccountDao.mongoDatabase instead of passing it as a parameter

    // ...




    public void depositMoney(int custId, double amount) {
        Account account = getAccountInfo(custId);
        double newBalance = account.getBalance() + amount;

        updateAccountBalance(account.getAccountId(), newBalance);
    }

    public boolean performTransaction(int sourceAccountId, int destinationAccountId, double amount) {
        Account sourceAccount = getAccountInfo(sourceAccountId);
        Account destinationAccount = getAccountInfo(destinationAccountId);

        if (sourceAccount.getBalance() >= amount) {
            double newSourceBalance = sourceAccount.getBalance() - amount;
            double newDestinationBalance = destinationAccount.getBalance() + amount;

            updateAccountBalance(sourceAccountId, newSourceBalance);
            updateAccountBalance(destinationAccountId, newDestinationBalance);

            return true; // Transaction successful
        } else {
            return false; // Insufficient funds in the source account
        }
    }

    public boolean withdrawMoney(int accountId, double amount) {
        Account account = getAccountInfo(accountId);

        if (account.getBalance() >= amount) {
            double newBalance = account.getBalance() - amount;

            updateAccountBalance(accountId, newBalance);

            return true; // Withdrawal successful
        } else {
            return false; // Insufficient funds
        }
    }

    public Account getAccountInfo(int custId) {
        Account account = null;

        MongoCollection<Document> accountsCollection = mongoDatabase.getCollection("accounts");

        Document query = new Document("CustomerID", custId);
        Document result = accountsCollection.find(query).first();

        if (result != null) {
            account = new Account();
            account.setAccountId(result.getInteger("AccountNumber"));
            account.setBalance(result.getDouble("Balance"));
            account.setCardNumber(result.getString("CardNumber"));
            account.setFirstName(result.getString("AccountHolderName"));
            account.setAccounttype(result.getString("AccountType"));

            // Set other account-related attributes as needed
        }

        return account;
    }

    public boolean createAccount(Account account) {
        MongoCollection<Document> accountsCollection = mongoDatabase.getCollection("accounts");

        Document newAccount = new Document()
                .append("AccountNumber", account.getAccountId())
                .append("AccountType", account.getAccounttype())
                .append("Balance", account.getBalance())
                .append("CustomerID", account.getCustid())
                .append("AccountHolderName", account.getFirstName())
                .append("CardNumber", account.getCardNumber());

        accountsCollection.insertOne(newAccount);

        return true; // Assuming successful creation
    }

    public int getAccountCountByMonthAndType(int month, String accountType) {
        int accountCount = 0;

        MongoCollection<Document> accountsCollection = mongoDatabase.getCollection("accounts");

        Document query = new Document("AccountType", accountType)
                .append("$expr", new Document("$eq", Arrays.asList(month, new Document("$month", "$creation_date"))));

        accountCount = (int) accountsCollection.countDocuments(query);

        return accountCount;
    }
}
