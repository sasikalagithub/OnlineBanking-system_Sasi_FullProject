package Practice_package;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDown_Decending {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dD = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		dD.click();
		Select s = new Select(dD);
		List<WebElement> options = s.getOptions();
		
		 System.out.println(options);
	for(WebElement op:options) {
			System.out.println(op.getText());	
			
		}

		Collections.reverse(options);
		System.out.println("=================");
		for(WebElement op1:options) {
			System.out.println(op1.getText());	
			
		}
		System.out.println("total " + options.size());
		
		System.out.println(options.get((options.size())/2).getText());
		for (int i = options.size()-1; i >=0 ; i--) {
			System.out.println(options.get(i).getText());
		}
		driver.close();

	}

}
