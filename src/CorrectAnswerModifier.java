import java.util.Scanner;

public class CorrectAnswerModifier {

	public void modifyCorrectAnswer(Scanner scanner, Question question, Answer correctAnswer) {
		AnswerValidatorStrategy answerValidator = null;
		IntValidator inputValidator = new IntValidator();

		if (question instanceof TrueFalseQuestion) {
			answerValidator = new TrueFalseAnswerValidator();
		} else if (question instanceof MultipleChoiceQuestion) {
			answerValidator = new MultipleChoiceAnswerValidator();
		} else if (question instanceof ShortAnswerQuestion) {
			answerValidator = new ShortAnswerValidator();
			((ShortAnswerValidator) answerValidator).setAnswerCharCount();
		} else if (question instanceof EssayQuestion) {
			answerValidator = new EssayAnswerValidator();
			((EssayAnswerValidator) answerValidator).setAnswerCharCount();
		} else if (question instanceof MatchingQuestion) {
			answerValidator = new MatchingAnswerValidator();
		} else if (question instanceof ValidDateQuestion) {
			answerValidator = new ValidDateAnswerValidator();
		}

		while (true) {
			System.out.println("Current Correct Answer:");
			for (String answer : correctAnswer.getContainedAnswer()) {
				System.out.println(answer);
			}
			System.out.println("Would you like to change the correct answer?");
			System.out.println("1. Yes");
			System.out.println("2. No");

			String input = scanner.nextLine().trim();
			int choice = 0;

			choice = inputValidator.validateIntInput(1, 2, input);

			if (choice < 0) {
				continue;
			}

			if (choice == 2) {
				System.out.println("Correct answer was left unmodified.");
				break;
			}

			if (choice == 1) {
				System.out.println("Enter new correct answer: ");
				answerValidator.validateResponse(scanner, question);
				break;
			}
		}

	}
}
