package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods related to webdriver
 * @author Pravin Yadav
 *
 */
public class WebDriverUtility {
	
	
	/**
	 * this method will maximize the window 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will wait for 20 seconds until page is loaded in dom
	 * @param driver
	 */
	public void waitForElementToLoadInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will wait for perticular to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToLoad(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/** 
	 * This method will wait for perticular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver ,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait for the eleemnt to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for perticular element to perform click operation
	 * if the element is not interactive it will eaot for 1 second
	 * @param element
	 * @throws InterruptedException 
	 */
	public void customWaitAndClickOnElement(WebElement element) throws InterruptedException {
		int count=0;
		while(count<10) {
			try
				{
					element.click();
					break ;
				}
				catch(Exception e) {
					// to do handle exception
					Thread.sleep(1000);
					count++ ;
				}
			}
		}
	
	/**
	 *  This method will handle dropdown by select class using index
	 * @param driver
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebDriver driver, WebElement element, int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by select class using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select s= new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method will handle the dropdown by select class using visible text
	 * @param visibleText
	 * @param element
	 */
	public void handleDropDown(String visibleText ,WebElement element ) {
	Select s= new Select(element);
	s.selectByVisibleText(visibleText);
	}
	
	/**
	 * this method will perform double click  over a web page
	 */
	public void doubleClick(WebDriver driver) {
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on perticular element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element);
	}
	
	/**
	 * This method will perform mouse hover action on perticular element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	
	/**
	 * This method will perform mouse hover actions over the offset(perticular cordinate)
	 */
	public void mouseHover(WebDriver driver,int x ,int y) 
	{
		Actions act= new Actions(driver);
		act.moveByOffset(x, y);
	}
	
	/**
	 * This method will perform right clilck on the page
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions act= new Actions(driver);
		act.contextClick();
	}
	
	/** 
	 * this method will perform right click on perticular element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.contextClick(element);
	}
	
	/** 
	 * This method will perform drag and drop action from source element to target element
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcElement,WebElement targetElement)
	{
		Actions act = new Actions (driver);
		act.dragAndDrop(srcElement, targetElement);
	}
	
	/**
	 * This method will accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/** 
	 * This method will get the text from alert pop up and return it to coller
	 * @param driver
	 */
	public String getTextAlert(WebDriver driver)
	{
		String alertText=driver.switchTo().alert().getText();
		return alertText;
	}
	
	/**
	 * This method will handle the all window
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver,String partialTitle)
	{
		//step 1 :get all the window handles
		Set<String>windowIds = driver.getWindowHandles();
		
		//Step 2 : iterate to all window ids
		Iterator<String> it = windowIds.iterator();
		
		//step 3 : navigate inside the windows
		while(it.hasNext())
		{
			//capture all the window ids
			String winId= it.next();
			
			//switch to window and capture the current title
		String currentTitle=	driver.switchTo().window(winId).getTitle();
		
		if(currentTitle.contains(partialTitle))
		{
			break;
		}
		}
	}
  
	/**
	 * This method will switch to frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame( WebDriver driver , int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch to frame by locating perticular element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/** 
	 * This method will take screen shot and return the destination path
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver,String screenshotName) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path= ".\\Screenshots"+screenshotName+".png";
		File dest=new File(path);
		FileUtils.copyFile(src,dest);
	
		return dest.getAbsolutePath();   // used for reporting in listners
		
	
	}
	
	/** 
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollActions(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)" ," ");
	}
	
	/**
	 * This method will scroll untill the perticular element
	 * @param driver
	 * @param element
	 */
	public void scrollActions(WebDriver driver ,WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		int y =element .getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
}



