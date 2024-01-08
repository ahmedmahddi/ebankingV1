package ebanking.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import ebanking.pageobjects.Loginpage;

public class TC_LoginTest_1100 extends Baseclass {
    
    // Test method to perform login and verify the title
    @Test
    public void LoginTest() {
        // Navigating to the specified URL
        driver.get(URL);
        
        // Initializing Loginpage and providing login credentials
        Loginpage lp = new Loginpage(driver);
        lp.setusername(un);
        lp.setpassword(pw);
        lp.clickSubmit();
        
        // Expected title for the home page after login
        String expectedTitle = "Guru99 Bank Manager HomePage";
        
        // Getting the actual title of the current page
        String actualTitle = driver.getTitle();
        
        // Assertion to compare expected and actual titles
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
    }
}
