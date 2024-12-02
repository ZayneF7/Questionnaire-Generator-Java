public class QuestionTabulationContext {

	private QuestionTabulationStrategy tabulationStrategy;

	public void setTabulationStrategy(QuestionTabulationStrategy tabulationStrategy) {
		this.tabulationStrategy = tabulationStrategy;
	}

	public void executeTabulationStrategy(Question question) {
		this.tabulationStrategy.tabulateQuestion(question);
	}

}
