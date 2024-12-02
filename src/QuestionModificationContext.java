import java.util.Scanner;

public class QuestionModificationContext {
	private QuestionModificationStrategy modificationStrategy;

	public void setModificationStrategy(QuestionModificationStrategy modificationStrategy) {
		this.modificationStrategy = modificationStrategy;
	}

	public void executeModificationStrategy(Scanner scanner, Question question) {
		modificationStrategy.modifyQuestion(scanner, question);
	}

	public void setCorrectAnswer(Answer answer) {
		this.modificationStrategy.setCorrectAnswer(answer);
	}

	public void setQuestionnaireStrategy(int strategy) {
		this.modificationStrategy.setQuestionnaireStrategy(strategy);
	}
}
