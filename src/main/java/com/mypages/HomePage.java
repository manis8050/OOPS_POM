package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	
	// ********************************************** PAge locators *********************************************88//
	private By homePageHeader=By.xpath("//td[contains(text(),'Enter Time-Track')]");
	private By productNameHeader=By.xpath("//div[@class='productName']/div[2]");
	private By TimeTrackNavItemLbl=By.xpath("//div[text()='Time-Track']");
	private By TimeTracknavItemIcon=By.id("container_tt");
	
	
	//**************************************** Getter methods ***************************************************************	
	/**
	 * @return the homePageHeader
	 */
	public String getHomePageHeader() {
		return getElement(homePageHeader).getText();
	}

	/**
	 * @return the productNameHeader
	 */
	public WebElement getProductNameHeader() {
		return getElement(productNameHeader);
	}

	/**
	 * @return the timeTrackNavItemLbl
	 */
	public WebElement getTimeTrackNavItemLbl() {
		return getElement(TimeTrackNavItemLbl);
	}

	/**
	 * @return the timeTracknavItemIcon
	 */
	public WebElement getTimeTracknavItemIcon() {
		return getElement(TimeTracknavItemIcon);
	}

	
	//************************************************************ Constructor *********************************************************//

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//************************************************* Page MEthods/actions *****************************************************//
	
	public String getHomePageTitle()
	{
		return getPageTitle();
	}

	public void getLoginPageHeader()
	{
		getPageHeader(homePageHeader);
		
	}
	

}
