package uk.co.kaboom.projets.fantasyfootball.stats.ui;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxUtil {
	
	static File pathToBinary = new File(System.getenv("FIREFOX_HOME"));
	static FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	static FirefoxProfile firefoxProfile = new FirefoxProfile();
	
	public static FirefoxBinary getBinary() {
		return ffBinary;
	}
	
	public static FirefoxProfile getProfile() {
		return firefoxProfile;
	}

}
