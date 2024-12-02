import java.util.Scanner;

public class NumOfAnswersGenerator {

	private IntValidator intValidator = new IntValidator();

	public int generateNumOfAnswers(Scanner scanner, int minNum, int maxNum) {
		int numOfPossibleAnswers;

		while (true) {
			System.out.println("Enter the number of possible answers for this question (max = " + maxNum + "): ");
			String inputNumOfAnswers = scanner.nextLine().trim();
			numOfPossibleAnswers = intValidator.validateIntInput(minNum, maxNum, inputNumOfAnswers);

			if (numOfPossibleAnswers >= 1) {
				break;
			}
		}

		return numOfPossibleAnswers;
	}
}
