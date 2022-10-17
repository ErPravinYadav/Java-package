package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromMySql {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Driver driverRef= new Driver();
		
		//Step 1 Register to driver
		
		DriverManager.registerDriver(driverRef);
		
		//Step 2  Get connection to the database
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","pravin");
		
		//Step 3 Issue Create Statement
		Statement statement= con.createStatement();
		
		//Step 4 Execute the query
		
		ResultSet result= statement.executeQuery("select * from customerinfo;");
		
		//close the database
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getShort(2)+"\t"+result.getString(3));
		}
		con.close();
	}

}
