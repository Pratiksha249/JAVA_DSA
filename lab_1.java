import java.util.Scanner;

public class lab_1 {

    private String ccNumber;

    // Constructor to initialize the credit card number
    public lab_1(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    // Method to validate the credit card number
    public void validate() {
        // Step 1: Check if the credit card number has 8 or 9 digits
        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number.");
            return;
        }

        // Step a: Extract the last digit
        int lastDigit = ccNumber.charAt(ccNumber.length() - 1) - '0';
        String remainingNumber = ccNumber.substring(0, ccNumber.length() - 1);

        // Step b: Reverse the remaining digits
        String reversedNumber = new StringBuilder(remainingNumber).reverse().toString();

        // Step c: Double the digits at odd positions and sum the digits if needed
        int sum = 0;
        for (int i = 0; i < reversedNumber.length(); i++) {
            int digit = reversedNumber.charAt(i) - '0';
            if (i % 2 == 0) {  // Odd-positioned digits (0-based index)
                digit *= 2;
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;  // Sum the digits of double-digit results
                }
            }
            sum += digit;  // Add to the total sum
        }

        // Step d: Calculate the check digit
        int checkDigit = (10 - (sum % 10)) % 10;

        // Step f: Use if-else to determine if the card is valid or invalid
        if (checkDigit == lastDigit) {
            System.out.println("The credit card number is valid.");
        } else {
            System.out.println("The credit card number is invalid.");
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
