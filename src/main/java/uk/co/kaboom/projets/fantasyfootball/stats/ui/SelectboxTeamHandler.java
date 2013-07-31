package uk.co.kaboom.projets.fantasyfootball.stats.ui;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to handle the selection of elements from a select dropdown.
 * @author FlannersAdmin
 */
public class SelectboxTeamHandler {

     private static final Logger LOG = LoggerFactory.getLogger(SelectboxTeamHandler.class);

     Map<String, String> selectionMap;
     String id;
     WebDriver driver;

     public SelectboxTeamHandler(final Map<String, String> selectionMap, final String id, final WebDriver driver) {
          this.selectionMap = selectionMap;
          this.id = id;
          this.driver = driver;
     }

     public boolean selectOption(final String option) {
          Select selectBox = new Select(driver.findElement(By.id(id)));
          if(selectionMap.get(option) == null) {
               LOG.error("ERROR with: " + option);
               return false;
          }
          else {
               selectBox.selectByVisibleText(selectionMap.get(option));
               return true;
          }
     }

}
