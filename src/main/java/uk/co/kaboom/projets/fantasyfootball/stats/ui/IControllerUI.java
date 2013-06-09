package uk.co.kaboom.projets.fantasyfootball.stats.ui;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public interface IControllerUI {

	/**
	 * Puts a selection of the hardcoded view options from the webpage into a map.
	 * The specific selection is all the teams. The other options are omited.
	 * This is required as the pagination without making a view selection has a random element.
	 * The random element can lead to player data not being available.
	 * e.g. a player could appear on adjacent page if sorted by some options and has team mates with same value.
	 * Conversely their team mate may randomly not show on either page. 
	 */
	public abstract void populateViewSelectionMap();

	/**
	 * Puts a selection of the hardcoded sorting options from webpage into a map.
	 */
	public abstract void populateSortSelectionMap();

	public abstract Map<String, String> getViewSelectionMap();
	
	public abstract Map<String, String> getSortSelectionMap();
	
	public void updateData2(String viewKey, String sortKey);
	
	public void home();
	
	public WebDriver getDriver();

}