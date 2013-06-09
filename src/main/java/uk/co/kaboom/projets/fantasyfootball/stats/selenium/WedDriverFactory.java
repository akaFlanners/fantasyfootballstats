package uk.co.kaboom.projets.fantasyfootball.stats.selenium;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WedDriverFactory {
	public static enum BROWSER {FIREFOX, CHROME};
	
	public static synchronized WebDriver getDriver(BROWSER browser) {
		if(browser.equals(BROWSER.CHROME)) {
			return getChromeDriver();
		}
		else {
			return getFirefoxDriver();
		}
	}

	private static  WebDriver getFirefoxDriver() {
		FirefoxUtil ffUtil = new FirefoxUtil();
		WebDriver driver = new FirefoxDriver(ffUtil.getBinary(), ffUtil.getProfile());
		return driver;
	}
	
	private static  WebDriver getChromeDriver() {
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setCapability("chrome.switches", Arrays.asList("--silent"));
	    WebDriver driver = new ChromeDriver(capabilities);
		return driver;
	}
	
}
