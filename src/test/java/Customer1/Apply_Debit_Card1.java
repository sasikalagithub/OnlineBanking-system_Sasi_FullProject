package Customer1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;

public class Apply_Debit_Card1 {

	public static void main(String[] args) throws IOException, AWTException {
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
   
  //creating object for web utility	
		WebDriver_Utility wdUtil = new WebDriver_Utility();
		
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
		   
		   driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
		   driver.findElement(By.name("holder_name")).sendKeys(accountHolderName);
		   driver.findElement(By.xpath("//input[@placeholder='Date of Birth']")).click();
		    //Robot class for Date of birth

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
		   
		   
		   
		   driver.findElement(By.name("pan")).sendKeys(panNum);
		   driver.findElement(By.name("mob")).sendKeys(phoneNum);
		   driver.findElement(By.name("acc_no")).sendKeys(accountNum);
		   
		   
		   driver.findElement(By.name("dbt_crd_submit")).click();
		   
		
		
		   
		
		
		

}
	
	
	
	
}

