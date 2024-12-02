public class StringValidator {

	public boolean validateString(String input, int maxCharCount) {

		if (input.isEmpty()) {
			System.out.println("Invalid input: Input string cannot be empty.");
			return false;
		} else if (input.length() > maxCharCount) {
			System.out.println("Invalid input: Input string annot exceed " + maxCharCount + " characters.");
			return false;
		}

		return true;
	}
}
