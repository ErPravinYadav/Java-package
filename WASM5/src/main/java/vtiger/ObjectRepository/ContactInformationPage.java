package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

	//Declateration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	//initialization
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getContactHeader() {
		return contactHeader;
	}
	//business library
	public String getContactHeaderText()
	{
		return contactHeader.getText();
	}
}
