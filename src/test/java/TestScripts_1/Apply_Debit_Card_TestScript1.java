package TestScripts_1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.BaseClass;
import com.Online_Banking.ObjectRepository.ApplyDebitCardPage;
import com.Online_Banking.ObjectRepository.HomePage;
@Listeners(com.Online_Banking.Banking.GenericLibraries.ListnerImplementationClass.class)
public class Apply_Debit_Card_TestScript1 extends BaseClass {
	
	@Test
	public void applyDebitCard() throws Throwable {
	
	  //creating an object for Home page
	   
	   HomePage hP=new HomePage(driver);
	   hP.applyDebitCardLink();
	    
	   //creating an object for ApplyDebitCardPage
	   
	   ApplyDebitCardPage applyDcard=new ApplyDebitCardPage(driver);
	   String accountHolderName = eUtil.readDataFromExcel("Sheet1", 0, 1);
		String panNum = eUtil.readDataFromExcel("Sheet1",2,1);
		String phoneNum = eUtil.readDataFromExcel("Sheet1",3,1);
		String accountNum = eUtil.readDataFromExcel("Sheet1",4,1);
		String dateOfBirth= eUtil.readDataFromExcel("Sheet1",7,1);
	   
	   applyDcard.accountHoldreNameTextField(accountHolderName);
	   applyDcard.panCardTextfield(panNum);
	   applyDcard.registeredMobieTextfield(phoneNum);
	   applyDcard.accountNumberTextfield(accountNum);
	 // Assert.fail();
	   
	   applyDcard.dateOfBirthTextfield();
	   applyDcard.getdateOfBirthTf().sendKeys(dateOfBirth);
	  
}
	/*@Test
	public void demo() {
		System.out.println("sample");
	}*/
	
	
}
