package utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileUtilsTest {

	@Test
	void processCsvFileRow() {
		File file = new File(FileUtils.class.getClassLoader().getResource("fileUtilsTestFile.txt").getFile());

		List<String> results = FileUtils.readFileByLine(file);

		assertNotNull(results);
		assertEquals(3, results.size());
		assertEquals("test1", results.get(0));
		assertEquals("test2", results.get(1));
		assertEquals(" ", results.get(2));
	}

	@Test
	void readFileByLine() {
		String[] results = FileUtils.processCsvFileRow("test1;test2;test3");

		assertNotNull(results);
		assertEquals("test1", results[0]);
		assertEquals("test2", results[1]);
		assertEquals("test3", results[2]);
	}
}