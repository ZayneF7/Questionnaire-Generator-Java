public class TrueFalseQuestion extends Question {

	public TrueFalseQuestion(String prompt) {
		super(prompt, 1);
	}

	@Override
	public void displayPrompt() {
		System.out.println(this.prompt);
		System.out.println("Enter true or false (case insensitive):");
		System.out.print("\n");
	}
}
