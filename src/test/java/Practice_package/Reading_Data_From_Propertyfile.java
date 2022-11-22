package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reading_Data_From_Propertyfile {

	public static void main(String[] args) throws IOException {
	Properties p= new Properties();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
			p.load(fis);
System.out.println(p.getProperty("url"));
System.out.println(p.getProperty("username"));
System.out.println(p.getProperty("password"));
//launch browser
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get(p.getProperty("url"));
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}

}
