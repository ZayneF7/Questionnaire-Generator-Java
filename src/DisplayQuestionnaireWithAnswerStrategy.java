import java.util.Scanner;

public class DisplayQuestionnaireWithAnswerStrategy implements ExistingQuestionnaireStrategy {

	@Override
	public void executeStrategy(Scanner scanner, Survey survey) {
		((Test) survey).displaySelfWithCorrectAnswers();
	}

	@Override
	public void setStrategyType(int strategy) {
	}
}
