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
    // Creating an instance of ReadConfig to read configuration properties
    ReadConfig readconfig = new ReadConfig();
    
    // Getting application URL, username, and password from configuration
    public String URL = readconfig.getapplicationURL();
    public String un = readconfig.getapplicationusername();
    public String pw = readconfig.getapplicationpassword();

    // WebDriver instance to be used across test classes
    public static WebDriver driver;

    // Setup method to be executed before the test class
    @BeforeClass
    public void setup() throws InterruptedException {
        // Setting the system property for ChromeDriver
        System.setProperty("webdriver.chrome.driver", readconfig.getapplicationchromedriver());

        // Defining the path for Chrome extension
        String extensionPath = "C:\\Users\\LEGION\\eclipse-workspace\\ebankingV1\\extension\\ublock.crx";

        // Configuring ChromeOptions with the extension
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(extensionPath));

        // Creating a new ChromeDriver with the configured ChromeOptions
        driver = new ChromeDriver(options);
        
        // Opening the application URL
        driver.get(URL);
        
        // Setting implicit wait for WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Teardown method to be executed after the test class
    @AfterClass
    public void teardown() {
        // Quitting the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
