package Staff1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;

public class Approve_Account1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		//creating object for file utility and excel utility
		File_Utility fUtil=new File_Utility();
		String URL= fUtil.readDataFromPropertyFile("url");
		String BROWSER=fUtil.readDataFromPropertyFile("browser");
		
		String userName = fUtil.readDataFromPropertyFile("StaffId");
		String password = fUtil.readDataFromPropertyFile("password");
		
		//creating an object for excel utility
		Excel_Utility eUtil = new Excel_Utility();
		String applicationNum = eUtil.readDataFromExcel("Sheet1",6,1);
		
		//creating object for web utilities
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
				   
				   driver.findElement(By.name("staff_id")).sendKeys(userName);
				   driver.findElement(By.name("password")).sendKeys(password);
				   
				   driver.findElement(By.name("staff_login-btn")).click();
				   driver.findElement(By.name("apprvac")).click();
				   driver.findElement(By.name("application_no")).sendKeys(applicationNum);
				   driver.findElement(By.name("search_application")).click();
				   
				   Thread.sleep(2000);
				   driver.findElement(By.name("approve_cust")).click();
				   
				   Thread.sleep(2000);
				   driver.close();
		
	}

}
