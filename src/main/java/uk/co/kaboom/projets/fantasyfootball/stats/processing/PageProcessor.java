package uk.co.kaboom.projets.fantasyfootball.stats.processing;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.exceptions.PlayerStatNotFoundException;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Player;
import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerManager;
import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;

public class PageProcessor implements IPageProcessor {

     private static final Logger LOG = LoggerFactory.getLogger(PageProcessor.class);

     private static Map<String, Player> playerDataMap;
     private WebDriver driver;
     private IControllerUI controlUI;

     public PageProcessor(final Map<String, Player> playerDataMap, final WebDriver driver, final IControllerUI controlUI) {
          if(PageProcessor.playerDataMap == null) {
               PageProcessor.playerDataMap = playerDataMap;
          }
          this.driver = driver;
          this.controlUI = controlUI;
     }

     /**
      * Run an additional captureInitialData() on first process passthrough of all players.
      * This puts the player in the map, prior to adding the sortKey stat.
      */
     public void process(final String viewKey, final PlayerStat stat) {
          LOG.debug("process");
          controlUI.updateData(viewKey, stat);
          captureInitialData();                      //We run this additional step of adding the player into the map on the fist pass through.
          processRetrievedData(stat);
     }

     public void process2(final String viewKey, final PlayerStat stat) {
          LOG.debug("process2");
          controlUI.updateData(viewKey, stat);

          processRetrievedData(stat);
     }

     private void captureInitialData() {
               PlayerManager pm = new PlayerManager();
               int numOfRows = driver.findElements(By.xpath("//*[@id='ism']/section[1]/table/tbody/tr")).size();

               for(int i=1; i<=numOfRows; i++) {
                    Player p = pm.generateScrapedPlayer(driver, i);
                    playerDataMap.put(p.find(PlayerStat.PLAYER_INDEX), p);  //Difference between methods is here - we need to put the player in the map.
               }
     }

     private void processRetrievedData(final PlayerStat stat) {
          PlayerManager pm = new PlayerManager();
          int numOfRows = driver.findElements(By.xpath("//*[@id='ism']/section[1]/table/tbody/tr")).size();

          for(int i=1; i<=numOfRows; i++) {

               Player p              = pm.generateScrapedPlayerWithoutChecks(driver, i);
               Player existingPlayer = playerDataMap.get(p.find(PlayerStat.PLAYER_INDEX)); //Lookup player by index

               try {
                    pm.updatePlayer(p, driver, i, existingPlayer, stat);
               }
               catch (PlayerStatNotFoundException e) {
                    LOG.warn(e.getMessage());
                    e.printStackTrace();
               }
               catch(NoSuchElementException e) {
                    LOG.warn("NoSuchElementException on: " + stat.getStatName());
               }
          }
     }

     public static Map<String, Player> getPlayerDataMap() {
          return playerDataMap;
     }

     public String getDataToPersist() {
          StringBuilder sb = new StringBuilder();
          sb.append(Player.getHeaders());

          for (Map.Entry<String, Player> entry : getPlayerDataMap().entrySet()) {
              Player player = entry.getValue();
              sb.append(player.getData());
          }

          return sb.toString();
     }

}
