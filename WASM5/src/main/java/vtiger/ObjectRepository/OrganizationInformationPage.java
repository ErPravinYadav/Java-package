package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class OrganizationInformationPage extends WebDriverUtility {
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderTxt;
	
	//initialization
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	//utilization
	public WebElement getOrgHeaderTxt() {
		return orgHeaderTxt;
	}
	//business library
	
	public String getOrgHeader() {
		return orgHeaderTxt.getText();
	}
	
}
