import java.util.Scanner;

public interface ReturnQuestionnaireStrategy {

	public abstract Survey executeStrategy(Scanner scanner);

	public abstract void setStrategyType(int strategyType);

}
