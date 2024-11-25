
interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}


abstract class RainySeasonConservation implements WaterConservationSystem {
    
}


class CityBlockConservation extends RainySeasonConservation {

    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        int n = blockHeights.length;
        if (n <= 2) return 0; 
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int trappedWater = 0;

        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return trappedWater;
    }
}


public class WaterConservationApp {
    public static void main(String[] args) {
        // Test cases
        int[] testCase1 = {3, 0, 0, 2, 0, 4};
        int[] testCase2 = {3, 0, 2, 0, 4};

        CityBlockConservation conservation = new CityBlockConservation();

      
        System.out.println("Test Case 1:");
        System.out.println("Input: {3, 0, 0, 2, 0, 4}");
        System.out.println("Output: " + conservation.calculateTrappedWater(testCase1) + "\n");

        System.out.println("Test Case 2:");
        System.out.println("Input: {3, 0, 2, 0, 4}");
        System.out.println("Output: " + conservation.calculateTrappedWater(testCase2));
    }
}
