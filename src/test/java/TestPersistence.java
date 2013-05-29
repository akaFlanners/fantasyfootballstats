import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats.ControlUI;
import uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats.FantasyFootballScraper;
import uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats.PersistenceManager;
import uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats.Player;


public class TestPersistence {
	
	private static final Logger logger = LoggerFactory.getLogger(TestPersistence.class);

	FantasyFootballScraper scraper;
	Player player;
	WebDriver driver;
    PersistenceManager pm;
    ControlUI controlUI;
	
	@Before
	public void setUp() throws Exception {
    	File pathToBinary = new File(System.getenv("FIREFOX_HOME"));
    	FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
    	FirefoxProfile firefoxProfile = new FirefoxProfile();
    	driver = new FirefoxDriver(ffBinary,firefoxProfile);
	
    	Map<String, Player> playerDataMap = new HashMap<String, Player>();
    	Map<String, String> viewSelectionMap = new HashMap<String, String>();
    	Map<String, String> sortSelectionMap = new HashMap<String, String>();
    	
    	playerDataMap.put("test1", PlayerDataGenerator.getPlayer());

    	this.pm = new PersistenceManager("output/fantasyfootball-testData.csv");
    	
		this.scraper = new FantasyFootballScraper(driver, playerDataMap, viewSelectionMap, sortSelectionMap, pm);
		
		this.controlUI = new ControlUI(viewSelectionMap, sortSelectionMap, driver);
		controlUI.populateSortSelectionMap();
		
	}
	
	@Test
	public void testPersistToFile() {
		String data = scraper.getDataToPersist();
		pm.persistToFile(data);
	}
	
	@Test
	public void testUpdateDataWithGoodData() {
		driver.get("http://fantasy.premierleague.com/stats/elements/");
		
		controlUI.waitForNextButton();
		controlUI.selectSortDropdown("cleanSheets");
		
		controlUI.waitForNextButton();
		controlUI.selectSortDropdown("bonus");
	}
	
	@Test
	public void testUpdateDataWithBadData() {
		driver.get("http://fantasy.premierleague.com/stats/elements/");
		
		controlUI.waitForNextButton();
		controlUI.updateData("baddata");
	}
	
	@After
	public void tearDown() {
        driver.close();
        driver.quit();
	}

}
