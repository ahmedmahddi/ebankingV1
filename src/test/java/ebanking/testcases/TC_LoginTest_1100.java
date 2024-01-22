package ebanking.testcases;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;

import ebanking.pageobjects.Loginpage;
import ebanking.utilities.ScreenshotUtils;

public class TC_LoginTest_1100 extends Baseclass {
    
    // Create a logger instance
    private static final Logger logger = Logger.getLogger(TC_LoginTest_1100.class.getName());
    
    // Test method to perform login and verify the title
    @Test(groups = "login")
    public void LoginTest() {
        try {
            // Navigating to the specified URL
            logger.log(Level.INFO, "Navigating to the specified URL: " + URL);
            driver.get(URL);

            // Initializing Loginpage and providing login credentials
            logger.log(Level.INFO, "Providing login credentials - Username: " + un + ", Password: " + pw);
            Loginpage lp = new Loginpage(driver);
            lp.setusername(un);
            lp.setpassword(pw);
            lp.clickSubmit();

            // Expected title for the home page after login
            String expectedTitle = "Guru99 Bank Manager HomePage";

            // Getting the actual title of the current page
            String actualTitle = driver.getTitle();

            // Assertion to compare expected and actual titles
            logger.log(Level.INFO, "Verifying the page title. Expected: " + expectedTitle + ", Actual: " + actualTitle);
            Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
        } catch (Exception e) {
            // Log and throw any exceptions that occur during the test
            logger.log(Level.SEVERE, "An unexpected error occurred during the test.", e);
            throw e;
        }
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Check if the test failed, and capture a screenshot if it did
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.captureScreenshot(driver, result);
        }
    }
}
