import java.util.Scanner;

public interface AnswerValidatorStrategy {

	public abstract Answer validateResponse(Scanner scanner, Question question);
}
