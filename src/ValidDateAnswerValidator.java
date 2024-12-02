import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidDateAnswerValidator implements AnswerValidatorStrategy {

	@Override
	public Answer validateResponse(Scanner scanner, Question question) {
		Answer answerToReturn = new Answer();
		int numOfAnswers = question.getNumOfPossibleAnswers();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

		for (int i = 0; i < numOfAnswers; i++) {
			while (true) {
				String input = scanner.nextLine().trim();
				try {
					LocalDate.parse(input, formatter);
					answerToReturn.addAnswer(input);
					System.out.println("Response saved.");
					break;
				} catch (DateTimeParseException e) {
					System.out.println("Error converting input into date format. Try again.");
					continue;
				}
			}
		}

		return answerToReturn;
	}
}
