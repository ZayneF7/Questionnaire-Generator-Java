import java.util.HashMap;
import java.util.Scanner;

public class SurveyMainMenu {
	private static final int MIN_OPTION = 1;
	private static final int MAX_OPTION = 8;

	public void activateSurveyMainMenu(Scanner scanner) {
		IntValidator inputValidator = new IntValidator();
		ReturnQuestionnaireContext myReturnSurveyContext = new ReturnQuestionnaireContext();
		HashMap<Integer, ReturnQuestionnaireStrategy> intToReturnStrategyHashmap = new HashMap<Integer, ReturnQuestionnaireStrategy>();
		ExistingQuestionnaireContext myExistingSurveyContext = new ExistingQuestionnaireContext();
		HashMap<Integer, ExistingQuestionnaireStrategy> intToExistingStrategyHashmap = new HashMap<Integer, ExistingQuestionnaireStrategy>();

		Survey loadedSurvey = null;

		intToReturnStrategyHashmap.put(1, new CreateQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(2, new DisplayQuestionnaireStrategy());
		intToReturnStrategyHashmap.put(3, new LoadQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(4, new StoreQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(5, new TakeQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(6, new ModifyQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(7, new TabulateQuestionnaireStrategy());

		System.out.println("Survey Generator");

		while (true) {

			System.out.println("==================================");
			System.out.println("1. Create new survey");
			System.out.println("2. Display current survey");
			System.out.println("3. Load existing survey");
			System.out.println("4. Store current survey");
			System.out.println("5. Take existing survey");
			System.out.println("6. Modify current survey");
			System.out.println("7. Tabulate current survey");
			System.out.println("8. Exit Survey Generator");
			System.out.println("==================================");
			System.out.println("Enter choice: ");

			String line = scanner.nextLine();

			int choice = inputValidator.validateIntInput(MIN_OPTION, MAX_OPTION, line);

			if (choice == MAX_OPTION) {
				System.out.println("Exiting Survey Generator");
				break;
			}

			if (choice == 1 || choice == 3) {
				ReturnQuestionnaireStrategy strategy = intToReturnStrategyHashmap.get(choice);
				strategy.setStrategyType(0);
				myReturnSurveyContext.setQuestionnaireStrategy(strategy);
				loadedSurvey = myReturnSurveyContext.executeQuestionnaireAction(scanner);
			} else {
				if (loadedSurvey == null && choice != 5) {
					System.out.println("Error: Cannot execute action because no survey is currently loaded.");
				} else {
					ExistingQuestionnaireStrategy strategy = intToExistingStrategyHashmap.get(choice);
					strategy.setStrategyType(0);
					myExistingSurveyContext.setQuestionnaireStrategy(strategy);
					myExistingSurveyContext.executeQuestionnaireAction(scanner, loadedSurvey);
				}
			}
		}
	}
}
