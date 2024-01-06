package ebanking.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	WebDriver ldriver;
	public AddNewCustomer(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement newcustomerbtn;
	@FindBy(name="name")
	WebElement cname;
	@FindBy(name="rad1")
	WebElement cgender;
	@FindBy(name="dob")
	WebElement cbirthday;
	@FindBy(name="addr")
	WebElement caddress;
	@FindBy(name="city")
	WebElement ccity;
	@FindBy(name="state")
	WebElement cstate;
	@FindBy(name="pinno")
	WebElement cpin;
	@FindBy(name="telephoneno")
	WebElement cmobile;
	@FindBy(name="emailid")
	WebElement cmail;
	@FindBy(name="password")
	WebElement cpassword;
	@FindBy(name="sub")
	WebElement clksubmit;
	public void newcustomer()
	{
		newcustomerbtn.click();
	}
	public void setname(String name)
	{
		cname.sendKeys(name);
	}
	public void setgender(String gender)
	{
		cgender.click();
	}
	public void setdob(String dd,String mmm, String yyyy)
	{
		cbirthday.clear();
		cbirthday.sendKeys(dd);
		cbirthday.sendKeys(mmm);
		cbirthday.sendKeys(Keys.TAB);
		cbirthday.sendKeys(yyyy);
	}
	public void setaddress(String location)
	{
		caddress.sendKeys(location);
	}
	public void setcity(String city)
	{
		ccity.sendKeys(city);
	}
	public void setstate(String state)
	{
		cstate.sendKeys(state);
	}
	public void setpin(int pin)
	{
		cpin.sendKeys(String.valueOf(pin));
	}
	public void setmobile(String tlp)
	{
		cmobile.sendKeys(tlp);
	}
	public void setmail(String mail)
	{
		cmail.sendKeys(mail);
	}
	public void setpassword(String pwd)
	{
		cpassword.sendKeys(pwd);
	}
	public void clicksubmit()
	{
		clksubmit.click();
	}
	
}
