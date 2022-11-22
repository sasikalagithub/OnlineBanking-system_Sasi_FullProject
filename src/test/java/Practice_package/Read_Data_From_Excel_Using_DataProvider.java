package Practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;

public class Read_Data_From_Excel_Using_DataProvider {
	@Test(dataProviderClass =Excel_Utility.class,dataProvider = "readMultipleData" )
	public void cityName(String a, String b) throws Throwable {
		Thread.sleep(1000);
		System.out.println(a+"------>"+b);
		
	}
	
	/*@DataProvider
	public Object[][] getDatapr() throws Throwable {
		Excel_Utility eUtil = new Excel_Utility();
		Object[][] value = eUtil.readMultipleData("Sheet7");
		return value;
		
	}
*/
}
