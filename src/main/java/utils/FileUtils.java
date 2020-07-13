package utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static void saveObjectToXml(String fileName, Object object) {
		File outputFile = new File(fileName);

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(object, outputFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		System.out.println("Results saved " + outputFile.getAbsolutePath());
	}

	public static String[] processCsvFileRow(String row) {
		return row.split(";");
	}

	public static List<String> readFileByLine(File inputFile) {

		List<String> lines = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
