package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import org.openqa.selenium.WebDriver;


public interface IScrapingControllerBuilder {

	public abstract ScrapingController build(WebDriver driver);

}