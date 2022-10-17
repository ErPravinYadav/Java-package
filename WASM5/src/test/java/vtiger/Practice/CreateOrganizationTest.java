package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) {
		//step 1: launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//step 2: login to App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step 3: Navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4: click on create organization look up  img
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		// step 5: fill the mandatory field
		driver.findElement(By.name("accountname")).sendKeys("Qspiders3");
		
		//step 6: click on save button
		driver.findElement(By.name("button")).click();
	
		// mouse hover for logout
		Actions action= new Actions(driver);
		//step 7: logout the App
	WebElement ele= driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	 action.moveToElement(ele).perform();
		driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]")).click();
	
		
		driver.close();
	}

}
