package uk.co.kaboom.projets.fantasyfootball.stats.ui;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;

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
		for (Team team : Team.values()) {
			viewSelectionMap.put(team.getDropdownSelection(), team.getTeamName());
		}
	}
	
	/**
	 * This list only contains those stats that are not present on every page (i.e. the column 10 stats).
	 * The other stats will all already be collected by the very first pass through.
	 * @see uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI#populateSortSelectionMap()
	 */
	@Override
	public void populateSortSelectionMap() {
		for (PlayerStat playerstat : PlayerStat.values()) {
			if(playerstat.isDropDownDelection()) {
				sortSelectionMap.put(playerstat.getStatName(), playerstat.getDropdownText());
			}
		}
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
	
	public WebDriver getDriver() {
		return driver;
	}
	
	 public void waitForFooterLogo() {
		 Thread.yield();
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
