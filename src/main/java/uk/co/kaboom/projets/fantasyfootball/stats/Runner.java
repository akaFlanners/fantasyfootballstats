package uk.co.kaboom.projets.fantasyfootball.stats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.controllers.CollectionThreadSpawner;

import uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingControllerBuilder;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.ScrapingControllerBuilder;

public class Runner {
	
	private static final Logger logger = LoggerFactory.getLogger(Runner.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("Starting application");
		
		if (System.getenv("FIREFOX_HOME") != null) {
	    	IScrapingControllerBuilder scb = new ScrapingControllerBuilder();
	        CollectionThreadSpawner cts = new CollectionThreadSpawner();
	        cts.setupThreads(scb, 3);
		}
		else {
			String message = "Please set system environment variable FIREFOX_HOME as path to firefox instance: e.g. C:/Browsers/firefox.exe";
			logger.warn(message);
		}
	}
}
