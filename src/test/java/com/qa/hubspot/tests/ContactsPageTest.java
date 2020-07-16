package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.ContactPage;
import com.qa.hubspot.pages.HomePage;

import qa.com.hubspot.utils.ConstantsUtil;

public class ContactsPageTest extends BaseTest {
	
	HomePage homepage;
	ContactPage contactpage;
	
	@BeforeClass
	public void contactPageSetup() {
		homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		contactpage=homepage.goToContactsPage();
		
	}
	@Test(priority=1)
	public void verifyContactsPageTest() {
		String title=contactpage.getContactPageTitle();
		System.out.println("Contact Page Title "+title);
		Assert.assertEquals(title, ConstantsUtil.CONTACTS_PAGE_TITLE);
	}
	@Test(priority=2)
	public void verifyContactPageHeader() {
		String header=contactpage.getContactPageHeader();
		System.out.println("Contact Page Header "+header);
		Assert.assertEquals(header,"Contacts");
		
	}

@Test(priority=3)	
	public void createNerContactTest() {
		contactpage.createContact("test@gmail.com","tom","peter","Sdet");
		
	}
@Test(priority=5)
public void deleteUserInfo() {
	 contactpage.deleteUserInfo();
}
@Test(priority=6,enabled=true)
public void verifyContactDelete() {
	String deleteConf=contactpage.getConfirmContactDelete();
	System.out.println("Delete Confirmation Heading "+deleteConf);
	Assert.assertEquals(deleteConf,"Time to get organized.");
}





@Test(priority=4)
public void verifyUserCreateSucessfully() {
	String userConf=contactpage.getUserConfirmation();
	System.out.println("user created "+userConf);
	Assert.assertEquals(userConf,"tom peter");
}

	
	
	
}
