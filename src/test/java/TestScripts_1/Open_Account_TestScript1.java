package TestScripts_1;

import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.BaseClass;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.OpenAccountPage;

public class Open_Account_TestScript1 extends BaseClass{
	@Test
	public void openAccount()throws Throwable {
		//creating an object for Home page
		   HomePage hP=new HomePage(driver);
		   hP.openAccountLink();
		   //creating an object for OpenAccountPage
		   OpenAccountPage openAccPage=new OpenAccountPage(driver);
		   
		   String name = eUtil.readDataFromExcel( "Sheet3", 0,1 );
			String mobileNum = eUtil.readDataFromExcel( "Sheet3", 1,1 );
			String emilId= eUtil.readDataFromExcel( "Sheet3", 2,1 );
			String landLineNum= eUtil.readDataFromExcel( "Sheet3", 3,1 );
			String panNum= eUtil.readDataFromExcel( "Sheet3",4,1 );
			String citizenShipNum= eUtil.readDataFromExcel( "Sheet3",5,1 );
			String homeAddress= eUtil.readDataFromExcel( "Sheet3",6,1 );
			String officeAddress= eUtil.readDataFromExcel( "Sheet3",7,1 );
			String pinCode= eUtil.readDataFromExcel( "Sheet3",8,1 );
			String area= eUtil.readDataFromExcel( "Sheet3",9,1 );
			String gendertext= eUtil.readDataFromExcel( "Sheet4",0,1 );
			String statetext= eUtil.readDataFromExcel( "Sheet4",1,1 );
			String accountTypetext= eUtil.readDataFromExcel( "Sheet4",2,1 );
			String citytext= eUtil.readDataFromExcel( "Sheet4",3,1 );
			String dateOfBirth= eUtil.readDataFromExcel("Sheet1",7,1);
		   
		   openAccPage.openAccountPageDetails(name, mobileNum,emilId,landLineNum,panNum );
		   openAccPage.openAccountPageDetails(citizenShipNum,homeAddress,officeAddress);
		   openAccPage.openAccountPageDetails(pinCode,area);
		  // openAccPage.openAccountPageGenderDropdown();
		   
		   openAccPage.openAccountPageGenderDropdown();
		   
		   wUtil.select_Visibletext(openAccPage.getGenderDd(),gendertext);
		   
		   
		   
		   openAccPage.stateDropdown();
		   wUtil.select_Visibletext(openAccPage.getStsteDd(),statetext);
		   
		   
		   
		   openAccPage.cityDropdown();
		   wUtil.select_Visibletext(openAccPage.getCityDd(),citytext);
		   
		   
		   openAccPage.accountTypeDropdown();
		   wUtil.select_Visibletext(openAccPage.getAccountTypeDd(),accountTypetext);
		   
		   openAccPage.dateOfBirth();
		   openAccPage. getDateOfBirthTf().sendKeys(dateOfBirth);
		
	}

}
