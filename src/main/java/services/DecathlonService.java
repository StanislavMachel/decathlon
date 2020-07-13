package services;

import model.Result;

import java.io.File;
import java.util.List;

public interface DecathlonService {
	List<Result> processInputFile(File inputFile);
}
