package com.Facebook.objectPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Facebook.testScripts.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[text()='Log Out']")  //form[@class='_w0d _w0d']//parent::span[@class='_54nh'] 
	WebElement logOutBtn;
	
	@FindBy(id="userNavigationLabel")   //div[text()='Account Settings']
	WebElement arrwMarkForOptns;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public void logout() {
	
		/*Actions actions = new Actions(driver);
		actions.moveToElement(arrwMarkForOptns);*/
		Select select = new Select(arrwMarkForOptns);
		arrwMarkForOptns.click();
		select.selectByVisibleText("Log Out");
		logOutBtn.click();
		/*arrwMarkForOptns.click();
		logOutBtn.click();
		return new LoginPage();*/
	}
	
	
	
	
	
}

	