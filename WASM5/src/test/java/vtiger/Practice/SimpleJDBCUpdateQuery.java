 package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SimpleJDBCUpdateQuery {

	public static void main(String[] args) throws SQLException {
		Driver driverRef= new Driver();
		
		Connection con= null;
		//step 1 Register Driver with database
	try {
		DriverManager.registerDriver(driverRef);
		
		//step 2 get the connection
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "pravin");  //use the url with your databse name ,root - username ,pravin -pwd
		//for url type in google search bar "my sql connection url";
		
		//step 3 issue create statment
		Statement statement = con.createStatement();
		
		//step4 execute the query
		String query="insert into customerinfo values('Alok',14,'Mumbai')";
		int result =statement.executeUpdate(query);
		
		if(result==1) {
			System.out.println("Data is inserted");
		}
		else {
			System.out.println("Data is not inserted");
		}
	}
	catch(Exception e) {
		
	}
		
	finally {
		//step 5 close the database
		con.close();
		System.out.println("Database closed");
	}
	}

}
