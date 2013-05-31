package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import uk.co.kaboom.projets.fantasyfootball.stats.processing.IPageProcessor;

public interface IScrapingController {

	public void scrape();
	public IPageProcessor getPageProcessor();

}
