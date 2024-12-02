public class ValidDateQuestion extends Question {

	public ValidDateQuestion(String prompt, int possibleAnswers) {
		super(prompt, possibleAnswers);
	}

	@Override
	public void displayPrompt() {
		System.out.println(this.prompt);
		if (this.numOfPossibleAnswers == 1) {
			System.out.println("Enter 1 date in MM-DD-YYYY format:");
		} else {
			System.out.println("Enter " + this.numOfPossibleAnswers + " dates in MM-DD-YYYY format:");
		}
		System.out.print("\n");
	}
}
