package com.Facebook.testScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Facebook.objectPage.HomePage;
import com.Facebook.objectPage.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		//openBrowser();
		lp = new LoginPage();
		hp = new HomePage();
	}
	
	@Test(priority = 1)
	public void loginPagetitleTest() {
		String title = lp.validLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up", "LoginPage title not matched");
	}
	
	@Test(priority = 2)
	public void fbLogoImgTest() {
		boolean flag = lp.validateFbImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void validLoginTest() {
		homePage = lp.login("prangya.pswain@gmail.com", "mylove!");
	}
	
	@Test(priority = 4)
    public void loginValidBackTest(){
		homePage = lp.login("prangya.pswain@gmail.com", "mylove!");
		//homePage.logout();
	    driver.navigate().back();
	    String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Facebook", "Homepage title not matched");	
	}
	
	@Test(priority = 5)
    public void invalidLoginTest(){
		loginPage = lp.invalidLogin("prangya.pswain@gmail.com", "abcdef");
		boolean flag = lp.validateErrMsg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 6)
    public void loginInvalidBlankTest(){
		loginPage = lp.invalidLogin("", "");
    }
	
	@Test(priority = 7)
    public void loginInvalidBlankPasswordTest(){
		loginPage = lp.invalidLogin("prangya.pswain@gmail.com", "");
    }
}
