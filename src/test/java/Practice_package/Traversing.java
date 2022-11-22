package Practice_package;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Traversing {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']"));
		Thread.sleep(1000);
		//Select s=new Select(dropdown);
		//s.selectByIndex(0)
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();
		/*WebElement dD = driver.findElement(By.xpath("//select[@id=\'icp-dropdown\']"));
		Select s=new Select(dD);
		Thread.sleep(5000);
		 s.selectByVisibleText("India");*/
		
		//driver.findElement(By.xpath(""))
		
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.elementToBeClickable(dD));
		//a.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[contains(text(), 'Go to website')]")).click();	
		
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
	driver.findElement(By.xpath("//input[@type='submit']")).click()	;
	driver.findElement(By.xpath("(//span[text()='Apple iPhone 12 (64GB) - Purple'])[1]/../../../..//span[@class='a-price']")).click();
	Set<String> child = driver.getWindowHandles();
	for(String ch:child) {
		driver.switchTo().window(ch);
		}
	driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	
	}

}
