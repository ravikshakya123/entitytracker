package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReader {

	public static final String SAMPLE_XLSX_FILE_PATH = "C://filename//Pods_Wise_Checklist.xlsx";

	public static void main(String[] args) throws IOException, InvalidFormatException {

		Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

		// Retrieving the number of sheets in the Workbook
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		// 2. Or you can use a for-each loop
		
		ArrayList<PodListTO> list=new ArrayList<PodListTO>();//Creating arraylist.
		
		PodListTO podListTO =null;
		int i = 0;
		
		for (Sheet sheet : workbook) {

			System.out.println();
			System.out.println(" Details for Workbook sheet =====> " + sheet.getSheetName());
			System.out.println("*************************************************************");

			// Getting the Sheet at index zero
			sheet = workbook.getSheetAt(i);
			//list.add(sheet.getSheetName());

			// Create a DataFormatter to format and get each cell's value as String
			DataFormatter dataFormatter = new DataFormatter();

			// 2. Or you can use a for-each loop to iterate over the rows and columns
			for (Row row : sheet) {
				for (Cell cell : row) {
					String cellValue = dataFormatter.formatCellValue(cell);
					 podListTO = new PodListTO();
					 podListTO.setPodName(sheet.getSheetName());
					 podListTO.setTaskName(cellValue);
					
					//System.out.print(cellValue + "\t");
				}
				System.out.println();
			}
			list.add(podListTO);
			System.out.println("list ===>"+ list.toString());
		
			i++;
		}

		// Closing the workbook
		workbook.close();
	}
}