package Staff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class View_Account {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		// Reading from Property File
		
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData1.properties");
				Properties p=new Properties();
				p.load(fis);
			   String URL = p.getProperty("url");
			   String staffid = p.getProperty("StaffId");
			   String password = p.getProperty("password");
			   
			 //Excel
			   FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
			   Workbook wb=WorkbookFactory.create(fi);
			  // String appliNum = wb.getSheet("Sheet1").getRow(6).getCell(1).getStringCellValue();
			   String accountNum = wb.getSheet("Sheet1").getRow(7).getCell(1).getStringCellValue();
			   String cusId = wb.getSheet("Sheet1").getRow(8).getCell(1).getStringCellValue(); 
			   String reason = wb.getSheet("Sheet1").getRow(9).getCell(1).getStringCellValue();
			   //Opening Browser
				WebDriver driver=null;
				String BROWSER = null;
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
			   
			   //WebDriver driver=new ChromeDriver();
			   driver.manage().window().maximize();
			   driver.get(URL);
			   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			   //staff
               driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
			   
			   driver.findElement(By.name("staff_id")).sendKeys(staffid);
			   driver.findElement(By.name("password")).sendKeys(password);
			   
			   driver.findElement(By.name("staff_login-btn")).click();
			   driver.findElement(By.name("del_cust")).click();
			   driver.findElement(By.name("Cust_ac_no")).sendKeys(accountNum);
			   driver.findElement(By.name("Cust_ac_Id")).sendKeys(cusId);
			   driver.findElement(By.name("reason")).sendKeys(reason);
			   driver.findElement(By.name("delete")).click();	
			   
			   //pop up
			  Alert msg = driver.switchTo().alert();
			  System.out.println(msg.getText());
			  msg.accept();
			  
			  Thread.sleep(2000);
			  driver.close();
			   
			   

	}

}
