package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {
	
	// Declaration
	@FindBy(xpath="// img[@title='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	// Initialization
	 
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}

	//utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	//Business library
	public void clickOnCreateOrgLookUpImg()
	{
		createOrgLookUpImg.click();
		
	}

}
