package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile2 {

	public static void main(String[] args) throws IOException {

		//Step 1: Load  the file to file input Stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\comanData.properties");
			//provide path of the properties file -->R.C on properties file--->properties --->Copy path from except the project name
		
		//Step 2: Create object of properties file
		Properties p= new Properties();
		
		//step 3: load the file to properties object
		p.load(fis);
		
		//step 4: Read the data through key using getProperty()
	System.out.println("Browser name :"+	p.getProperty("browser"));
	}

}
