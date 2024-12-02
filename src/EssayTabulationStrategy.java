public class EssayTabulationStrategy implements QuestionTabulationStrategy {

	@Override
	public void tabulateQuestion(Question question) {

		for (Answer response : question.getUserResponses()) {
			for (String answer : response.getContainedAnswer()) {
				System.out.println(answer);
				System.out.print("\n");
			}
		}
	}

}
