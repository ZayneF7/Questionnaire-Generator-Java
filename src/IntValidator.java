public class IntValidator {

	public int validateIntInput(int minNum, int maxNum, String inputNum) {
		int choice = -1;
		try {
			int intInput = Integer.valueOf(inputNum);
			if (minNum <= intInput && intInput <= maxNum) {
				choice = intInput;
			} else if (maxNum > minNum) {
				System.out.println("Invalid input: Please input a value between " + minNum + " and " + maxNum + ".");
			} else {
				System.out.println("Invalid input: Please input " + minNum + ".");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input: Please enter a valid integer.");
		}
		return choice;
	}
}
