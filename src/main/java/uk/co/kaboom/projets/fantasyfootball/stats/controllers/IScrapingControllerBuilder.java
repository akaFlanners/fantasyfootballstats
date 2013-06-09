package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;


public interface IScrapingControllerBuilder {
	public IScrapingController getThreadedInstance(Team team);
}