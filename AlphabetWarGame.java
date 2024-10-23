import java.util.Scanner;

public class AlphabetWarGame {

    // Strength mappings for left-side letters
    private static final int W_STRENGTH = 4;
    private static final int P_STRENGTH = 3;
    private static final int B_STRENGTH = 2;
    private static final int S_STRENGTH = 1;

    // Strength mappings for right-side letters
    private static final int M_STRENGTH = 4;
    private static final int Q_STRENGTH = 3;
    private static final int D_STRENGTH = 2;
    private static final int Z_STRENGTH = 1;

    // Method to calculate the score of the word for both left and right side
    public static void determineWinner(String word) {
        int leftScore = 0;
        int rightScore = 0;

        System.out.println("Analyzing word: " + word);

        // Process each character in the word
        for (char ch : word.toCharArray()) {
            int strength = getStrength(ch);

            if (strength > 0) {
                if (isLeftSideLetter(ch)) {
                    leftScore += strength;
                    System.out.println("  Letter '" + ch + "' (Left-side) -> Strength: " + strength + 
                                       " | Cumulative Left Score: " + leftScore);
                } else {
                    rightScore += strength;
                    System.out.println("  Letter '" + ch + "' (Right-side) -> Strength: " + strength + 
                                       " | Cumulative Right Score: " + rightScore);
                }
            }
        }

        System.out.println("Final Left-side Score: " + leftScore);
        System.out.println("Final Right-side Score: " + rightScore);

        // Determine the winner
        if (leftScore > rightScore) {
            System.out.println("Result: Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Result: Right side wins!");
        } else {
            System.out.println("Result: Let's fight again!");
        }
    }

    // Helper method to get the strength of a letter
    private static int getStrength(char ch) {
        switch (ch) {
            case 'w': return W_STRENGTH;
            case 'p': return P_STRENGTH;
            case 'b': return B_STRENGTH;
            case 's': return S_STRENGTH;
            case 'm': return M_STRENGTH;
            case 'q': return Q_STRENGTH;
            case 'd': return D_STRENGTH;
            case 'z': return Z_STRENGTH;
            default: return 0;  // Non-relevant characters have 0 strength
        }
    }

    // Helper method to check if a letter belongs to the left side
    private static boolean isLeftSideLetter(char ch) {
        return "wpbs".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the word for battle (or type 'exit' to quit): ");
            String word = scanner.nextLine();

            if (word.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the game. Thank you!");
                break;
            }

            determineWinner(word);
            System.out.println();  // Blank line for readability
        }

        scanner.close();
    }
}
