package vtiger.OrganizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgWithIndustryAndTypeTest extends BaseClass {
	
	@Test(dataProvider ="orgData")
	public void CreateMultipleOrgsWithIndustryAndType(String orgName, String industryType ,String type) throws IOException {
	
		String org=orgName+jUtil.getRandomNumber();
			 
		 //navigate to orglink
		 HomePage hp= new HomePage(driver);
		 hp.clickOnOrgLnk();
		 
		 //navigate to org lookup img
		 OrganizationsPage op= new OrganizationsPage(driver);
		 op.clickOnCreateOrgLookUpImg();
	
		 //create org
		 CreatingNewOrganizationPage cnp= new CreatingNewOrganizationPage(driver);
		 cnp.createNewOrg(org, industryType, type);
		 
		 //validate
		 OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		 String OrgHeader=oip.getOrgHeader();
		 
		 if(OrgHeader.contains(org))
		 {
			 System.out.println("pass");
		 }
		 else
		 {
			 System.out.println("Fail");
		 }
	}
	
	@DataProvider(name="orgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataFromExcel("MultipleOrg");	
	}
}
