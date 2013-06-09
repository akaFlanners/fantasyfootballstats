package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;

public class CollectionThreadSpawner {

	private static final Logger logger = LoggerFactory.getLogger(CollectionThreadSpawner.class);
	
	
	public void setupThreads(IScrapingControllerBuilder scb, int numOfThreads) {
		
		for(int i = 1; i<=numOfThreads; i++) {
			Team team = TeamQueueManager.INSTANCE.getNext();    // Will return null if none left in queue.
			
			if(team != null) {
				logger.info(i + ") Team to get scraper for: " + team.getTeamName() );
				
				//Build scraper for first team
				IScrapingController scraper = scb.getThreadedInstance(team);
				
				//Run start() scraper.
				Thread t = new Thread(scraper, "Thread " + scraper.getTeam());
				t.start();
			}
			else {
				logger.info("Null team returned");
			}
		}
	}
}
