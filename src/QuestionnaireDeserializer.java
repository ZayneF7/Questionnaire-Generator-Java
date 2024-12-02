import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class QuestionnaireDeserializer {

	public Survey getQuestionnaireFromFile(String filename) {

		Survey surveyToReturn = null;

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			surveyToReturn = (Survey) in.readObject();
			System.out.println("Questionnaire successfully loaded from " + filename);
		} catch (IOException e) {
			System.out.println("Error loading the questionnaire: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return surveyToReturn;
	}
}
