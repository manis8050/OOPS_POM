package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	static WebDriver driver;
	WebDriverWait wait;
	
	

	public Page(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,15);
	}
	
	//abstract methods
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitforElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	
	
	//Generic method-to return the object of the page
	//at run time whatever the page class i am passing 
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass)
	{
		
		try {
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
	}
		
 catch(Exception e)
		{
	    //System.out.println(e.getMessage());  or
	    e.printStackTrace();
	    return null;
		}
	
}
	
}
