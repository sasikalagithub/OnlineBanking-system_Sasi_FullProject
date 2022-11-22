package Customer1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;

public class Open_Account1 {

	public static void main(String[] args) throws IOException {
		
		
		//creating object for file utility and excel utility
				File_Utility fUtil=new File_Utility();
				String url = fUtil.readDataFromPropertyFile("url");
				String BROWSER=fUtil.readDataFromPropertyFile("browser");
				Excel_Utility eUtil = new Excel_Utility();
			    String name = eUtil.readDataFromExcel( "Sheet3", 0,1 );
				String mobileNum = eUtil.readDataFromExcel( "Sheet3", 1,1 );
				String emilId= eUtil.readDataFromExcel( "Sheet3", 2,1 );
				String landLineNum= eUtil.readDataFromExcel( "Sheet3", 3,1 );
				String panNum= eUtil.readDataFromExcel( "Sheet3",4,1 );
				String citizenShipNum= eUtil.readDataFromExcel( "Sheet3",5,1 );
				String homeAddress= eUtil.readDataFromExcel( "Sheet3",6,1 );
				String officeAddress= eUtil.readDataFromExcel( "Sheet3",7,1 );
				String pinCode= eUtil.readDataFromExcel( "Sheet3",8,1 );
				String area= eUtil.readDataFromExcel( "Sheet3",9,1 );
				
				//opening account
				WebDriver_Utility wdUtil = new WebDriver_Utility();
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
				   driver.findElement(By.xpath("//li[text()='Open Account']")).click();
				   
				   
				   
				   
	}

}
