package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT {

	public static void main(String[] args) throws IOException {

		FileInputStream fis =new FileInputStream("./location of the property file");
		Properties p =new Properties();
		p.load(fis);
		p.getProperty("key");
		
		FileInputStream fise= new FileInputStream("./ excel location");
		Workbook wb =WorkbookFactory.create(fise);
		String value= wb.getSheet("sheetname").getRow(1).getCell(2).getStringCellValue();
		
		
		
	}

}
