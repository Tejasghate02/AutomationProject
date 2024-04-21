package test;

import org.testng.annotations.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.PracticeForm;
import utility.Screenshot;

public class PracticeFormTest extends TestBase{

	
	PracticeForm form;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		form = new PracticeForm();
	}
	
	@Test
	public void studentRegistrationFormTest() throws IOException, InterruptedException {
		form.studentRegistrationForm();
		AssertJUnit.assertTrue(true);  
	}

	@Test 
	public void verifyLoginBtnTest() {
		boolean act = form.verifyLoginBtn();
		boolean exp = false;
		AssertJUnit.assertEquals(exp, act);  
		Reporter.log("Login button is not clickable");
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		Reporter.setCurrentTestResult(it);
		File img = new File(System.getProperty("user.dir")+"/failedScreenshot"+it.getMethod().getMethodName()+".jpeg");
		
		if(it.FAILURE==it.getStatus()) {
			Reporter.log("This is failure log");
			
			FileOutputStream screshotStream = new FileOutputStream(img);
			screshotStream.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			screshotStream.close();
			
			//Screenshot.screenshot(it.getName());
			
			Reporter.log(" <a href='"+img.getAbsolutePath()+"'> <img src='"+ img.getAbsolutePath()+"' height='200' widht='200/> </a>");
			
		}
		
		driver.quit();
	}
}
