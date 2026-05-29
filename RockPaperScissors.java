// Importing ArrayList so we can store a list of choices
import java.util.ArrayList;

// Importing Arrays to use methods like asList()
import java.util.Arrays;

// Importing Scanner to take user input
import java.util.Scanner;

// Main class for the Rock Paper Scissors game
public class RockPaperScissors {

	// Method to determine the winner
	// Takes in an ArrayList of choices from the user and AI
	static int determineWinner (ArrayList<String> choices) {

		// If there is Rock and NO Scissors,
		// Rock wins, so return the index of Rock
		if (choices.contains("R") && !choices.contains("S")) {
			return choices.indexOf("R");
		}

		// If there is both Rock and Paper,
		// Paper wins, so return the index of Paper
		if (choices.contains("R") && choices.contains("P")) {
			return choices.indexOf("P");
		}

		// If there is both Paper and Scissors,
		// Scissors wins, so return the index of Scissors
		if (choices.contains("P") && choices.contains("S")) {
			return choices.indexOf("S");
		}

		// If none of the conditions happen,
		// it means the game is a tie
		return -1;
	}

	// Main method where the program starts running
	public static void main(String[] args) {

		// Creating a Scanner object to get user input
		Scanner input = new Scanner(System.in);

		// Array to keep track of wins, losses, and ties
		// Index 0 = User Wins
		// Index 1 = AI Wins (User Losses)
		// Index 2 = Ties
		int[] record = {0,0,0};

		// Array storing player names
		String[] players = {"User", "AI"};

		// Array storing possible choices
		// R = Rock, P = Paper, S = Scissors
		String[] possibleChoices = {"R", "P", "S"};

		// Full names for displaying choices
		String[] fullChoiceNames = {"Rock", "Paper", "Scissors"};

		// Variable to store replay decision
		String replayChoice;

		// Do-while loop keeps running until user enters 0
		do {

			// Ask user to choose Rock, Paper, or Scissors
			System.out.println("Select Rock, Paper, or Scissors (put in the first letter of your choice)");

			// Read user input and convert it to uppercase
			String RPSchoice = input.nextLine().toUpperCase();

			// Input validation loop
			// Runs if user enters anything other than R, P, or S
			while (!Arrays.asList(possibleChoices).contains(RPSchoice)) {

				// Tell user the input is invalid
				System.out.println("Invalid. Select Rock, Paper, or Scissors (put in the first letter of your choice)");

				// Ask for input again and convert to uppercase
				RPSchoice = input.nextLine().toUpperCase();
			}

			// Generate a random choice for the AI
			// Math.random() gives a number between 0 and 1
			// Multiply by length (3) to get 0, 1, or 2
			int oppChoice = (int)(Math.random()*possibleChoices.length);

			// Display the AI's full choice name
			System.out.println("AI chose " + fullChoiceNames[oppChoice]);

			// Create an ArrayList to store both player choices
			ArrayList<String> sideChoices = new ArrayList<String>();

			// Add user's choice to the list
			sideChoices.add(RPSchoice);

			// Add AI's choice to the list
			sideChoices.add(possibleChoices[oppChoice]);

			// Call determineWinner method to find winner
			int winner = determineWinner(sideChoices);

			// If winner = -1, game is a tie
			if (winner==-1) {

				// Print tie message
				System.out.println("You tied!");

				// Increase tie count in record array
				record[record.length-1] += 1;

			} else {

				// Add win to whichever player won
				record[winner] += 1;

				// Check if user won
				if ((players[winner].equals("User"))) {

					// Display win message
					System.out.println("You won!");

				} else {

					// Otherwise user lost
					System.out.println("You lost!");
				}
			}

			// Ask user if they want to play again
			System.out.println("Enter 0 if you don't want to play again.");

			// Store replay input
 			replayChoice = input.nextLine();

		// Continue loop if user DOES NOT enter 0
		} while (!replayChoice.equals("0"));

		// Loop through record array to display final stats
		for (int i = 0; i < record.length; i++) {

			// Print number of wins/losses/ties
			System.out.print(record[i]);

			// If it is the last index, print ties
			if (i == record.length-1) {
				System.out.println(" Ties");

			// If index belongs to User, print wins
			} else if (players[i].equals("User")) {
				System.out.println(" Wins");

			// If index belongs to AI, print losses
			} else if (players[i].equals("AI")) {
				System.out.println(" Losses");
			}
		}

		// Close Scanner to prevent resource leak
		input.close();
	}
}
