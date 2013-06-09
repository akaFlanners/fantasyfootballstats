package uk.co.kaboom.projets.fantasyfootball.stats.selenium;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxUtil {
	
	File pathToBinary = new File(System.getenv("FIREFOX_HOME"));
	FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	FirefoxProfile firefoxProfile = new FirefoxProfile();
	
	public  FirefoxBinary getBinary() {
		return ffBinary;
	}
	
	public  FirefoxProfile getProfile() {
		return firefoxProfile;
	}

}
