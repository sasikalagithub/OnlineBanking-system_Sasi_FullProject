
package Staff1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;

public class View_Account1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		//creating object for file utility and excel utility
				File_Utility fUtil=new File_Utility();
				String URL= fUtil.readDataFromPropertyFile("url");
				String BROWSER=fUtil.readDataFromPropertyFile("browser");
				
				String staffid = fUtil.readDataFromPropertyFile("StaffId");
				String password = fUtil.readDataFromPropertyFile("password");
		 //creating object for file utility and excel utility
				Excel_Utility eUtil = new Excel_Utility();
				String accountNum = eUtil.readDataFromExcel("Sheet1",7,1);
				String cusId = eUtil.readDataFromExcel("Sheet1",8,1);
				String reason = eUtil.readDataFromExcel("Sheet1",9,1);
				
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
				   driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
				   
				   driver.findElement(By.name("staff_id")).sendKeys(staffid);
				   driver.findElement(By.name("password")).sendKeys(password);
				   driver.findElement(By.name("staff_login-btn")).click();
				   
				   driver.findElement(By.name("del_cust")).click();
				   driver.findElement(By.name("Cust_ac_no")).sendKeys(accountNum);
				   driver.findElement(By.name("Cust_ac_Id")).sendKeys(cusId);
				   driver.findElement(By.name("reason")).sendKeys(reason);
				   driver.findElement(By.name("delete")).click();
				   
				   wdUtil.alertPopUp_Accept(driver);
				   
				   Thread.sleep(2000);
					  
				   driver.close();
				   
				


	}

}
