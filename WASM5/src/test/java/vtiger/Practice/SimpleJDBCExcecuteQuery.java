package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SimpleJDBCExcecuteQuery {

	public static void main(String[] args) throws SQLException {

		Driver driverRef= new Driver();
		
		//step 1 Register the Driver/database
		
		DriverManager.registerDriver(driverRef);
		
		//step 2  get the connection with database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "pravin");
		
		//step 3  issue create statement 
		
		Statement  statement =con.createStatement();
		
		//step 4  execute the query
		
		ResultSet  result=statement.executeQuery("select * from customerinfo;");
		
		//step 5 Close the database
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getShort(2)+"\t"+result.getString(3));
			
		}
		
	}

}
