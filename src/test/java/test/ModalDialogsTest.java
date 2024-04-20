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
import pages.ModalDialogs;
import utility.Screenshot;

public class ModalDialogsTest extends TestBase{

	ModalDialogs mod;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		mod = new ModalDialogs();
	}
	
	@Test
	public void verifySmallModalTest() {
		Boolean exp = true;
		Boolean act = mod.verifySmallModal();
		AssertJUnit.assertEquals(exp, act);
	}
	
	@Test
	public void verifyLargeModalTest() {
		Boolean exp = true;
		Boolean act = mod.verifyLargeModal();
		AssertJUnit.assertEquals(exp, act);
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
