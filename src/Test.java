import java.util.ArrayList;

public class Test extends Survey {

	private ArrayList<Answer> correctAnswers;
	private ArrayList<String> responseFilenames;

	public Test() {
		this.correctAnswers = new ArrayList<Answer>();
		this.responseFilenames = new ArrayList<String>();
	}

	public void displaySelfWithCorrectAnswers() {
		for (int i = 0; i < this.questions.size(); i++) {
			System.out.print((i + 1) + ") ");
			this.questions.get(i).displayPrompt();

			System.out.println("Correct Answer:");

			for (String answer : correctAnswers.get(i).getContainedAnswer()) {
				System.out.println(answer);
			}

			System.out.print("\n");
		}
	}

	public ArrayList<Answer> getCorrectAnswers() {
		return this.correctAnswers;
	}

	public ArrayList<String> getResponseFilenames() {
		return this.responseFilenames;
	}

	public void addCorrectAnswer(Answer answer) {
		this.correctAnswers.add(answer);
	}

	public void addResponseFilename(String filename) {
		this.responseFilenames.add(filename);
	}
}
