import java.util.Scanner;

public class MatchingModificationStrategy implements QuestionModificationStrategy {
	private Answer correctAnswer;
	private int questionnaireStrategy;

	@Override
	public void modifyQuestion(Scanner scanner, Question question) {
		PromptModifier promptModifier = new PromptModifier();
		OptionsModifier optionModifier = new OptionsModifier();
		CorrectAnswerModifier correctAnswerModifier = new CorrectAnswerModifier();

		int maxPromptCharCount = MatchingGenerator.getMaxPromptCharCount();
		int maxMatchCharCount = MatchingGenerator.getMaxMatchCharCount();

		System.out.println("Modifying Matching question");
		System.out.println("===========================================");

		promptModifier.modifyPrompt(scanner, question, maxPromptCharCount);

		System.out.println("Current alphabetic matches:");
		((MatchingQuestion) question).displayAlphaMatches();
		optionModifier.modifyOptions(scanner, question, maxMatchCharCount, 1);

		System.out.println("Current numerical matches:");
		((MatchingQuestion) question).displayNumericalMatches();
		optionModifier.modifyOptions(scanner, question, maxMatchCharCount, 2);

		if (this.questionnaireStrategy == 1) {
			correctAnswerModifier.modifyCorrectAnswer(scanner, question, this.correctAnswer);
		}
	}

	@Override
	public void setCorrectAnswer(Answer answer) {
		this.correctAnswer = answer;
	}

	@Override
	public void setQuestionnaireStrategy(int strategy) {
		this.questionnaireStrategy = strategy;
	}
}
