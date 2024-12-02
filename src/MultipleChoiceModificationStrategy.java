import java.util.Scanner;

public class MultipleChoiceModificationStrategy implements QuestionModificationStrategy {
	private Answer correctAnswer;
	private int questionnaireStrategy;

	@Override
	public void modifyQuestion(Scanner scanner, Question question) {
		PromptModifier promptModifier = new PromptModifier();
		OptionsModifier optionModifier = new OptionsModifier();
		CorrectAnswerModifier correctAnswerModifier = new CorrectAnswerModifier();

		int maxPromptCharCount = MultipleChoiceGenerator.getMaxPromptCharCount();
		int maxChoiceCharCount = MultipleChoiceGenerator.getMaxChoiceCharCount();

		System.out.println("Modifying Multiple Choice question");
		System.out.println("===========================================");

		promptModifier.modifyPrompt(scanner, question, maxPromptCharCount);

		System.out.println("Current answer choices:");
		((MultipleChoiceQuestion) question).displayMultipleChoiceOptions();
		optionModifier.modifyOptions(scanner, question, maxChoiceCharCount, 0);

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
