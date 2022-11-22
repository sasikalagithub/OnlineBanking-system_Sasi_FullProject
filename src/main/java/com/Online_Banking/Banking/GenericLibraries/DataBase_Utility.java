package com.Online_Banking.Banking.GenericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBase_Utility {
	Connection con=null;
	
	public void connectToDB() throws SQLException {
		Driver driverf=new Driver();
		DriverManager.registerDriver(driverf);
		 con = DriverManager.getConnection(IPathConstant.dbURL,IPathConstant.dbUsername,IPathConstant.dbPassword);
	}
	public String executeQueryAndDate(String query,int ColumnIndex,String expdata) throws SQLException {
		
		Statement state = con.createStatement();
		boolean flag=false;
		ResultSet res = con.createStatement().executeQuery(query);
		while(res.next())
		{
			String data=res.getString(ColumnIndex);
			if(data.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
			}
		if(flag=true) {
			System.out.println(expdata+"---------->data verified");
			return expdata;
			
		}
		else {
			System.out.println(expdata+"---------->data  not verified");
			return "";
		}
	}
	/**Thisbis used to close the connecton of database
	 * @author kalam
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
		
	}
}

	
		
	
	
	
	


