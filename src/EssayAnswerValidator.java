public class EssayAnswerValidator extends LongFormAnswerValidator {

	private static final int MAX_ANSWER_CHAR_COUNT = 100;

	public void setAnswerCharCount() {
		this.setMaxAnswerCharCount(MAX_ANSWER_CHAR_COUNT);
	}
}
