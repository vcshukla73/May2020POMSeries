package qa.com.hubspot.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {

	Properties prop;
	ChromeOptions co;
	FirefoxOptions fo;

	public OptionManager(Properties prop) {
		this.prop = prop;

	}

	public ChromeOptions getChromeOption() {

		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			co.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			co.addArguments("--incognito");
		return co;

	}

	public FirefoxOptions getFireFoxOption() {

		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			fo.addArguments("--headless");
		return fo;

	}

}
