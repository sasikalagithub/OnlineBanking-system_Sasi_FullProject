package TestngPractice;

import org.testng.annotations.Test;

public class Sample1Test {
@Test(groups="smoke")
public void tc1() {
	System.out.println("Hi");
	
}
@Test(groups="regression")
public void tc1_1() {
	System.out.println("hi");
	
}
}
