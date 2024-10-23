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

        System.out.println("\nStep 1: Calculate max profit from the first transaction (Left to Right)");

        // Calculate max profit for the first transaction (left to right)
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);

            // Display step-by-step values
            System.out.printf("Day %d: Min price so far = %d, Profit if sold today = %d, Left profit = %d\n", 
                              i, minPrice, prices[i] - minPrice, leftProfit[i]);
        }

        System.out.println("\nStep 2: Calculate max profit from the second transaction (Right to Left)");

        // Calculate max profit for the second transaction (right to left)
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);

            // Display step-by-step values
            System.out.printf("Day %d: Max price so far = %d, Profit if bought today = %d, Right profit = %d\n", 
                              i, maxPrice, maxPrice - prices[i], rightProfit[i]);
        }

        System.out.println("\nStep 3: Combine profits from both transactions to find the maximum possible profit");

        // Combine the results to find the maximum profit
        maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int totalProfit = leftProfit[i] + rightProfit[i];
            maxProfit = Math.max(maxProfit, totalProfit);

            // Display step-by-step combination of profits
            System.out.printf("Day %d: Left profit = %d, Right profit = %d, Total profit = %d\n", 
                              i, leftProfit[i], rightProfit[i], totalProfit);
        }

        // Display the final result
        System.out.println("\nMaximum Profit with at most 2 transactions: " + maxProfit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the stock prices as a space-separated string
        System.out.println("Please enter the stock prices for each day, separated by spaces:");
        String input = scanner.nextLine();

        // Split the input string into an array of strings, then convert to integers
        String[] inputArray = input.trim().split("\\s+");
        int[] prices = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            prices[i] = Integer.parseInt(inputArray[i]);
        }

        // Call the method to calculate max profit
        findMaxProfit(prices);

        scanner.close();
    }
}
