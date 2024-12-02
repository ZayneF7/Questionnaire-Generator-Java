public class ShortAnswerQuestion extends LongFormQuestion {

	private static final int MIN_ANSWER_CHAR_COUNT = 50;
	private static final int MAX_ANSWER_CHAR_COUNT = 250;

	public ShortAnswerQuestion(String prompt, int numAnswers) {
		super(prompt, numAnswers, MIN_ANSWER_CHAR_COUNT, MAX_ANSWER_CHAR_COUNT);
	}

}
