import java.util.HashMap;

public class TrueFalseTabulationStrategy implements QuestionTabulationStrategy {

	@Override
	public void tabulateQuestion(Question question) {
		HashMap<String, Integer> responses = new HashMap<String, Integer>();
		responses.put("True", 0);
		responses.put("False", 0);

		for (int i = 0; i < question.getUserResponses().size(); i++) {
			if (question.getUserResponses().get(i).getContainedAnswer().get(0).equals("True")) {
				responses.put("True", responses.get("True") + 1);
			} else {
				responses.put("False", responses.get("False") + 1);
			}
		}

		System.out.printf("True: %d%nFalse: %d%n", responses.get("True"), responses.get("False"));
	}

}
