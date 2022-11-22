package Practice_package;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Apple iPhone 12 (64GB) - Purple'])[1]/../../../..//span[@class='a-price']")).click();
		Set<String> child = driver.getWindowHandles();
		for(String ch:child) {
			driver.switchTo().window(ch);
			
		}
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
	}

}
