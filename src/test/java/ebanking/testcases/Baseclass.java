package ebanking.testcases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import ebanking.utilities.ReadConfig;

public class Baseclass {
	ReadConfig readconfig= new ReadConfig();
	public String URL=readconfig.getapplicationURL();
	public String un=readconfig.getapplicationusername();
	public String pw=readconfig.getapplicationpassword();
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",readconfig.getapplicationchromedriver());
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@AfterClass
	public void teardown() {
		driver.close();
		
	}
}
