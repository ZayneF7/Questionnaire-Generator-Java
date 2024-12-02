import java.util.Scanner;

public class MainMenu {

	private static final int MIN_OPTION = 1;
	private static final int MAX_OPTION = 3;

	public void activateMainMenu() {
		Scanner scanner = new Scanner(System.in);
		IntValidator inputValidator = new IntValidator();
		SurveyMainMenu surveyMainMenu = new SurveyMainMenu();
		TestMainMenu testMainMenu = new TestMainMenu();

		System.out.println("Welcome to Questionnaire Generator!");

		while (true) {
			System.out.println("==================================================");
			System.out.println("1. Enter Survey Generator");
			System.out.println("2. Enter Test Generator");
			System.out.println("3. Exit");
			System.out.println("==================================================");
			System.out.println("Enter choice: ");

			String line = scanner.nextLine();
			int choice = inputValidator.validateIntInput(MIN_OPTION, MAX_OPTION, line);

			if (choice == MAX_OPTION) {
				System.out.println("Thank you for using Questionnaire Generator. Goodbye!");
				break;
			} else if (choice == 1) {
				surveyMainMenu.activateSurveyMainMenu(scanner);
			} else if (choice == 2) {
				testMainMenu.activateTestMainMenu(scanner);
			}
		}
	}
}
