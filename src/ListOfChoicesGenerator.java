import java.util.ArrayList;
import java.util.Scanner;

public class ListOfChoicesGenerator {

	private StringValidator stringValidator = new StringValidator();

	public ArrayList<String> generateListOfChoices(Scanner scanner, int numOfOptions, int maxChoiceCharCount,
			int strategy) {
		ArrayList<String> listOfChoices = new ArrayList<String>();

		for (int i = 0; i < numOfOptions; i++) {
			char alpha = (char) ('A' + i);
			while (true) {
				if (strategy == 0) { // Enter choice for Multiple Choice question
					System.out.println("Enter choice " + alpha + ": ");
				} else if (strategy == 1) { // Enter choice for alphabetic match for Matching question
					System.out.println("Enter alphabetic match " + alpha + ": ");
				} else if (strategy == 2) { // Enter choice for numerical match for Matching question
					System.out.println("Enter numerical match " + (i + 1) + ": ");
				}

				String inputChoice = scanner.nextLine().trim();

				if (stringValidator.validateString(inputChoice, maxChoiceCharCount)) {
					listOfChoices.add(inputChoice);
					break;
				}
			}
		}

		return listOfChoices;
	}
}
