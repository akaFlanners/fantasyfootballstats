package uk.co.kaboom.projects.fantasyfootball.stats.tests;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Player;
import uk.co.kaboom.projets.fantasyfootball.stats.persistence.PersistenceManager;
import uk.co.kaboom.projets.fantasyfootball.stats.processing.PageProcessor;
import uk.co.kaboom.projets.fantasyfootball.stats.selenium.WedDriverFactory;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.ControlUI;

public class TestPersistence {
	
	private static final Logger logger = LoggerFactory.getLogger(TestPersistence.class);

	Player player;
	WebDriver driver;
    PersistenceManager pm;
    ControlUI controlUI;
    Map<String, Player> playerDataMap;
	
	@Before
	public void setUp() throws Exception {
		driver = WedDriverFactory.getDriver(WedDriverFactory.BROWSER.CHROME);

    	playerDataMap = new HashMap<String, Player>();
    	Map<String, String> viewSelectionMap = new HashMap<String, String>();
    	Map<String, String> sortSelectionMap = new HashMap<String, String>();
    	
    	playerDataMap.put("test1", PlayerDataGenerator.getPlayer());

    	this.pm = new PersistenceManager("output/fantasyfootball-testData.csv");
    		
		this.controlUI = new ControlUI(viewSelectionMap, sortSelectionMap, driver);
		controlUI.populateSortSelectionMap();
	}
	
	/**
	 * Writes to a file and ensures no exceptions
	 * TODO: Consider setting up a watcher to detect changes to the log file?
	 */
	@Test
	public void testPersistToFile() {
		PageProcessor pp = new PageProcessor(playerDataMap, null, null);
		String data = pp.getDataToPersist();
		logger.debug("Data:" + data);
		pm.persistToFile(data);
	}
	
	
	/**
	 * Selects a dropdown 3 times.
	 * Confirms that the correct dropdown is selected.
	 */
	@Test
	public void testUpdateDataWithGoodData() {
		driver.get("http://fantasy.premierleague.com/stats/elements/");
		By locator = By.id("id_stat_filter");
		
		String expectedText;
		Select select;
		String actualText;
		
		controlUI.waitForFooterLogo();
		controlUI.getSortSelectionHandler().selectOption("cleanSheets");
		

		expectedText = "Clean sheets";
		select = new Select(driver.findElement(locator));
		actualText = select.getFirstSelectedOption().getText();
		
		assertEquals("Expected Clean sheets: ", expectedText, actualText);
		
		controlUI.waitForFooterLogo();
		controlUI.getSortSelectionHandler().selectOption("bonus");
		
		expectedText = "Bonus";
		select = new Select(driver.findElement(locator));
		actualText = select.getFirstSelectedOption().getText();
		
		assertEquals("Expected Bonus: ", expectedText, actualText);
		
		
		controlUI.waitForFooterLogo();
		controlUI.getSortSelectionHandler().selectOption("eaSportsPPI");
		
		expectedText = "EA SPORTS PPI";
		select = new Select(driver.findElement(locator));
		actualText = select.getFirstSelectedOption().getText();
		
		assertEquals("Expected EA SPORTS PPI: ", expectedText, actualText);
	}
	
	
	/**
	 * Selects a valid dropdown then an invalid one.
	 * Confirms that the original dropdown is still selected.
	 */
	@Test
	public void testUpdateDataWithBadData() {
		driver.get("http://fantasy.premierleague.com/stats/elements/");
		
		By locator = By.id("id_stat_filter");
		
		String expectedText;
		Select select;
		String actualText;
		
		controlUI.waitForFooterLogo();
		controlUI.getSortSelectionHandler().selectOption("eaSportsPPI");
		
		expectedText = "EA SPORTS PPI";
		select = new Select(driver.findElement(locator));
		actualText = select.getFirstSelectedOption().getText();
		
		assertEquals("Expected EA SPORTS PPI: ", expectedText, actualText);
		
		controlUI.waitForFooterLogo();
		controlUI.getSortSelectionHandler().selectOption("baddata"); //Attempt to select value that does not exist.
		
		//Dropdown should remain as it was.
		expectedText = "EA SPORTS PPI";
		select = new Select(driver.findElement(locator));
		actualText = select.getFirstSelectedOption().getText();
		
		assertEquals("Expected EA SPORTS PPI: ", expectedText, actualText);
	}
	
	@After
	public void tearDown() {
		if(driver != null) {
			driver.close();
		}
	}

}
