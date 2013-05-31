package uk.co.kaboom.projets.fantasyfootball.stats.ui;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <code>ControlUI</code> class contains methods associated with form controls on the webpage being accessed.
 * It has various methods to select from dropdown boxes and click on buttons.
 * It is also responsible for keeping lists of the select dropdown contents.
 */
public class ControlUI implements IControllerUI {
	
	private static final Logger logger = LoggerFactory.getLogger(ControlUI.class);

	private WebDriver driver;
	private Map<String, String> viewSelectionMap;
	private Map<String, String> sortSelectionMap;
	private SelectboxHandler viewSelectbox;
	private SelectboxHandler sortSelectbox;

	public ControlUI(Map<String, String> viewSelectionMap, Map<String, String> sortSelectionMap, WebDriver driver) {
		this.viewSelectionMap = viewSelectionMap;
		this.sortSelectionMap = sortSelectionMap;
		this.viewSelectbox = new SelectboxHandler(viewSelectionMap, "id_element_filter", driver);
		this.sortSelectbox = new SelectboxHandler(sortSelectionMap, "id_stat_filter", driver);
		this.driver = driver;
	}
	
	/* (non-Javadoc)
	 * @see uk.co.kaboom.projets.fantasyfootball.stats.IControllerUI#populateViewSelectionMap()
	 */
	@Override
	public void populateViewSelectionMap() {
		viewSelectionMap.put("te_1"  ,"Arsenal"    );
		viewSelectionMap.put("te_2"  ,"Aston Villa");	
		viewSelectionMap.put("te_3"  ,"Chelsea"    );
		viewSelectionMap.put("te_4"  ,"Everton"    );
		viewSelectionMap.put("te_5"  ,"Fulham"     );
		viewSelectionMap.put("te_6"  ,"Liverpool"  );
		viewSelectionMap.put("te_7"  ,"Man City"   );
		viewSelectionMap.put("te_8"  ,"Man Utd"    );
		viewSelectionMap.put("te_9"  ,"Newcastle"  );
		viewSelectionMap.put("te_10" ,"Norwich"    );
		viewSelectionMap.put("te_11" ,"QPR"        );
		viewSelectionMap.put("te_12" ,"Reading"    );
		viewSelectionMap.put("te_13" ,"Southampton");
		viewSelectionMap.put("te_14" ,"Stoke City" );
		viewSelectionMap.put("te_15" ,"Sunderland" );
		viewSelectionMap.put("te_16" ,"Swansea"    );
		viewSelectionMap.put("te_17" ,"Tottenham"  );
		viewSelectionMap.put("te_18" ,"West Brom"  );
		viewSelectionMap.put("te_19" ,"West Ham"   );
		viewSelectionMap.put("te_20" ,"Wigan"      );
	}
	
	//These are facade methods. Could be used to protect implementation details. 
	public int viewSelectionOptionSize() {  //TODO: remove as not used
		return viewSelectionMap.size();
	}
	
	public int sortSelectionOptionSize() {  //TODO: remove as not used
		return sortSelectionMap.size();
	}
	
	/**
	 * This list only contains those stats that are not present on every page (i.e. the column 10 stats).
	 * The other stats will all already be collected by the very first pass through.
	 * @see uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI#populateSortSelectionMap()
	 */
	@Override
	public void populateSortSelectionMap() {
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
	
	@Override
	public Map<String, String> getViewSelectionMap() {
		 return viewSelectionMap;
	 }
	
	@Override
	public Map<String, String> getSortSelectionMap() {
		 return sortSelectionMap;
	 }
	
	public SelectboxHandler getViewSelectionHandler() {
		 return viewSelectbox;
	 }
	
	public SelectboxHandler getSortSelectionHandler() {
		 return sortSelectbox;
	 }

	 public void waitForFooterLogo() {
	     (new WebDriverWait(driver, 50)).until(new ExpectedCondition<Boolean>() {
	         public Boolean apply(WebDriver d) {
	             boolean isFooterLogoFound = driver.findElements(By.cssSelector("div.footerLogo")).size() > 0;
	             logger.debug("Returning from wait with: " + isFooterLogoFound);
	             return isFooterLogoFound;
	          }
	         });
	 } 
	 
	 public void updateData2(String viewKey, String sortKey) {
		 logger.debug("updateData2: " +viewKey + " " +sortKey);
		 waitForFooterLogo();//Due to first time in 
		 logger.debug("part2");
		 sortSelectbox.selectOption(sortKey);
		 viewSelectbox.selectOption(viewKey);
		 clickShow();
		 waitForFooterLogo();
	 }
	 
	 public void home() {
		 driver.get("http://fantasy.premierleague.com/stats/elements/");
	 }
	 
	 
	 public void clickShow() {
		 driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/form/input")).click();
	 }

}
