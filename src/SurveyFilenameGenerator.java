public class SurveyFilenameGenerator extends FilenameGenerator {
	private static final String SURVEY_EXTENSION = ".ser";

	public void setSurveyExtension() {
		this.setExtension(SURVEY_EXTENSION);
	}
}
