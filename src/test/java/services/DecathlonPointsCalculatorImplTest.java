package services;

import model.EventTableRow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class DecathlonPointsCalculatorImplTest {

	@Test
	void calculateTotal() {
		EventTableRow eventTableRow0 = new EventTableRow();
		eventTableRow0.setA(25.4347);
		eventTableRow0.setB(18);
		eventTableRow0.setC(1.81);

		EventTableRow eventTableRow1 = new EventTableRow();
		eventTableRow1.setA(0.14354);
		eventTableRow1.setB(220);
		eventTableRow1.setC(1.4);

		List<EventTableRow> eventTableRows = Arrays.asList(eventTableRow0, eventTableRow1);

		DecathlonPointsCalculatorImpl calculator = new DecathlonPointsCalculatorImpl(eventTableRows);

		List<String> ps = Arrays.asList("33.48", "6:51.01");

		int result = calculator.calculateTotal(ps);

		int expectedResult = (int) (25.4347 * Math.pow(33.48 - 18, 1.81)) + (int) (0.14354 * Math.pow(411.01 - 220, 1.4));

		Assertions.assertEquals(expectedResult, result);
	}

}