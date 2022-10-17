package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateContactTest {

	@Test
	public void createcontactTest()
	{
		//Step 1: launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		//step 2: Login to App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//Step 3: NAvigate to Contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 4: Create contact by providing mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
	
		//Step 5: save the contact
		driver.findElement(By.name("button")).click();	
		//Step 6: logout the the App
		
		//Step 7: close the App
		System.out.println("Contact ctreated successfull");
		driver.close();
	}

}
