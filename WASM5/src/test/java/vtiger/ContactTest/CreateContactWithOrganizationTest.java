package vtiger.ContactTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

/**
 * @author Pravin Yadav
 */
public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test
	public  void createContactWithOrgTest() throws IOException {

	 String ORGNAME=eUtil.getDataFromExcel( "Contact", 4, 3)+jUtil.getRandomNumber();
	 String LASTNAME= eUtil.getDataFromExcel("Contact", 4, 2);
	 String LeadSource=eUtil.getDataFromExcel("Contact", 7, 6);
	
	 //step 5: navigate to organization
	 HomePage hp= new HomePage(driver);
	 hp.clickOnOrgLnk();
		
	//step 6: navigate to create organizations lookup img
	OrganizationsPage op= new OrganizationsPage(driver);
	op.clickOnCreateOrgLookUpImg();
		
	//step 7: create organization with mandatory fields 
	CreatingNewOrganizationPage cnp=new CreatingNewOrganizationPage(driver);
	cnp.createNewOrg(ORGNAME);
	
	//Step 8 validation
	OrganizationInformationPage oip= new OrganizationInformationPage(driver);
	String OrgHeader=oip.getOrgHeader();
	if(OrgHeader.contains(ORGNAME)) 
	{
		System.out.println("Organization created");
	}
	else
	{
		System.out.println("Organization not created");
	}
	
	// Step 9: create Contact
	hp.clickOnContact();
	
	ContactsPage cp= new ContactsPage(driver);
	cp.clickOnContactLookUpImg();
	
	CreatingNewContactPage cncp =new CreatingNewContactPage(driver);
	cncp.createNewContact(LASTNAME, LeadSource, ORGNAME, driver);
	
	//validation
	ContactInformationPage cip= new ContactInformationPage(driver);
	String CongHeader=cip.getContactHeaderText();
	if(CongHeader.contains(LASTNAME)) 
	{
		System.out.println("Contact created");
	}
	else
	{
		System.out.println("Contact not created");
	}
  }
}
