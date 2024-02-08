package bank_management_system.Dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {
    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;

    public static MongoDatabase getConnection() {
        if (mongoDatabase == null) {
            try {
                // MongoDB connection URL. Replace <host> and <port> with your MongoDB server details.
//                String connectionString = "mongodb://<localhost>:<27017>";
                MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");

                mongoClient = new MongoClient(connectionString);
                mongoDatabase = mongoClient.getDatabase("BankSystem");
                System.out.println("Connected to MongoDB");
            } catch (Exception e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        }
        return mongoDatabase;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Disconnected from MongoDB");
        }
    }
}
