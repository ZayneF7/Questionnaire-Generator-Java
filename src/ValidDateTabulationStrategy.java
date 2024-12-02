public class ValidDateTabulationStrategy implements QuestionTabulationStrategy {

	@Override
	public void tabulateQuestion(Question question) {
		StandardTabulator.tabulate(question);
	}

}
