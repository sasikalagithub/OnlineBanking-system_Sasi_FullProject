package TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;
import com.Online_Banking.ObjectRepository.FundTransferPage;
import com.Online_Banking.ObjectRepository.HomePage;
import com.Online_Banking.ObjectRepository.InternetLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Internet_Banking_login_TestScripts {
public static void main(String[] args) throws IOException, InterruptedException {
		
		//creating object for file utility 
	     File_Utility fUtil=new File_Utility();
	     String URL= fUtil.readDataFromPropertyFile("url");
	     String BROWSER=fUtil.readDataFromPropertyFile("browser");
	   
	     //creating object for  excel utility		
		Excel_Utility eUtil = new Excel_Utility();

		String customerId = eUtil.readDataFromExcel("Sheet2",9,1 );
	    String customerpassword = eUtil.readDataFromExcel("Sheet2",10,1);
	    
	    String amount=eUtil.readDataFromExcel("Sheet2",12,1 );
	    String remark=eUtil.readDataFromExcel("Sheet2",13,1 );
	    
	    String value=eUtil.readDataFromExcel("Sheet2",14,1);
	    
	  
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
				   hP.loginButton();
				  
				  //creating an object for InternetLoginPage
				  InternetLoginPage intLogin=new InternetLoginPage(driver);
				  intLogin.Internet_LoginPage(customerId,customerpassword);
				  
				  //creating an object for Fund Transfer page
				  
				  FundTransferPage  fundTransferPage=new FundTransferPage (driver);
				  fundTransferPage.fundTransferButton();
				  fundTransferPage.selectBenificiaryDropdown();
				  wdUtil.select_Value(fundTransferPage.getSelectBenificiaryDd(),value);
				  Thread.sleep(2000);
				  fundTransferPage.Fund_TransferPage(amount,remark);
				   
}


}
