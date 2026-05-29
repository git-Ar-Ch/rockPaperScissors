import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class RockPaperScissors {
	static int determineWinner (ArrayList<String> choices) {
		if (choices.contains("R") && !choices.contains("S")) {
			return choices.indexOf("R");
		}
		if (choices.contains("R") && choices.contains("P")) {
			return choices.indexOf("P");
		}
		if (choices.contains("P") && choices.contains("S")) {
			return choices.indexOf("S");
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] record = {0,0,0};
		String[] players = {"User", "AI"};
		String[] possibleChoices = {"R", "P", "S"};
		String[] fullChoiceNames = {"Rock", "Paper", "Scissors"};
		String replayChoice;
		do {
			System.out.println("Select Rock, Paper, or Scissors (put in the first letter of your choice)");
			String RPSchoice = input.nextLine().toUpperCase();
			while (!Arrays.asList(possibleChoices).contains(RPSchoice)) {
				System.out.println("Invalid. Select Rock, Paper, or Scissors (put in the first letter of your choice)");
				RPSchoice = input.nextLine().toUpperCase();
			}
			int oppChoice = (int)(Math.random()*possibleChoices.length);
			System.out.println("AI chose " + fullChoiceNames[oppChoice]);
			ArrayList<String> sideChoices = new ArrayList<String>();
			sideChoices.add(RPSchoice);
			sideChoices.add(possibleChoices[oppChoice]);
			int winner = determineWinner(sideChoices);
			if (winner==-1) {
				System.out.println("You tied!");
				record[record.length-1] += 1;
			} else {
				record[winner] += 1;
				if ((players[winner].equals("User"))) {
					System.out.println("You won!");
				} else {
					System.out.println("You lost!");
				}
			}
			System.out.println("Enter 0 if you don't want to play again.");
 			replayChoice = input.nextLine();
		} while (!replayChoice.equals("0"));
		for (int i = 0; i < record.length; i++) {
			System.out.print(record[i]);
			if (i == record.length-1) {
				System.out.println(" Ties");
			} else if (players[i].equals("User")) {
				System.out.println(" Wins");
			} else if (players[i].equals("AI")) {
				System.out.println(" Losses");
			}
		}
		input.close();
	}
}
