import java.util.Scanner;

public class TabulateQuestionnaireStrategy implements ExistingQuestionnaireStrategy {

	@Override
	public void executeStrategy(Scanner scanner, Survey questionnaire) {
		QuestionTabulationContext tabulationContext = new QuestionTabulationContext();

		System.out.println("Tabulating questionnaire");
		System.out.println("==========================================");

		for (int i = 0; i < questionnaire.getQuestions().size(); i++) {

			Question currentQuestion = questionnaire.getQuestions().get(i);

			if (currentQuestion instanceof TrueFalseQuestion) {
				tabulationContext.setTabulationStrategy(new TrueFalseTabulationStrategy());
			} else if (currentQuestion instanceof MultipleChoiceQuestion) {
				tabulationContext.setTabulationStrategy(new MultipleChoiceTabulationStrategy());
			} else if (currentQuestion instanceof ShortAnswerQuestion) {
				tabulationContext.setTabulationStrategy(new ShortAnswerTabulationStrategy());
			} else if (currentQuestion instanceof EssayQuestion) {
				tabulationContext.setTabulationStrategy(new EssayTabulationStrategy());
			} else if (currentQuestion instanceof MatchingQuestion) {
				tabulationContext.setTabulationStrategy(new MatchingTabulationStrategy());
			} else if (currentQuestion instanceof ValidDateQuestion) {
				tabulationContext.setTabulationStrategy(new ValidDateTabulationStrategy());
			}

			System.out.println((i + 1) + ") " + currentQuestion.getPrompt());
			System.out.print("\n");
			tabulationContext.executeTabulationStrategy(currentQuestion);
			System.out.print("\n");
		}
	}

	@Override
	public void setStrategyType(int strategy) {
	}
}
