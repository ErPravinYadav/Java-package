package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class  contains method which will take the screenshot whenever test script got failed
 * @author ss
 *
 */
public class ListenersImplementation implements ITestListener{

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
	
		String testName= result.getMethod().getMethodName();
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.ldriver);
		
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+testName+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
