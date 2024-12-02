import java.util.Scanner;

public class AnswerValidatorContext {
	private AnswerValidatorStrategy answerValidatorStrategy;

	public void setAnswerValidatorStrategy(AnswerValidatorStrategy validatorStrategy) {
		this.answerValidatorStrategy = validatorStrategy;
	}

	public Answer executeValidatorAction(Scanner scanner, Question question) {
		return this.answerValidatorStrategy.validateResponse(scanner, question);
	}
}
