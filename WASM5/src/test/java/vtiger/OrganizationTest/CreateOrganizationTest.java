package vtiger.OrganizationTest;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreatingNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;


@Listeners(vtiger.GenericUtility.ListenersImplementation.class)
public class CreateOrganizationTest  extends BaseClass{

	
	@Test
	public void createOrgTest() throws IOException
	{
		String ORGNAME= eUtil.getDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//step 4: navigate to organization
		HomePage hp =new HomePage(driver);
		hp.clickOnOrgLnk();
		
		//step 5: navigate to create organizations lookup img
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		//step 6: create organization with mandatory fields 
		CreatingNewOrganizationPage cnp =new CreatingNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME);
		Assert.fail();
		
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
	}
}
