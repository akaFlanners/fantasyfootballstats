package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;
import uk.co.kaboom.projets.fantasyfootball.stats.processing.IPageProcessor;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;

public interface IScrapingController extends Runnable {

	public void scrape();
	
	//TODO:REMOVE
	public IPageProcessor getPageProcessor();
	//TODO:REMOVE
	public IControllerUI getControllerUI();
	
	public void run();
	public Team getTeam();

}
