package vtiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class contains basic configuration annotation for common functonality
 * like connection to database ,launch the browser etc. 
 * @author ss
 *
 */
public class BaseClass {
	
	//create Objects of utilities
    public DatabaseUtility dUtil= new DatabaseUtility();
	public	WebDriverUtility wUtil= new WebDriverUtility();
	public JavaUtility jUtil= new JavaUtility();
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public ExcelFileUtility eUtil= new ExcelFileUtility();
	
	public WebDriver driver=null;
	public static WebDriver ldriver;
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		//dUtil.connectToDB();
		Reporter.log("-- Database Connection Successful-- " ,true);
	}
	
	@BeforeClass
	public void bcConfig() throws IOException
	{
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		//String BROWSER=System.getProperty("browser");
		System.out.println(BROWSER);
		String URL= pUtil.readDataFromPropertyFile("url");
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			Reporter.log("-- Chrome Browser Launched Successfully-- ", true);
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			Reporter.log("-- Firefox Browser Launched  Successfully-- " ,true);
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
		ldriver=driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementToLoadInDOM(driver);
		driver.get(URL);
	}
	
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		//Login to App
		String USERNAME= pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp= new LoginPage(driver);
		lp.clickOnLoginBtn(USERNAME, PASSWORD);
		Reporter.log("-- Login to app  Successfully-- " ,true);
	}
	
	@AfterMethod
	public void amConfig()
	{
		//signout
		HomePage hp= new HomePage(driver);
		hp.clickOnSignOutLnk(driver);
		Reporter.log("-- SignOut  Successfully-- " ,true);
	}
	
	@AfterClass
	public void acConfig()
	{
		// close the browser
		driver.close();
		Reporter.log("-- Browser closed  Successfully-- " ,true);
	}
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		//dUtil.closeDB();
		Reporter.log("-- Database closed   Successfully-- " ,true);
		System.out.println(" this is modification add for git performing commit and push");
		System.out.println(" this is modification add for git performing pull");
		System.out.println(" this is modification add for git performing pull after import this is modification");
		System.out.println(" this is modification add for git performing push after pull and  this is modification");
	}
}
