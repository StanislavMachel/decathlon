package services;

import model.Result;
import utils.FileUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class DecathlonServiceImpl implements DecathlonService {

	private final DecathlonPointsCalculator calculator;

	public DecathlonServiceImpl(DecathlonPointsCalculator calculator) {
		this.calculator = calculator;
	}

	public List<Result> processInputFile(File inputFile) {
		return FileUtils.readFileByLine(inputFile).stream().filter(s -> !s.isEmpty()).map(line -> {
			String[] data = FileUtils.processCsvFileRow(line);

			Result result = new Result();
			result.setAhlete(data[0]);

			for (int i = 1; i < data.length; i++) {
				result.addResultOfEvent(data[i].replace(" ", ""));
			}

			result.setTotalScore(calculator.calculateTotal(result.getResultOfEvents()));
			return result;
		}).collect(Collectors.toList());
	}
}
