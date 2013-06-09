package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Player;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;
import uk.co.kaboom.projets.fantasyfootball.stats.persistence.PersistenceManager;
import uk.co.kaboom.projets.fantasyfootball.stats.processing.IPageProcessor;
import uk.co.kaboom.projets.fantasyfootball.stats.processing.PageProcessor;
import uk.co.kaboom.projets.fantasyfootball.stats.selenium.WedDriverFactory;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.ControlUI;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;


public class ScrapingControllerBuilder implements IScrapingControllerBuilder {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ScrapingControllerBuilder.class);
	
	static int instance = 0;
	
	private Map<String, String> viewSelectionMap = new HashMap<String, String>();
	private Map<String, String> sortSelectionMap = new HashMap<String, String>();
	private Map<String, Player> playerDataMap = new HashMap<String, Player>();
    private IPageProcessor pageProcessor;
	
	public synchronized IScrapingController getThreadedInstance(Team team) {
		WebDriver driver = WedDriverFactory.getDriver(WedDriverFactory.BROWSER.FIREFOX);
		driver.get("http://fantasy.premierleague.com/stats/elements/");
		
		IControllerUI controlUI = new ControlUI(viewSelectionMap, sortSelectionMap, driver);
		
		controlUI.populateViewSelectionMap();
		controlUI.populateSortSelectionMap();
		pageProcessor = new PageProcessor(playerDataMap, driver, controlUI);
		PersistenceManager pm = new PersistenceManager("output/fantasyfootball.csv");
		
		IScrapingController sc = new ScrapingController(controlUI, pageProcessor, team, pm);
		return sc;
	}
}
