import java.util.Scanner;

public class PromptModifier {

	private IntValidator inputValidator = new IntValidator();
	private PromptGenerator promptGenerator = new PromptGenerator();

	public void modifyPrompt(Scanner scanner, Question question, int maxPromptCharCount) {
		while (true) {

			System.out.println("Prompt: " + question.getPrompt());

			System.out.println("Would you like to modify the prompt?");
			System.out.println("1. Yes");
			System.out.println("2. No");

			String input = scanner.nextLine().trim();
			int choice = 0;

			choice = inputValidator.validateIntInput(1, 2, input);

			if (choice < 0) {
				continue;
			}

			if (choice == 2) {
				System.out.println("Prompt was left unmodified.");
				break;
			}

			if (choice == 1) {
				String newPrompt = promptGenerator.generatePrompt(scanner, maxPromptCharCount);
				question.setPrompt(newPrompt);
				System.out.println("Prompt has been modified.");
				break;
			}
		}
	}
}
