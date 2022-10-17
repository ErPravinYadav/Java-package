package vtiger.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreatingNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustryTest {

	@Test
	public  void createOrgWithIndustryTest() throws IOException  {
		WebDriver driver;
		
		//create Objrcts of utilities
		
		WebDriverUtility wUtil= new WebDriverUtility();
		JavaUtility jUtil= new JavaUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		ExcelFileUtility eUtil= new ExcelFileUtility();
		
		// read all the require data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL= pUtil.readDataFromPropertyFile("url");
		String USERNAME= pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		String ORGNAME= eUtil.getDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE=eUtil.getDataFromExcel("Organization" ,4, 3);
		
		//Launch browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			System.out.println("Chrome browser lounched successfully");
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			System.out.println("Firefox browser lounched successfully");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			System.out.println("Edge browser lounched successfully");
		}
		else
		{	WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			System.out.println(" By default Chrome browser lounched successfully");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementToLoadInDOM(driver);
		driver.get(URL);
		
		//Login to App
		LoginPage lp= new LoginPage(driver);
		lp.clickOnLoginBtn(USERNAME, PASSWORD);
		
		//step 4: navigate to organization
		HomePage hp =new HomePage(driver);
		hp.clickOnOrgLnk();
		
		//step 5: navigate to create organizations lookup img
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		//step 6: create organization with mandatory fields 
		CreatingNewOrganizationPage cnp =new CreatingNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME, INDUSTRYTYPE);
		
		//validation
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
    	String header=oip.getOrgHeader();
    	if(header.contains(ORGNAME))
    	{
    		System.out.println("Organization created");
    	}
    	else
    	{
    		System.out.println("Organization not created");
    	}
		
		//step 8 : logout
    	hp.clickOnSignOutLnk(driver);
	}
}
