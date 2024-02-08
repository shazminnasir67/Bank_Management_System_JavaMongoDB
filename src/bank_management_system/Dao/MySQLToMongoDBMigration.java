package bank_management_system.Dao;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLToMongoDBMigration {
    public static void main(String[] args) {
        // MySQL Configuration
        String mysqlUrl = "jdbc:mysql://localhost:3306/Bank";
        String mysqlUser = "root";
        String mysqlPassword = "like1212";

        // MongoDB Configuration
        String mongoConnectionString = "mongodb://localhost:27017";
        String mongoDatabaseName = "BankSystem";

        try {
            // MySQL Connection
            Connection mysqlConnection = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);

            // MongoDB Connection
            MongoClient mongoClient = MongoClients.create(mongoConnectionString);
            MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDatabaseName);
            migrateTable(mysqlConnection, mongoDatabase , "accounts");

            // Migrate branches table
//            migrateTable(mysqlConnection, mongoDatabase, "branches");
//
//            // Migrate customers table
//            migrateTable(mysqlConnection, mongoDatabase, "customers");
//
//            // Migrate employee table
//            migrateTable(mysqlConnection, mongoDatabase, "employee");
//
//            // Migrate loans table
//            migrateTable(mysqlConnection, mongoDatabase, "loans");
//
//            // Migrate transaction table
//            migrateTable(mysqlConnection, mongoDatabase, "transaction");

            // Close connections
            mysqlConnection.close();
            mongoClient.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void migrateTable(Connection mysqlConnection, MongoDatabase mongoDatabase, String tableName) {
        try {
            // MySQL Query
            String mysqlQuery = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = mysqlConnection.prepareStatement(mysqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            // MongoDB Collection
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(tableName);

            // MongoDB Data Insertion
            while (resultSet.next()) {
                Document document = new Document();

                // Customize this block based on the columns of each table
                switch (tableName) {
                    case "accounts":
                        document.append("AccountNumber", resultSet.getInt("AccountNumber"))
                                .append("AccountType", resultSet.getString("AccountType"))
                                .append("Balance", resultSet.getDouble("Balance"))
                                .append("CustomerID", resultSet.getInt("CustomerID"))
                                .append("AccountHolderName", resultSet.getString("AccountHolderName"))
                                .append("CardNumber", resultSet.getString("CardNumber"))
                                .append("creation_date", resultSet.getDate("creation_date"));
                        break;
                    case "branches":
                        document.append("BranchID", resultSet.getInt("BranchID"))
                                .append("BranchName", resultSet.getString("BranchName"))
                                .append("Location", resultSet.getString("Location"));
                        break;

                    case "customers":
                        document.append("CustomerID", resultSet.getInt("CustomerID"))
                                .append("FirstName", resultSet.getString("FirstName"))
                                .append("LastName", resultSet.getString("LastName"))
                                .append("Username", resultSet.getString("Username"))
                                .append("Password", resultSet.getString("Password"))
                                .append("CNIC", resultSet.getString("CNIC"))
                                .append("Email", resultSet.getString("Email"))
                                .append("PhoneNumber", resultSet.getString("PhoneNumber"))
                                .append("Gender", resultSet.getString("Gender"))
                                .append("RegistrationDate", resultSet.getTimestamp("RegistrationDate"));
                        break;

                    case "employee":
                        document.append("EmployeeID", resultSet.getInt("EmployeeID"))
                                .append("FirstName", resultSet.getString("FirstName"))
                                .append("LastName", resultSet.getString("LastName"))
                                .append("DateOfBirth", resultSet.getDate("DateOfBirth"))
                                .append("Address", resultSet.getString("Address"))
                                .append("PhoneNumber", resultSet.getString("PhoneNumber"))
                                .append("Email", resultSet.getString("Email"))
                                .append("JobTitle", resultSet.getString("JobTitle"))
                                .append("HireDate", resultSet.getDate("HireDate"))
                                .append("Salary", resultSet.getDouble("Salary"))
                                .append("Username", resultSet.getString("Username"))
                                .append("Password", resultSet.getString("Password"));
                        break;

                    case "loans":
                        document.append("LoanID", resultSet.getInt("LoanID"))
                                .append("AccountNumber", resultSet.getInt("AccountNumber"))
                                .append("CustomerID", resultSet.getInt("CustomerID"))
                                .append("LoanAmount", resultSet.getDouble("LoanAmount"))
                                .append("InterestRate", resultSet.getDouble("InterestRate"))
                                .append("LoanTerm", resultSet.getInt("LoanTerm"))
                                .append("StartDate", resultSet.getDate("StartDate"))
                                .append("EndDate", resultSet.getDate("EndDate"))
                                .append("Status", resultSet.getString("Status"));
                        break;

                    case "transaction":
                        document.append("TransactionID", resultSet.getInt("TransactionID"))
                                .append("AccountNumber", resultSet.getInt("AccountNumber"))
                                .append("TransactionType", resultSet.getString("TransactionType"))
                                .append("Amount", resultSet.getDouble("Amount"))
                                .append("DateAndTime", resultSet.getTimestamp("DateAndTime"))
                                .append("AccountFrom", resultSet.getInt("AccountFrom"))
                                .append("AccountTo", resultSet.getInt("AccountTo"))
                                .append("TransactionStatus", resultSet.getString("TransactionStatus"))
                                .append("Fees", resultSet.getDouble("Fees"))
                                .append("BalanceAfterTransaction", resultSet.getDouble("BalanceAfterTransaction"))
                                .append("TransactionCategory", resultSet.getString("TransactionCategory"));
                        break;

                    default:
                        System.out.println("Unsupported table: " + tableName);
                        break;
                }

                mongoCollection.insertOne(document);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
