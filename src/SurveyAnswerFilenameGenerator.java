public class SurveyAnswerFilenameGenerator extends FilenameGenerator {
	private static final String ANSWER_EXTENSION = ".ans";

	public void setAnswerExtension() {
		this.setExtension(ANSWER_EXTENSION);
	}
}
