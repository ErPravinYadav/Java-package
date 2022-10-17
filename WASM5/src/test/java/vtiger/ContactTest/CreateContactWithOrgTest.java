package vtiger.ContactTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.CreatingNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public  void createContactwithOrgTest() throws IOException {
	/*	
		WebDriver driver= null;
		// create objects of utility 
		JavaUtility jUtil= new JavaUtility();
		WebDriverUtility wUtil= new WebDriverUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		ExcelFileUtility eUtil= new ExcelFileUtility();
		
		// read all the necessary data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=	pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORd =pUtil.readDataFromPropertyFile("password");
	
		String LASTNAME=eUtil.getDataFromExcel("Contact", 7, 2);
		String ORGNAME= eUtil.getDataFromExcel("Contact", 7, 3)+jUtil.getRandomNumber();
		String INDUSTRYTYPE= eUtil.getDataFromExcel("Contact", 7, 4);
		String TYPE= eUtil.getDataFromExcel("Contact", 7, 5);
		String LEADSOURCETYPE=eUtil.getDataFromExcel("Contact", 7, 6);
	
		// launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser ");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementToLoadInDOM(driver);
		driver.get(URL);
		
		//login to app
		LoginPage lp= new LoginPage(driver);
		lp.clickOnLoginBtn(USERNAME, PASSWORd);
		*/	

		String LASTNAME=eUtil.getDataFromExcel("Contact", 7, 2);
		String ORGNAME= eUtil.getDataFromExcel("Contact", 7, 3)+jUtil.getRandomNumber();
		String INDUSTRYTYPE= eUtil.getDataFromExcel("Contact", 7, 4);
		String TYPE= eUtil.getDataFromExcel("Contact", 7, 5);
		String LEADSOURCETYPE=eUtil.getDataFromExcel("Contact", 7, 6);

		//navigate to org link
		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLnk();
		
		//navigate to org look up Img
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//create organization with mandatory fields
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME, INDUSTRYTYPE, TYPE);
	
		// validate
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		String OrgHeader=oip.getOrgHeader();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("Org created");
		}
		else
		{
			System.out.println("org not created");
		}
		// navigate to contact link
		hp.clickOnContact();
		
		//navigate to contact look up img
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnContactLookUpImg();
		
		//create contact  with org name	
		CreatingNewContactPage cnp= new CreatingNewContactPage(driver);
		cnp.createNewContact(LASTNAME, LEADSOURCETYPE, ORGNAME, driver);
		
		// validate
		ContactInformationPage cip= new ContactInformationPage(driver);
		String ContactHeader=cip.getContactHeaderText();		
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println("Contact created : Pass");
		}
		else
		{
			System.out.println("Contact not created : Failed");
		}
	}
}
