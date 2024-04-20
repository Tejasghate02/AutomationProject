package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ModalDialogs extends TestBase{

	
	@FindBy(xpath="//button[normalize-space()='Alerts, Frames & Windows']") private WebElement alertFramesWindowPage;
	@FindBy(xpath="//a[normalize-space()='Modal Dialogs']") private WebElement modalDialogsPage;
	@FindBy(xpath="//button[normalize-space()='Small Modal']") private WebElement smallModalBtn;
	@FindBy(xpath="//button[normalize-space()='Large Modal']") private WebElement largeModalBtn;
	@FindBy(xpath="//button[@data-bs-target='#exampleModalLg'][normalize-space()='Close']") private WebElement largeCloseBtn;
	@FindBy(xpath="//div[@class='modal-dialog modal-sm']//button[@class='btn btn-primary'][normalize-space()='Close']") private WebElement smallCloseBtn;
	
	
	//constructor
	public ModalDialogs() {
		PageFactory.initElements(driver, this);
	}
	
	
	//action methods
	public boolean verifySmallModal() {
		alertFramesWindowPage.click();
		modalDialogsPage.click();
		smallModalBtn.click();
		boolean btn = smallCloseBtn.isEnabled();
		smallCloseBtn.click();
		return btn;
	}
	
	public boolean verifyLargeModal() {
		alertFramesWindowPage.click();
		modalDialogsPage.click();
		largeModalBtn.click();
		boolean btn = largeCloseBtn.isEnabled();
		largeCloseBtn.click();
		return btn;
	}
}
