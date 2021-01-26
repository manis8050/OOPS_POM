package com.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.BasePage1;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 */

public class BaseTest2 extends BasePage1{
	
//	WebDriver driver;
//	public Page page;
	
	public BaseTest2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUpTest(String browser)
	{
		setUpBrowser(browser);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}
	
}
