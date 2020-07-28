package com.qa.hubspot.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public BasePage basepage;
	public LoginPage loginpage;
	public Properties prop;
	
	
	
	@org.testng.annotations.Parameters("browser")
	@BeforeTest
	public void setup(String browsername) {
		basepage= new BasePage();
		prop=basepage.init_prop();
		prop.setProperty("browser",browsername);
		driver=basepage.init_driver(prop);
		loginpage=new LoginPage(driver);
		
	}
	
	//@AfterMethod
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
