package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {

		//Step 1: load the file to the file input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\comanData.properties");
		
		//Step 2: create  object of properties from java
		Properties p = new Properties();
		
		//Step 3: load the file to properties obj
		p.load(fis);
		
		//Step 4 : read the data through key 
		String browser= p.getProperty("browser");
		System.out.println(browser);
		
		String url= p.getProperty("url");
		System.out.println(url);
		
		String  userName= p.getProperty("username");
		System.out.println(userName);
		
		
	}

}
