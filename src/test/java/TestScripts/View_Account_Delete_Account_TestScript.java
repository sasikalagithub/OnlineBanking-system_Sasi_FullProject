package TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;
import com.Online_Banking.ObjectRepository.DeleteCustomerAccountPage;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.StaffLoginHomePage;
import com.Online_Banking.ObjectRepository.StaffLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class View_Account_Delete_Account_TestScript {
	public static void main(String[] args) throws IOException, InterruptedException {
		//creating object for file utility and excel utility
				File_Utility fUtil=new File_Utility();
				String URL= fUtil.readDataFromPropertyFile("url");
				String BROWSER=fUtil.readDataFromPropertyFile("browser");
				
				String staffid = fUtil.readDataFromPropertyFile("StaffId");
				String password = fUtil.readDataFromPropertyFile("password");
		 //creating object for file utility and excel utility
				Excel_Utility eUtil = new Excel_Utility();
				String accountNum = eUtil.readDataFromExcel("Sheet1",8,1);
				String cusId = eUtil.readDataFromExcel("Sheet5",0,1);
				String reason = eUtil.readDataFromExcel("Sheet5",1,1);
				
				//creating object for web utility	
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
				   driver.get(URL);
				   wdUtil.waitForPageLoad( driver); 
				    
				   //creating an object for Home page
				   
				   HomePage hP=new HomePage(driver);
				   hP.staffloginlink();
				   Thread.sleep(2000);
				   
				   //creating an object for  StaffLoginPage
				   StaffLoginPage staffloginPage=new  StaffLoginPage(driver);
				   staffloginPage.staffLoginPage(staffid,password);
				   Thread.sleep(2000);
				   //creating an object for staff login home page
				   StaffLoginHomePage staffLoginHomePage=new StaffLoginHomePage(driver);
				   staffLoginHomePage.DeleteCustomerAccountLink();
				   //creating an object for DeleteCustomerAccountPage
				   DeleteCustomerAccountPage deleteCusAcc=new DeleteCustomerAccountPage(driver);
				   
				   deleteCusAcc.deleteCustomerAccountPageDetails(accountNum,cusId,reason);
	

	}

}


