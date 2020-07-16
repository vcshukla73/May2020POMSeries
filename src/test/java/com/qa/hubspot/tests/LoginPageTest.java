package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void verifySignupLinkTest() {
		Assert.assertEquals(loginpage.isSignUpLinkExists(), true);
	}

	@Test(priority = 2)
	public void verifyLoginPageTitle() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("Page Title " + title);
		Assert.assertEquals(title, "HubSpot Login");

	}

	@Test(priority = 3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
