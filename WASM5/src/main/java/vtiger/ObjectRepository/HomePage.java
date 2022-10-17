package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	//Declaration
	
	@FindBy (linkText="Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy (linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy (linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy (linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText="Leads")
	private WebElement LeadsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstrationImg;
	
//	@FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")})
//	private WebElement signOutLnk;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	//Initialization
	public HomePage( WebDriver driver)
	{
	PageFactory.initElements(driver,this);
	}
	
	//utilization

	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getAdminstrationImg() {
		return adminstrationImg;
	}
	
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	//Business library
	
	/**
	 * This method will click on organiozation link
	 */
	public void clickOnOrgLnk() {
		OrganizationLnk.click();
	}
	
	/**
	 * this methodsw will click on contact link
	 */
	public void clickOnContact()
	{
		ContactsLnk.click();
	}
	
	
	/**
	 * this method will click on opportunity link
	 */
	
	public void clickOnOpportunityLnk()
	{
		OpportunitiesLnk.click();
	}
	
	/**
	 * this method will click on product lnk
	 */
	
	public void clickOnProduct()
	{
		ProductsLnk.click();
	}
	
	/**
	 * this method will click on lead lnk
	 */
	public void clickOnLeadsLnk()
	{
		LeadsLnk.click();
	}
	
	/**
	 * this method will perform signout operation
	 */
	public void clickOnSignOutLnk(WebDriver driver)
	{
		adminstrationImg.click();
		waitForElementToBeVisible(driver,signOutLnk);
		mouseHover( driver, signOutLnk);
		signOutLnk.click();
	}
	}
