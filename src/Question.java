import java.io.Serializable;
import java.util.ArrayList;

public abstract class Question implements Serializable {
	protected String prompt;
	protected int numOfPossibleAnswers;
	protected ArrayList<Answer> userResponses;

	public Question(String prompt, int possibleAnswers) {
		this.prompt = prompt;
		this.numOfPossibleAnswers = possibleAnswers;
		this.userResponses = new ArrayList<Answer>();
	}

	public abstract void displayPrompt();

	public String getPrompt() {
		return this.prompt;
	}

	public void setPrompt(String newPrompt) {
		this.prompt = newPrompt;
	}

	public int getNumOfPossibleAnswers() {
		return this.numOfPossibleAnswers;
	}

	public void setNumOfPossibleAnswers(int numOfAnswers) {
		this.numOfPossibleAnswers = numOfAnswers;
	}

	public ArrayList<Answer> getUserResponses() {
		return this.userResponses;
	}

	public void addUserResponse(Answer userResponse) {
		this.userResponses.add(userResponse);
	}

}
