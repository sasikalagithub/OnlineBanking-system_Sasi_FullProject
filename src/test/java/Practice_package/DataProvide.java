package Practice_package;

import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;

public class DataProvide {
	
	//Excel_Utility eUtil=new Excel_Utility();
	
	public Object[][] getData() {
		Object[][] obj=new Object[3][2];
		
		obj[0][0]="Banglore";
		obj[0][1]="Bhimavaram";
		
		obj[1][0]="Banglore";
		obj[1][1]="Hyderabad";
		
		obj[2][0]="Banglore";
		obj[2][1]="Hyderabad";
		
		
		return obj;
		
	}
	@Test(dataProvider="getData")
	public void DataProvider(String src,String des) {
		System.out.println(src +"to" +des);
		
	}

}
