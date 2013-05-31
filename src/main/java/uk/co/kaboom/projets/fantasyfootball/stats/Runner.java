package uk.co.kaboom.projets.fantasyfootball.stats;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingController;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingControllerBuilder;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.ScrapingControllerBuilder;
import uk.co.kaboom.projets.fantasyfootball.stats.persistence.PersistenceManager;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.FirefoxUtil;


public class Runner {
	
	private static final Logger logger = LoggerFactory.getLogger(Runner.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
		// FIREFOX_HOME needs to be set.
    	
		logger.debug("Starting application");
		
		if (System.getenv("FIREFOX_HOME") != null) {

	    	WebDriver driver = new FirefoxDriver(FirefoxUtil.getBinary(), FirefoxUtil.getProfile());
	    	driver.get("http://fantasy.premierleague.com/stats/elements/");
	    	
	    	IScrapingControllerBuilder scb = new ScrapingControllerBuilder();
	    	IScrapingController scraper = scb.build(driver);
	        scraper.scrape();

	        PersistenceManager pm = new PersistenceManager("output/fantasyfootball.csv");
	        pm.persistToFile(scraper.getPageProcessor().getDataToPersist());

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
