package Practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;

public class ReadingFromExcel5RowsAnd3Columns {
	
	/*@Test(dataProvider = )
	 * 
	public void demo()
	{
		System.out.println();
	}*/
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		Excel_Utility eUtil = new Excel_Utility();
		Object[][] value = eUtil.readMultipleData("Sheet6");
		return value;
	}
	@Test(dataProvider ="getData")
	public void getData1(String name1,String name2,String name3) {
		System.out.println(name1+" "+name2+" "+name3+" ");
		
	}
	

}
