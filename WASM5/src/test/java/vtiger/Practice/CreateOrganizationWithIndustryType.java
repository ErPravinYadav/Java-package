package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustryType {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Step 1  launch the browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//load file into file input stream
		FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\comanData.properties");
		
		//create object of properties file
		Properties p=new Properties();
		
		//load properties  object to file 
		p.load(fis1);
		
		//Step 2 Open the App
		//use data using key
		driver.get(p.getProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3  navigate to  organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4 create organization by using organization lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 5 Enter mandatory field 
		//load excel file into file input stream
		FileInputStream fis2= new FileInputStream(".\\src\\test\\resources\\TestData_Exel.xlsx");
		
		//create workbook to load workbook factory
		Workbook wb= WorkbookFactory.create(fis2);
		
		//navigate to sheet
		Sheet sh=wb.getSheet("Organization");
		
		//navigate to row
		Row row=sh.getRow(7);
	
		//navigate to cell
		Cell cell= row.getCell(2);
		
		String value =cell.getStringCellValue(); 
		
		driver.findElement(By.name("accountname")).sendKeys(value);
		
		//step 6 choose Electronics from Industry dropdown
		WebElement dropdown= driver.findElement(By.name("industry"));
		Select s=new Select(dropdown);
		
		Cell cell2=row.getCell(3);
		s.selectByValue(cell2.getStringCellValue());
		System.out.println("Electronics seelected");
		
		//step 7 choose Inventor from Type dropdown
		WebElement dropdownType=driver.findElement(By.name("accounttype"));
		Select s2= new Select(dropdownType);
		
		//navigate to cell
		Cell cell3=row.getCell(4);
		String value4=cell3.getStringCellValue();
		s2.selectByValue(value4);
		System.out.println("Investor selected");
		
		//step 8 save the organization
		driver.findElement(By.name("button")).click();
		System.out.println("Data Saved");
		
		// Step 9 close the App
		driver.close();
		System.out.println("App closed");
		
	}

}
