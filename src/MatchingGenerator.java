import java.util.ArrayList;
import java.util.Scanner;

public class MatchingGenerator implements QuestionGeneratorStrategy {
	private static final int MAX_PROMPT_CHAR_COUNT = 100;
	private static final int MAX_MATCH_CHAR_COUNT = 50;
	private static final int MIN_NUM_OF_OPTIONS = 2;
	private static final int MAX_NUM_OF_OPTIONS = 5;

	public static int getMaxPromptCharCount() {
		return MAX_PROMPT_CHAR_COUNT;
	}

	public static int getMaxMatchCharCount() {
		return MAX_MATCH_CHAR_COUNT;
	}

	@Override
	public void generateQuestion(Survey questionnaire, Scanner scanner) {
		PromptGenerator promptGenerator = new PromptGenerator();
		NumOfOptionsGenerator numOfOptionsGenerator = new NumOfOptionsGenerator();
		ListOfChoicesGenerator listOfChoicesGenerator = new ListOfChoicesGenerator();

		System.out.println("Matching Question Generator");
		System.out.println("========================================");

		String newPrompt = promptGenerator.generatePrompt(scanner, MAX_PROMPT_CHAR_COUNT);

		int numOfPossibleMatches = numOfOptionsGenerator.generateNumOfOptions(scanner, MIN_NUM_OF_OPTIONS,
				MAX_NUM_OF_OPTIONS);

		// initialize list of alphabetic matches
		ArrayList<String> listOfAlphaMatches = listOfChoicesGenerator.generateListOfChoices(scanner,
				numOfPossibleMatches, MAX_MATCH_CHAR_COUNT, 1);

		// initialize list of numerical matches
		ArrayList<String> listOfNumericalMatches = listOfChoicesGenerator.generateListOfChoices(scanner,
				numOfPossibleMatches, MAX_MATCH_CHAR_COUNT, 2);

		Question question = new MatchingQuestion(newPrompt, listOfAlphaMatches, listOfNumericalMatches);

		if (questionnaire instanceof Test) {
			MatchingAnswerValidator answerValidator = new MatchingAnswerValidator();
			System.out.println("Enter correct answer:");
			Answer correctAnswer = answerValidator.validateResponse(scanner, question);
			((Test) questionnaire).addCorrectAnswer(correctAnswer);
		}

		questionnaire.addQuestion(question);
	}
}
