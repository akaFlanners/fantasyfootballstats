package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.config.URLConfig;
import uk.co.kaboom.projets.fantasyfootball.stats.model.IPlayerManager;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Player;
import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerManager;
import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;
import uk.co.kaboom.projets.fantasyfootball.stats.persistence.PersistenceManager;
import uk.co.kaboom.projets.fantasyfootball.stats.processing.IPageProcessor;
import uk.co.kaboom.projets.fantasyfootball.stats.processing.PageProcessor;
import uk.co.kaboom.projets.fantasyfootball.stats.processing.PageProcessorJSoup;
import uk.co.kaboom.projets.fantasyfootball.stats.selenium.WebDriverFactory;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.ControlUI;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;


/**
 * TODO: Refactor into a Builder - avoid the mock of this (or use a proper mocking library).
 * Re-examine to see if we need to expose the variables - or see if they can be examined via reflection in the tests used by ScrapingControllerBuilderMock
 */
public class ScrapingControllerBuilder implements IScrapingControllerBuilder {

     @SuppressWarnings("unused")
     private static final Logger LOG = LoggerFactory.getLogger(ScrapingControllerBuilder.class);
     
     private Map<String, String> viewSelectionMap = new HashMap<String, String>();
     private EnumSet<PlayerStat> playerStats = EnumSet.allOf(PlayerStat.class);
     private Map<String, Player> playerDataMap = new HashMap<String, Player>();
     private IPageProcessor pageProcessor;

     public final synchronized IScrapingController getThreadedInstance(final Team team) {
          WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BROWSER.FIREFOX);
          driver.get(URLConfig.MAIN_FPL_URL.getUrl());

          IControllerUI controlUI = new ControlUI(viewSelectionMap, playerStats, driver);

          controlUI.populateViewSelectionMap();
          controlUI.populateSortSelectionMap();
          
          IPlayerManager playerManager = new PlayerManager();
          pageProcessor = new PageProcessorJSoup(playerDataMap, driver, controlUI, playerManager);
          
          PersistenceManager pm = new PersistenceManager("output/fantasyfootball.csv");

          IScrapingController sc = new ScrapingController(controlUI, pageProcessor, team, pm);
          return sc;
     }
}
