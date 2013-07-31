package uk.co.kaboom.projets.fantasyfootball.stats.ui;

import java.util.EnumSet;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;

/**
 * Class to handle the selection of elements from a select dropdown.
 * @author FlannersAdmin
 */
public class SelectboxStatHandler {

     @SuppressWarnings("unused")
     private static final Logger LOG = LoggerFactory.getLogger(SelectboxStatHandler.class);

     EnumSet<PlayerStat> playerStats;
     String id;
     WebDriver driver;

     public SelectboxStatHandler(final EnumSet<PlayerStat> playerStats, final String id, final WebDriver driver) {
          this.playerStats = playerStats;
          this.id = id;
          this.driver = driver;
     }

     public boolean selectOption(final PlayerStat stat) {
         try {
          Select selectBox = new Select(driver.findElement(By.id(id)));
          selectBox.selectByVisibleText(stat.getDropdownText());
         }
         catch(NoSuchElementException e) {
             LOG.error("NoSuchElementException raised: " + stat.getDropdownText() + " " + e.getMessage() + " " + e.toString());
             return false;
         }
         return true;
     }

}
