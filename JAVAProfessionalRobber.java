import java.util.Arrays;

// Abstract class definition
abstract class Robber {
    // Abstract method
    abstract void RobbingClass();

    // Concrete method
    void MachineLearning() {
        System.out.println("I love MachineLearning");
    }

    // Abstract methods for the different house robbing problems
    abstract int RowHouses(int[] money);
    abstract int RoundHouses(int[] money);
    abstract int SquareHouse(int[] money);
    abstract int MultiHouseBuilding(int[][] houses);
}

// Concrete class implementation
public class JAVAProfessionalRobber extends Robber {

    @Override
    void RobbingClass() {
        System.out.println("MScAI&ML");
    }

    @Override
    int RowHouses(int[] money) {
        if (money == null || money.length == 0) return 0;
        if (money.length == 1) return money[0];
        
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        
        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        return dp[money.length - 1];
    }

    @Override
    int RoundHouses(int[] money) {
        if (money == null || money.length == 0) return 0;
        if (money.length == 1) return money[0];

        // Helper function to handle linear house robbing
        return Math.max(robLinear(money, 0, money.length - 2), robLinear(money, 1, money.length - 1));
    }

    private int robLinear(int[] money, int start, int end) {
        if (start > end) return 0;
        if (end - start == 0) return money[start];

        int[] dp = new int[end - start + 1];
        dp[0] = money[start];
        dp[1] = Math.max(money[start], money[start + 1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[start + i]);
        }
        
        return dp[dp.length - 1];
    }

    @Override
    int SquareHouse(int[] money) {
        // Logic is the same as RowHouses
        return RowHouses(money);
    }

    @Override
    int MultiHouseBuilding(int[][] houses) {
        int totalMax = 0;
        for (int[] house : houses) {
            totalMax += RowHouses(house);
        }
        return totalMax;
    }

    // Main method to test the class
    public static void main(String[] args) {
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();

        // Test cases
        System.out.println("RowHouses([1, 2, 3, 0]): " + robber.RowHouses(new int[]{1, 2, 3, 0})); // Expected output: 4
        System.out.println("RoundHouses([1, 2, 3, 4]): " + robber.RoundHouses(new int[]{1, 2, 3, 4})); // Expected output: 6
        System.out.println("SquareHouse([5, 10, 2, 7]): " + robber.SquareHouse(new int[]{5, 10, 2, 7})); // Expected output: 17
        System.out.println("MultiHouseBuilding: " +
                robber.MultiHouseBuilding(new int[][]{
                    {5, 3, 8, 2},   
                    {10, 12, 7, 6},  
                    {4, 9, 11, 5},   
                    {8, 6, 3, 7}    
                })); 
    }
}
