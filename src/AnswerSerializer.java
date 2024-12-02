import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AnswerSerializer {

	public void serializeAnswersToFile(ArrayList<Answer> answers, String filename) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(answers);
			System.out.println("Questionnaire responses successfully saved to " + filename);
		} catch (IOException e) {
			System.out.println("Error saving the responses: " + e.getMessage());
		}
	}
}
