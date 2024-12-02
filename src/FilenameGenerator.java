import java.io.File;
import java.util.Scanner;

public abstract class FilenameGenerator {
	private static final int MAX_FILENAME_CHAR_COUNT = 50;
	private String extension; // file extension (.ser or .ans)

	public String generateFilename(Scanner scanner) {
		String inputFilename;
		IntValidator intValidator = new IntValidator();

		while (true) {
			System.out.println(
					"Enter a file name (up to 50 characters, only letters and digits allowed for base filename, ending with "
							+ this.extension + "): ");
			inputFilename = scanner.nextLine().trim();

			if (isValidFilename(inputFilename)) {

				if (!inputFilename.endsWith(this.extension)) { // add appropriate extension to filename if not already
																// present
					inputFilename += this.extension;
				}

				// check if file already exists in project folder
				File file = new File(inputFilename);
				if (file.exists()) {
					System.out.println(inputFilename + " already exists. Would you like to overwrite the file?");

					int choice = -1;

					while (true) {
						System.out.println("1. Yes");
						System.out.println("2. No");

						String inputChoice = scanner.nextLine().trim();
						choice = intValidator.validateIntInput(1, 2, inputChoice);

						if (choice > 0) {
							break;
						}
					}

					if (choice == 1) {
						System.out.println(inputFilename + " will be overwritten with new content.");
						break;
					}

				} else {
					break;
				}
			} else {
				System.out.println(
						"Invalid file name: Please make sure your input does not exceed 50 characters (without the extension), only has letters and digits in the base file name, and ends with "
								+ this.extension + " (optional).");
			}
		}

		return inputFilename;
	}

	private boolean isValidFilename(String filename) {
		// retrieve base filename if there is a .ser extension
		String baseName = filename.endsWith(this.extension) ? filename.substring(0, filename.length() - 4) : filename;

		if (baseName.length() > MAX_FILENAME_CHAR_COUNT) {
			return false;
		}

		// check if any of the characters in the base file name are anything other than
		// letters or digits
		for (char c : baseName.toCharArray()) {
			if (!Character.isLetter(c) && !Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}

	public void setExtension(String ext) {
		this.extension = ext;
	}
}
