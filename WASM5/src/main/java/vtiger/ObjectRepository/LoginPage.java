package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Rule 1: Create new class for every web Page
	
	// Rule 2 : identify element by using @ FindBy, @FindAll , @Findbys
	
		// Declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	// Rule 3: Create a constructor to initialize 
	// Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	// Rule 4: Provide getters to access webElement 
	// R.C --> Source-->click on generate getters and setters ---> click on slelct getters ---> click on generate
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	// Rule 5: Business Library
	/**
	 * This method will login to app with username and password
	 */
	 public void clickOnLoginBtn(String username ,String password)
	 {
		 userNameEdt.sendKeys(username);
		 passwordEdt.sendKeys(password);
		 loginBtn.click();
	 }
	
}
