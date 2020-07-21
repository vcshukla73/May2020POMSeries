package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.testlistners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



@Epic("Epic -101 :design login page feature")
@Feature("US - 201:desing login page title ,signup link and login modules")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {

	@Description("verify signup link on login test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void verifySignupLinkTest() {
		Assert.assertEquals(loginpage.isSignUpLinkExists(), true);
	}
    @Description("verify login page title")
    @Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void verifyLoginPageTitle() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("Page Title " + title);
		Assert.assertEquals(title, "HubSpot Login");

	}
    @Description("verify user able to login")
    @Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
