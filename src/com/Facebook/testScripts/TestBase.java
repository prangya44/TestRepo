package com.Facebook.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	public static WebDriver driver;
	   
    @BeforeMethod
    public void openBrowser(){
    
    	String url = "https://www.facebook.com/";
    	System.setProperty("webdriver.chrome.driver", "D://Selenium//workspace//Facebook_Project_POM//drivers//chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void closeBrowser(){
    driver.close();
    }
}
