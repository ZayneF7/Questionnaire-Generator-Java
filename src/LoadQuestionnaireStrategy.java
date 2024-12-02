import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadQuestionnaireStrategy implements ReturnQuestionnaireStrategy {

	private static final int MIN_OPTION = 1;

	public int questionnaireChoice = -1;
	private int loadStrategy;

	@Override
	public Survey executeStrategy(Scanner scanner) {
		IntValidator inputValidator = new IntValidator();
		QuestionnaireDeserializer questionnaireDeserializer = new QuestionnaireDeserializer();

		System.out.println("Loading Existing Questionnaires");
		System.out.println("=================================================");

		// retrieve file names for all serialized files
		ArrayList<String> serializedFilenames = getSerializedFilenames();

		if (serializedFilenames == null) { // if no serialized file names exists, unable to load a survey
			System.out.println("There is no available questionnaire to load.");
			return null;
		}

		int choice = -1;

		while (true) {
			System.out.println("Select which questionnaire you would like to load");
			System.out.println("=================================================");

			for (int i = 0; i < serializedFilenames.size(); i++) { // output list of file names
				System.out.println((i + 1) + ") " + serializedFilenames.get(i));
			}

			System.out.println("=================================================");
			System.out.println("Enter choice: ");

			String line = scanner.nextLine();

			choice = inputValidator.validateIntInput(MIN_OPTION, serializedFilenames.size(), line);

			if (choice > 0) {
				break;
			}
		}

		this.questionnaireChoice = choice;

		String filename = serializedFilenames.get(choice - 1);
		Survey loadedSurvey = questionnaireDeserializer.getQuestionnaireFromFile(filename);

		return loadedSurvey;
	}

	public ArrayList<String> getSerializedFilenames() {
		File currentFolder = new File(System.getProperty("user.dir"));
		String ext;

		if (loadStrategy == 0) {
			ext = ".ser";
		} else {
			ext = ".tst";
		}

		// retrieve list of serialized questionnaire files
		File[] serializedFiles = currentFolder.listFiles((dir, name) -> name.endsWith(ext));

		if (serializedFiles.length == 0) { // if no serialized files exists, unable to return file names
			return null;
		}

		// retrieve file names for all serialized files
		ArrayList<String> serializedFilenames = new ArrayList<String>();
		for (File file : serializedFiles) {
			serializedFilenames.add(file.getName());
		}

		return serializedFilenames;
	}

	@Override
	public void setStrategyType(int strategyType) {
		this.loadStrategy = strategyType;
	}
}