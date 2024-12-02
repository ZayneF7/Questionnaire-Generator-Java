import java.util.ArrayList;
import java.util.Scanner;

public class MatchingAnswerValidator implements AnswerValidatorStrategy {

	@Override
	public Answer validateResponse(Scanner scanner, Question question) {
		Answer answerToReturn = new Answer();
		ArrayList<Character> usedAlphaChoices = new ArrayList<Character>();
		ArrayList<Integer> usedNumChoices = new ArrayList<Integer>();

		int numOptions = ((MatchingQuestion) question).getNumOfMatches();

		for (int i = 0; i < numOptions; i++) {
			char alpha = (char) ('A' + i);

			while (true) {
				String input = scanner.nextLine().trim().toUpperCase();

				if (input.length() < 3) {
					System.out.println("Invalid input: response is not of appropriate length");
					continue;
				}

				String substring = input.substring(2);
				char charToValidate;
				int numToValidate;

				if (Character.isLetter(input.charAt(0)) && Character.isWhitespace(input.charAt(1))
						&& substring.matches("\\d+")) {
					charToValidate = input.charAt(0);
					numToValidate = Integer.parseInt(substring);
				} else {
					System.out.println("Invalid input: response is improperly formatted");
					continue;
				}

				if (charToValidate != alpha) {
					System.out.println("Invalid input: You must enter alphabetic matches in order");
					continue;
				}

				if (usedNumChoices.contains(numToValidate)) {
					System.out.println("Invalid input: Your numerical match was already selected");
					continue;
				}

				if (!(1 <= numToValidate && numToValidate <= numOptions)) {
					System.out.println("Invalid input: Your numerical match is out of bounds");
					continue;
				}

				usedNumChoices.add(numToValidate);
				answerToReturn.addAnswer(input);
				System.out.println("Response saved.");
				break;
			}
		}

		return answerToReturn;
	}
}
