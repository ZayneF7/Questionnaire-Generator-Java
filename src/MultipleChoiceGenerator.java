import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoiceGenerator implements QuestionGeneratorStrategy {

	private static final int MAX_PROMPT_CHAR_COUNT = 100;
	private static final int MAX_CHOICE_CHAR_COUNT = 50;
	private static final int MIN_NUM_OF_OPTIONS = 2;
	private static final int MAX_NUM_OF_OPTIONS = 10;
	private static final int MIN_NUM_OF_ANSWERS = 1;

	public static int getMaxPromptCharCount() {
		return MAX_PROMPT_CHAR_COUNT;
	}

	public static int getMaxChoiceCharCount() {
		return MAX_CHOICE_CHAR_COUNT;
	}

	public static int getMinNumOfAnswers() {
		return MIN_NUM_OF_ANSWERS;
	}

	@Override
	public void generateQuestion(Survey questionnaire, Scanner scanner) {
		PromptGenerator promptGenerator = new PromptGenerator();
		NumOfOptionsGenerator numOfOptionsGenerator = new NumOfOptionsGenerator();
		ListOfChoicesGenerator listOfChoicesGenerator = new ListOfChoicesGenerator();
		NumOfAnswersGenerator numOfAnswersGenerator = new NumOfAnswersGenerator();

		System.out.println("Multiple Choice Question Generator");
		System.out.println("========================================");

		String newPrompt = promptGenerator.generatePrompt(scanner, MAX_PROMPT_CHAR_COUNT);

		int numOfPossibleOptions = numOfOptionsGenerator.generateNumOfOptions(scanner, MIN_NUM_OF_OPTIONS,
				MAX_NUM_OF_OPTIONS);

		ArrayList<String> listOfChoices = listOfChoicesGenerator.generateListOfChoices(scanner, numOfPossibleOptions,
				MAX_CHOICE_CHAR_COUNT, 0);

		int numOfAnswers = numOfAnswersGenerator.generateNumOfAnswers(scanner, MIN_NUM_OF_ANSWERS,
				numOfPossibleOptions);

		Question question = new MultipleChoiceQuestion(newPrompt, numOfAnswers, listOfChoices);

		if (questionnaire instanceof Test) {
			MultipleChoiceAnswerValidator answerValidator = new MultipleChoiceAnswerValidator();
			System.out.println("Enter correct answer(s):");
			Answer correctAnswer = answerValidator.validateResponse(scanner, question);
			((Test) questionnaire).addCorrectAnswer(correctAnswer);
		}

		questionnaire.addQuestion(question);
	}
}
