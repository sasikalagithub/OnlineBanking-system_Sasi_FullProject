package TestScripts_1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.BaseClass;
import com.Online_Banking.ObjectRepository.ApprovePendingAccountPage;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.StaffLoginHomePage;
import com.Online_Banking.ObjectRepository.StaffLoginPage;
@Listeners(com.Online_Banking.Banking.GenericLibraries.ListnerImplementationClass.class)
public class Approve_Account_TestScript1 extends BaseClass 
{
	@Test//(retryAnalyzer=com.Online_Banking.Banking.GenericLibraries.RetryImplementationClass.class)
	public void approveAccount() throws Throwable{
	 //creating an object for HomePage
	   HomePage hP=new HomePage(driver);
	   
	   hP.staffloginlink();
	   //creating an object for  StaffLoginPage 
	   String staffid = fUtil.readDataFromPropertyFile("StaffId");
	   String password = fUtil.readDataFromPropertyFile("password");
		
	   StaffLoginPage staffLPage=new StaffLoginPage(driver) ;
	   staffLPage.staffLoginPage(staffid, password);
	  
	   //creating  an object for StaffLoginHomePage
	    StaffLoginHomePage sHomePage = new StaffLoginHomePage(driver);
	    sHomePage.approvePendingAccountLink();
	    //creating an object for ApprovePendingAccountPage
	    ApprovePendingAccountPage approvePendingAccPage=new ApprovePendingAccountPage(driver);
	    
	    String appliNum = eUtil.readDataFromExcel( "Sheet1", 6,1 );
	    
	    approvePendingAccPage.approvePendingAccountPageDetails(appliNum);
	   
	
	  
}

}


