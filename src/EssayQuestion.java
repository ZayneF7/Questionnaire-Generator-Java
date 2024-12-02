public class EssayQuestion extends LongFormQuestion {
	private static final int MIN_ANSWER_CHAR_COUNT = 100;
	private static final int MAX_ANSWER_CHAR_COUNT = 500;

	public EssayQuestion(String prompt, int numAnswers) {
		super(prompt, numAnswers, MIN_ANSWER_CHAR_COUNT, MAX_ANSWER_CHAR_COUNT);
	}

}
