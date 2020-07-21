package com.qa.hubspot.tests;

import org.testng.Assert;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.HomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Epic("Epic -101 :design home page feature")
@Feature("US - 201:desing home page title ,header and account name modules")
public class HomePageTest extends BaseTest {
	
	HomePage homepage;
	@BeforeClass
	public void homePageSetup() {
		homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	@Description("verify Home Page Title Test on home page")
	@Severity(SeverityLevel.NORMAL)

	@Test(priority=2)
	public void verifyHomePageTitleTest() {
		String title = homepage.getHomePageTitle();
		Assert.assertEquals(title, "Account Setup | HubSpot");

	}
	@Description("verify Home Page Header on home page")
	@Severity(SeverityLevel.MINOR)

	@Test(priority=1)
	public void verifyPageHeader() {
		String header = homepage.getHomePageHeader();
		Assert.assertEquals(header, "Thanks for choosing HubSpot");

	}
	@Description("verify Login in User Home Page ")
	@Severity(SeverityLevel.BLOCKER)

	@Test(priority=3)
	public void verifyLoggedUserTest() {
		String accountname = homepage.getLoggedAccountName();
		Assert.assertEquals(accountname, "hos");

	}

	

}
