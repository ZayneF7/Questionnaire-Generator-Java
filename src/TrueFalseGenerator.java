import java.util.Scanner;

public class TrueFalseGenerator implements QuestionGeneratorStrategy {

	private static final int MAX_PROMPT_CHAR_COUNT = 100;

	public static int getMaxPromptCharCount() {
		return MAX_PROMPT_CHAR_COUNT;
	}

	@Override
	public void generateQuestion(Survey questionnaire, Scanner scanner) {
		PromptGenerator promptGenerator = new PromptGenerator();

		System.out.println("True/False Question Generator");
		System.out.println("========================================");

		String newPrompt = promptGenerator.generatePrompt(scanner, MAX_PROMPT_CHAR_COUNT);

		Question question = new TrueFalseQuestion(newPrompt);

		if (questionnaire instanceof Test) {
			TrueFalseAnswerValidator answerValidator = new TrueFalseAnswerValidator();
			System.out.println("Enter correct answer:");
			Answer correctAnswer = answerValidator.validateResponse(scanner, question);
			((Test) questionnaire).addCorrectAnswer(correctAnswer);
		}

		questionnaire.addQuestion(question);
	}
}
