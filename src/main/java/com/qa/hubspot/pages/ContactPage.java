package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

import qa.com.hubspot.utils.ConstantsUtil;
import qa.com.hubspot.utils.ElementUtil;

public class ContactPage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementutil;

	public ContactPage(WebDriver driver) {
		this.driver=driver;
		elementutil =new ElementUtil(this.driver);

	}
	
	By header=By.xpath("(//*[text()='Contacts'])[2]");
	///By header=By.cssSelector("h1.private-header__heading");
	By createContactPrimary=By.xpath("//span[text()='Create contact']");
	By email=By.xpath("//input[@data-field='email']");
	By firstname =By.xpath("//input[@data-field='firstname']");
	By lastname=By.xpath("//input[@data-field='lastname']");
	By jobtitle=By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary=By.xpath("(//span[text()='Create contact'])[2]");
	
	By contactBackLink=By.xpath("(//*[text()='Contacts'])[1]");
	By userConfirmation=By.xpath("//span[@data-selenium-test='highlightTitle']");
	By userCheckBox=By.xpath("(//span[@class='private-checkbox__icon private-checkbox__dash'])[2]");
	By deleteUser=By.xpath("//*[text()='Delete']");
	By username=By.xpath("(//a[@class='private-link uiLinkWithoutUnderline uiLinkDark truncate-text align-center'])[1]");
    By userLabel=By.xpath("//span[@data-selenium-test='highlightTitle']");
    By checkBox=By.xpath("(//span[@class='private-checkbox__icon private-checkbox__dash'])[1]");
    By deleteIcon=By.xpath("//*[text()='Delete']");
    By deleteBox=By.xpath("//*[@id=\"UIFormControl-34\"]");
    By deleteIcon2=By.xpath("(//*[text()='Delete'])[2]");
	By deleteConf=By.xpath("//*[text()='Time to get organized.']");
	
	
	
	
	public String getContactPageTitle() {
		return elementutil.doGetPageTitleWithIsTitle(10,ConstantsUtil.CONTACTS_PAGE_TITLE);

		
	}
	public String getUserConfirmation() {
		elementutil.waitForElementPresent(userConfirmation, 10);
		String captUserInfo=elementutil.doGetText(userConfirmation);
		elementutil.clickWhenReady(contactBackLink, 10);

		return captUserInfo;
	}
	public String getContactPageHeader() {
		elementutil.waitForElementPresent(header, 10);
		return elementutil.doGetText(header);
	}
	
	public String getConfirmContactDelete() {
		elementutil.waitForElementPresent(deleteConf,10);
		return elementutil.doGetText(deleteConf);
	}
	
	public void createContact(String emailId,String firstname,String lastname,String jobTitle) {
		elementutil.clickWhenReady(createContactPrimary, 10);
		elementutil.doSendKeys(this.email, emailId);
		elementutil.doSendKeys(this.firstname, firstname);
		elementutil.doSendKeys(this.lastname, lastname);
		elementutil.doSendKeys(this.jobtitle, jobTitle);
		
		elementutil.clickWhenReady(createContactSecondary,10);
		
		
		
	}
	
	public void deleteUserInfo() {
		elementutil.doClick(checkBox);
		elementutil.doClick(deleteIcon);
		elementutil.doSendKeys(deleteBox,"1");
		elementutil.doClick(deleteIcon2);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
