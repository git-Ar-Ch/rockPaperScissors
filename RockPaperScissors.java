import java.util.ArrayList;
public class RockPaperScissors {
	static int determineWinner (ArrayList<String> choices) {
		if (choices.contains("R") && choices.contains("S")) {
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
	}
}
