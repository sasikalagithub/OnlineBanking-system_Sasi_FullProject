package TestScripts_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.BaseClass;
import com.Online_Banking.ObjectRepository.FundTransferPage;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.InternetLoginPage;
@Listeners(com.Online_Banking.Banking.GenericLibraries.ListnerImplementationClass.class)
public class Internet_Banking_login_TestScripts1 extends BaseClass{
	@Test
	public void internetLogin() throws  Throwable {
		
		//creating an object for HomePage
		   HomePage hP=new HomePage(driver);
		  //mousehovering on internet Banking
		   wUtil.action_Mousehover(driver, hP.getInternetBankingLink());
		   hP.loginButton();
		  
		  //creating an object for InternetLoginPage
		  InternetLoginPage intLogin=new InternetLoginPage(driver);
		  
		  String customerId = eUtil.readDataFromExcel("Sheet2",9,1 );
		  String customerpassword = eUtil.readDataFromExcel("Sheet2",10,1);
		    
		  intLogin.Internet_LoginPage(customerId,customerpassword);
		  
		  //creating an object for Fund Transfer page
		  
		  FundTransferPage  fundTransferPage=new FundTransferPage (driver);
		  fundTransferPage.fundTransferButton();
		  fundTransferPage.selectBenificiaryDropdown();
		  Assert.fail();
		  
		  String value=eUtil.readDataFromExcel("Sheet2",14,1);
		  
		  wUtil.select_Value(fundTransferPage.getSelectBenificiaryDd(),value);
		  
		  Thread.sleep(2000);
		  String amount=eUtil.readDataFromExcel("Sheet2",12,1 );
		    String remark=eUtil.readDataFromExcel("Sheet2",13,1 );
		    
		  fundTransferPage.Fund_TransferPage(amount,remark);
		   
		
	}

}
