package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Login extends  TestBase{

	
	//Object Repository
	@FindBy(xpath="//a[normalize-space()='Login']") private WebElement loginPageBtn;
	@FindBy(xpath="//input[@id='email']") private WebElement emailInputBox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordInputBox;
	@FindBy(xpath="//input[@value='Login']") private WebElement loginBtn;
	@FindBy(xpath="//a[@type='submit']") private WebElement newUserBtn;

	//constructor
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	//actionMethods
	public String verifyLogin() {
		loginPageBtn.click();
		emailInputBox.sendKeys("tejasghate@gmail.com");
		passwordInputBox.sendKeys("Pass@123");
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyNewUserBtn() {
		loginPageBtn.click();
		newUserBtn.click();
		return driver.getCurrentUrl();
	}
}
