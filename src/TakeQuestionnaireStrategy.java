import java.util.ArrayList;
import java.util.Scanner;

public class TakeQuestionnaireStrategy implements ExistingQuestionnaireStrategy {
	private int takeStrategy;

	@Override
	public void executeStrategy(Scanner scanner, Survey questionnaire) {
		AnswerValidatorContext answerValidatorContext = new AnswerValidatorContext();
		SurveyAnswerFilenameGenerator filenameGenerator = new SurveyAnswerFilenameGenerator();

		// load questionnaire to take
		LoadQuestionnaireStrategy loadQuestionnaireStrategy = new LoadQuestionnaireStrategy();
		loadQuestionnaireStrategy.setStrategyType(this.takeStrategy);
		filenameGenerator.setAnswerExtension();

		Survey questionnaireToTake = loadQuestionnaireStrategy.executeStrategy(scanner);
		int questionnaireChoice = loadQuestionnaireStrategy.questionnaireChoice;
		ArrayList<String> serializedFilenames = loadQuestionnaireStrategy.getSerializedFilenames();
		String questionnaireFilename = serializedFilenames.get(questionnaireChoice - 1);

		ArrayList<Answer> answers = new ArrayList<Answer>();

		System.out.println("Taking questionnaire from file: " + questionnaireFilename);
		System.out.println("=============================================================");

		for (int i = 0; i < questionnaireToTake.getQuestions().size(); i++) {
			Question currentQuestion = questionnaireToTake.getQuestions().get(i);
			System.out.print((i + 1) + ") ");
			currentQuestion.displayPrompt();

			ShortAnswerValidator shortAnswerValidator = new ShortAnswerValidator();
			shortAnswerValidator.setAnswerCharCount();
			EssayAnswerValidator essayAnswerValidator = new EssayAnswerValidator();
			essayAnswerValidator.setAnswerCharCount();

			if (currentQuestion instanceof TrueFalseQuestion) {
				answerValidatorContext.setAnswerValidatorStrategy(new TrueFalseAnswerValidator());
			} else if (currentQuestion instanceof MultipleChoiceQuestion) {
				answerValidatorContext.setAnswerValidatorStrategy(new MultipleChoiceAnswerValidator());
			} else if (currentQuestion instanceof ShortAnswerQuestion) {
				answerValidatorContext.setAnswerValidatorStrategy(shortAnswerValidator);
			} else if (currentQuestion instanceof EssayQuestion) {
				answerValidatorContext.setAnswerValidatorStrategy(essayAnswerValidator);
			} else if (currentQuestion instanceof MatchingQuestion) {
				answerValidatorContext.setAnswerValidatorStrategy(new MatchingAnswerValidator());
			} else if (currentQuestion instanceof ValidDateQuestion) {
				answerValidatorContext.setAnswerValidatorStrategy(new ValidDateAnswerValidator());
			}

			Answer returnedAnswer = answerValidatorContext.executeValidatorAction(scanner, currentQuestion);
			answers.add(returnedAnswer);
			currentQuestion.addUserResponse(returnedAnswer);
		}

		System.out.println("Questionnaire completed.");
		System.out.println("=====================================");

		System.out.println("Save your answers to a file.");
		System.out.println("=====================================");

		String filename = filenameGenerator.generateFilename(scanner);

		if (questionnaireToTake instanceof Test) {
			((Test) questionnaireToTake).addResponseFilename(filename);
			System.out.println("The following filename was saved to the test: " + filename);
		}

		// Save questionnaire to original filename with updated user responses (for
		// surveys and tests), answer set filename (for tests only)
		QuestionnaireSerializer questionnaireSerializer = new QuestionnaireSerializer();
		questionnaireSerializer.serializeQuestionnaireToFile(questionnaireToTake, questionnaireFilename);

		AnswerSerializer serializer = new AnswerSerializer();
		serializer.serializeAnswersToFile(answers, filename);

	}

	@Override
	public void setStrategyType(int strategy) {
		this.takeStrategy = strategy;
	}

}
