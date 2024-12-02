import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AnswerDeserializer {

	public ArrayList<Answer> getAnswerSetFromFile(String filename) {

		ArrayList<Answer> answerSetToReturn = null;

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			answerSetToReturn = (ArrayList<Answer>) in.readObject();
			System.out.println("Answer set successfully loaded from " + filename);
		} catch (IOException e) {
			System.out.println("Error loading the answer set: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return answerSetToReturn;

	}
}
