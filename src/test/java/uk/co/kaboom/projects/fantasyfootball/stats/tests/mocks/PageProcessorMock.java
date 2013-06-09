package uk.co.kaboom.projects.fantasyfootball.stats.tests.mocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.processing.IPageProcessor;

/**
 * The page processor is responsible for handling the processing on an individual page of objects 
 * @author FlannersAdmin
 *
 */
public class PageProcessorMock implements IPageProcessor {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(PageProcessorMock.class);
	
	//Just used for testing
	int count = 0;
	
	public void process(String viewKey, String sortKey) {
		count++;
	}
	
	public void process2(String viewKey, String sortKey) {
		count++;
	}
	
	//Just used for testing
	public int getCount() {
		return count;
	}
	
	public String getDataToPersist(){
		return "TESTING Persist";
	}
}
