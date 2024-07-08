package com.task1;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Game settings
        int min = 1;
        int max = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to Guess the Number!");
            System.out.println("I have selected a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    score += (maxAttempts - attempts + 1) * 10;
                    System.out.println("Congratulations! You've guessed the number.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is higher.");
                } else {
                    System.out.println("The number is lower.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was " + numberToGuess + ".");
            }

            System.out.println("Your score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        scanner.close();
        System.out.println("Thank you for playing!");
    }
}




