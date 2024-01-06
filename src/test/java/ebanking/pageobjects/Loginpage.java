package ebanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;
	public Loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="uid")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
	WebElement logoutbtn;
	public void setusername(String un){
		username.sendKeys(un);
		
	}
	public void setpassword(String pw){
		password.sendKeys(pw);
		
	}
	public void clickSubmit(){
		btnLogin.click();
	}
	public void clicklogout() 
	{
		logoutbtn.click();
	}
}
