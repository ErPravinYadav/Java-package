package vtiger.ContactTest_TestNg;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.HomePage;

public class CreateContactTest extends BaseClass {
	
		@Test
		public void createContactTest() throws EncryptedDocumentException, IOException{	
	
		String LASTNAME= eUtil.getDataFromExcel("Contact", 1, 2);
		
		//step 4 navigate to contact
		HomePage hp= new HomePage(driver);
		hp.clickOnContact();
		
		//step 5 click on create contact lookup img
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnContactLookUpImg();
		
		//create contact
		CreatingNewContactPage cnp= new CreatingNewContactPage(driver);
		cnp.createNewContact(LASTNAME);	
		
		// validation
		
		ContactInformationPage cip= new ContactInformationPage(driver);
		 String ContactHeader =cip.getContactHeaderText();
		if(ContactHeader.contains(LASTNAME))
		{
			Reporter.log("----Contact created----- ",true);
		}
		else
		{
			Reporter.log("Contact not created", true);
		}	
	}
}
