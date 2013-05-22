/**
 * 
 */
package uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * 
 * @author FlannersAdmin
 *
 */
public class MainRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	
		if (args.length==1) {
	    	File pathToBinary = new File(args[0]);
	    	FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	    	FirefoxProfile firefoxProfile = new FirefoxProfile();
	    	WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
	    	
	    	FantasyFootballScraper scraper = new FantasyFootballScraper(driver);
	        scraper.scrape();
	        
	        //Close the browser
	        driver.close();
	        driver.quit();
		}
		else {
			System.out.println("Please pass in the path to your firefox instance: e.g. C:/Browsers/firefox.exe");
		}
	}
}
