package com.Online_Banking.Banking.GenericLibraries;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public File_Utility fUtil = new File_Utility();
	public Excel_Utility eUtil = new Excel_Utility();
	public DataBase_Utility dUtil = new DataBase_Utility();
	public Java_Utility jUtil = new Java_Utility();
	public WebDriver_Utility wUtil = new WebDriver_Utility();
	public   WebDriver driver=null;
	public static WebDriver sdriver;

	@BeforeSuite
	public void connectToDB() throws SQLException {
		dUtil.connectToDB();
		System.out.println("----Connected to database----");
	}
	//@Parameters ({"browsername"})
	@BeforeClass
	public void launchBrowser() throws Throwable {

		// launching the browser
		String BROWSER = fUtil.readDataFromPropertyFile("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser");
		}
		sdriver=driver;
		
		driver.manage().window().maximize();
//	String URL= fUtil.readDataFromPropertyFile("url");
//	driver.get(URL);
//	wUtil.waitForPageLoad(driver);
		// Thread.sleep(2000);
	}

	@BeforeMethod
	public void oppeningApplication() throws Throwable {
		System.out.println("hiii");
		String URL = fUtil.readDataFromPropertyFile("url");
		driver.navigate().to(URL);
		wUtil.waitForPageLoad(driver);

	}

	@AfterMethod
	public void closeApplication() {
		System.out.println("This is after method");
		
		
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is after class");
		driver.quit();

	}

	@AfterSuite
	public void closeDbConnection() throws Throwable {
		dUtil.closeDB();
	}
}
