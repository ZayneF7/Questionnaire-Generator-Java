import java.util.Scanner;

public class PromptGenerator {
	private StringValidator stringValidator = new StringValidator();

	public String generatePrompt(Scanner scanner, int maxPromptCharCount) {
		String newPrompt;

		while (true) {
			System.out.println("Enter prompt (max = " + maxPromptCharCount + " char): ");
			newPrompt = scanner.nextLine().trim();

			if (stringValidator.validateString(newPrompt, maxPromptCharCount)) {
				break;
			}
		}

		return newPrompt;
	}
}
