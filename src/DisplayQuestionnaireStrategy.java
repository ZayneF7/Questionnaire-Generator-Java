import java.util.Scanner;

public class DisplayQuestionnaireStrategy implements ExistingQuestionnaireStrategy {

	@Override
	public void executeStrategy(Scanner scanner, Survey survey) {
		survey.displaySelf();
	}

	@Override
	public void setStrategyType(int strategy) {
	}
}
