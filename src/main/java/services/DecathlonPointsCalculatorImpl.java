package services;

import model.EventTableRow;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.List;

public class DecathlonPointsCalculatorImpl implements DecathlonPointsCalculator {

	private List<EventTableRow> eventTableRowTable;

	public DecathlonPointsCalculatorImpl(List<EventTableRow> eventTableRowTable) {
		this.eventTableRowTable = eventTableRowTable;
	}

	public int calculateTotal(List<String> ps) {
		int totalScore = 0;

		for (int i = 0; i < ps.size(); i++) {

			try {
				String durationString = ps.get(i).replace(":", "M");
				durationString = "PT" + durationString + "S";
				Duration duration = Duration.parse(durationString);
				double p = duration.getSeconds() + (double) duration.getNano() * Math.pow(10, -9);

				EventTableRow eventTableRowTableEntry = eventTableRowTable.get(i);
				totalScore += calculate(p, eventTableRowTableEntry.getA(), eventTableRowTableEntry.getB(), eventTableRowTableEntry.getC());

			} catch (DateTimeParseException e) {
				e.printStackTrace();
			}
		}
		return totalScore;
	}

	//Points = INT(A(B — P)^C)
	private int calculate(double p, double a, double b, double c) {
		return (int) (a * Math.pow(p - b, c));
	}
}
