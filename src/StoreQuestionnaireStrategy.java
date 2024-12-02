import java.util.Scanner;

public class StoreQuestionnaireStrategy implements ExistingQuestionnaireStrategy {

	@Override
	public void executeStrategy(Scanner scanner, Survey questionnaire) {
		FilenameGenerator filenameGenerator = null;

		if (questionnaire instanceof Test) {
			System.out.println("Store Current Test");
			filenameGenerator = new TestFilenameGenerator();
			((TestFilenameGenerator) filenameGenerator).setTestExtension();
		} else {
			System.out.println("Store Current Survey");
			filenameGenerator = new SurveyFilenameGenerator();
			((SurveyFilenameGenerator) filenameGenerator).setSurveyExtension();
		}

		System.out.println("========================================");

		String filename = filenameGenerator.generateFilename(scanner);

		// use valid file name to save Survey object to file
		QuestionnaireSerializer serializer = new QuestionnaireSerializer();
		serializer.serializeQuestionnaireToFile(questionnaire, filename);
	}

	@Override
	public void setStrategyType(int strategy) {
	}
}
