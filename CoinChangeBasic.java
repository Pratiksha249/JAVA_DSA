public class CoinChangeBasic {

    public static int countWays(int[] coins, int sum) {
        
        if (sum == 0) {
            return 1;
        }
        
        if (sum < 0) {
            return 0;
        }
        
        if (coins.length == 0) {
            return 0;
        }

    
        return countWays(coins, sum - coins[0]) + countWays(removeFirstCoin(coins), sum);
    }

    
    public static int[] removeFirstCoin(int[] coins) {
        int[] newCoins = new int[coins.length - 1];
        for (int i = 1; i < coins.length; i++) {
            newCoins[i - 1] = coins[i];
        }
        return newCoins;
    }

    public static void main(String[] args) {
    
        int sum1 = 4;
        int[] coins1 = {1, 2, 3};
        System.out.println("Output 1: " + countWays(coins1, sum1));

        
        int sum2 = 10;
        int[] coins2 = {2, 5, 3, 6};
        System.out.println("Output 2: " + countWays(coins2, sum2));
    }
}
