import java.util.Scanner;

public class TrueFalseAnswerValidator implements AnswerValidatorStrategy {

	@Override
	public Answer validateResponse(Scanner scanner, Question question) {
		String response;
		Answer answerToReturn = new Answer();

		while (true) {

			String input = scanner.nextLine().trim();

			if (input.equalsIgnoreCase("true")) {
				response = "True";
				break;
			} else if (input.equalsIgnoreCase("false")) {
				response = "False";
				break;
			} else {
				System.out.println("Invalid response: Please enter true or false.");
			}
		}

		answerToReturn.addAnswer(response);
		System.out.println("Response saved.");
		return answerToReturn;
	}
}
