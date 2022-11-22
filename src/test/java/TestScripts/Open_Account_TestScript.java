package TestScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.OpenAccountPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_Account_TestScript {
public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		
		
		//creating object for file utility and excel utility
				File_Utility fUtil=new File_Utility();
				String url = fUtil.readDataFromPropertyFile("url");
				String BROWSER=fUtil.readDataFromPropertyFile("browser");
				
				Excel_Utility eUtil = new Excel_Utility();
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
				//opening account
				 WebDriver_Utility wdUtil = new WebDriver_Utility();

					//using webDriverManager
					WebDriverManager.chromedriver().setup();
				 
				WebDriver driver=null;
				
				
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}
				else 
				{
			System.out.println("Invalid browser");
				}
				 driver.manage().window().maximize();
				   driver.get(url);
				 
				   wdUtil.waitForPageLoad( driver);
				   //creating an object for Home page
				   HomePage hP=new HomePage(driver);
				   hP.openAccountLink();
				   //creating an object for OpenAccountPage
				   OpenAccountPage openAccPage=new OpenAccountPage(driver);
				   
				   openAccPage.openAccountPageDetails(name, mobileNum,emilId,landLineNum,panNum );
				   openAccPage.openAccountPageDetails(citizenShipNum,homeAddress,officeAddress);
				   openAccPage.openAccountPageDetails(pinCode,area);
				  // openAccPage.openAccountPageGenderDropdown();
				   
				   openAccPage.openAccountPageGenderDropdown();
				   
				   wdUtil.select_Visibletext(openAccPage.getGenderDd(),gendertext);
				   
				   
				   
				   openAccPage.stateDropdown();
				   wdUtil.select_Visibletext(openAccPage.getStsteDd(),statetext);
				   
				   
				   
				   openAccPage.cityDropdown();
				   wdUtil.select_Visibletext(openAccPage.getCityDd(),citytext);
				   
				   
				   openAccPage.accountTypeDropdown();
				   wdUtil.select_Visibletext(openAccPage.getAccountTypeDd(),accountTypetext);
				   
				   openAccPage.dateOfBirth();
				   openAccPage. getDateOfBirthTf().sendKeys(dateOfBirth);
				   
				   //Robot class for Date of birth

//				   wdUtil.robot_Press(driver, 2);
//				   wdUtil.robot_Release(driver, 2);
//				   wdUtil.robot_Press(driver, 8);
//				   wdUtil.robot_Release(driver, 8);
//				   wdUtil.robot_Press(driver, 0);
//				   wdUtil.robot_Release(driver, 0);
//				   wdUtil.robot_Press(driver, 5);
//				   wdUtil.robot_Release(driver, 5);
//				   wdUtil.robot_Press(driver, 1);
//				   wdUtil.robot_Release(driver, 1);
//				   wdUtil.robot_Press(driver, 9);
//				   wdUtil.robot_Release(driver, 9);
//				   wdUtil.robot_Press(driver, 9);
//				   wdUtil.robot_Release(driver, 9);
//				   wdUtil.robot_Press(driver, 2);
//				   wdUtil.robot_Release(driver, 2);
//				   
				   Thread.sleep(3000);
				   
				   
				   openAccPage.submitButton();
				   
					   
				   
	}

}


