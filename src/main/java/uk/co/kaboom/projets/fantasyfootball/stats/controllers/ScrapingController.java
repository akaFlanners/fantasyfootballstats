package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;
import uk.co.kaboom.projets.fantasyfootball.stats.persistence.PersistenceManager;
import uk.co.kaboom.projets.fantasyfootball.stats.processing.IPageProcessor;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;

/**
 * A <code>ScrapingController</code> instance is built by a <code>ScrapingControllerBuilder</code>
 * It is responsible for the control flow of the scraping process.
 * It ensures that all the relevant pages are looped through correctly.
 * @author FlannersAdmin
 *
 */
public class ScrapingController implements IScrapingController, Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(ScrapingController.class);
	
    private IControllerUI controlUI;
	private IPageProcessor pageProcessor;
	private Team team = null;
	private PersistenceManager pm;

	public ScrapingController(IControllerUI controlUI, IPageProcessor pageProcessor, Team team, PersistenceManager pm) {
		logger.debug("Creating Scraping Controller");
		this.controlUI = controlUI;
		this.pageProcessor = pageProcessor;
		this.team = team;
		this.pm = pm;
	}
	
	/**
	 * The scrape method starts the scraping process
	 */
	@Override
	public void scrape() {
		logger.debug("scrape() for team " + this.getTeam());
		iterate();
		complete();
	}
	
	public void complete() {
		logger.info("Completed: " + team.getTeamName());
		if (TeamQueueManager.INSTANCE.completed(team)) {
			logger.info("All Complete: " + team.getTeamName());
			controlUI.getDriver().close();
			
			logger.info("Writing Out data");
			pm.persistToFile(pageProcessor.getDataToPersist());
		}
		else {
			logger.info("Not everything has completed");
			Team nextTeam = TeamQueueManager.INSTANCE.getNext();
			if (nextTeam != null) {
				logger.info(team.getTeamName() + " found Additional unprocessed team: " + nextTeam.getTeamName());
				team = nextTeam;
				scrape();
			}
			else {
				logger.info("No more teams to process - waiting for other threads to complete.");
				controlUI.getDriver().close();
				logger.info("Closed Driver");
			}
		}
	}
	
	
	/**
	 * Iterate over the list of dropdowns
	 * Loop through each sort type for each of the views (teams).
	 */
	private void iterate() {
		
		logger.debug("iterate() for " + this.getTeam());
		int count = 0;
		for (Map.Entry<String, String> sortEntry : controlUI.getSortSelectionMap().entrySet()) {
			count++;
			
			logger.debug("Iterating, count ("+count+") " + team + " : " + sortEntry.getKey());
			
			if(count==1) {
				pageProcessor.process(team.getDropdownSelection(), sortEntry.getKey());
			}
			else {
				pageProcessor.process2(team.getDropdownSelection(), sortEntry.getKey());
			}
		}
		
	}
	
	public Team getTeam() {
		return team;
	}

	@Override
	public void run() {
		logger.debug("Run called on thread for: " + this.getTeam());
		scrape();
	}
	
}
