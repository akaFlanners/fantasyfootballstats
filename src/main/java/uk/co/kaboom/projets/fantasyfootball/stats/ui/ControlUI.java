package uk.co.kaboom.projets.fantasyfootball.stats.ui;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
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
          this.viewSelectbox = new SelectboxTeamHandler(viewSelectionMap, HTMLElement.VIEW_SELECTBOX.getName(), driver);
          this.sortSelectbox = new SelectboxStatHandler(playerStats, HTMLElement.SORT_SELECTBOX.getName(), driver);
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

     
     /**
      * Wait for an individual HTMLElement to be found
      * @param element
      */
     public void waitForHTMLElement(final HTMLElement element) {
         int timeToWait = 50;
         Thread.yield();
         (new WebDriverWait(driver, timeToWait)).until(new ExpectedCondition<Boolean>() {
              public Boolean apply(final WebDriver d) {
                  boolean isFound = driver.findElements(By.cssSelector(element.getSelector())).size() > 0;
                  LOG.debug("Returning from wait for: " + element.getName() + " with: " + isFound);
                  return isFound;
              }
          });
      }
      
     /**
      * Wait for a list of HTMLElements to be found
      * If an empty list is provided the following default list is called
      * waitForHtmlElements(HTMLElement.FOOTER, HTMLElement.SORT_SELECTBOX, HTMLElement.VIEW_SELECTBOX, HTMLElement.INPUT_SUBMIT);
      * @param elements
      */
      public void waitForHtmlElements(HTMLElement ... elements) {
          if(elements.length == 0) {
              waitForHtmlElements(HTMLElement.FOOTER, HTMLElement.SORT_SELECTBOX, HTMLElement.VIEW_SELECTBOX, HTMLElement.INPUT_SUBMIT);
          }
          else {
              for(HTMLElement element : elements) {
                  waitForHTMLElement(element);
              }
          }
      }

      /**
       * Wait for all elements to load on the page then select the view and stat dropdowns and click SHOW to update the data.
       */
      public void updateData(final String viewKey, final PlayerStat stat) {
           waitForHtmlElements();
           sortSelectbox.selectOption(stat);
           viewSelectbox.selectOption(viewKey);
           clickShow();
           waitForHTMLElement(HTMLElement.FOOTER);
      }
    
      
      /**
       * TODO: Remove the XPath expressions as it's now always incorrect due to a HTML change on the page. Just use the css selector.
       */
      public void clickShow() {
           try {
               driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/form/input")).click();
           }
           catch (Exception e) {
               LOG.warn("Exception thrown clicking Show Button - will attempt another method");
               LOG.warn(e.getMessage());
               try {
                   List<WebElement> showButtonList = driver.findElements(By.cssSelector(HTMLElement.INPUT_SUBMIT.getSelector()));
                   if(showButtonList != null && showButtonList.size() > 0) {
                       LOG.debug("Found: " + showButtonList.size() + " SHOW Buttons");
                       showButtonList.get(0).click();
                   }
               }
               catch (Exception e2) {
                   LOG.error("Exception thrown clicking Show Button using 2nd Method");
                   LOG.error(e.getMessage());
                   LOG.error("*** MAJOR ERROR GETTING SHOW BUTTON ***"); 
               }
           }
      }
}
