import java.util.ArrayList;
import java.util.HashMap;

public class MatchingTabulationStrategy implements QuestionTabulationStrategy {

	@Override
	public void tabulateQuestion(Question question) {
		HashMap<ArrayList<String>, Integer> responses = new HashMap<ArrayList<String>, Integer>();

		for (int i = 0; i < question.getUserResponses().size(); i++) {
			ArrayList<String> containedAnswer = question.getUserResponses().get(i).getContainedAnswer();
			if (responses.containsKey(containedAnswer)) {
				responses.put(containedAnswer, responses.get(containedAnswer) + 1);
			} else {
				responses.put(containedAnswer, 1);
			}
		}

		for (ArrayList<String> key : responses.keySet()) {
			for (String answer : key) {
				System.out.println(answer);
			}
			System.out.println(responses.get(key));
		}
	}
}
