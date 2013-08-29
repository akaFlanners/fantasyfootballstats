package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.config.URLConfig;
import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;
import uk.co.kaboom.projets.fantasyfootball.stats.persistence.PersistenceManager;
import uk.co.kaboom.projets.fantasyfootball.stats.processing.IPageProcessor;
import uk.co.kaboom.projets.fantasyfootball.stats.selenium.WebDriverFactory;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;

/**
 * A <code>ScrapingController</code> instance is built by a <code>ScrapingControllerBuilder</code>
 * It is responsible for the control flow of the scraping process.
 * It ensures that all the relevant pages are looped through correctly.
 * @author FlannersAdmin
 *
 */
public class ScrapingController implements IScrapingController, Runnable {

     private static final Logger LOG = LoggerFactory.getLogger(ScrapingController.class);
     private static final int MAX_FAILURES = 10;

     private IControllerUI controlUI;
     private IPageProcessor pageProcessor;
     private Team team = null;
     private PersistenceManager pm;
     private int failureAttempts = 0;

     public ScrapingController(final IControllerUI controlUI, final IPageProcessor pageProcessor, final Team team, final PersistenceManager pm) {
          LOG.debug("Creating Scraping Controller");
          this.controlUI = controlUI;
          this.pageProcessor = pageProcessor;
          this.team = team;
          this.pm = pm;
     }

     /**
      * The scrape method starts the scraping process
      */
     @Override
     public final void scrape() {
          LOG.debug("scrape() for team " + this.getTeam());
          if(failureAttempts <= MAX_FAILURES) {
              try {
                  iterate();
              }
              catch(Exception e) {
                  failureAttempts++;
                  LOG.warn(e.getMessage() + " " + e.getStackTrace());
                  System.out.println(e.getMessage() + " " + e.getStackTrace());
                  WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BROWSER.FIREFOX);
                  driver.get(URLConfig.MAIN_FPL_URL.getUrl());
                  scrape();
              }
              complete();
          }
          else {
              String msg = "Exceeded failure attempts with: " + team;
              System.out.println(msg);
              LOG.error(msg);
          }
     }

     public final void complete() {
          LOG.info("Completed: " + team.getTeamName());
          if (TeamQueueManager.INSTANCE.completed(team)) {
               LOG.info("All Complete: " + team.getTeamName());
               controlUI.getDriver().close(); //TODO: Implement try catch here to resolve issues with closing browsers on occasions.

               LOG.info("Writing Out data");
               pm.persistToFile(pageProcessor.getDataToPersist());
          }
          else {
               LOG.info("Not everything has completed");
               Team nextTeam = TeamQueueManager.INSTANCE.getNext();
               if (nextTeam != null) {
                    LOG.info(team.getTeamName() + " found Additional unprocessed team: " + nextTeam.getTeamName());
                    team = nextTeam;
                    scrape();
               }
               else {
                    LOG.info("No more teams to process - waiting for other threads to complete.");
                    controlUI.getDriver().close();
                    LOG.info("Closed Driver");
               }
          }
     }


     /**
      * Iterate over the list of dropdowns
      * Loop through each sort type for each of the views (teams).
      */
     private void iterate() {

          LOG.debug("iterate() for " + this.getTeam());
          int count = 0;
          for (PlayerStat stat : controlUI.getSortSelectionMap()) {
               count++;

               LOG.debug("Iterating, count (" + count + ") " + team + " : " + stat.getStatName());

               if (count==1) {
                    pageProcessor.process(team.getDropdownSelection(), stat);
               }
               else {
                    pageProcessor.process2(team.getDropdownSelection(), stat);
               }
          }

     }

     public final Team getTeam() {
          return team;
     }

     @Override
     public final void run() {
          LOG.debug("Run called on thread for: " + this.getTeam());
          scrape();
     }

}
