package uk.co.kaboom.projets.fantasyfootball.stats.ui;

import java.util.EnumSet;
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

     private static final Logger LOG = LoggerFactory.getLogger(ControlUI.class);

     private WebDriver driver;
     private Map<String, String> viewSelectionMap;
     private EnumSet<PlayerStat> playerStats;
     private SelectboxTeamHandler viewSelectbox;
     private SelectboxStatHandler sortSelectbox;

     public ControlUI(
                      final Map<String, String> viewSelectionMap, 
                      final EnumSet<PlayerStat> sortSelectionMap, 
    		          final WebDriver driver
     ){
          this.viewSelectionMap = viewSelectionMap;
          this.playerStats = sortSelectionMap;
          this.viewSelectbox = new SelectboxTeamHandler(viewSelectionMap, "id_element_filter", driver);
          this.sortSelectbox = new SelectboxStatHandler(playerStats, "id_stat_filter", driver);
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
          for (PlayerStat playerStat : PlayerStat.values()) {
               if(!playerStat.isDropDownDelection()) {
                    playerStats.remove(playerStat);
               }
          }
      }

     @Override
     public Map<String, String> getViewSelectionMap() {
           return viewSelectionMap;
      }

     @Override
     public EnumSet<PlayerStat> getSortSelectionMap() {
           return playerStats;
      }

     public SelectboxTeamHandler getViewSelectionHandler() {
           return viewSelectbox;
      }

     public SelectboxStatHandler getSortSelectionHandler() {
           return sortSelectbox;
      }

     public WebDriver getDriver() {
          return driver;
     }

     public void waitForFooterLogo() {
         int timeToWait = 50;
         Thread.yield();
         (new WebDriverWait(driver, timeToWait)).until(new ExpectedCondition<Boolean>() {
              public Boolean apply(final WebDriver d) {
                  boolean isFooterLogoFound = driver.findElements(By.cssSelector("div.footerLogo")).size() > 0;
                  LOG.debug("Returning from wait with: " + isFooterLogoFound);
                  return isFooterLogoFound;
              }
          });
      }

      public void updateData2(final String viewKey, final PlayerStat stat) {
           LOG.debug("updateData2: " + viewKey + " " + stat.getStatName());
           waitForFooterLogo(); //Due to first time in.
           LOG.debug("part2");
           sortSelectbox.selectOption(stat);
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
