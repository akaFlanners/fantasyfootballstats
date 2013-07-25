package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;

public class CollectionThreadSpawner {

     private static final Logger LOG = LoggerFactory.getLogger(CollectionThreadSpawner.class);

     public final void setupThreads(final IScrapingControllerBuilder builder, final int numOfThreads) {

          for(int i = 1; i <= numOfThreads; i++) {
               Team team = TeamQueueManager.INSTANCE.getNext();    // Will return null if none left in queue.

               if(team != null) {
                    LOG.info(i + ") Team to get scraper for: " + team.getTeamName() );

                    //Build scraper for first team
                    IScrapingController scraper = builder.getThreadedInstance(team);

                    //Run start() scraper.
                    Thread t = new Thread(scraper, "Thread " + scraper.getTeam());
                    t.start();
               }
               else {
                    LOG.info("Null team returned");
               }
          }
     }
}
