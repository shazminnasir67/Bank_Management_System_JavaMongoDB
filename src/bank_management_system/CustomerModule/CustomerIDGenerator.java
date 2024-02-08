package bank_management_system.CustomerModule;

import java.util.Random;

public class CustomerIDGenerator {
   // private static final String CUSTOMER_ID_PREFIX = "CUST";
    private static final int NUMERIC_LENGTH = 6; // Adjust as needed

    public static int generateCustomerID() {
        // Generate a random numeric portion of the ID
        int numericPart = generateRandomNumericPart();

        // Format the numeric portion as a string with leading zeros


        // Combine the prefix and numeric part to create the customer ID
        int customerID = generateRandomNumericPart();

        return customerID;
    }

    private static int generateRandomNumericPart() {
        Random random = new Random();
        return random.nextInt((int) Math.pow(10, NUMERIC_LENGTH));
    }

    private static String formatNumericPart(int numericPart) {
        return String.format("%0" + NUMERIC_LENGTH + "d", numericPart);
    }

    public static void main(String[] args) {

    }
}
