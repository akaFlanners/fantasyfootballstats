/**
 * 
 */
package uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <code>MainRunner</code> is a wrapper to initialise variables for screen scraping.
 * This contains the main method to run the application.
 * Note that FIREFOX_HOME needs to be set as a system environment variable.
 * 
 * @author FlannersAdmin
 *
 */
public class MainRunner {

	private static final Logger logger = LoggerFactory.getLogger(MainRunner.class);
	
	/**
	 * Main Method to populate the <code>FantasyFootBallScraper<code> constructor with dependencies.
	 * It calls <code>scrape()</code> on the <code>FantasyFootballScraper</code> object instance.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
		// FIREFOX_HOME needs to be set.
    	
		logger.debug("Starting application");
		
		if (System.getenv("FIREFOX_HOME") != null) {
	    	File pathToBinary = new File(System.getenv("FIREFOX_HOME"));
	    	FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	    	FirefoxProfile firefoxProfile = new FirefoxProfile();
	    	WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
	    	
	    	Map<String, Player> playerDataMap = new HashMap<String, Player>();
	    	Map<String, String> sortSelectionMap = new HashMap<String, String>();
	    	Map<String, String> viewSelectionMap = new HashMap<String, String>();
	    	
	        PersistenceManager pm = new PersistenceManager("output/fantasyfootball.csv");
	        
	    	FantasyFootballScraper scraper = new FantasyFootballScraper(driver, playerDataMap, viewSelectionMap, sortSelectionMap, pm);
	        scraper.scrape();
	        
	        //Close the browser
	        driver.close();
	        driver.quit();
		}
		else {
			String message = "Please set system environment variable FIREFOX_HOME as path to firefox instance: e.g. C:/Browsers/firefox.exe";
			logger.warn(message);
		}
	}
}
