package ebanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ebanking.pageobjects.Loginpage;
import ebanking.utilities.XLUtils;

public class TC_LoginDDT_1101 extends Baseclass {
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String un, String pw) throws InterruptedException
	{
		Loginpage lp=new Loginpage(driver);
		lp.setusername(un);
		lp.setpassword(pw);
		lp.clickSubmit();
		Thread.sleep(3000);
		if(isAlertpresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
			lp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	public boolean isAlertpresent()
	{
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	@DataProvider(name="LoginData")
	String[][] getData() {
	    String path = "C:\\Users\\LEGION\\eclipse-workspace\\ebankingV1\\src\\test\\java\\ebanking\\testData\\LoginData.xlsx";
	    int rownum = 0;
	    int colcount = 0;
	    String loginData[][] = null;

	    try {
	        rownum = XLUtils.getRowCount(path, "Sheet1");
	        colcount = XLUtils.getCellCount(path, "Sheet1", 1);

	        loginData = new String[rownum][colcount];

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
