public class ComplexPattern {
    public static void main(String[] args) {
        int n = 5;  // Number of rows in the pyramid
        System.out.println("hello changes");

        for (int i = 1; i <= n; i++) {
            // Print spaces for alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            // Print asterisks for the left half of the pyramid
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }

            for (int l = i - 1; l >= 1; l--) {
                System.out.print("* ");
            }            

            // Move to the next line for the next row
            System.out.println();
        }
    }
}