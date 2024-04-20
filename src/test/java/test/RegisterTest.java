package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.PracticeForm;
import pages.Register;
import utility.Screenshot;

public class RegisterTest extends TestBase{

	Register reg;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		reg = new Register();
	}
	
	
	@Test
	public void registerFormTest() {
		String expUrl = "https://www.tutorialspoint.com/selenium/practice/register.php#";
		String actUrl = reg.registerForm();
		AssertJUnit.assertEquals(expUrl, actUrl);
	}
	
	@Test
	public void verifyBackToLoginBtnTest() {
		String expUrl = "https://www.tutorialspoint.com/selenium/practice/login.php";
		String actUrl = reg.verifyBackToLoginBtn();
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
