package TestngPractice;

import org.testng.annotations.Test;

public class Sample3 {
	@Test(groups="regression")
	public void tc3() {
		System.out.println("Selenium");
	}
	@Test(groups="smoke")
	public void tc3_1() {
		System.out.println("Selenium");
	}

}
