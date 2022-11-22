package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Reading_Data_Nosql_Test {

	public static void main(String[] args) throws SQLException {
		int result=0;
		//Step1:Register the database
		Driver driverf=new Driver();
	    DriverManager.registerDriver(driverf);
	//Step2:get connection for database
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet43", "root","root");
	    //Step3:issue create statement
	    Statement st = con.createStatement();
	    String query="insert into student values(1687,'Aadhya',3,1234567898)";
	    //step4:Execute query
	        result = st.executeUpdate(query);
	        
	      if(result==1) {
	    	  System.out.println("data updated");
	      }
	      else {
	    	  System.out.println("data not updated");
	      }
	    	  
	        con.close();
	}
}


	



