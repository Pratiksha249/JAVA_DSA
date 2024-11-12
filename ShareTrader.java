import java.util.Scanner;

public class ShareTrader {
    // Static variable to store the maximum profit
    private static int maxProfit = 0;

    // Static method to calculate the maximum profit with at most 2 transactions
    public static void findMaxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            System.out.println("Not enough prices to make a transaction.");
            return;
        }

        // Step 1: Create arrays to store the max profit up to each day
        int[] leftProfit = new int[n];  // Max profit if selling on or before day i
        int[] rightProfit = new int[n]; // Max profit if buying on or after day i

        // Step 2: Calculate max profit for the first transaction (left to right)
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        // Step 3: Calculate max profit for the second transaction (right to left)
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        // Step 4: Combine the results to find the maximum possible profit
        maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        // Print the result
        System.out.println("Maximum Profit with at most 2 transactions: " + maxProfit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Clear prompt to guide the user
        System.out.println("Please enter the stock prices for each day, separated by spaces:");
        
        // Read the entire input as a line
        String input = scanner.nextLine();

        // Split the input line by spaces and convert each element to an integer
        String[] inputArray = input.trim().split("\\s+");
        int[] prices = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            prices[i] = Integer.parseInt(inputArray[i]);
        }

        // Call the method to calculate the max profit
        findMaxProfit(prices);

        scanner.close();
    }
}
