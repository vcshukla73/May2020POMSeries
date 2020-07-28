package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import qa.com.hubspot.utils.ElementUtil;
import qa.com.hubspot.utils.OptionManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public ElementUtil elementutil;
	public OptionManager optionsmanager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(Properties prop) {

		String browsername = prop.getProperty("browser").trim();

		System.out.println("Browser Name " + browsername);

		optionsmanager = new OptionManager(prop);

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			if(Boolean.parseBoolean(prop.getProperty("remote"))) 
			{
				init_remoteWebDriver(browsername);
			}	
			else	
			{
				// driver=new ChromeDriver(optionsmanager.getChromeOption());
				tlDriver.set(new ChromeDriver(optionsmanager.getChromeOption()));	
			}

			
		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if(Boolean.parseBoolean(prop.getProperty("remote"))) 
			{
				init_remoteWebDriver(browsername);
			}	
			else	
			{
			// driver=new FirefoxDriver(optionsmanager.getFireFoxOption());
			tlDriver.set(new FirefoxDriver(optionsmanager.getFireFoxOption()));	
			}
			
			
			
			
			

		} else if (browsername.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			// driver=new SafariDriver();
			tlDriver.set(new SafariDriver());

		} else {

			System.out.println(browsername + " is not found please pass the correct browser");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}

	/*
	 * Run on remote machine - hub
	 * @Return
	 */
	public void init_remoteWebDriver(String browsername) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, optionsmanager.getChromeOption());
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}else if(browsername.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap=DesiredCapabilities.firefox();
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsmanager.getFireFoxOption());
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
		
		
	
	
	
	
	
	
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();

	}

	public Properties init_prop() {

		prop = new Properties();
		String path = null;
		String env = null;
		try {
			env = System.getProperty("env");
			if (env == null) {
				path = "C:\\Users\\vaibhav\\eclipse-workspace\\May2020POMSeries\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
			} else {
				switch (env) {
				case "qa":
					path = "C:\\Users\\vaibhav\\eclipse-workspace\\May2020POMSeries\\src\\main\\java\\com\\qa\\hubspot\\config\\qa.config.properties";
					break;
				case "dev":
					path = "C:\\Users\\vaibhav\\eclipse-workspace\\May2020POMSeries\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
					break;
				default:
					System.out.println("Please pass the corect value");
					break;

				}

			}
			FileInputStream io = new FileInputStream(path);
			prop.load(io);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	// take screenshot
	public String getScreenShot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}

}
