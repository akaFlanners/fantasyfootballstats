package uk.co.kaboom.projets.fantasyfootball.stats.processing;

import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.exceptions.PlayerStatNotFoundException;
import uk.co.kaboom.projets.fantasyfootball.stats.model.IPlayerManager;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Player;
import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;
import uk.co.kaboom.projets.fantasyfootball.stats.ui.IControllerUI;

public class PageProcessorJSoup implements IPageProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(PageProcessorJSoup.class);

    private static Map<String, Player> playerDataMap;
    private WebDriver driver;
    private IControllerUI controlUI;
    private IPlayerManager pm;

    public PageProcessorJSoup(final Map<String, Player> playerDataMap, final WebDriver driver, final IControllerUI controlUI, final IPlayerManager pm) {
         if(PageProcessorJSoup.playerDataMap == null) {
             PageProcessorJSoup.playerDataMap = playerDataMap;
         }
         this.driver = driver;
         this.controlUI = controlUI;
         this.pm = pm;
    }

    /**
     * Run an additional captureInitialData() on first process passthrough of all players.
     * This puts the player in the map, prior to adding the sortKey stat.
     */
    public void process(final String viewKey, final PlayerStat stat) {
         LOG.debug("process - JSoup");
         controlUI.updateData(viewKey, stat);
         Elements rows = getStatsTable(getHTML());             //Create a copy of the table here - to pass to the IPlayerManager for parsing.
         captureInitialData(this.pm, rows);                    //We run this additional step of adding the player into the map on the fist pass through.
         processRetrievedData(stat, this.pm, rows);
    }

    public void process2(final String viewKey, final PlayerStat stat) {
         LOG.debug("process2 - JSoup");
         controlUI.updateData(viewKey, stat);
         Elements rows = getStatsTable(getHTML());            //Create a copy of the table here - to pass to the IPlayerManager for parsing.
         processRetrievedData(stat, this.pm, rows);
    }

    public String getHTML() {
        return driver.getPageSource();
    }
    
    public Elements getStatsTable(String html) {
        Document doc = Jsoup.parse(html);
        Elements rows = doc.select("#ism .ismTable tbody tr");
        /*
        System.out.println(rows);
        System.out.println();
        System.out.println();
        
        for (Element row : rows) {
            System.out.println("tagName?:" +row.tagName());
            System.out.println("text?:" +row.text());
            
            System.out.println("*** START PLAYER ***");
            Elements cols = row.getAllElements();
            for (Element col : cols) {
                System.out.println("tagName?:" +col.tagName());
                System.out.println("text?:" +col.text());
            }
            System.out.println("*** END PLAYER ***");
        }
        */
        return rows;
    }
    
    private void captureInitialData(IPlayerManager pm,  Elements rows) {
              int rowCount = 0;             //TODO: If PageProcessor.java is removed rowCount can be removed too.

              for(Element row : rows) {
                   rowCount++;              //TODO: If PageProcessor.java is removed rowCount can be removed too.
                   Elements cols = row.getAllElements();

                   Player p  = pm.generateScrapedPlayer(driver, rowCount, cols); //TODO: RowCount only used for backwards compatibility with PageProcessor.java interface.
                   playerDataMap.put(p.find(PlayerStat.PLAYER_INDEX), p);        //Difference between methods is here - we need to put the player in the map.
              }
    }
    
    private void processRetrievedData(final PlayerStat stat, IPlayerManager pm, Elements rows) {

         int rowCount = 0;             //TODO: If PageProcessor.java is removed rowCount can be removed too.

         for(Element row : rows) {
              rowCount++;              //TODO: If PageProcessor.java is removed rowCount can be removed too.
              Elements cols = row.getAllElements();
              
              Player p              = pm.generateScrapedPlayerWithoutChecks(driver, rowCount, cols);
              Player existingPlayer = playerDataMap.get(p.find(PlayerStat.PLAYER_INDEX)); //Lookup player by index

              try {
                   pm.updatePlayer(p, driver, rowCount, existingPlayer, stat, cols);
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
