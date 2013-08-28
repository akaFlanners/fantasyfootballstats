package uk.co.kaboom.projects.fantasyfootball.stats.tests.mocks;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.config.URLConfig;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingController;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingControllerBuilder;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.ScrapingController;
import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;
import uk.co.kaboom.projets.fantasyfootball.stats.persistence.PersistenceManager;
import uk.co.kaboom.projets.fantasyfootball.stats.selenium.WedDriverFactory;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.ControlUI;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;


/**
 * <code>ScrapingControllerBuilder</code> creates ScrapingController instances
 * @author FlannersAdmin
 *
 */
public class ScrapingControllerBuilderMock implements IScrapingControllerBuilder {

     @SuppressWarnings("unused")
     private static final Logger LOG = LoggerFactory.getLogger(ScrapingControllerBuilderMock.class);

     public PageProcessorMock pageProcessor = new PageProcessorMock();
     public EnumSet<PlayerStat> playerStats = EnumSet.allOf(PlayerStat.class);
     public Map<String, String> viewSelectionMap = new HashMap<String, String>();

     public synchronized IScrapingController getThreadedInstance(Team team) {
          WebDriver driver = WedDriverFactory.getDriver(WedDriverFactory.BROWSER.FIREFOX);
          driver.get(URLConfig.MAIN_FPL_URL.getUrl());

          IControllerUI controlUI = new ControlUI(viewSelectionMap, playerStats, driver);

          controlUI.populateViewSelectionMap();
          controlUI.populateSortSelectionMap();
          pageProcessor = new PageProcessorMock();
          PersistenceManager pm = new PersistenceManager("output/fantasyfootball-test-ScrapingControllerMock.csv");

          IScrapingController sc = new ScrapingController(controlUI, pageProcessor, team, pm);
          return sc;
     }

}
