<h1>Alphabet War Game 🆚</h1>

<h2>Introduction</h2>
The Alphabet War Game is a playful Java program where two teams of letters fight against each other. Each letter has its own strength, contributing to its team’s score. This fun little program showcases Java concepts like loops, conditionals, scanner inputs, and object-oriented programming.

<h2>Features</h2>
Interactive console-based gameplay.
Dynamic input from users.
Clear step-by-step outputs explaining how scores are calculated.
Multiple test scenarios with different outcomes.
Fun battle logic to determine the winner between left-side and right-side letters.
<h2>Rules</h2>
Left-side team:

'w' → Strength 4
'p' → Strength 3
'b' → Strength 2
's' → Strength 1
Right-side team:

'm' → Strength 4
'q' → Strength 3
'd' → Strength 2
'z' → Strength 1
If the left-side score is higher, the result will be "Left side wins!"

If the right-side score is higher, the result will be "Right side wins!"

If both scores are equal, the result will be "Let's fight again!"

<h2>How It Works</h2>
The program takes a word from the user as input.
It analyzes each letter’s strength and adds it to the corresponding team’s score.
It displays the cumulative score as each letter is processed.
At the end, it declares the winner or a tie based on the final scores.
<h2>Usage</h2>
Input a word with any combination of the specified letters.
The program will calculate the scores step-by-step for both sides.
It prints the winner or a tie at the end.


<h1>Credit Card Validator 💳</h1>

<h2>Introduction</h2>
The Credit Card Validator is a Java program that implements a validation algorithm to check whether a given credit card number is valid. The program demonstrates Java programming concepts such as loops, conditionals, string manipulations, and scanner input.

It performs step-by-step validation following the Luhn Algorithm, a standard algorithm used for verifying card numbers.

<h2>Features</h2>
Interactive console-based input for credit card numbers.
Real-time validation with step-by-step explanation of the process.
Works with 8 or 9-digit credit card numbers.
Checks digit calculation and comparison to validate card numbers.
Validation Process
The validation process follows these steps:

Input length check: The card number must have 8 or 9 digits.
Extract the last digit: This is the check digit.
Reverse the remaining digits for processing.
Double the digits at odd positions (0-based indexing). If a doubled value is more than 9, sum its individual digits.
Sum all the digits to get the total cumulative sum.
Calculate the check digit using the formula:
Check digit=(10−(sum%10))%10
Compare the calculated check digit with the last digit from the original input. If they match, the card is valid.

<h2>Usage</h2>
Input a credit card number in the console.
The program will display each step of the validation process.
At the end, the program will tell whether the card is valid or invalid.

<h1>📈 ShareTrader - Max Profit Calculator with 2 Transactions</h1>

<h2>Description</h2>
The ShareTrader program helps traders calculate the maximum profit they can earn by making at most two transactions in a day. A transaction consists of buying and selling shares, and the second transaction can only begin after the first one is completed. The program uses stock prices provided by the user and calculates the maximum possible profit step-by-step.

This project is built in Java and designed to run interactively through the command line.

<h2>How It Works</h2>
<h3>Input:</h3>
The user enters daily stock prices as a space-separated list (e.g., 10 22 5 75 65 80).
<h3>Logic:</h3>

The program calculates
Maximum profit for the first transaction (left to right).
Maximum profit for the second transaction (right to left).
Combines both results to determine the overall maximum profit.
Each step of the calculation is displayed for better understanding.
<h2>Output:</h2>

It shows the detailed profit calculation per day and prints the maximum possible profit.

