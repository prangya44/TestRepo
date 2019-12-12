package com.Facebook.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Facebook.objectPage.HomePage;
import com.Facebook.objectPage.LoginPage;

public class AtloginValidBack extends TestBase{

	LoginPage lp;
	HomePage homePage;
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void setup() {
		openBrowser();
		lp = new LoginPage();
	}
		@Test
		public void invalidLogintest() {
	
			homePage = lp.login("prangya.pswain@gmail.com", "mylove!");
		    homePage.logout();
	    /*driver.navigate().back();
	    String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Facebook");*/
		
		
	}
}

