package vtiger.GenericUtility;

import java.sql.Date;
import java.util.Random;

/**
 * This class contains all the java specific generic methods
 * @author Pravin Yadav
 *
 */
public class JavaUtility {

	/**
	 * This method will generate the random number and we will upend the random number
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		int ran=r.nextInt(1000);
		return ran;
	}
	
	/**
	 * This method will generate the current date
	 * @return
	 */
	public String  getSystemDate() {
		Date d=new Date(0);
		String date =d.toString();
		return date;
	}
	
	
	/**
	 * This method will generate the current system date in specific format
	 * @return
	 */
	public String getSystemDateInFormate() {
		Date d= new Date(0);
		String[]dArr=d.toString().split(" ");
		String date =dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":", "-");
		String currentDateAndTime= date+" "+month+" "+year+" " +time;
		return currentDateAndTime;
		}
}
