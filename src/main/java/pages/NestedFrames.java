package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class NestedFrames extends TestBase{

	@FindBy(xpath="//button[normalize-space()='Alerts, Frames & Windows']") private WebElement alertFramesWindowsPage;
	@FindBy (xpath="//a[normalize-space()='Nested Frames']") private WebElement nestedFramesPage;
	
	//constructor
	public NestedFrames() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyFrameText() {
		alertFramesWindowsPage.click();
		nestedFramesPage.click();
	    driver.switchTo().frame(0);
	    String text = driver.findElement(By.tagName("h1")).getText();
		return text;
	}
}
