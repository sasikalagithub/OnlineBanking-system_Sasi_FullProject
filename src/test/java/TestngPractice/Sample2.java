package TestngPractice;

import org.testng.annotations.Test;

public class Sample2 {
@Test(groups="smoke")
public void tc2() {
	System.out.println("Hello");
	
}
@Test (groups="regression")
public void tc2_1() {
	System.out.println("hello");
}

}
