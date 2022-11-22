package TestngPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FaceBookXpath {
	@Test
	public void opening_Browser() throws Throwable {
		WebDriver driver=new ChromeDriver() ;
			driver.manage().window().maximize();
			driver.get("https://www.amazon.in/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("men shoes");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/../../descendant::span[@data-csa-c-id='1o3okh-tavmzl-6k7unm-tqrsnp']")).click();
			driver.findElement(By.xpath("//input[@name='submit.add-to-cart']")).click();
		}
		
	}


