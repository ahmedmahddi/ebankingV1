package ebanking.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;


import ebanking.pageobjects.Loginpage;

public class TC_LoginTest_1100 extends Baseclass {
	@Test
	public void LoginTest() {
		
		driver.get(URL);
		Loginpage lp= new Loginpage(driver);
		lp.setusername(un);
		lp.setpassword(pw);
		lp.clickSubmit();
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");		
	}
}
