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
import pages.AlertPage;
import pages.Register;
import utility.Screenshot;

public class AlertPageTest extends TestBase{

	
	AlertPage al;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		al = new AlertPage();
	}
	
	@Test
	public void verifyHelloWorldAlertTest() {
		String expText = "Hello world!";
		String actText = al.verifyHelloWorldAlert();
		AssertJUnit.assertEquals(expText, actText);
	}
	
	@Test
	public void verifyDelayedAlertTest() throws InterruptedException {
		String expText = "Hello just appeared";
		String actText = al.verifyDelayedAlert();
		AssertJUnit.assertEquals(expText, actText);
	}
	
	@Test
	public void verifyConfirmationAlertTest() {
		String expText = "Press a button!";
		String actText = al.verifyConfirmationAlert();
		AssertJUnit.assertEquals(expText, actText);
	}
	
	@Test
	public void verifyInputAlertTest() {
		String expText = "What is your name?";
		String actText = al.verifyInputAlert();
		AssertJUnit.assertEquals(expText, actText);
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
