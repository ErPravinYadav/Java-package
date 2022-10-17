package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//step 1: Load the file into file input stream 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData_Exel.xlsx");
		
		//step 2: create workbook using workbook factory
		Workbook wb=  WorkbookFactory.create(fis);
		
		//step 3: navigate to sheet 
		 Sheet sh=wb.getSheet("Organization");
		
		//step 4: navigate to row
		Row row= sh.getRow(1);
		Row row1=sh.getRow(4);
		//step 5: navigate to cell 
		Cell cell= row.getCell(2);
		Cell cell1= row1.getCell(3);
		//step 6: read the response cell value
		
		String value =cell.getStringCellValue();
		String value1=cell1.getStringCellValue();
		System.out.println(value);
		System.out.println(value1);
	}

}
