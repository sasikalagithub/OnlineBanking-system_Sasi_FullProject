package TestScripts_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.BaseClass;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.InternetBankingRegistrationPage;

public class Registration_Into_InternetBanking_TestScript1 extends BaseClass {
	@Test
	public void registrationOfInternetBanking() throws Throwable, IOException {
		 
		   //creating an object for HomePage
		   HomePage hP=new HomePage(driver);
		  //mousehovering on internet Banking
		   wUtil.action_Mousehover(driver, hP.getInternetBankingLink());
		   
		   hP.registerLink();
		   //creating an object   for Registration page
		   InternetBankingRegistrationPage internetRegisPage=new InternetBankingRegistrationPage(driver);
		   
		   String accountHolderName= eUtil.readDataFromExcel("Sheet2",0,1 );
		    String accountNum = eUtil.readDataFromExcel("Sheet2",1,1);
	        String debitNum = eUtil.readDataFromExcel("Sheet2",2,1);
	       String debitPinNum = eUtil.readDataFromExcel("Sheet2",3,1);
		    String phoneNum = eUtil.readDataFromExcel("Sheet2",4,1);
		    String panNum = eUtil.readDataFromExcel("Sheet2",5,1);
		    String password = eUtil.readDataFromExcel("Sheet2",7,1);
		    String Transaction = eUtil.readDataFromExcel("Sheet2",8,1);
		    String dateOfBirth= eUtil.readDataFromExcel("Sheet1",7,1);
		    
		   internetRegisPage.InternetBanking_RegistrationPage(accountHolderName,accountNum,debitNum,debitPinNum);
		   internetRegisPage.InternetBanking_RegistrationPage(phoneNum,panNum,Transaction);
		   internetRegisPage.dateOfBirthTextField();
		   internetRegisPage.getDateOfBirthTf().sendKeys(dateOfBirth);
		   
		   internetRegisPage.InternetBanking_RegistrationPage(password);
	}

}
