package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.processing.IPageProcessor;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;

/**
 * A <code>ScrapingController</code> instance is built by a <code>ScrapingControllerBuilder</code>
 * It is responsible for the control flow of the scraping process.
 * It ensures that all the relevant pages are looped through correctly.
 * @author FlannersAdmin
 *
 */
public class ScrapingController implements IScrapingController{
	
	private static final Logger logger = LoggerFactory.getLogger(ScrapingController.class);
	
    private IControllerUI controlUI;
	private IPageProcessor pageProcessor;

	public ScrapingController(IControllerUI controlUI, IPageProcessor pageProcessor) {
		logger.debug("Creating Scraping Controller");
		this.controlUI = controlUI;
		this.pageProcessor = pageProcessor;
	}
	
	/**
	 * The scrape method starts the scraping process
	 */
	@Override
	public void scrape() {
		logger.debug("scrape()");
		//controlUI.home();
		iterate();
	}
	
	/**
	 * Iterate over the list of dropdowns
	 * Loop through each sort type for each of the views (teams).
	 */
	private void iterate() {
		logger.debug("iterate()");
		int count = 0;
		
		for (Map.Entry<String, String> sortEntry : controlUI.getSortSelectionMap().entrySet()) {		
			count++;
			for (Map.Entry<String, String> viewEntry : controlUI.getViewSelectionMap().entrySet()) {
				logger.debug("Iterating, count ("+count+")" + viewEntry.getKey() + " : " + sortEntry.getKey());
				if(count <= 1) {
					pageProcessor.process(viewEntry.getKey(), sortEntry.getKey());
				}
				else {
					pageProcessor.process2(viewEntry.getKey(), sortEntry.getKey());
				}
			}
		}
	}
	
	public IPageProcessor getPageProcessor() {
		return pageProcessor;
	}

}
