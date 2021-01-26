package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author manis
 *
 */
public class LoginPage extends BasePage {

	//*********************************************** Page Locators ******************************************************
	private By usernameTb=By.id("username");
	private By passwordTb=By.name("pwd");
	private By loginBtn=By.id("loginButton");
	private By header=By.xpath("//td[@id='headerContainer']");

// ******************************************************** Getter Methods **********************************************************8
	//In most cases we do not need setters methods but can add based on your requirements.
	/**
	 * @return the usernameTb
	 */
	//getElement is expecting a locator which is By locator.
	public WebElement getUsernameTb() {
		return getElement(usernameTb);
	}
	/**
	 * @return the passwordTb
	 */
	public WebElement getPasswordTb() {
		return getElement(passwordTb);
	}
	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}
	/**
	 * @return the loginPageTitle
	 */
	public  String getHeader() {
		return getElement(header).getText();
	}
// ******************************************************* Constructors **************************************************************//
	public LoginPage(WebDriver driver) {
		super(driver);
		}
//****************************************Page Actions/methods *************************************************************************//
	public String getLoginPageTitle()
	{
		System.out.println("Inside the LoginPage title method in LoginPAge class");
		return getPageTitle();
	}
	
   public String getLoginPageHeader()
	{
		return getPageHeader(header);
		
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public HomePage doLogin(String username,String password)
	{
		getUsernameTb().sendKeys(username);
		getPasswordTb().sendKeys(password);
		getLoginBtn().click();
		return getInstance(HomePage.class);  //Page chaining model
	}
	/**
	 *
	 * @return
	 */
	//This is  method overloading- passing empty data into the text fields
	public void doLogin()
	{
		getUsernameTb().sendKeys("");
		getPasswordTb().sendKeys("");
		getLoginBtn().click();
	}
	
	
	//This is  method overloading - passing single parameter
	//username:ABC@gmail.com
	public void doLogin(String userCred)
	{
		if(userCred.contains("username"))
		{
			getUsernameTb().sendKeys(userCred.split(":")[1].trim());	
		}
		else if(userCred.contains("password"))
	{
			getUsernameTb().sendKeys(userCred.split(":")[1].trim());
	}
		getLoginBtn().click();
	}
}
