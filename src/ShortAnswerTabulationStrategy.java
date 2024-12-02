public class ShortAnswerTabulationStrategy implements QuestionTabulationStrategy {

	@Override
	public void tabulateQuestion(Question question) {
		StandardTabulator.tabulate(question);
	}
}
