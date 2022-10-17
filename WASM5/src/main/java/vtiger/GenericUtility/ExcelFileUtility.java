package vtiger.GenericUtility;
/**
 * This will read the data from excel sheet and return the value 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains all the excel file related method 
 * @author ss
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read the data from the excel sheet and return the String value
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(sheet);
		Row r=s.getRow(row);
		Cell cel= r.getCell(cell);
		String value =cel.getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This will return the number of last row of specific sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int  getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		int lastRow=sh.getLastRowNum();
		wb.close();
		return lastRow;
	}
	
	/**
	 * This method will write the data into excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row r= sh.getRow(row);
		Cell cel=r.getCell(cell);
		cel.setCellValue(value);
		
		FileOutputStream fos= new FileOutputStream(ConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	
	/**
	 * This method will execute the test script with multiple set of data
	 * Hence it will return the two diamentional object array data ( Object[][] ) so it can be directly used in data Provider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=	wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][]data= new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0; j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
























