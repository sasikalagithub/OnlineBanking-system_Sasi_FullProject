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
import com.Online_Banking.ObjectRepository.ApprovePendingAccountPage;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.StaffLoginHomePage;
import com.Online_Banking.ObjectRepository.StaffLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Approve_Account_TestScript {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
	//creating object for file utility and excel utility
	File_Utility fUtil=new File_Utility();
	String url = fUtil.readDataFromPropertyFile("url");
	String staffid = fUtil.readDataFromPropertyFile("StaffId");
	String password = fUtil.readDataFromPropertyFile("password");
	String BROWSER=fUtil.readDataFromPropertyFile("browser");
	
	Excel_Utility eUtil = new Excel_Utility();
	String accountHolderName = eUtil.readDataFromExcel( "Sheet1", 0,1 );
	String panNum = eUtil.readDataFromExcel( "Sheet1", 2,1 );
	String phoneNum = eUtil.readDataFromExcel( "Sheet1", 3,1 );
	String accountNum = eUtil.readDataFromExcel( "Sheet1", 4,1 );
	String appliNum = eUtil.readDataFromExcel( "Sheet1", 6,1 );
	
	WebDriver_Utility wdUtil = new WebDriver_Utility();
	

	//using webDriverManager
	WebDriverManager.chromedriver().setup();
	
	//launching the browser
	
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
	   //creating an object for HomePage
	   HomePage hP=new HomePage(driver);
	   hP.staffloginlink();
	   //creating an object for  StaffLoginPage 
	   StaffLoginPage staffLPage=new StaffLoginPage(driver) ;
	   staffLPage.staffLoginPage(staffid, password);
	  
	   //creating  an object for StaffLoginHomePage
	    StaffLoginHomePage sHomePage = new StaffLoginHomePage(driver);
	    sHomePage.approvePendingAccountLink();
	    //creating an object for ApprovePendingAccountPage
	    ApprovePendingAccountPage approvePendingAccPage=new ApprovePendingAccountPage(driver);
	    approvePendingAccPage.approvePendingAccountPageDetails(appliNum);
	   
	
	  
}

}



