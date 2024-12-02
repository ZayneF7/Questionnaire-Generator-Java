public abstract class LongFormQuestion extends Question {
	private int minCharCountForAnswers;
	private int maxCharCountForAnswers;

	public LongFormQuestion(String prompt, int numAnswers, int minCount, int maxCount) {
		super(prompt, numAnswers);
		this.minCharCountForAnswers = minCount;
		this.maxCharCountForAnswers = maxCount;
	}

	@Override
	public void displayPrompt() {
		System.out.println(this.prompt);
		System.out.println("Enter " + this.numOfPossibleAnswers + " answer(s): ");
		System.out.print("\n");
	}
}
