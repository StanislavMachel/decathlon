package services;

import model.EventTableRow;
import utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventTableServiceImpl implements EventTableService {

	private static final String TABLE_FILE_NAME = "table.csv";

	public List<EventTableRow> getEventTable() {

		File tableFile = getTableFile();

		if (tableFile.exists()) {
			return FileUtils.readFileByLine(tableFile).stream().filter(s -> !s.isEmpty()).map(line -> {
				String[] data = FileUtils.processCsvFileRow(line);
				EventTableRow eventTableRow = new EventTableRow();
				eventTableRow.setEvent(data[0]);
				eventTableRow.setA(Double.parseDouble(data[1]));
				eventTableRow.setB(Double.parseDouble(data[2]));
				eventTableRow.setC(Double.parseDouble(data[3]));
				return eventTableRow;
			}).collect(Collectors.toList());
		} else {
			return new ArrayList<>();
		}
	}

	private File getTableFile() {
		return new File(FileUtils.class.getClassLoader().getResource(TABLE_FILE_NAME).getFile());
	}
}
