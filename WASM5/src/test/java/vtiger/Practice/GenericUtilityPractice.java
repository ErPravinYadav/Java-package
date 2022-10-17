package vtiger.Practice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUtility jlib= new JavaUtility();
		 int ran=jlib.getRandomNumber();
		System.out.println(ran);
		
		ExcelFileUtility elib=new ExcelFileUtility();
		String value=elib.getDataFromExcel("Organization", 1, 2);
		System.out.println(value);
		String industry=elib.getDataFromExcel("Organization",7 , 3);
		System.out.println(industry);
		elib.writeDataIntoExcel("Organization", 4, 7, "Pravin");
	
	}
	 public void implicitlyWait(WebDriver driver)
	 {
		 
	 }
	 public void maximize(WebDriver driver)
	 {
		 driver.manage().window().maximize();
	 }
	 public void switchToWindow(WebDriver driver, String partialTilte)
	 {
		 Set<String >allWinId=driver.getWindowHandles();
		 Iterator<String> it=allWinId.iterator();
		 while(it.hasNext())
		 {
			 String winId=it.next();
			 driver.switchTo().window(winId);
			 if(driver.getTitle().contains(partialTilte))
			 {
				 break;
			 }
		 }
	 }
	 public void screenshot(WebDriver driver ,String screenshotname) throws IOException
	 {
		 TakesScreenshot ts= ( TakesScreenshot) driver;
		 File ram= ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./screenshot"+screenshotname+".png");
		 FileUtils.copyFile(ram, dest);
		 
	 }
	

}
