package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Login;
import pages.Register;
import utility.Screenshot;

public class LoginTest extends TestBase{

	Login log ;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		log = new Login();
	}
	
	@Test
	public void LoginTest() {
		String expUrl = "https://www.tutorialspoint.com/selenium/practice/login.php#";
		String actUrl = log.verifyLogin();
		AssertJUnit.assertEquals(expUrl, actUrl);
	}
	
	@Test
	public void verifyNewUserBtnTest() {
		String expUrl = "https://www.tutorialspoint.com/selenium/practice/register.php";
		String actUrl = log.verifyNewUserBtn();
		AssertJUnit.assertEquals(expUrl, actUrl);
	}
	
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus()) {
			Screenshot.screenshot(it.getName());
		}
		driver.quit();
	}
}
