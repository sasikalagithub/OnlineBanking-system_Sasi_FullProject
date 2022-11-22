package TestngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
@Test
public void tc1() {
	
	System.out.println("hi");
	System.out.println("hello");
	System.out.println("java");
	Assert.assertEquals("sasi", "kala");
	System.out.println("selenium");
	System.out.println("Advselenium");
	
}
@Test
public void tc1_1() {
	
	System.out.println("Hi");
	System.out.println("Hello");
	System.out.println("Java");
}


@Test
public void tc2() {
	
	System.out.println("hi111");
	System.out.println("hello111");
	System.out.println("java111");
	SoftAssert s=new SoftAssert();
	s.assertEquals("sasi", "sa");
	System.out.println("selenium111");
	System.out.println("Advselenium111");
	
}
public void tc2_1() {
	
	System.out.println("Hi111");
	System.out.println("Hello111");
	System.out.println("Java111");
}
}
