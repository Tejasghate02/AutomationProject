package test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AlertPage;
import pages.NestedFrames;
import utility.Screenshot;

public class NestedFramesTest extends TestBase {
	
	NestedFrames ns;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		ns = new NestedFrames();
		
	}
	
	@Test
	public void verifyIFrameTextTest() {
		String actText = ns.verifyFrameText();
		String expText = "New Tab";
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
