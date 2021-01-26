package com.mypages;

import static com.mypages.Page.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage1 extends Page{
	public static Page page;
//If we have only a parameterized constructor in parent class then we should have one in child class. if we have both default(no-arg) and parameterized consutuctor 
	//in parent then we do not need to have one in child class
	//Implicit super constructor Page() is undefined for default constructor. Must define an explicit constructor
	public BasePage1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPageTitle()  {
		System.out.println("this is inside the getPAgeTitle method in BasePAge");
		//Thread.sleep(6000);
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	
	}

	@Override
	public WebElement getElement(By locator) {         //This is the wrapper method
		WebElement element=null;
		try {
			waitforElementPresent(locator);
			element=driver.findElement(locator);
			return element;
		}
		catch(Exception e)
		{
			System.out.println("some error occurred while creating element" +locator.toString());
			e.printStackTrace();
			
		}
		return element;
	}

	@Override
	public void waitforElementPresent(By locator) {
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e)
		{
			System.out.println("Some exception occured while waiting for the element" +locator.toString());
		}
		
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e)
		{
			System.out.println("Some Exception occured while waiting for the Page title" + title);
		}
		
	}
	@Parameters(value= {"browser"})
	public static void setUpBrowser(String browser)
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

	public static void closeBrowser()
	{
		driver.quit();
	}
}


