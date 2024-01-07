package ebanking.testcases;

import java.util.UUID;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ebanking.pageobjects.AddNewCustomer;
import ebanking.pageobjects.Loginpage;

public class TC_AddNewCustomer_1103 extends Baseclass {

    @Test
    public void addNewCustomer() throws InterruptedException {
        System.out.println("Logging in as user: " + un);

        Loginpage lp = new Loginpage(driver);
        lp.setusername(un);
        lp.setpassword(pw);
        lp.clickSubmit();

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[2]/a")));

        AddNewCustomer ac = new AddNewCustomer(driver);
        Thread.sleep(5000);
        ac.newcustomer();
    
        String customerName = generateRandomUsername();
        String customerEmail = generateRandomEmail();
        ac.setname(customerName);
        System.out.println("New customer with this username: " + customerName);
        ac.setgender("male");
        ac.setdob("31", "Aug", "1969");
        ac.setaddress("Route mahdia km 10 ");
        ac.setcity("Sfax");
        ac.setstate("Tunisia");
        ac.setpin(241227);
        ac.setmobile("27172110");
        ac.setmail(customerEmail);
        System.out.println("New customer with this email: " + customerEmail);

        ac.setpassword("Heckyeah12");
        ac.clicksubmit();
        Thread.sleep(3000);
        // Assertion
        String expectedMsg = "Customer Registered Successfully!!!";
        String actualMsg = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p")).getText();

        try {
            Assert.assertEquals(actualMsg, expectedMsg);
            System.out.println("Customer Registered Successfully!!!");
        } catch (Exception e) {
            System.out.println("Failed to register customer. Verify the entered inputs.");
        }
    }

    private String generateRandomUsername() {
        String base = "user" + UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "");
        return base.substring(0, Math.min(base.length(), 8));
    }

    private String generateRandomEmail() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12) + "@gmail.com";
    }
}
