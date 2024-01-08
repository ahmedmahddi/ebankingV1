package ebanking.testcases;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ebanking.pageobjects.AddNewCustomer;
import ebanking.pageobjects.Loginpage;
import ebanking.utilities.ScreenshotUtils;

public class TC_AddNewCustomer_1103 extends Baseclass {

    @Test
    public void addNewCustomer() throws InterruptedException {
        // Print the username being used for login
        System.out.println("Logging in as user: " + un);

        // Initializing Loginpage and logging in
        Loginpage lp = new Loginpage(driver);
        lp.setusername(un);
        lp.setpassword(pw);
        lp.clickSubmit();

        // Wait until the "New Customer" button is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[2]/a")));

        // Initializing AddNewCustomer page object
        AddNewCustomer ac = new AddNewCustomer(driver);

        // Click on the "New Customer" button
        ac.newcustomer();

        // Generating random customer name and email
        String customerName = generateRandomUsername();
        String customerEmail = generateRandomEmail();

        // Setting customer details
        ac.setname(customerName);
        System.out.println("New customer with this username: " + customerName);
        ac.setgender("male");
        ac.setdob("31", "10", "1969");
        ac.setaddress("Route mahdia km 10 ");
        ac.setcity("Sfax");
        ac.setstate("Tunisia");
        ac.setpin(241227);
        ac.setmobile("27172110");
        ac.setmail(customerEmail);
        System.out.println("New customer with this email: " + customerEmail);

        ac.setpassword("Heckyeah12");
        Thread.sleep(3000);

        // Click on the "Submit" button
        ac.clicksubmit();
        Thread.sleep(3000);

        // Assertion to verify successful customer registration
        String expectedMsg = "Customer Registered Successfully!!!";
        String actualMsg = driver.findElement(By.xpath("(//p[@class='heading3'])[1]")).getText();

        try {
            Assert.assertEquals(actualMsg, expectedMsg);
            System.out.println("Customer Registered Successfully!!!");
        } catch (Exception e) {
            System.out.println("Failed to register customer. Verify the entered inputs.");
        }
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Check if the test failed, and capture a screenshot if it did
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.captureScreenshot(driver, result);
        }
    }

    // Method to generate a random username
    private String generateRandomUsername() {
        String base = "user" + UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "");
        return base.substring(0, Math.min(base.length(), 8));
    }

    // Method to generate a random email
    private String generateRandomEmail() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12) + "@gmail.com";
    }
}
