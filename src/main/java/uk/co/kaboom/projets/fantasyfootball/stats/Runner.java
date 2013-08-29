package uk.co.kaboom.projets.fantasyfootball.stats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.controllers.CollectionThreadSpawner;

import uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingControllerBuilder;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.ScrapingControllerBuilder;

public final class Runner {

     private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

     private Runner() { };

     /**
      * @param args
      */
     public static void main(final String[] args) {
          LOG.debug("Starting application");

          final int numOfThreads = 8;

          if (System.getenv("FIREFOX_HOME") != null) {
             IScrapingControllerBuilder scb = new ScrapingControllerBuilder();
             CollectionThreadSpawner cts = new CollectionThreadSpawner();
             cts.setupThreads(scb, numOfThreads);
          }
          else {
               String message = "Please set system environment variable FIREFOX_HOME as path to firefox instance: e.g. C:/Browsers/firefox.exe";
               LOG.warn(message);
          }
     }
}
