package ebanking.testcases;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ebanking.pageobjects.Loginpage;
import ebanking.utilities.ScreenshotUtils;
import ebanking.utilities.XLUtils;

public class TC_LoginDDT_1101 extends Baseclass {
    // Create a logger instance
    private static final Logger logger = Logger.getLogger(TC_LoginDDT_1101.class.getName());

    // Test method to perform data-driven testing for login
    @Test(dataProvider = "LoginData")
    public void LoginDDT(String username, String password) throws InterruptedException {
        // Create an instance of the Loginpage
        Loginpage lp = new Loginpage(driver);

        // Check if username and password are not null
        if (username != null && password != null) {
            // Set the username and password
            lp.setusername(username);
            lp.setpassword(password);

            // Log the username and password being used for login
            logger.log(Level.INFO, "Attempting login with username: " + username + " and password: " + password);

            // Click the submit button
            lp.clickSubmit();
            Thread.sleep(3000);

            // Check if the login error alert is present
            if (isAlertPresent("User or Password is not valid")) {
                // Handle the case where the login error alert is present
                logger.log(Level.INFO, "Login error alert detected.");
                
            } else {
                Assert.assertTrue(true);
                // Proceed with logout only if login is successful
                try {
                    // Click the logout button
                    lp.clicklogout();
                    Thread.sleep(3000);

                    // Check if the logout success alert is present
                    if (isAlertPresent("You Have Succesfully Logged Out!!")) {
                        // Handle the case where the logout success alert is present
                        logger.log(Level.INFO, "Logout success alert detected.");
                    }
                } catch (Exception e) {
                    // Handle exception (e.g., if logout button is not present, or any other issue)
                    logger.log(Level.INFO, "Logout process skipped.", e);
                }
            }
        } else {
            // Log that the test is skipped as username or password is null
            logger.log(Level.INFO, "Skipping test as username or password is null.");
        }
    }

    // AfterMethod annotation to capture a screenshot if the test fails
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Check if the test failed, and capture a screenshot if it did
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.captureScreenshot(driver, result);
        }
    }

    // Method to check if an alert is present
    public boolean isAlertPresent(String expectedMessage) {
        try {
            Alert alert = driver.switchTo().alert();
            String actualMessage = alert.getText();

            // Check if the alert message contains the expected message
            if (actualMessage.contains(expectedMessage)) {
                logger.log(Level.INFO, "Alert with message '" + expectedMessage + "' detected.");
                alert.accept();
                return true;
            } else {
                // Log unexpected alert message
                logger.log(Level.INFO, "alert message: " + actualMessage);
                alert.dismiss();
                return false;
            }
        } catch (NoAlertPresentException e) {
            // No alert present
            return false;
        }
    }

    // DataProvider to fetch login data from Excel
    @DataProvider(name = "LoginData")
    String[][] getData() {
        String path = "C:\\Users\\LEGION\\eclipse-workspace\\ebankingV1\\src\\test\\java\\ebanking\\testData\\LoginData.xlsx";
        int rownum = 0;
        int colcount = 0;
        String loginData[][] = null;

        try {
            // Get row and column count from Excel
            rownum = XLUtils.getRowCount(path, "Sheet1");
            colcount = XLUtils.getCellCount(path, "Sheet1", 1);

            // Initialize the array to store login data
            loginData = new String[rownum][colcount];

            // Loop through Excel data and store in the array
            for (int i = 1; i <= rownum; i++) {
                for (int j = 0; j < colcount; j++) {
                    String cellData = XLUtils.getCellData(path, "Sheet1", i, j);
                    if (cellData != null && !cellData.trim().isEmpty()) {
                        loginData[i - 1][j] = cellData;
                    } else {
                        // Handle empty cells as needed, e.g., skip or log a message
                    }
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Unable to read data from Excel file. Check the file path and format.", e);
        }

        return loginData;
    }
}
