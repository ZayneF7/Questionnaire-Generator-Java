import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoiceAnswerValidator implements AnswerValidatorStrategy {

	@Override
	public Answer validateResponse(Scanner scanner, Question question) {
		Answer answerToReturn = new Answer();
		ArrayList<Character> usedChoices = new ArrayList<Character>();

		int numAnswers = question.getNumOfPossibleAnswers();
		int numChoices = ((MultipleChoiceQuestion) question).getNumOfChoices();

		for (int i = 0; i < numAnswers; i++) {

			while (true) {
				String input = scanner.nextLine().trim().toUpperCase();

				if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
					System.out.println("Invalid input: response must be a single letter (case insensitive)");
					continue;
				}

				char charToValidate = input.charAt(0);

				if (usedChoices.contains(charToValidate)) {
					System.out.println("Invalid input: this choice was already selected");
					continue;
				}

				if ('A' <= charToValidate && charToValidate <= (char) ('A' + numChoices - 1)) {
					usedChoices.add(charToValidate);
					answerToReturn.addAnswer(input);
					System.out.println("Response saved.");
					break;
				} else {
					System.out.println("Invalid input: choice must be within the range of provided choices");
				}
			}
		}

		return answerToReturn;

	}
}
