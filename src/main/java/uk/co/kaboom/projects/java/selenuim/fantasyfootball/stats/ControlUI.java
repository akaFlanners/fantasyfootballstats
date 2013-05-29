package uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The <code>ControlUI</code> class contains methods associated with form controls on the webpage being accessed.
 * It has various methods to select from dropdown boxes and click on buttons.
 * It is also responsible for keeping lists of the select dropdown contents.
 */
public class ControlUI {
	
	private static final Logger logger = LoggerFactory.getLogger(ControlUI.class);

	private Map<String, String> viewSelectionMap;
	private Map<String, String> sortSelectionMap;
	private WebDriver driver;
	
	public ControlUI(Map<String, String> viewSelectionMap, Map<String, String> sortSelectionMap, WebDriver driver) {
		this.viewSelectionMap = viewSelectionMap;
		this.sortSelectionMap = sortSelectionMap;
		this.driver = driver;
	}
	
	public void populateSortSelectionMap() {
		sortSelectionMap.put("totalScore", "Total score");//present
//		selectionMap.put("roundScore", "Round score");//present
//		selectionMap.put("price", "Price");//present
//		selectionMap.put("teamsSelectedBy", "Teams selected by %");//present
		sortSelectionMap.put("minutesPlayed", "Minutes played");
		sortSelectionMap.put("goalsScored", "Goals scored");
		sortSelectionMap.put("assists", "Assists");
		sortSelectionMap.put("cleanSheets", "Clean sheets");
		sortSelectionMap.put("goalsConceded", "Goals conceded");
		sortSelectionMap.put("ownGoals", "Own goals");
		sortSelectionMap.put("penaltiesSaved", "Penalties saved");
		sortSelectionMap.put("penaltiesMissed", "Penalties missed");
		sortSelectionMap.put("yellowCards", "Yellow cards");
		sortSelectionMap.put("redCards", "Red cards");
		sortSelectionMap.put("saves", "Saves");
		sortSelectionMap.put("bonus", "Bonus");
		sortSelectionMap.put("eaSportsPPI", "EA SPORTS PPI");
		sortSelectionMap.put("form", "Form");
		sortSelectionMap.put("timesInDreamTeam", "Times in Dream Team");
		sortSelectionMap.put("valueForm", "Value (form)");
		sortSelectionMap.put("valueSeason", "Value (season)");
		sortSelectionMap.put("pointsPerGame", "Points per game");
		sortSelectionMap.put("transfersIn", "Transfers in");
		sortSelectionMap.put("transfersOut", "Transfers out");
		sortSelectionMap.put("transfersInRound", "Transfers in (round)");
		sortSelectionMap.put("transfersOutRound", "Transfers out (round)");
		sortSelectionMap.put("priceRise", "Price rise");
		sortSelectionMap.put("priceFall", "Price fall");
		sortSelectionMap.put("priceRiseRound", "Price rise (round)");
		sortSelectionMap.put("priceFallRound", "Price fall (round)");
	 }
	
	 public Map<String, String> getViewSelectionMap() {
		 return sortSelectionMap;
	 }
	
	 
	public void waitForNextButton() {
	     (new WebDriverWait(driver, 50)).until(new ExpectedCondition<Boolean>() {
	         public Boolean apply(WebDriver d) {
	             boolean isNextFound = driver.findElements(By.cssSelector("span.ui-button-text")).size() > 0;
	             logger.trace("Returning from waitForNextButton with: " + isNextFound);
	             return isNextFound;
	          }
	         });
	} 
	 
	 
	/**
	 * Must be done after all data captured for a given dropdown.
	 * As soon as you adjust dropdown and click show, page resets to page 1
	 */
	public void updateData(String statId) {
		selectSortDropdown(statId);
		clickShow();
	}
	
	public void selectSortDropdown(String statId) {
		
		logger.debug("SELECTING: "+ statId);
		
		Select selectBox = new Select(driver.findElement(By.id("id_stat_filter")));
		if(sortSelectionMap.get(statId) == null ) {
			logger.error("ERROR with: " + statId);
		}
		else {
			logger.debug("Calling wait then select using StatID:" +statId);
			selectBox.selectByVisibleText(sortSelectionMap.get(statId));
		}
	}
	
	public void clickShow() {
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/form/input")).click();
	}
}
