package TestScripts_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.BaseClass;
import com.Online_Banking.ObjectRepository.DeleteCustomerAccountPage;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.StaffLoginHomePage;
import com.Online_Banking.ObjectRepository.StaffLoginPage;

public class View_Account_Delete_Account_TestScript1 extends BaseClass{
	@Test
	public void viewaccountDelAcc() throws Throwable, IOException {
		   //creating an object for Home page
		   
		   HomePage hP=new HomePage(driver);
		   hP.staffloginlink();
		   Thread.sleep(2000);
		   
		   //creating an object for  StaffLoginPage
		   StaffLoginPage staffloginPage=new  StaffLoginPage(driver);
		   

			String staffid = fUtil.readDataFromPropertyFile("StaffId");
			String password = fUtil.readDataFromPropertyFile("password");
			
		   staffloginPage.staffLoginPage(staffid,password);
		   Thread.sleep(2000);
		   //creating an object for staff login home page
		   StaffLoginHomePage staffLoginHomePage=new StaffLoginHomePage(driver);
		   staffLoginHomePage.DeleteCustomerAccountLink();
		   //creating an object for DeleteCustomerAccountPage
		   DeleteCustomerAccountPage deleteCusAcc=new DeleteCustomerAccountPage(driver);
		   
		   String accountNum = eUtil.readDataFromExcel("Sheet1",8,1);
			String cusId = eUtil.readDataFromExcel("Sheet5",0,1);
			String reason = eUtil.readDataFromExcel("Sheet5",1,1);
		   
		   deleteCusAcc.deleteCustomerAccountPageDetails(accountNum,cusId,reason);

		
	}

}
