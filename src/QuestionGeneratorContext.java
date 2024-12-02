import java.util.Scanner;

public class QuestionGeneratorContext {
	private QuestionGeneratorStrategy generatorStrategy;

	public void setGeneratorStrategy(QuestionGeneratorStrategy strategy) {
		this.generatorStrategy = strategy;
	}

	public void executeStrategy(Survey survey, Scanner scanner) {
		this.generatorStrategy.generateQuestion(survey, scanner);
	}
}
