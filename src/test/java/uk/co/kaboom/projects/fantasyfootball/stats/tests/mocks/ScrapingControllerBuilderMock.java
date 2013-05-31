package uk.co.kaboom.projects.fantasyfootball.stats.tests.mocks;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingControllerBuilder;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.ScrapingController;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.ControlUI;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;


/**
 * <code>ScrapingControllerBuilder</code> creates ScrapingController instances
 * @author FlannersAdmin
 *
 */
public class ScrapingControllerBuilderMock implements IScrapingControllerBuilder {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ScrapingControllerBuilderMock.class);
	
	public PageProcessorMock pageProcessor = new PageProcessorMock();
	public Map<String, String> sortSelectionMap = new HashMap<String, String>();
	public Map<String, String> viewSelectionMap = new HashMap<String, String>();
	
	/**
	 * @see uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingControllerBuilder#build()
	 */
	@Override
	public ScrapingController build(WebDriver driver) {
		IControllerUI controlUI = new ControlUI(viewSelectionMap, sortSelectionMap, driver);
		controlUI.populateViewSelectionMap();
		controlUI.populateSortSelectionMap();
		return new ScrapingController(controlUI, pageProcessor);
	}

}
