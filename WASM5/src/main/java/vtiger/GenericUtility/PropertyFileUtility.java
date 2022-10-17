package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class will read the data from property file
 * @author ss
 *
 */
public class PropertyFileUtility {
	/**
	 * this method will read the data from property file
	 * @throws IOException 
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		
	FileInputStream fis= new FileInputStream(ConstantsUtility.PropertyFilePath);
	Properties p= new Properties();
	p.load(fis);
	String value=p.getProperty(key);
	return value;
	}
	}
	
