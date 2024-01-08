package ebanking.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
    WebDriver ldriver;

    // Constructor to initialize the WebDriver and PageFactory
    public AddNewCustomer(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    // WebElements using @FindBy annotation
    @FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
    WebElement newcustomerbtn;

    @FindBy(name = "name")
    WebElement cname;

    @FindBy(name = "rad1")
    WebElement cgender;

    @FindBy(name = "dob")
    WebElement cbirthday;

    @FindBy(name = "addr")
    WebElement caddress;

    @FindBy(name = "city")
    WebElement ccity;

    @FindBy(name = "state")
    WebElement cstate;

    @FindBy(name = "pinno")
    WebElement cpin;

    @FindBy(name = "telephoneno")
    WebElement cmobile;

    @FindBy(name = "emailid")
    WebElement cmail;

    @FindBy(name = "password")
    WebElement cpassword;

    @FindBy(name = "sub")
    WebElement clksubmit;

    // Method to click the "New Customer" button
    public void newcustomer() {
        newcustomerbtn.click();
    }

    // Method to set customer name
    public void setname(String name) {
        cname.sendKeys(name);
    }

    // Method to set customer gender
    public void setgender(String gender) {
        cgender.click();
    }

    // Method to set customer date of birth
    public void setdob(String dd, String mm, String yyyy) {
        cbirthday.clear();
        cbirthday.sendKeys(dd);
        cbirthday.sendKeys(mm);
        cbirthday.sendKeys(Keys.TAB);
        cbirthday.sendKeys(yyyy);
    }

    // Method to set customer address
    public void setaddress(String location) {
        caddress.sendKeys(location);
    }

    // Method to set customer city
    public void setcity(String city) {
        ccity.sendKeys(city);
    }

    // Method to set customer state
    public void setstate(String state) {
        cstate.sendKeys(state);
    }

    // Method to set customer PIN
    public void setpin(int pin) {
        cpin.sendKeys(String.valueOf(pin));
    }

    // Method to set customer mobile number
    public void setmobile(String tlp) {
        cmobile.sendKeys(tlp);
    }

    // Method to set customer email
    public void setmail(String mail) {
        cmail.sendKeys(mail);
    }

    // Method to set customer password
    public void setpassword(String pwd) {
        cpassword.sendKeys(pwd);
    }

    // Method to click the "Submit" button
    public void clicksubmit() {
        clksubmit.click();
    }
}
