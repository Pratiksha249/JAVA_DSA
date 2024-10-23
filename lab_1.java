import java.util.Scanner;

public class lab_1 {

    private String ccNumber;

    // Constructor to initialize the credit card number
    public lab_1(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    // Method to validate the credit card number
    public void validate() {
        System.out.println("Step 1: Validating the credit card number: " + ccNumber);

        // Step 1: Check if the credit card number has 8 or 9 digits
        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number. Must be 8 or 9 digits long.");
            return;
        }

        // Step a: Extract the last digit (check digit)
        int lastDigit = ccNumber.charAt(ccNumber.length() - 1) - '0';
        String remainingNumber = ccNumber.substring(0, ccNumber.length() - 1);
        System.out.println("Step 2a: Last digit (check digit) extracted: " + lastDigit);
        System.out.println("Step 2a: Remaining number after removing last digit: " + remainingNumber);

        // Step b: Reverse the remaining digits
        String reversedNumber = new StringBuilder(remainingNumber).reverse().toString();
        System.out.println("Step 2b: Reversed remaining number: " + reversedNumber);

        // Step c: Double the digits at odd positions and sum the digits if needed
        int sum = 0;
        System.out.println("Step 2c: Processing each digit from the reversed number:");

        for (int i = 0; i < reversedNumber.length(); i++) {
            int digit = reversedNumber.charAt(i) - '0';
            System.out.print("  Position " + (i + 1) + " (digit: " + digit + "): ");

            if (i % 2 == 0) {  // Double the digits at odd positions (0-based index)
                digit *= 2;
                System.out.print("Doubled value: " + digit);

                if (digit > 9) {
                    digit = digit / 10 + digit % 10;  // Sum the digits of double-digit results
                    System.out.print(" (Summed digits: " + digit + ")");
                }
            }

            sum += digit;
            System.out.println(" -> Cumulative sum: " + sum);
        }

        // Step d: Calculate the check digit
        int checkDigit = (10 - (sum % 10)) % 10;
        System.out.println("Step 2d: Calculated check digit: " + checkDigit);

        // Step f: Determine if the card is valid or invalid
        if (checkDigit == lastDigit) {
            System.out.println("Step 3: The credit card number is valid.");
        } else {
            System.out.println("Step 3: The credit card number is invalid.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Input the credit card number
            System.out.print("Enter the credit card number (or type 'exit' to quit): ");
            String ccNumber = scanner.nextLine();

            // Exit the loop if the user types 'exit'
            if (ccNumber.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program. Thank you!");
                break;
            }

            // Create an instance of lab_1 and validate the credit card
            lab_1 validator = new lab_1(ccNumber);
            validator.validate();
            System.out.println();  // Print a blank line for better readability
        }

        scanner.close();
    }
}
