import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlphabetWarGame {
    // Maps to hold the strengths of left-side and right-side letters
    private Map<Character, Integer> leftStrengths;
    private Map<Character, Integer> rightStrengths;

    // Default constructor
    public AlphabetWarGame() {
        leftStrengths = new HashMap<>();
        leftStrengths.put('w', 4);
        leftStrengths.put('p', 3);
        leftStrengths.put('b', 2);
        leftStrengths.put('s', 1);

        rightStrengths = new HashMap<>();
        rightStrengths.put('m', 4);
        rightStrengths.put('q', 3);
        rightStrengths.put('d', 2);
        rightStrengths.put('z', 1);
    }

    // Method to determine the winner from a single word
    public String alphabetWar(String word) {
        int leftScore = 0;
        int rightScore = 0;

        // Calculate scores for both sides in a single pass
        for (char c : word.toCharArray()) {
            if (leftStrengths.containsKey(c)) {
                leftScore += leftStrengths.get(c);
            } else if (rightStrengths.containsKey(c)) {
                rightScore += rightStrengths.get(c);
            }
        }

        // Determine the winner
        if (leftScore > rightScore) {
            return "Left side wins!";
        } else if (rightScore > leftScore) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create an instance of the game
        AlphabetWarGame game = new AlphabetWarGame();

        System.out.println("Welcome to Alphabet War!");
        System.out.println("Enter letters to start the battle (type 'exit' to quit):");

        // Loop for interactive input
        while (true) {
            System.out.print("Enter a word: ");
            String input = scanner.nextLine().trim().toLowerCase();

            // Exit condition
            if (input.equals("exit")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }

            // Determine the result and print it
            String result = game.alphabetWar(input);
            System.out.println(result);
        }

        // Close the scanner
        scanner.close();
    }
}
