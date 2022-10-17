package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class JDBC {

	public static void main(String[] args) throws SQLException {
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
	Connection con=	DriverManager.getConnection("URL OF DATABASE","UN","PW");
		Statement state= con.createStatement();
		String query ="select * from DatabaseNAme;";
		 ResultSet result=state.executeQuery(query);
		 while(result.next())
		 {
			 System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		 }
		 
		 String query1="insert into tablename values('');";
		  int result1= state.executeUpdate(query1);
		  if(result1==1) {
			  
		  }
		 
		  WebDriver driver= new ChromeDriver();
		  JavascriptExecutor jse= (JavascriptExecutor) driver;
		  jse.executeScript("ducument.getElementById('email').value='pravin'");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		 
		
	}

}
