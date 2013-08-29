package uk.co.kaboom.projets.fantasyfootball.stats.model;

import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.exceptions.PlayerStatNotFoundException;

public class PlayerManager implements IPlayerManager {

     private static final Logger LOG = LoggerFactory.getLogger(PlayerManager.class);

     /* (non-Javadoc)
     * @see uk.co.kaboom.projets.fantasyfootball.stats.model.IPlayerManager#generateScrapedPlayer(org.openqa.selenium.WebDriver, int)
     */
    @Override
    public Player generateScrapedPlayer(WebDriver driver, int i) {

          Player p = new Player();
          
          p.setDynamicValue(PlayerStat.PLAYER_INDEX,    driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[2]/a")).getAttribute("href").split("#")[1] );
          p.setDynamicValue(PlayerStat.PLAYER,          driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[3]")).getText() );
          p.setDynamicValue(PlayerStat.TEAM,            driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[4]")).getText() );
          p.setDynamicValue(PlayerStat.POS,             driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[5]")).getText() );
          p.setDynamicValue(PlayerStat.SELECTED,        driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[6]")).getText() );
          p.setDynamicValue(PlayerStat.PRICE,           driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[7]")).getText() );
          p.setDynamicValue(PlayerStat.GW,              driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[8]")).getText() );
          p.setDynamicValue(PlayerStat.TOTAL_SCORE,     driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[9]")).getText() );

          return p;
     }
    
    /* (non-Javadoc)
    * @see uk.co.kaboom.projets.fantasyfootball.stats.model.IPlayerManager#generateScrapedPlayer(org.openqa.selenium.WebDriver, int, org.jsoup.select.Elements cols)
    */
     public Player generateScrapedPlayer(WebDriver driver, int i, Elements cols) {
         return generateScrapedPlayer(driver,  i);
     }

     /* (non-Javadoc)
     * @see uk.co.kaboom.projets.fantasyfootball.stats.model.IPlayerManager#generateScrapedPlayerWithoutChecks(org.openqa.selenium.WebDriver, int)
     */
    @Override
    public Player generateScrapedPlayerWithoutChecks(WebDriver driver, int i) {

          Player p = new Player();

          p.setDynamicValue(PlayerStat.PLAYER_INDEX, driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[2]/a")).getAttribute("href").split("#")[1] );
          p.setDynamicValue(PlayerStat.PLAYER,       driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[3]")).getText() );

          return p;
     }
    
    
    public Player generateScrapedPlayerWithoutChecks(WebDriver driver, int i, Elements cols) {
        return generateScrapedPlayerWithoutChecks(driver,  i);
    }

     /* (non-Javadoc)
     * @see uk.co.kaboom.projets.fantasyfootball.stats.model.IPlayerManager#updatePlayer(uk.co.kaboom.projets.fantasyfootball.stats.model.Player, org.openqa.selenium.WebDriver, int, uk.co.kaboom.projets.fantasyfootball.stats.model.Player, uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat)
     */
    @Override
    public boolean updatePlayer(Player p, WebDriver driver, int i,  Player existingPlayer, PlayerStat stat) throws PlayerStatNotFoundException {
          if (existingPlayer == null) {
               LOG.debug("Null returned with:  \n" + p.find(PlayerStat.PLAYER_INDEX));
               LOG.debug("PlayerData (lookup): \n" + p.getData());
               return false;
          }

          //Double check player values match
          if (p.isMatch(existingPlayer)) {
               String dynamicValue = driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[10]")).getText();
               existingPlayer.setDynamicValue(stat, dynamicValue);
               return true;
          }

          LOG.warn("WARN: matching up player data: \n " + existingPlayer.getData() + " \n with: \n" + p.getData());
          return false;
     }
    
     public boolean updatePlayer(Player p, WebDriver driver, int i,  Player existingPlayer, PlayerStat stat, Elements cols) throws PlayerStatNotFoundException {
         return updatePlayer( p, driver,  i,  existingPlayer, stat); 
     }
}
