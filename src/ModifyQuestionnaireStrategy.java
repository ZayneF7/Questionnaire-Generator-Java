import java.util.Scanner;

public class ModifyQuestionnaireStrategy implements ExistingQuestionnaireStrategy {

	private static final int MIN_OPTION = 0;

	private IntValidator inputValidator = new IntValidator();
	private QuestionModificationContext modificationContext = new QuestionModificationContext();

	@Override
	public void executeStrategy(Scanner scanner, Survey questionnaire) {
		int numOfQuestions = questionnaire.getQuestions().size();

		System.out.println("Modify Current Questionnaire");

		while (true) {
			Question questionToModify;
			Answer correctAnswer = null;
			int strategy = 0;

			System.out.println("Select the question you would like to modify");
			System.out.println("=============================================================================");
			questionnaire.displaySelf();
			System.out.println((numOfQuestions + 1) + ") Return to main menu");
			System.out.println("=============================================================================");
			System.out.println("Enter choice: ");

			String line = scanner.nextLine();

			int choice = inputValidator.validateIntInput(MIN_OPTION, numOfQuestions + 1, line);

			if (choice < 0) {
				continue;
			}

			if (choice == numOfQuestions + 1) {
				System.out.println("Returning to main menu.");
				System.out.println(
						"REMINDER: You must store the survey to the initial filename to save changes to the original file.");
				break;
			} else {
				questionToModify = questionnaire.getQuestions().get(choice - 1);
				if (questionnaire instanceof Test) {
					correctAnswer = ((Test) questionnaire).getCorrectAnswers().get(choice - 1);
					strategy = 1;
				}
			}

			if (questionToModify instanceof TrueFalseQuestion) {
				modificationContext.setModificationStrategy(new TrueFalseModificationStrategy());
			} else if (questionToModify instanceof MultipleChoiceQuestion) {
				modificationContext.setModificationStrategy(new MultipleChoiceModificationStrategy());
			} else if (questionToModify instanceof ShortAnswerQuestion) {
				modificationContext.setModificationStrategy(new ShortAnswerModificationStrategy());
			} else if (questionToModify instanceof EssayQuestion) {
				modificationContext.setModificationStrategy(new EssayModificationStrategy());
			} else if (questionToModify instanceof MatchingQuestion) {
				modificationContext.setModificationStrategy(new MatchingModificationStrategy());
			} else if (questionToModify instanceof ValidDateQuestion) {
				modificationContext.setModificationStrategy(new ValidDateModificationStrategy());
			}

			modificationContext.setCorrectAnswer(correctAnswer);
			modificationContext.setQuestionnaireStrategy(strategy);
			modificationContext.executeModificationStrategy(scanner, questionToModify);

		}
	}

	@Override
	public void setStrategyType(int strategy) {
	}
}
