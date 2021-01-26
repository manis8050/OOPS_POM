package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{
//If we have only a parameterized constructor in parent class then we should have one in child class. if we have both default(no-arg) and parameterized consutuctor 
	//in parent then we do not need to have one in child class
	//Implicit super constructor Page() is undefined for default constructor. Must define an explicit constructor
	public BasePage(WebDriver driver) {
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

}
