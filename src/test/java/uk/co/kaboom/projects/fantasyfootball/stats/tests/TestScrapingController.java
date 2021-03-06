package uk.co.kaboom.projects.fantasyfootball.stats.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projects.fantasyfootball.stats.tests.mocks.ScrapingControllerBuilderMock;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingController;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.TeamQueueManager;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;


public class TestScrapingController {

     private static final Logger logger = LoggerFactory.getLogger(TestScrapingController.class);

     IScrapingController controller;
     ScrapingControllerBuilderMock scb;

     /**
      * Create an appropriate ScrapingController from a Builder
      * @throws Exception
      */
     @Before
     public void setUp() throws Exception {
          scb = new ScrapingControllerBuilderMock(); //This ensures pageProcessorMock is used.
          Team team = TeamQueueManager.INSTANCE.getNext();    // Will return null if none left in queue.
          if(team != null) {
               this.controller = scb.getThreadedInstance(team);
          }
          else {
               fail("Team returned null");
          }
     }

     @Test
     public void test() {
          controller.scrape();
          logger.debug("sortsize * viewsize: " + scb.playerStats.size() + " * " + scb.viewSelectionMap.size() + " = " + scb.playerStats.size() * scb.viewSelectionMap.size() + " matching loops: " + scb.pageProcessor.getCount());
          assertEquals("Count of calls equal to the list counts multiplied", scb.playerStats.size() * scb.viewSelectionMap.size(), scb.pageProcessor.getCount());
     }

}
