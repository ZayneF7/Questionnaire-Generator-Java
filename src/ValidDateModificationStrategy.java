import java.util.Scanner;

public class ValidDateModificationStrategy implements QuestionModificationStrategy {
	private Answer correctAnswer;
	private int questionnaireStrategy;

	@Override
	public void modifyQuestion(Scanner scanner, Question question) {
		PromptModifier promptModifier = new PromptModifier();
		CorrectAnswerModifier correctAnswerModifier = new CorrectAnswerModifier();

		int maxPromptCharCount = ValidDateGenerator.getMaxPromptCharCount();

		System.out.println("Modifying Valid Date question");
		System.out.println("===========================================");

		promptModifier.modifyPrompt(scanner, question, maxPromptCharCount);

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
