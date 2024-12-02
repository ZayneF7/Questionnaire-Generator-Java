import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {
	private ArrayList<String> choices;

	public MultipleChoiceQuestion(String prompt, int numAnswers, ArrayList<String> choices) {
		super(prompt, numAnswers);
		this.choices = choices;
	}

	@Override
	public void displayPrompt() {
		System.out.println(this.prompt);
		System.out.println("Select " + this.numOfPossibleAnswers + " answer(s): ");
		this.displayMultipleChoiceOptions();
		System.out.print("\n");
	}

	public void displayMultipleChoiceOptions() {
		for (int i = 0; i < this.choices.size(); i++) {
			String choiceToPrint = this.choices.get(i);
			char alpha = (char) ('A' + i);
			System.out.print(alpha + ". " + choiceToPrint + "\n");
		}
	}

	public int getNumOfChoices() {
		return this.choices.size();
	}

	public ArrayList<String> getChoices() {
		return this.choices;
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}
}
