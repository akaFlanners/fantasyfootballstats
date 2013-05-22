package uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FantasyFootballScraper {
	
	private WebDriver driver;
	private Map<String, Player> playerDataMap = new HashMap<String, Player>(); 
	private Map<String, String> selectionMap = new HashMap<String, String>();
	
	private boolean initialDataCaptured = false;
	
	public FantasyFootballScraper(WebDriver driver) {
		this.driver = driver;
		createSelectionMap();
	}
	
	private void createSelectionMap() {
		//selectionMap.put("totalScore", "Total score");
		selectionMap.put("roundScore", "Round score");
		//selectionMap.put("price", "Price");
		selectionMap.put("teamsSelectedBy", "Teams selected by %");
		selectionMap.put("minutesPlayed", "Minutes played");
		selectionMap.put("goalsScored", "Goals scored");
		selectionMap.put("assists", "Assists");
		selectionMap.put("cleanSheets", "Clean sheets");
		selectionMap.put("goalsConceded", "Goals conceded");
		selectionMap.put("ownGoals", "Own goals");
		selectionMap.put("penaltiesSaved", "Penalties saved");
		selectionMap.put("penaltiesMissed", "Penalties missed");
		selectionMap.put("yellowCards", "Yellow cards");
		selectionMap.put("redCards", "Red cards");
		selectionMap.put("saves", "Saves");
		selectionMap.put("bonus", "Bonus");
		selectionMap.put("eaSportsPPI", "EA SPORTS PPI");
		selectionMap.put("form", "Form");
		selectionMap.put("timesInDreamTeam", "Times in Dream Team");
		selectionMap.put("valueForm", "Value (form)");
		selectionMap.put("valueSeason", "Value (season)");
		selectionMap.put("pointsPerGame", "Points per game");
		selectionMap.put("transfersIn", "Transfers in");
		selectionMap.put("transfersOut", "Transfers out");
		selectionMap.put("transfersInRound", "Transfers in (round)");
		selectionMap.put("transfersOutRound", "Transfers out (round)");
		selectionMap.put("priceRise", "Price rise");
		selectionMap.put("priceFall", "Price fall");
		selectionMap.put("priceRiseRound", "Price rise (round)");
		selectionMap.put("priceFallRound", "Price fall (round)");
	}
	

	public void scrape() {
        driver.get("http://fantasy.premierleague.com/stats/elements/");
        processNext();
	}
	
	public void processNext() {
		
		waitForNextButton();
		if(!initialDataCaptured) {
			captureInitialData();
		}
		
        List<WebElement> buttons = driver.findElements(By.cssSelector("span.ui-button-text"));

        if(buttons.size() == 1) {
            pressNext(buttons.get(0));
        } 
        else if (buttons.size() == 2) {
        	pressNext(buttons.get(1));
        }
        
	}
	
	public void waitForNextButton() {
	     (new WebDriverWait(driver, 50)).until(new ExpectedCondition<Boolean>() {
	         public Boolean apply(WebDriver d) {
	             return driver.findElements(By.cssSelector("span.ui-button-text")).size() > 0;
	          }
	         });
	}
	
	public void captureInitialData() {
		
		int numOfRows = driver.findElements(By.xpath("//*[@id='ism']/section[1]/table/tbody/tr")).size();

		for(int i=1; i<numOfRows; i++) {

			String playerIndex  = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[2]/a")).getAttribute("href").split("#")[1];
			String player       = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[3]")).getText();
			String team         = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[4]")).getText();
			String pos          = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[5]")).getText();
			String selected     = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[6]")).getText();
			String price        = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[7]")).getText();
			String gw           = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[8]")).getText();
			
			String totalScore   = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[9]")).getText();
			
			System.out.println(		"PlayerIndex: " + playerIndex
								+	" Player: "     + player
								+	" Team: "     	+ team
								+	" Pos: "     	+ pos
								+	" Selected: "   + selected
								+	" Price: "     	+ price
								+	" Gw: "     	+ gw
								+	" Value: "      + totalScore
			);
			
			Player p = new Player();
			p.setPlayerIndex(playerIndex);
			p.setPlayer(player);
			p.setTeam(team);
			p.setPos(pos);
			p.setSelected(selected);
			p.setPrice(price);
			p.setGw(gw);
			
			playerDataMap.put(p.getPlayerIndex(), p);
		}
		
		initialDataCaptured = true;
	}
	
	public void pressNext(WebElement we) {
       	if("NEXT".equals(we.getText())) {
       		we.click();
       		processNext();
       	} 
       	else {
       		System.out.println("Next Button not found");
       		updateData();
       	}
	}
	
	/**
	 * Must be done after all data captured for a given dropdown.
	 * As soon as you adjust dropdown and click show, page resets to page 1
	 */
	public void updateData() {
		selectDropdown();
		clickShow();
	}
	
	public void selectDropdown() {
		Select selectBox = new Select(driver.findElement(By.id("id_stat_filter")));
		selectBox.selectByVisibleText(selectionMap.get("minutesPlayed")); //TODO: Change to iterate over different map values.
	}
	
	public void clickShow() {
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/form/input")).click();
	}
	
}
