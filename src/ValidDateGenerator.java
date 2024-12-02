import java.util.Scanner;

public class ValidDateGenerator implements QuestionGeneratorStrategy {

	private static final int MAX_PROMPT_CHAR_COUNT = 100;
	private static final int MIN_NUM_OF_ANSWERS = 1;
	private static final int MAX_NUM_OF_ANSWERS = 5;

	public static int getMaxPromptCharCount() {
		return MAX_PROMPT_CHAR_COUNT;
	}

	public static int getMinNumOfAnswers() {
		return MIN_NUM_OF_ANSWERS;
	}

	public static int getMaxNumOfAnswers() {
		return MAX_NUM_OF_ANSWERS;
	}

	@Override
	public void generateQuestion(Survey questionnaire, Scanner scanner) {
		PromptGenerator promptGenerator = new PromptGenerator();
		NumOfAnswersGenerator numOfAnswersGenerator = new NumOfAnswersGenerator();

		System.out.println("Valid Date Question Generator");
		System.out.println("========================================");

		String newPrompt = promptGenerator.generatePrompt(scanner, MAX_PROMPT_CHAR_COUNT);

		int numOfPossibleAnswers = numOfAnswersGenerator.generateNumOfAnswers(scanner, MIN_NUM_OF_ANSWERS,
				MAX_NUM_OF_ANSWERS);

		Question question = new ValidDateQuestion(newPrompt, numOfPossibleAnswers);

		if (questionnaire instanceof Test) {
			ValidDateAnswerValidator answerValidator = new ValidDateAnswerValidator();
			System.out.println("Enter correct answer(s):");
			Answer correctAnswer = answerValidator.validateResponse(scanner, question);
			((Test) questionnaire).addCorrectAnswer(correctAnswer);
		}

		questionnaire.addQuestion(question);
	}
}
