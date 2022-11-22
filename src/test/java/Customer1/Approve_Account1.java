package Customer1;

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
				   driver.get(url);
				   wdUtil.waitForPageLoad( driver);  
				   
				   driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
				   
				   driver.findElement(By.name("staff_id")).sendKeys(staffid);
				   driver.findElement(By.name("password")).sendKeys(password);
				   
				   driver.findElement(By.name("staff_login-btn")).click();
				   driver.findElement(By.name("apprvac")).click();
				   driver.findElement(By.name("application_no")).sendKeys(appliNum);
				   driver.findElement(By.name("search_application")).click();
				   
				   Thread.sleep(2000);
				   driver.findElement(By.name("approve_cust")).click();
				   
				   Thread.sleep(2000);
				   driver.close();

	}

}
