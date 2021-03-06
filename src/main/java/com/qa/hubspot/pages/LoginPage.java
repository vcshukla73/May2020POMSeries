package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

import io.qameta.allure.Step;
import qa.com.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {

	private WebDriver driver;
	ElementUtil elementutil;

	

	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	public LoginPage(WebDriver driver) {
		 
		
		this.driver = driver;
		elementutil=new ElementUtil(driver);
	}

	// page action
	@Step("Getting Login Page Title")
	public String getLoginPageTitle() {

		return driver.getTitle();
	}
	@Step("Getting SignUp Link presence")
	public boolean isSignUpLinkExists() {

		return driver.findElement(signUpLink).isDisplayed();
		//return elementutil.isElementDisplayed(signUpLink, 10);
		

	}
	@Step("Login with User Name :{0} and PassWord: {1}")
	public HomePage doLogin(String username, String pwd) {
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new HomePage(driver);	
		
		
	}

}
