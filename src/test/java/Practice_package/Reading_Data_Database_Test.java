package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.poifs.crypt.temp.AesZipFileZipEntrySource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

public class Reading_Data_Database_Test {

	public static void main(String[] args) throws SQLException {
		WebDriver driver=null;
		String BROWSER = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else 
		{
	System.out.println("Invalid browser");
		}
		//Step1:Register the database
		Driver driverf=new Driver();
	   
		DriverManager.registerDriver(driverf);
	//Step2:get connection for database
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet43", "root","root");
	    //Step3:issue create statement
	    Statement st = con.createStatement();
	    String query="select * from student";
	    //step4:Execute query
	        ResultSet result = st.executeQuery(query);
	        System.out.println("id name duration");//for my reference
	       
	        //System.out.println(result.getString(1));
	        
	        
	        
	        
	        
	      while(result.next())
	        {
	        	
	        	System.out.println(result.getString(1)+" "+result.getString(2)+"  "+result.getString(3));//+" "+result.getString(4));
	      
	        }
	        //for(;result.next();)
	        //{
	        //	System.out.println(result.getString(1)+" "+result.getString(2)+"  "+result.getString(3));//+" "+result.getString(4));
	        //}
	        //step5:close database connection
	        con.close();
	}
	

}
