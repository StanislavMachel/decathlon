package services;

import model.EventTableRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EventTableServiceImplTest {

	private EventTableService eventTableService;

	@BeforeEach
	void setUp() {
		eventTableService = new EventTableServiceImpl();
	}

	@Test
	void getEventTable() {
		List<EventTableRow> results = eventTableService.getEventTable();
		assertNotNull(results);
		assertEquals(2, results.size());
		assertNotNull(results.get(0));
		assertEquals("100 m", results.get(0).getEvent());
		assertEquals(25.05, results.get(0).getA());
		assertEquals(10.6, results.get(0).getB());
		assertEquals(1.88, results.get(0).getC());

		assertNotNull(results.get(1));
		assertEquals("Long jump", results.get(1).getEvent());
		assertEquals(0.15, results.get(1).getA());
		assertEquals(200.5, results.get(1).getB());
		assertEquals(1.5, results.get(1).getC());
	}
}