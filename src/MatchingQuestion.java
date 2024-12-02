import java.util.ArrayList;

public class MatchingQuestion extends Question {
	private ArrayList<String> alphaMatches;
	private ArrayList<String> numericalMatches;

	public MatchingQuestion(String prompt, ArrayList<String> matches, ArrayList<String> matchees) {
		super(prompt, 1);
		this.alphaMatches = matches;
		this.numericalMatches = matchees;
	}

	@Override
	public void displayPrompt() {
		System.out.println(this.prompt);
		System.out.println(
				"Enter a letter followed by a matching number. For example, entering 'A 2' means that you are matching choice A to choice 2. Enter these matches one at a time.");
		this.displayMatchingOptions();
	}

	public void displayMatchingOptions() {
		for (int i = 0; i < alphaMatches.size(); i++) {
			char alpha = (char) ('A' + i);
			System.out.printf("%-4s %-20s %-4s %s%n", alpha + ")", alphaMatches.get(i), (i + 1) + ")",
					numericalMatches.get(i));
		}
		System.out.print("\n");
	}

	public void displayAlphaMatches() {
		for (int i = 0; i < alphaMatches.size(); i++) {
			char alpha = (char) ('A' + i);
			System.out.println(alpha + ") " + alphaMatches.get(i));
		}
	}

	public void displayNumericalMatches() {
		for (int i = 0; i < numericalMatches.size(); i++) {
			System.out.println((i + 1) + ") " + numericalMatches.get(i));
		}
	}

	public int getNumOfMatches() {
		return this.alphaMatches.size();
	}

	public ArrayList<String> getAlphaMatches() {
		return alphaMatches;
	}

	public ArrayList<String> getNumericalMatches() {
		return numericalMatches;
	}
}
