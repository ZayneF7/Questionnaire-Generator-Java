import java.util.Scanner;

public class ExistingQuestionnaireContext {
	private ExistingQuestionnaireStrategy existingQuestionnaireStrategy;

	public void setQuestionnaireStrategy(ExistingQuestionnaireStrategy strategy) {
		this.existingQuestionnaireStrategy = strategy;
	}

	public void executeQuestionnaireAction(Scanner scanner, Survey questionnaire) {
		this.existingQuestionnaireStrategy.executeStrategy(scanner, questionnaire);
	}
}
