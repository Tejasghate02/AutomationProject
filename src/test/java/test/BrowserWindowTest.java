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
import pages.BrowserWindow;
import pages.ModalDialogs;
import utility.Screenshot;

public class BrowserWindowTest extends TestBase{

	
	BrowserWindow bw;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		bw = new BrowserWindow();
	}
	
	@Test
	public void verifyNewTabBtnTest() {
		String actText = bw.verifyNewTabBtn();
		String expText = "New Tab";
		AssertJUnit.assertEquals(expText, actText);
	}
	
	@Test
	public void VerifyNewWindowBtnTest() {
		String actText = bw.VerifyNewWindowBtn();
		String expText = "New Window";
		AssertJUnit.assertEquals(expText, actText);
	}
	
	@Test
	public void verifyNewWinMessageBtnTest() {
		String actText = bw.verifyNewWinMessageBtn();
		String expText = "New Window Message";
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
