import java.io.Serializable;
import java.util.ArrayList;

public class Survey implements Serializable {
	protected ArrayList<Question> questions;

	public Survey() {
		this.questions = new ArrayList<Question>();
	}

	public ArrayList<Question> getQuestions() {
		return this.questions;
	}

	public void addQuestion(Question questionToAdd) {
		questions.add(questionToAdd);
	}

	public void displaySelf() {
		for (int i = 0; i < this.questions.size(); i++) {
			System.out.print((i + 1) + ") ");
			this.questions.get(i).displayPrompt();
		}
	}
}
