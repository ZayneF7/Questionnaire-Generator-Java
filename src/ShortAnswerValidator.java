public class ShortAnswerValidator extends LongFormAnswerValidator {

	private static final int MAX_ANSWER_CHAR_COUNT = 50;

	public void setAnswerCharCount() {
		this.setMaxAnswerCharCount(MAX_ANSWER_CHAR_COUNT);
	}
}
