package Customer1;

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

public class Registration_Into_InternetBanking1 {

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
				   
				   driver.findElement(By.xpath("//li[text()='Register']")).click();
				   driver.findElement(By.name("holder_name")).sendKeys(accountHolderName);
				   driver.findElement(By.name("accnum")).sendKeys(accountNum);
				   driver.findElement(By.name("dbtcard")).sendKeys(debitNum);
				   driver.findElement(By.name("dbtpin")).sendKeys(debitPinNum);
				   driver.findElement(By.name("mobile")).sendKeys(phoneNum);
				   driver.findElement(By.name("pan_no")).sendKeys(panNum);
				   driver.findElement(By.name("password")).sendKeys(password);
				   driver.findElement(By.name("cnfrm_password")).sendKeys(password); 
				   driver.findElement(By.name("last_trans")).sendKeys(Transaction );
				 Thread.sleep(2000);
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
				   
				   driver.findElement(By.xpath("//input[@type='submit']")).click();   
				   
				   
	

	}

}
