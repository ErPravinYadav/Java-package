package vtiger.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustryTest {

	public static void main(String[] args) {
		//step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		// Step 2: Login to the App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// step 3 : Navigate to organization 
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4: create organization by click create organization look up img
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Qspiders4");
		
		//step 5: select Healthcare from industry dropdown list
		WebElement dropdown= driver.findElement(By.xpath("//select[@name='industry']"));
		Select select =new Select(dropdown);
		select.selectByValue("Healthcare");
		
		// get all the options
		List<WebElement>allOptions= select.getOptions();
		System.out.println(allOptions.size());
		
		for(WebElement b:allOptions) {
			System.out.println(b.getText());
		}
		
		//step 6: save the organization 
		driver.findElement(By.name("button")).click();
		
		
		// step7 : close the App
		System.out.println("Organization created withindustry");
		driver.close();
	}

}
