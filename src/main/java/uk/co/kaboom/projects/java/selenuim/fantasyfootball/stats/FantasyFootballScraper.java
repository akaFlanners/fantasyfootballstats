package uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats.exceptions.PlayerStatNotFoundException;

public class FantasyFootballScraper {
	
	private static final Logger logger = LoggerFactory.getLogger(FantasyFootballScraper.class);
	
	private WebDriver driver;
	private Map<String, Player> playerDataMap;
	private Map<String, String> viewSelectionMap;
	private Map<String, String> sortSelectionMap;
	private PersistenceManager pm;
	private boolean isInitialDataCaptured = false;
	private ControlUI controlUI;
	
	public FantasyFootballScraper(WebDriver driver, Map<String, Player> playerDataMap, Map<String, String> viewSelectionMap, Map<String, String> sortSelectionMap, PersistenceManager pm) {
		this.driver = driver;
		this.playerDataMap = playerDataMap;
		this.viewSelectionMap = viewSelectionMap;
		this.sortSelectionMap = sortSelectionMap;
		this.pm = pm;
		this.controlUI = new ControlUI(viewSelectionMap, sortSelectionMap, driver);
		controlUI.populateSortSelectionMap();  //This could be injected, but not necessary for current tests.
	}
	
	public void scrape() {
        driver.get("http://fantasy.premierleague.com/stats/elements/");
        // Could call waitForNextButton() here.
        
        logger.debug("Calling processNext(roundScore) from scrape()");
        controlUI.updateData("totalScore");
        processNext("totalScore");
        
        logger.debug("Iterate over selection map");
        iterateOverSelectionMap();
        
        logger.debug("Scrape() calling Persist Data");
        pm.persistToFile(getDataToPersist());
	}
	
	public void iterateOverSelectionMap() {
		for (Map.Entry<String, String> entry : sortSelectionMap.entrySet()) {
			    String key = entry.getKey();
			    
			    logger.debug("Calling processNext(" + key + ") from iterateOverSelectionMap()");
			    controlUI.updateData(key);
			    processNext(key);
		}
	}
	

	public void processNext(String statId) {
		
		logger.debug("processNext(" + statId + ")");
		
		controlUI.waitForNextButton();
		if(!isInitialDataCaptured) {
			captureInitialData();
		}
		else {
			updatePlayerData(statId);
		}
		
        List<WebElement> buttons = driver.findElements(By.cssSelector("span.ui-button-text"));

        //Rely on the fact that the "next" button is always last of 1 or 2 selected buttons.
        if(buttons.size() == 1) {
            pressNext(buttons.get(0), statId);
        } 
        else if (buttons.size() == 2) {
        	pressNext(buttons.get(1), statId);
        }
	}
	
	public void updatePlayerData(String statId) {
		
		logger.info("Updating on stat: " + statId);
		
		PlayerManager pm = new PlayerManager();
		int numOfRows = driver.findElements(By.xpath("//*[@id='ism']/section[1]/table/tbody/tr")).size();
		
		for(int i=1; i<=numOfRows; i++) {

			Player p              = pm.generateScrapedPlayer(driver, i);
			Player existingPlayer = playerDataMap.get(p.getPlayerIndex()); //Lookup player by index
			
			try {
				pm.updatePlayer(p, driver, i, existingPlayer, statId);
			}
			catch (PlayerStatNotFoundException e) {
				logger.warn(e.getMessage());
				e.printStackTrace();
			}
			catch(NoSuchElementException e) {
				logger.warn("NoSuchElementException on: " + statId);
			}
		}
	}
	

	
	//NOTE: we never specifically check for null keys or duplicate keys.
	public void captureInitialData() {
		
		PlayerManager pm = new PlayerManager();
		
		int numOfRows = driver.findElements(By.xpath("//*[@id='ism']/section[1]/table/tbody/tr")).size();
		
		for(int i=1; i<=numOfRows; i++) {
			
			Player p = pm.generateScrapedPlayer(driver, i);
			playerDataMap.put(p.getPlayerIndex(), p);
			
		}
	}
	
	public String getDataToPersist() {
		StringBuilder sb = new StringBuilder();
		sb.append(Player.getHeaders());
		
		for (Map.Entry<String, Player> entry : playerDataMap.entrySet()) {
		 //   String key = entry.getKey();
		    Player player = entry.getValue();
		    sb.append(player.getData());
		}
		
		return sb.toString();
	}
	
	public void pressNext(WebElement we, String statId) {
       	if("NEXT".equals(we.getText())) {
       		we.click();
       		processNext(statId);
       	} 
       	else {
       		logger.debug("Next Button not found on page");
        	isInitialDataCaptured = true;
       		//updateData(statId);
       	}
	}
	

	
}
