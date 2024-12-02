import java.util.Scanner;

public class ReturnQuestionnaireContext {
	private ReturnQuestionnaireStrategy returnStrategy;

	public void setQuestionnaireStrategy(ReturnQuestionnaireStrategy strategy) {
		this.returnStrategy = strategy;
	}

	public Survey executeQuestionnaireAction(Scanner scanner) {
		return this.returnStrategy.executeStrategy(scanner);
	}
}
