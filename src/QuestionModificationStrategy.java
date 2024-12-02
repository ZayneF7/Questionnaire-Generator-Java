import java.util.Scanner;

public interface QuestionModificationStrategy {

	public abstract void modifyQuestion(Scanner scanner, Question question);

	public abstract void setCorrectAnswer(Answer answer);

	public abstract void setQuestionnaireStrategy(int strategy);

}
