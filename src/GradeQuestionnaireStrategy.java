import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GradeQuestionnaireStrategy implements ExistingQuestionnaireStrategy {
	private static final int MIN_OPTION = 1;

	private int gradeStrategy;

	@Override
	public void executeStrategy(Scanner scanner, Survey questionnaire) {
		IntValidator inputValidator = new IntValidator();
		AnswerDeserializer answerDeserializer = new AnswerDeserializer();

		System.out.println("Grading Questionnaire");
		System.out.println("========================================");

		LoadQuestionnaireStrategy loadQuestionnaireStrategy = new LoadQuestionnaireStrategy();
		loadQuestionnaireStrategy.setStrategyType(this.gradeStrategy);

		Survey questionnaireToGrade = loadQuestionnaireStrategy.executeStrategy(scanner);

		if (questionnaireToGrade == null) {
			return;
		}

		Test testToGrade = (Test) questionnaireToGrade;

		if (testToGrade.getResponseFilenames().isEmpty()) {
			System.out.println("There is no available answer set to grade");
			return;
		}

		int choice = -1;

		while (true) {
			System.out.println("Select the answer set you would like to grade");
			System.out.println("====================================================");
			for (int i = 0; i < testToGrade.getResponseFilenames().size(); i++) {
				System.out.println((i + 1) + ") " + testToGrade.getResponseFilenames().get(i));
			}

			System.out.println("=================================================");
			System.out.println("Enter choice: ");

			String line = scanner.nextLine();

			choice = inputValidator.validateIntInput(MIN_OPTION, testToGrade.getResponseFilenames().size(), line);

			if (choice > 0) {
				break;
			}
		}

		String responseFilename = testToGrade.getResponseFilenames().get(choice - 1);
		ArrayList<Answer> answerSet = answerDeserializer.getAnswerSetFromFile(responseFilename);

		float score = 0;
		float questionWorth = (float) 100 / testToGrade.getQuestions().size();
		int numOfEssayQuestions = 0;

		ArrayList<Answer> correctAnswers = testToGrade.getCorrectAnswers();

		for (int i = 0; i < correctAnswers.size(); i++) {
			if (correctAnswers.get(i).getContainedAnswer().get(0).equals("N/A")) {
				numOfEssayQuestions += 1;
			} else {
				HashSet<String> correctAnswerSet = new HashSet<>(correctAnswers.get(i).getContainedAnswer());
				HashSet<String> userAnswerSet = new HashSet<>(answerSet.get(i).getContainedAnswer());
				if (correctAnswerSet.equals(userAnswerSet)) {
					score += questionWorth;
				}
			}
		}

		float autogradedPoints = 100 - (numOfEssayQuestions * questionWorth);

		System.out.printf("You scored a %.2f on the test.%n", score);

		if (autogradedPoints == 100) {
			System.out.println("There is no essay question, so the entire test was autograded.");
		} else {
			System.out.printf(
					"The test has %d essay question(s), so only %.2f out of 100 points could be autograded.%n",
					numOfEssayQuestions, autogradedPoints);
		}

	}

	@Override
	public void setStrategyType(int strategy) {
		this.gradeStrategy = strategy;
	}
}
