package Practice_package;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Invocation_count {
	@Test(priority = -1,invocationCount=-5)
	public void createAccount() {
	
		Reporter.log("Created an Account",true);
	}
	@Test(priority=-1)
	public void updateAccount() {
	Reporter.log("Updated an account",true);
	}
	@Test(priority=1,enabled=false)
	public void deleteAccount() {
	Reporter.log("Deleted An Account",true);
	}
	@Test(dependsOnMethods="createAccount")
	public void deleteAccount1()
	{
		Reporter.log("Deleted An Account111",true);
		}

	}
