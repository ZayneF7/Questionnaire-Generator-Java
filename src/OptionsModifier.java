import java.util.ArrayList;
import java.util.Scanner;

public class OptionsModifier {

	private IntValidator inputValidator = new IntValidator();
	private StringValidator stringValidator = new StringValidator();

	public void modifyOptions(Scanner scanner, Question question, int maxOptionCharCount, int strategy) {

		// For strategy, 0 = multiple choice, 1 = matching (alphabetic options), 2 =
		// matching (numeric options)
		while (true) {

			System.out.println("Would you like to modify these options?");
			System.out.println("1. Yes");
			System.out.println("2. No");

			String input = scanner.nextLine().trim();
			int choice = 0;

			choice = inputValidator.validateIntInput(1, 2, input);

			if (choice < 0) {
				continue;
			}

			if (choice == 2) {
				System.out.println("Options were left unmodified.");
				break;
			}

			if (choice == 1) {
				this.actuallyModify(scanner, question, maxOptionCharCount, strategy);
				break;
			}
		}
	}

	private void actuallyModify(Scanner scanner, Question question, int maxOptionCharCount, int strategy) {
		ArrayList<String> options = null;

		while (true) {
			System.out.println("Which option would you like to modify?");

			if (strategy == 0) { // multiple choice
				options = ((MultipleChoiceQuestion) question).getChoices();
			} else if (strategy == 1) { // matching (alphabetic)
				options = ((MatchingQuestion) question).getAlphaMatches();
			} else if (strategy == 2) { // matching (numeric)
				options = ((MatchingQuestion) question).getNumericalMatches();
			}

			for (int i = 0; i < options.size(); i++) {
				System.out.println((i + 1) + ") " + options.get(i));
			}
			System.out.println((options.size() + 1) + ") Exit");

			String optionInput = scanner.nextLine().trim();
			int optionChoice = 0;

			optionChoice = inputValidator.validateIntInput(1, options.size() + 1, optionInput);

			if (optionChoice < 0) {
				continue;
			}

			if (optionChoice == options.size() + 1) {
				System.out.println("Option modification complete.");
				break;
			}

			System.out.println("Enter new option: ");
			String newOption = scanner.nextLine().trim();

			if (stringValidator.validateString(newOption, maxOptionCharCount)) {
				options.set(optionChoice - 1, newOption);
				System.out.println("Option successfully modified.");
			}
		}
	}
}
