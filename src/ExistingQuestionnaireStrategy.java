import java.util.Scanner;

public interface ExistingQuestionnaireStrategy {

	public abstract void executeStrategy(Scanner scanner, Survey survey);

	public abstract void setStrategyType(int strategy);

}
