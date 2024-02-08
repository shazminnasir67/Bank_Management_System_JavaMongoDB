package bank_management_system.CustomerModule;

import java.util.Random;

public class CardNumberGenerator {

    public static String generateCardNumber() {
        Random random = new Random();

        // Generate the first 15 digits randomly
        StringBuilder first15Digits = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            int digit = random.nextInt(10);
            first15Digits.append(digit);
        }

        // Calculate the check digit (the last digit) to satisfy Luhn's algorithm
        int total = 0;
        String reversedDigits = first15Digits.toString();
        for (int i = 0; i < reversedDigits.length(); i++) {
            int digit = Character.getNumericValue(reversedDigits.charAt(i));
            if (i % 2 == 1) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            total += digit;
        }
        int checkDigit = (10 - (total % 10)) % 10;

        // Combine the first 15 digits and the check digit
        String cardNumber = first15Digits.toString() + checkDigit;
        System.out.println(cardNumber);

        return cardNumber;
    }

    public static void main(String[] args) {

    }
}

