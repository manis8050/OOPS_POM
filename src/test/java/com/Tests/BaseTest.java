package com.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 */

public class BaseTest {
	
	WebDriver driver;
	public Page page;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUpTest(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("FF"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
		}
		else
		{
			System.out.println("No browser is defined in the testng.xml file");
		}
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
	//	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.MICROSECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MICROSECONDS);   //something in the pageLoadTimeout is causing this. 
		page=new BasePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
