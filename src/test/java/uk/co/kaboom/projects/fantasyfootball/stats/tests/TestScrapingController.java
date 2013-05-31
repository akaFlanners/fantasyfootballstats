package uk.co.kaboom.projects.fantasyfootball.stats.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projects.fantasyfootball.stats.tests.mocks.ScrapingControllerBuilderMock;
import uk.co.kaboom.projets.fantasyfootball.stats.controllers.IScrapingController;


public class TestScrapingController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestScrapingController.class);
	
	IScrapingController controller;
	ScrapingControllerBuilderMock scb;
	
	/**
	 * Create an appropriate ScrapingController from a Builder
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		scb = new ScrapingControllerBuilderMock();
		this.controller = scb.build(null);
	}

	@Test
	public void test() {
		controller.scrape();
		logger.debug("sortsize * viewsize: " + scb.sortSelectionMap.size() + " * " + scb.viewSelectionMap.size() + " = " + scb.sortSelectionMap.size() * scb.viewSelectionMap.size() + " matching loops: " + scb.pageProcessor.getCount());
		assertEquals("Count of calls equal to the list counts multiplied", scb.pageProcessor.getCount(), scb.sortSelectionMap.size() * scb.viewSelectionMap.size());
	}

}
