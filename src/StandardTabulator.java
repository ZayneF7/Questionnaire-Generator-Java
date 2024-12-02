import java.util.ArrayList;
import java.util.HashMap;

public class StandardTabulator {

	public static void tabulate(Question question) {
		HashMap<String, Integer> responses = new HashMap<String, Integer>();

		for (int i = 0; i < question.getUserResponses().size(); i++) {
			ArrayList<String> containedAnswer = question.getUserResponses().get(i).getContainedAnswer();
			for (String answer : containedAnswer) {
				if (responses.containsKey(answer)) {
					responses.put(answer, responses.get(answer) + 1);
				} else {
					responses.put(answer, 1);
				}
			}
		}

		for (String key : responses.keySet()) {
			System.out.println(key + ": " + responses.get(key));
		}
	}
}
