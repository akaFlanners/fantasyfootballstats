package uk.co.kaboom.projets.fantasyfootball.stats.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.exceptions.PlayerStatNotFoundException;

public class PlayerManager {
	
	private static final Logger logger = LoggerFactory.getLogger(PlayerManager.class);

	public Player generateScrapedPlayer(WebDriver driver, int i) {
		
		Player p = new Player();
		
		p.setPlayerIndex(driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[2]/a")).getAttribute("href").split("#")[1] );
		p.setPlayer(     driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[3]")).getText() );
		p.setTeam(       driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[4]")).getText() );
		p.setPos(        driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[5]")).getText() );
		p.setSelected(   driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[6]")).getText() );
		p.setPrice(      driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[7]")).getText() );
		p.setGw(         driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[8]")).getText() );
		p.setTotalScore( driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[9]")).getText() );
		
		return p;
	}
	
	public Player generateScrapedPlayerWithoutChecks(WebDriver driver, int i) {
		
		Player p = new Player();
		
		p.setPlayerIndex(driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[2]/a")).getAttribute("href").split("#")[1] );
		p.setPlayer(     driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[3]")).getText() );

		return p;
	}

	public boolean updatePlayer(Player p, WebDriver driver, int i,  Player existingPlayer, String statId) throws PlayerStatNotFoundException {
		if(existingPlayer == null) {
			logger.debug("Null returned with:  \n" + p.getPlayerIndex());
			logger.debug("PlayerData (lookup): \n" + p.getData());
			return false;
		}
		
		//Double check player values match
		if(p.isMatch(existingPlayer)) {
			String dynamicValue = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[10]")).getText();
			existingPlayer.setDynamicValue(statId, dynamicValue);
			return true;
		}
		
		logger.warn("WARN: matching up player data: \n " + existingPlayer.getData() + " \n with: \n" + p.getData());
		return false;
	}

}
