package TestScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.InternetBankingRegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration_Into_InternetBanking_TestScript {
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		//creating object for file utility 
	     File_Utility fUtil=new File_Utility();
	     String URL= fUtil.readDataFromPropertyFile("url");
	     String BROWSER=fUtil.readDataFromPropertyFile("browser");
	   
	     //creating object for  excel utility		
		Excel_Utility eUtil = new Excel_Utility();

		String accountHolderName= eUtil.readDataFromExcel("Sheet2",0,1 );
	    String accountNum = eUtil.readDataFromExcel("Sheet2",1,1);
        String debitNum = eUtil.readDataFromExcel("Sheet2",2,1);
       String debitPinNum = eUtil.readDataFromExcel("Sheet2",3,1);
	    String phoneNum = eUtil.readDataFromExcel("Sheet2",4,1);
	    String panNum = eUtil.readDataFromExcel("Sheet2",5,1);
	    String password = eUtil.readDataFromExcel("Sheet2",7,1);
	    String Transaction = eUtil.readDataFromExcel("Sheet2",8,1);
	    String dateOfBirth= eUtil.readDataFromExcel("Sheet1",7,1);
	    
	    
	    
	  
	    //creating object for web utility		
	    WebDriver_Utility wdUtil = new WebDriver_Utility();

		//using webDriverManager
		WebDriverManager.chromedriver().setup();
				
	    //opening Browser
				
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
				   driver.get(URL);
				   wdUtil.waitForPageLoad( driver);  
				   
				   //creating an object for HomePage
				   HomePage hP=new HomePage(driver);
				  //mousehovering on internet Banking
				   wdUtil.action_Mousehover(driver, hP.getInternetBankingLink());
				   
				   hP.registerLink();
				   //creating an object   for Registration page
				   InternetBankingRegistrationPage internetRegisPage=new InternetBankingRegistrationPage(driver);
				   
				   internetRegisPage.InternetBanking_RegistrationPage(accountHolderName,accountNum,debitNum,debitPinNum);
				   internetRegisPage.InternetBanking_RegistrationPage(phoneNum,panNum,Transaction);
				   internetRegisPage.dateOfBirthTextField();
				   internetRegisPage.getDateOfBirthTf().sendKeys(dateOfBirth);

//				   //Robot class for Date of birth
//
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
				   
				   internetRegisPage.InternetBanking_RegistrationPage(password);
				   
	

	}

}



