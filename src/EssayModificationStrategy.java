import java.util.Scanner;

public class EssayModificationStrategy implements QuestionModificationStrategy {

	@Override
	public void modifyQuestion(Scanner scanner, Question question) {
		PromptModifier promptModifier = new PromptModifier();

		int maxPromptCharCount = EssayGenerator.getMaxPromptCharCount();

		System.out.println("Modifying Essay question");
		System.out.println("===========================================");

		promptModifier.modifyPrompt(scanner, question, maxPromptCharCount);
	}

	@Override
	public void setCorrectAnswer(Answer answer) {
	}

	@Override
	public void setQuestionnaireStrategy(int strategy) {
	}
}
