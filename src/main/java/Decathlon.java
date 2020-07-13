import model.Results;
import services.*;
import utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decathlon {

	private static final String OUTPUT_FILE_NAME = "output.xml";

	public static void main(String[] args) throws FileNotFoundException {

		EventTableService eventTableService = new EventTableServiceImpl();

		DecathlonPointsCalculatorImpl calculator = new DecathlonPointsCalculatorImpl(eventTableService.getEventTable());

		File inputFile = readInputFile();

		DecathlonService decathlonService = new DecathlonServiceImpl(calculator);

		Results results = new Results(decathlonService.processInputFile(inputFile));

		FileUtils.saveObjectToXml(OUTPUT_FILE_NAME, results);
	}

	private static File readInputFile() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please provide absolute path of result csv file: ");

		String filePath = scanner.nextLine(); // C:\_dev\decathlon\results.csv

		if (filePath.isEmpty() && scanner.hasNextLine()) {
			filePath = scanner.nextLine();
		}

		File inputFile = new File(filePath);

		while (!inputFile.exists()) {
			System.out.printf("File %s not exists\n", inputFile.getPath());
			System.out.println("Please provide absolute path of result csv file: ");

			filePath = scanner.nextLine();

			if (filePath.isEmpty() && scanner.hasNextLine()) {
				filePath = scanner.nextLine();
			}

			inputFile = new File(filePath);
		}

		return inputFile;
	}
}
