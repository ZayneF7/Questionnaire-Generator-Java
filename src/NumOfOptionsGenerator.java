import java.util.Scanner;

public class NumOfOptionsGenerator {
	private IntValidator intValidator = new IntValidator();

	public int generateNumOfOptions(Scanner scanner, int minNum, int maxNum) {
		int numOfPossibleOptions;

		while (true) {
			System.out.println("Enter the number of options for this question (max = " + maxNum + "): ");
			String inputNumOfOptions = scanner.nextLine().trim();
			numOfPossibleOptions = intValidator.validateIntInput(minNum, maxNum, inputNumOfOptions);

			if (numOfPossibleOptions >= 1) {
				break;
			}
		}

		return numOfPossibleOptions;
	}
}
