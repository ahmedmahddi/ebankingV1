package ebanking.testcases;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ebanking.utilities.ReadConfig;

public class Baseclass {
    ReadConfig readconfig = new ReadConfig();
    public String URL = readconfig.getapplicationURL();
    public String un = readconfig.getapplicationusername();
    public String pw = readconfig.getapplicationpassword();

    public static WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", readconfig.getapplicationchromedriver());

        String extensionPath = "C:\\Users\\LEGION\\eclipse-workspace\\ebankingV1\\extension\\ublock.crx";

        ChromeOptions options = new ChromeOptions();

        options.addExtensions(new File(extensionPath));
        // Create a new ChromeDriver with the configured ChromeOptions
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
