package uk.co.kaboom.projets.fantasyfootball.stats.ui;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to handle the selection of elements from a select dropdown.
 * @author FlannersAdmin
 */
public class SelectboxHandler {

	private static final Logger logger = LoggerFactory.getLogger(SelectboxHandler.class);
	
	Map<String, String> selectionMap;
	String id;
	WebDriver driver;
	
	public SelectboxHandler(Map<String, String> selectionMap, String id, WebDriver driver) {
		this.selectionMap = selectionMap;
		this.id = id;
		this.driver = driver;
	}
	
	public boolean selectOption(String option) {
		Select selectBox = new Select(driver.findElement(By.id(id)));
		if(selectionMap.get(option) == null) {
			logger.error("ERROR with: " + option);
			return false;
		}
		else {
			selectBox.selectByVisibleText(selectionMap.get(option));
			return true;
		}
	}
	
	
	
}
