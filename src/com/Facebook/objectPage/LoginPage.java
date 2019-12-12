package com.Facebook.objectPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Facebook.testScripts.TestBase;


public class LoginPage extends TestBase{

	//Page Factory
	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(id="u_0_b")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@class='fb_logo img sp_FNo-BRNXnCI sx_47caa9']")
	WebElement fbLogo;
	
	@FindBy(id="u_0_13")
	WebElement signUpBtn;
	
	@FindBy(xpath="//*[@class='_4rbf _53ij']")
	WebElement errMsg;
	
	//Initializing the objects
	public LoginPage(){
	PageFactory.initElements(driver, this);
	
	}
	
	//Actions
	public String validLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateFbImage() {
		return fbLogo.isDisplayed();
	}
	
	public WebElement loginBtn() {
		return loginBtn;
	}
	
	public HomePage login(String eId, String pwd) {
		emailId.sendKeys(eId);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	public LoginPage invalidLogin(String eId, String pwd) {
		emailId.sendKeys(eId);
		password.sendKeys(pwd);
		loginBtn.click();
		return new LoginPage();
	}
	
	public boolean validateErrMsg() {
		return errMsg.isDisplayed();
	}

}
