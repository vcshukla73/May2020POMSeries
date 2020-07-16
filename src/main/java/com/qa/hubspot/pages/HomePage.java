package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

import qa.com.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	
	
	private WebDriver driver;
	ElementUtil elementutil;
	
	By header=By.cssSelector("h1.private-header__heading.private-header__heading--solo");
	By accountname=By.cssSelector("span.account-name ");
	By contactPrimaryLink=By.id("nav-primary-contacts-branch");
	By contactSecondaryLink=By.id("nav-secondary-contacts");

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementutil=new ElementUtil(this.driver);
	}
	
	public String  getHomePageTitle() {
		return driver.getTitle();
		
	}
	public String getHomePageHeader() {
		if(driver.findElement(header).isDisplayed())
		return driver.findElement(header).getText();
		return null;
		
		
	}
	
public String getLoggedAccountName() {
	if(driver.findElement(accountname).isDisplayed())
		return driver.findElement(accountname).getText();
	return null;
	
	
	
}
	
public ContactPage goToContactsPage() {
	clickOnContacts();
	return new ContactPage(driver);
}


	private void clickOnContacts() {
		elementutil.waitForElementPresent(contactPrimaryLink, 10);
		elementutil.doClick(contactPrimaryLink);
		elementutil.clickWhenReady(contactSecondaryLink, 5);
	}
	
	
	
	

}
