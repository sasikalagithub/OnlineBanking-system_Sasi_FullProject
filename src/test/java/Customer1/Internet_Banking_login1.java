package Customer1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;

public class Internet_Banking_login1 {

	public static void main(String[] args) throws IOException {
		
		//creating object for file utility 
	     File_Utility fUtil=new File_Utility();
	     String URL= fUtil.readDataFromPropertyFile("url");
	     String BROWSER=fUtil.readDataFromPropertyFile("browser");
	   
	     //creating object for  excel utility		
		Excel_Utility eUtil = new Excel_Utility();

		String customerId = eUtil.readDataFromExcel("Sheet2",9,1 );
	    String customerpassword = eUtil.readDataFromExcel("Sheet2",10,1);
	  
	    //creating object for web utility		
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
				   driver.get(URL);
				   wdUtil.waitForPageLoad( driver);  
				   
				   WebElement intBanking = driver.findElement(By.partialLinkText("Internet Banking"));
				   
				   //mousehover on internet banking
				   wdUtil.action_Mousehover( driver, intBanking);
				   
				   driver.findElement(By.xpath("//li[contains(text(),'Login')]")).click();
				   driver.findElement(By.name("customer_id")).sendKeys(customerId);
				   driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customerpassword);
				   driver.findElement(By.name("login-btn")).click();
				   driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
				   
					   

	}

}
