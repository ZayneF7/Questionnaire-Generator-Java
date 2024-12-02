import java.util.HashMap;
import java.util.Scanner;

public class CreateQuestionnaireStrategy implements ReturnQuestionnaireStrategy {
	private static final int MIN_OPTION = 1;
	private static final int MAX_OPTION = 7;

	private int creationStrategy; // 0 = Survey, 1 = Test

	@Override
	public Survey executeStrategy(Scanner scanner) {
		IntValidator inputValidator = new IntValidator();
		QuestionGeneratorContext myContext = new QuestionGeneratorContext();
		HashMap<Integer, QuestionGeneratorStrategy> intToQuestionGeneratorHashmap = new HashMap<Integer, QuestionGeneratorStrategy>();

		intToQuestionGeneratorHashmap.put(1, new TrueFalseGenerator());
		intToQuestionGeneratorHashmap.put(2, new MultipleChoiceGenerator());
		intToQuestionGeneratorHashmap.put(3, new ShortAnswerGenerator());
		intToQuestionGeneratorHashmap.put(4, new EssayGenerator());
		intToQuestionGeneratorHashmap.put(5, new MatchingGenerator());
		intToQuestionGeneratorHashmap.put(6, new ValidDateGenerator());

		Survey questionnaire;

		if (this.creationStrategy == 0) {
			questionnaire = new Survey();
			System.out.println("Create New Survey");
		} else {
			questionnaire = new Test();
			System.out.println("Create New Test");
		}

		while (true) {

			System.out.println("Select which type of question you would like to add");
			System.out.println("=========================================================");
			System.out.println("1. True/False");
			System.out.println("2. Multiple Choice");
			System.out.println("3. Short Answer");
			System.out.println("4. Essay");
			System.out.println("5. Matching");
			System.out.println("6. Valid Date");
			System.out.println("7. Return questionnaire to main menu");
			System.out.println("=========================================================");
			System.out.println("Enter choice: ");

			String line = scanner.nextLine();

			int choice = inputValidator.validateIntInput(MIN_OPTION, MAX_OPTION, line);

			if (choice < 0) {
				continue;
			}

			if (choice != MAX_OPTION) {
				QuestionGeneratorStrategy generatorStrategy = intToQuestionGeneratorHashmap.get(choice);
				myContext.setGeneratorStrategy(generatorStrategy);
				myContext.executeStrategy(questionnaire, scanner);

			}

			if (choice == MAX_OPTION) {
				System.out.println("Returning to main menu.");
				break;
			}

		}

		if (questionnaire.getQuestions().isEmpty()) {
			System.out.println("No questionnaire was created.");
			return null;
		}

		System.out.println("A questionnaire was created.");
		System.out.println(
				"REMINDER: If you would like to save it to a file, you must store this questionnaire before creating another.");

		return questionnaire;
	}

	@Override
	public void setStrategyType(int strategy) {
		this.creationStrategy = strategy;
	}
}
