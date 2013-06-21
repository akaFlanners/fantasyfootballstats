package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;

public interface IScrapingController extends Runnable {

	public void scrape();

	public void run();
	public Team getTeam();

}
