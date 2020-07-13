package services;

import model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import utils.FileUtils;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DecathlonServiceImplTest {

	private static final int CALCULATOR_CALCULATE_TOTAL_RESULT = 1000;

	private DecathlonService decathlonService;

	@Mock
	private DecathlonPointsCalculator decathlonPointsCalculator;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(decathlonPointsCalculator.calculateTotal(Mockito.anyList())).thenReturn(CALCULATOR_CALCULATE_TOTAL_RESULT);
		decathlonService = new DecathlonServiceImpl(decathlonPointsCalculator);
	}

	@Test
	void processInputFile() {

		File inputFile = new File(FileUtils.class.getClassLoader().getResource("test-results.csv").getFile());

		List<Result> results = decathlonService.processInputFile(inputFile);

		assertNotNull(results);
		assertEquals(2, results.size());
		Result firslResult = results.get(0);
		assertNotNull(firslResult);
		assertEquals("John Smith", firslResult.getAhlete());
		List<String> firstResultResultOfEvents = firslResult.getResultOfEvents();
		assertNotNull(firstResultResultOfEvents);
		assertEquals(CALCULATOR_CALCULATE_TOTAL_RESULT, firslResult.getTotalScore());
		assertEquals(10, firstResultResultOfEvents.size());
		assertEquals("12.61", firstResultResultOfEvents.get(0));
		assertEquals("5.00", firstResultResultOfEvents.get(1));
		assertEquals("9.22", firstResultResultOfEvents.get(2));
		assertEquals("1.50", firstResultResultOfEvents.get(3));
		assertEquals("60.39", firstResultResultOfEvents.get(4));
		assertEquals("16.43", firstResultResultOfEvents.get(5));
		assertEquals("21.60", firstResultResultOfEvents.get(6));
		assertEquals("2.60", firstResultResultOfEvents.get(7));
		assertEquals("35.81", firstResultResultOfEvents.get(8));
		assertEquals("5:25.72", firstResultResultOfEvents.get(9));

	}
}