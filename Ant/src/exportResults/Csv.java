package exportResults;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class Csv {
	public static void writeMarkToFile(Integer mark, String studentId) throws IOException {
		String filePath = System.getProperty("user.dir") +  File.separatorChar + "Marks.csv";
		String rowTitle = "#" + studentId;
		String columnTitle = "Testing Assignment Points Grade <Numeric MaxPoints:174 Weight:10>";
		String stringMark = mark.toString();
		FileReader fileReader = new FileReader(filePath);
		CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
		List<CSVRecord> records = csvParser.getRecords();
		
		//index array, indexes[0] = index for row, indexes[1] = index for column
		int[] indexes = {-1, -1};
		indexes = findIndexes(records, rowTitle, columnTitle);
		// close
		csvParser.close();
		fileReader.close();
		write(indexes[0], indexes[1], filePath, records, stringMark);
	}

	public static int[] findIndexes(List<CSVRecord> records, String rowTitle, String columnTitle) {
		//index array, indexes[0] = index for row, indexes[1] = index for column
		int[] indexes = {-1, -1};
		for (int i = 0; i < records.size(); i++) {
			CSVRecord record = records.get(i);
			if (record.get(0).equals(rowTitle)) {
				indexes[0] = i;
			}

			// find column name
			for (int j = 0; j < record.size(); j++) {
				if (record.get(j).equals(columnTitle)) {
					indexes[1] = j;
				}
			}
		}
		return indexes;
	}

	public static void write(int rowIndex, int columnIndex, String filePath, List<CSVRecord> records, String stringMark)
			throws IOException {
		// if found
		if (rowIndex >= 0 && columnIndex >= 0) {
			FileWriter fileWriter = new FileWriter(filePath);
			CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);

			// get to desired index
			for (int i = 0; i < records.size(); i++) {
				CSVRecord record = records.get(i);
				for (int j = 0; j < record.size(); j++) {
					if (i == rowIndex && j == columnIndex) {
						// once reached, print mark
						csvPrinter.print(stringMark);
					} else {
						// otherwise, print what is there
						csvPrinter.print(record.get(j));
					}
				}
				csvPrinter.println();
			}

			csvPrinter.flush();
			csvPrinter.close();

			fileWriter.close();
		}
	}
}
