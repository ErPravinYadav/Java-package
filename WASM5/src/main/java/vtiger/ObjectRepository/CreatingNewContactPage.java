package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility {
	WebDriver driver;
	//declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement OrgNameImg;
	
	@FindBy(name="search_text")
	private WebElement searchBoxEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadsourceDropdown;
	
	@FindBy(name= "button")
	private WebElement saveBtn;
	
	// initialization
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	//Utilization
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameImg() {
		return OrgNameImg;
	}

	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLeadsourceDropdown() {
		return leadsourceDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business library
	/**
	 * This method will create contact using mandatory feild and save 
	 * @param lastName
	 */
	
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	/**
	 * This method will create new contact using mandatory field last name ,lead source type and save
	 * @param lastName
	 * @param leadSourchType
	 */
	public void createNewContact(String lastName , String leadSourchType)
	{
		lastNameEdt.sendKeys(lastName);
		handleDropDown(leadSourchType, leadsourceDropdown);
		saveBtn.click();
	}
	/**
	 * This method will create  new contact using last name , with organozation and lead source type
	 * @param lastName
	 * @param leadSourchType
	 * @param orgName
	 * @param driver
	 */
	public void createNewContact(String lastName , String leadSourchType ,String  orgName ,WebDriver driver)
	{
		lastNameEdt.sendKeys(lastName);
		OrgNameImg.click();
		switchToWindow(driver,"Accounts");
		searchBoxEdt.sendKeys(orgName);	
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); // Dynamic Xpath
		switchToWindow(driver,"Contacts");
		handleDropDown(leadSourchType, leadsourceDropdown);
		saveBtn.click();
	}
		
}
