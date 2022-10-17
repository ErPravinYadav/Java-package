package vtiger.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunParamter {

	@Test
	public void method() 
	{
		
		String BROWSER= System.getProperty("browser");
		System.out.println(BROWSER);
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			Reporter.log("---Chrome browser lounched successfully---",true);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			Reporter.log("---firefox browser lounched successfully----",true);
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			Reporter.log("---edge browser lounched successfully----",true);
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			Reporter.log("--- By default Chrome browser lounched successfully---",true);
		}
		
		
	}
}
