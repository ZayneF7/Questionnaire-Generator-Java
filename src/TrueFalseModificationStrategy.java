import java.util.Scanner;

public class TrueFalseModificationStrategy implements QuestionModificationStrategy {
	private Answer correctAnswer;
	private int questionnaireStrategy;

	@Override
	public void modifyQuestion(Scanner scanner, Question question) {
		PromptModifier promptModifier = new PromptModifier();
		CorrectAnswerModifier correctAnswerModifier = new CorrectAnswerModifier();

		System.out.println("Modifying True/False question");
		System.out.println("===========================================");
		int maxPromptCharCount = TrueFalseGenerator.getMaxPromptCharCount();
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
