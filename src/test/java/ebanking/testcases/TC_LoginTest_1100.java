package ebanking.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;

import ebanking.pageobjects.Loginpage;
import ebanking.utilities.ScreenshotUtils;

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
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Check if the test failed, and capture a screenshot if it did
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.captureScreenshot(driver, result);
        }
    }
}
