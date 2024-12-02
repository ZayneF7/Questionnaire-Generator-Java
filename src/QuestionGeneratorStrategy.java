import java.util.Scanner;

public interface QuestionGeneratorStrategy {

	public static final StringValidator STRING_VALIDATOR = new StringValidator();

	public void generateQuestion(Survey survey, Scanner scanner);

}
