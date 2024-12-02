import java.util.Scanner;

public class EssayGenerator implements QuestionGeneratorStrategy {
	private static final int MAX_PROMPT_CHAR_COUNT = 200;
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

		System.out.println("Essay Question Generator");
		System.out.println("========================================");

		String newPrompt = promptGenerator.generatePrompt(scanner, MAX_PROMPT_CHAR_COUNT);
		int numAnswers = numOfAnswersGenerator.generateNumOfAnswers(scanner, MIN_NUM_OF_ANSWERS, MAX_NUM_OF_ANSWERS);

		Question question = new EssayQuestion(newPrompt, numAnswers);
		questionnaire.addQuestion(question);

		Answer essayCorrectAnswer = new Answer();
		essayCorrectAnswer.addAnswer("N/A");

		if (questionnaire instanceof Test) {
			((Test) questionnaire).addCorrectAnswer(essayCorrectAnswer);
		}
	}
}
