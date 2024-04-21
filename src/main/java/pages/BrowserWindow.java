package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class BrowserWindow extends TestBase{

	@FindBy(xpath="//button[normalize-space()='Alerts, Frames & Windows']") private WebElement alertFramesWindowsPage;
	@FindBy(xpath="//a[normalize-space()='Browser Windows']") private WebElement browserWindowPage;
	@FindBy(xpath="//button[@title='New Tab']") private WebElement newTabBtn;
	@FindBy(xpath="//button[normalize-space()='New Window']") private WebElement newWindowBtn;
	@FindBy(xpath="//button[normalize-space()='New Window Message']") private WebElement newWinMessageBtn;
	
	
	//constructor
	public BrowserWindow() {
		PageFactory.initElements(driver, this);
	}
	
	//action methods
	public String verifyNewTabBtn() {
		alertFramesWindowsPage.click();
		browserWindowPage.click();
		String oW = driver.getWindowHandle();
		newTabBtn.click();
		
		Set<String> windows = driver.getWindowHandles();
		
		for (String w : windows) {
	         if(!oW.equalsIgnoreCase(w)) {
	            driver.switchTo().window(w);
	         }
	      }
		
		String newTabText = driver.findElement(By.xpath("//h1[@class='mb-3 fw-normal border-bottom text-left pb-2 mb-4']")).getText();
		return newTabText;
	}
	
	public String VerifyNewWindowBtn() {
		alertFramesWindowsPage.click();
		browserWindowPage.click();
		String oW = driver.getWindowHandle();
		newWindowBtn.click();
		
	    Set<String> windows = driver.getWindowHandles();
	    
	    for (String w : windows) {
	         if(!oW.equalsIgnoreCase(w)) {
	            driver.switchTo().window(w);
	         }
	      }
	    
	    String eleText = driver.findElement(By.xpath("//h1[@class='mb-3 fw-normal border-bottom text-left pb-2 mb-4']")).getText();
	    
		return eleText;
		
	}
	
	public String verifyNewWinMessageBtn() {
		alertFramesWindowsPage.click();
		browserWindowPage.click();
		String oW = driver.getWindowHandle();
		newWinMessageBtn.click();
		
	    Set<String> windows = driver.getWindowHandles();
	    
	    for (String w : windows) {
	         if(!oW.equalsIgnoreCase(w)) {
	          
	            driver.switchTo().window(w);
	         }
	      }
	    
	    String newWinText = driver.findElement(By.xpath("//h1[@class='mb-3 fw-normal border-bottom text-left pb-2 mb-4']")).getText();
	    
		return newWinText;
	}
}
