package ebanking.testcases;

import java.io.IOException;
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

    // Test method to perform data-driven testing for login
    @Test(dataProvider = "LoginData")
    public void LoginDDT(String un, String pw) throws InterruptedException {
        // Initializing Loginpage and providing login credentials
        Loginpage lp = new Loginpage(driver);
        lp.setusername(un);
        lp.setpassword(pw);
        lp.clickSubmit();
        Thread.sleep(3000);

        // Checking if an alert is present
        if (isAlertpresent()) {
            // Handling alert if present
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
        } else {
            // If no alert is present, asserting login success
            Assert.assertTrue(true);

            // Logging out and handling the logout alert
            lp.clicklogout();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Check if the test failed, and capture a screenshot if it did
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.captureScreenshot(driver, result);
        }
    }
    // Method to check if an alert is present
    public boolean isAlertpresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
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
            e.printStackTrace();
            System.out.println("Unable to read data from Excel file. Check the file path and format.");
        }

        return loginData;
    }
}
