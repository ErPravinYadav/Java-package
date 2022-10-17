package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility {

		//Declaration
	@FindBy(name="accountname")
	private WebElement OrganizationNameEdit;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initializxation
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	//utilization
	public WebElement getOrganizationNameEdit() {
		return OrganizationNameEdit;
	}
	
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	/**
	 * this method will create organization
	 * @param orgName
	 */
	public void createNewOrg(String orgName)
	{
		OrganizationNameEdit.sendKeys(orgName);	
		saveBtn.click();
	}
	
	/**
	 * this method will create organization with industry
	 */
	public void createNewOrg(String orgName,String industryType)
	{
		OrganizationNameEdit.sendKeys(orgName);
		handleDropDown(industryType, industryDropDown);
		System.out.println("Industry selected");
		saveBtn.click();
	}
	
	public void createNewOrg(String orgName,String industryType,String Type)
	{
		OrganizationNameEdit.sendKeys(orgName);
		handleDropDown(industryType, industryDropDown);
		System.out.println("Industry selected");
		handleDropDown(Type, typeDropDown);
		System.out.println("Type selected");
		saveBtn.click();
	}
}
