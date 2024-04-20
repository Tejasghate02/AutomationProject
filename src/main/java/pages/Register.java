package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Register extends TestBase {

	//creating object repository for practiceform
	@FindBy(xpath="//a[normalize-space()='Register']") private WebElement registerFormBtn;
	@FindBy(xpath="//input[@id='firstname']") private WebElement firstName;
	@FindBy(xpath="//input[@id='lastname']") private WebElement lastName;
	@FindBy(xpath="//input[@id='username']") private WebElement userName;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//input[@value='Register']") private WebElement registerBtn;
	@FindBy(xpath="//a[@type='submit']") private WebElement backToLoginBtn;
	
	
	//constructor
	public Register(){
		PageFactory.initElements(driver, this);
	}
	
	//action methods
	public String registerForm() {
		registerFormBtn.click();
		firstName.sendKeys("Tejas");
		lastName.sendKeys("Ghate");
		userName.sendKeys("Tejas123");
		password.sendKeys("Pass@123");
		registerBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyBackToLoginBtn() {
		registerFormBtn.click();
		backToLoginBtn.click();
		return driver.getCurrentUrl();
	}
}
