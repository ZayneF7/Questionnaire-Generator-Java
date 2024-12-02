import java.util.HashMap;
import java.util.Scanner;

public class TestMainMenu {

	private static final int MIN_OPTION = 1;
	private static final int MAX_OPTION = 10;

	public void activateTestMainMenu(Scanner scanner) {
		IntValidator inputValidator = new IntValidator();
		ReturnQuestionnaireContext myReturnTestContext = new ReturnQuestionnaireContext();
		HashMap<Integer, ReturnQuestionnaireStrategy> intToReturnStrategyHashmap = new HashMap<Integer, ReturnQuestionnaireStrategy>();
		ExistingQuestionnaireContext myExistingTestContext = new ExistingQuestionnaireContext();
		HashMap<Integer, ExistingQuestionnaireStrategy> intToExistingStrategyHashmap = new HashMap<Integer, ExistingQuestionnaireStrategy>();

		Test loadedTest = null;

		intToReturnStrategyHashmap.put(1, new CreateQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(2, new DisplayQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(3, new DisplayQuestionnaireWithAnswerStrategy());
		intToReturnStrategyHashmap.put(4, new LoadQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(5, new StoreQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(6, new TakeQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(7, new ModifyQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(8, new TabulateQuestionnaireStrategy());
		intToExistingStrategyHashmap.put(9, new GradeQuestionnaireStrategy());

		System.out.println("Test Generator");

		while (true) {

			System.out.println("====================================================");
			System.out.println("1. Create new test");
			System.out.println("2. Display current test without correct answers");
			System.out.println("3. Display current test with correct answers");
			System.out.println("4. Load existing test");
			System.out.println("5. Store current test");
			System.out.println("6. Take existing test");
			System.out.println("7. Modify current test");
			System.out.println("8. Tabulate current test");
			System.out.println("9. Grade existing test");
			System.out.println("10. Exit Test Generator");
			System.out.println("====================================================");
			System.out.println("Enter choice: ");

			String line = scanner.nextLine();
			int choice = inputValidator.validateIntInput(MIN_OPTION, MAX_OPTION, line);

			if (choice == MAX_OPTION) {
				System.out.println("Exiting Test Generator");
				break;
			}

			if (choice == 1 || choice == 4) {
				ReturnQuestionnaireStrategy strategy = intToReturnStrategyHashmap.get(choice);
				strategy.setStrategyType(1);
				myReturnTestContext.setQuestionnaireStrategy(strategy);
				loadedTest = (Test) myReturnTestContext.executeQuestionnaireAction(scanner);
			} else {
				if (loadedTest == null && choice != 6 && choice != 9) {
					System.out.println("Error: Cannot execute action because no test is currently loaded.");
				} else {
					ExistingQuestionnaireStrategy strategy = intToExistingStrategyHashmap.get(choice);
					strategy.setStrategyType(1);
					myExistingTestContext.setQuestionnaireStrategy(strategy);
					myExistingTestContext.executeQuestionnaireAction(scanner, loadedTest);
				}
			}
		}
	}
}
