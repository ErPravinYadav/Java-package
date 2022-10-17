package vtiger.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class CreateContactTest extends BaseClass {

	@Test
	public  void  createContactTest() throws IOException {
	
		String LASTNAME= eUtil.getDataFromExcel("Contact", 1, 2);
		
		//Navigate To Contacts link
		HomePage hp= new HomePage(driver);
		hp.clickOnContact();
		
		//navigate to create contact look up img
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnContactLookUpImg();
		
		//create contact with mandatory fields
		CreatingNewContactPage cnp= new CreatingNewContactPage(driver);
    	cnp.createNewContact(LASTNAME);
    	
    	//validates
    	ContactInformationPage cip= new ContactInformationPage(driver);
    	 String ContactHeader=cip.getContactHeaderText();
    	 if(ContactHeader.contains(LASTNAME))
    	 {
    		 System.out.println(" Contact created : Pass");
    	 }
    	 else
    	 {
    		 System.out.println("contact not created : Fail");
    	 }
	}
}
