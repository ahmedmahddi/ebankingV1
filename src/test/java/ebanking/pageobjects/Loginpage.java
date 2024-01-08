package ebanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    
    // WebDriver instance
    WebDriver ldriver;

    // Constructor to initialize WebDriver and PageFactory
    public Loginpage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    // WebElement for username field
    @FindBy(name = "uid")
    WebElement username;

    // WebElement for password field
    @FindBy(name = "password")
    WebElement password;

    // WebElement for login button
    @FindBy(name = "btnLogin")
    WebElement btnLogin;

    // WebElement for logout button
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
    WebElement logoutbtn;

    // Method to set the username
    public void setusername(String un) {
        username.sendKeys(un);
    }

    // Method to set the password
    public void setpassword(String pw) {
        password.sendKeys(pw);
    }

    // Method to click the login button
    public void clickSubmit() {
        btnLogin.click();
    }

    // Method to click the logout button
    public void clicklogout() {
        logoutbtn.click();
    }
}
