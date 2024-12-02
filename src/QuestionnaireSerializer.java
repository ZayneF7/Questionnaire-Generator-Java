import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class QuestionnaireSerializer {

	public void serializeQuestionnaireToFile(Survey questionnaire, String filename) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(questionnaire);
			System.out.println("Questionnaire successfully saved to " + filename);
		} catch (IOException e) {
			System.out.println("Error saving the questionnaire: " + e.getMessage());
		}
	}

}
