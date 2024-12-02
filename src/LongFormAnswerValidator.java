import java.util.Scanner;

public class LongFormAnswerValidator implements AnswerValidatorStrategy {

	private int maxAnswerCharCount;
	private StringValidator stringValidator = new StringValidator();

	@Override
	public Answer validateResponse(Scanner scanner, Question question) {
		Answer answerToReturn = new Answer();
		int numOfAnswers = question.getNumOfPossibleAnswers();

		for (int i = 0; i < numOfAnswers; i++) {
			while (true) {
				char alpha = (char) ('A' + i);
				System.out.print(alpha + ") ");
				String input = scanner.nextLine().trim();

				if (stringValidator.validateString(input, this.maxAnswerCharCount)) {
					answerToReturn.addAnswer(input);
					System.out.println("Response saved.");
					break;
				}
			}
		}

		return answerToReturn;
	}

	public void setMaxAnswerCharCount(int charCount) {
		this.maxAnswerCharCount = charCount;
	}
}
