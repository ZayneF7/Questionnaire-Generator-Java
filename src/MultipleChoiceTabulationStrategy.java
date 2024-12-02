import java.util.ArrayList;
import java.util.HashMap;

public class MultipleChoiceTabulationStrategy implements QuestionTabulationStrategy {

	@Override
	public void tabulateQuestion(Question question) {
		ArrayList<String> choices = ((MultipleChoiceQuestion) question).getChoices();
		HashMap<Character, Integer> responses = new HashMap<Character, Integer>();

		for (int i = 0; i < choices.size(); i++) {
			char alpha = (char) ('A' + i);
			responses.put(alpha, 0);
		}

		for (int i = 0; i < question.getUserResponses().size(); i++) {
			ArrayList<String> containedAnswer = question.getUserResponses().get(i).getContainedAnswer();
			for (String s : containedAnswer) {
				char responseToIncrement = s.charAt(0);
				responses.put(responseToIncrement, responses.get(responseToIncrement) + 1);
			}
		}

		for (int i = 0; i < choices.size(); i++) {
			char alpha = (char) ('A' + i);
			System.out.println(alpha + ": " + responses.get(alpha));
		}

	}
}
