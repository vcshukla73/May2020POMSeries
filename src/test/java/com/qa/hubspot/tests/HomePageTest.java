package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.HomePage;

public class HomePageTest extends BaseTest {
	
	HomePage homepage;
	@BeforeClass
	public void homePageSetup() {
		homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	

	@Test(priority=2)
	public void verifyHomePageTitleTest() {
		String title = homepage.getHomePageTitle();
		Assert.assertEquals(title, "Account Setup | HubSpot");

	}

	@Test(priority=1)
	public void verifyPageHeader() {
		String header = homepage.getHomePageHeader();
		Assert.assertEquals(header, "Thanks for choosing HubSpot");

	}

	@Test(priority=3)
	public void verifyLoggedUserTest() {
		String accountname = homepage.getLoggedAccountName();
		Assert.assertEquals(accountname, "hos");

	}

	

}
