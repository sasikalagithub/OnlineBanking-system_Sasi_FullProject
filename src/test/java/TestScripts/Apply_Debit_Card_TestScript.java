package TestScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;
import com.Online_Banking.ObjectRepository.ApplyDebitCardPage;
import com.Online_Banking.ObjectRepository.HomePage;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Apply_Debit_Card_TestScript  {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		//creating object for file utility a
			File_Utility fUtil=new File_Utility();
			String URL= fUtil.readDataFromPropertyFile("url");
			String BROWSER=fUtil.readDataFromPropertyFile("browser");
	   //creating object for file utility and excel utility
			Excel_Utility eUtil = new Excel_Utility();
			String accountHolderName = eUtil.readDataFromExcel("Sheet1", 0, 1);
			String panNum = eUtil.readDataFromExcel("Sheet1",2,1);
			String phoneNum = eUtil.readDataFromExcel("Sheet1",3,1);
			String accountNum = eUtil.readDataFromExcel("Sheet1",4,1);
			String dateOfBirth= eUtil.readDataFromExcel("Sheet1",7,1);
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
			   hP.applyDebitCardLink();
			   
			   //creating an object for ApplyDebitCardPage
			   
			   ApplyDebitCardPage applyDcard=new ApplyDebitCardPage(driver);
			   applyDcard.accountHoldreNameTextField(accountHolderName);
			   applyDcard.panCardTextfield(panNum);
			   applyDcard.registeredMobieTextfield(phoneNum);
			   applyDcard.accountNumberTextfield(accountNum);
			   applyDcard.dateOfBirthTextfield();
			   applyDcard.getdateOfBirthTf().sendKeys(dateOfBirth);
			   
			   
			  /*  //Robot class for Date of birth

			   wdUtil.robot_Press(driver, 2);
			   wdUtil.robot_Release(driver, 2);
			   wdUtil.robot_Press(driver, 8);
			   wdUtil.robot_Release(driver, 8);
			   wdUtil.robot_Press(driver, 0);
			   wdUtil.robot_Release(driver, 0);
			   wdUtil.robot_Press(driver, 5);
			   wdUtil.robot_Release(driver, 5);
			   wdUtil.robot_Press(driver, 1);
			   wdUtil.robot_Release(driver, 1);
			   wdUtil.robot_Press(driver, 9);
			   wdUtil.robot_Release(driver, 9);
			   wdUtil.robot_Press(driver, 9);
			   wdUtil.robot_Release(driver, 9);
			   wdUtil.robot_Press(driver, 2);
			   wdUtil.robot_Release(driver, 2);
			   
			   Thread.sleep(3000);*/
			   
			  //clicking on submit
			   applyDcard.submitButton();
			  

	}
		
}		   
			
			
			   
			
			
			




