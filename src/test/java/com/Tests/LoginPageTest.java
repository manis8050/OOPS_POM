package com.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

public class LoginPageTest extends BaseTest {
	
//	public LoginPageTest(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}


	/**
	 * @throws InterruptedException 
	 * 
	 */
	
    @Test(priority=1,enabled=false)
    public void verifyLoginPageTitleTest( )
    {
    	System.out.println("Into LoginPage test");
    	String title=page.getInstance(LoginPage.class).getLoginPageTitle();       //page.getInstance(LoginPage.class)" is equivalent to the object of login page
//    	LoginPage lpage=new LoginPage(driver);
//    	String title=lpage.getLoginPageTitle();
    	 System.out.println(title);
    	 Assert.assertEquals(title, "actiTIME - Login","Title assertion failed");
    }

    
  //  @Test(priority=2)
    public void verifyLoginPageHeaderTest()
    {
    	String header=page.getInstance(LoginPage.class).getHeader();
    	System.out.println(header);
    	Assert.assertEquals(header,"Please identify yourself","Login Page header is incorrect");
    }
    
    
    @Test(priority=3)
    @Parameters(value= {"username","password"})
    public void verifyDoLoginTest(String username,String password)
    {
    	HomePage homepage=page.getInstance(LoginPage.class).doLogin(username, password);
    	String headerHome=homepage.getHomePageHeader();
    	System.out.println(headerHome);
    	Assert.assertEquals(headerHome, "Enter Time-Track","Incorrect home page header");
    	
    }
}
