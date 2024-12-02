import java.io.Serializable;
import java.util.ArrayList;

public class Answer implements Serializable {
	private ArrayList<String> containedAnswer = new ArrayList<String>();

	public ArrayList<String> getContainedAnswer() {
		return this.containedAnswer;
	}

	public void addAnswer(String response) {
		containedAnswer.add(response);
	}
}
