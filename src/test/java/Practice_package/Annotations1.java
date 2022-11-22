package Practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations1 {
	@BeforeSuite
	public void display() {
		System.out.println("Before suite");
	}
    @BeforeClass
    public void display1() {
	System.out.println("Before class");
}
    @BeforeMethod
    
    public void display2() {
    	System.out.println("Before method");
    }
	
    @Test
    
    public void display3() {
    	System.out.println("main method");
    }
	@AfterMethod
	public void display4() {
    	System.out.println("After method");
	}
	@AfterClass
	public void display5() {
    	System.out.println("After class");
	}
	@AfterSuite
	public void display6() {
    	System.out.println("After suite");
	}
	
@Test
    
    public void display7() {
    	System.out.println("main method---2");
    }
	
}


