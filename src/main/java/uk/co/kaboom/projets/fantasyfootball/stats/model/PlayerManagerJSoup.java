package uk.co.kaboom.projets.fantasyfootball.stats.model;

import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projets.fantasyfootball.stats.exceptions.PlayerStatNotFoundException;

public class PlayerManagerJSoup extends PlayerManager implements IPlayerManager {

     private static final Logger LOG = LoggerFactory.getLogger(PlayerManagerJSoup.class);

     @Override
     public Player generateScrapedPlayer(WebDriver driver, int i, Elements cols) {

        Player p = new Player();
        
        p.setDynamicValue(PlayerStat.PLAYER_INDEX,    cols.get(4).attr("href").split("#")[1] );
        p.setDynamicValue(PlayerStat.PLAYER,          cols.get(6).text()                     );
        p.setDynamicValue(PlayerStat.TEAM,            cols.get(7).text()                     );
        p.setDynamicValue(PlayerStat.POS,             cols.get(8).text()                     );
        p.setDynamicValue(PlayerStat.SELECTED,        cols.get(9).text()                     );
        p.setDynamicValue(PlayerStat.PRICE,           cols.get(10).text()                    );
        p.setDynamicValue(PlayerStat.GW,              cols.get(11).text()                    );
        p.setDynamicValue(PlayerStat.TOTAL_SCORE,     cols.get(12).text()                    );

        /*
        System.out.println(i + "\t" + driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[2]/a")).getAttribute("href").split("#")[1] + " \t" + cols.get(4).attr("href").split("#")[1]);
        System.out.println(i + "\t" + driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[3]")).getText() + " \t" + cols.get(6).text());
        System.out.println(i + "\t" + driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[4]")).getText() + " \t" + cols.get(7).text());
        System.out.println(i + "\t" + driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[5]")).getText() + " \t" + cols.get(8).text());
        System.out.println(i + "\t" + driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[6]")).getText() + " \t" + cols.get(9).text());
        System.out.println(i + "\t" + driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[7]")).getText() + " \t" + cols.get(10).text());
        System.out.println(i + "\t" + driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[8]")).getText() + " \t" + cols.get(11).text());
        System.out.println(i + "\t" + driver.findElement(By.xpath("//*[@id=\"ism\"]/section[1]/table/tbody/tr[" + i + "]/td[9]")).getText() + " \t" + cols.get(12).text());
        */

        return p;
     }
     
     @Override
     public Player generateScrapedPlayerWithoutChecks(WebDriver driver, int i, Elements cols) {

         Player p = new Player();

         //TODO: DRY Principals - should this be extracted to another method as used in generateScrapedPlayer?
         p.setDynamicValue(PlayerStat.PLAYER_INDEX,    cols.get(4).attr("href").split("#")[1] );
         p.setDynamicValue(PlayerStat.PLAYER,          cols.get(6).text()                     );

         return p;
    }
   
    @Override
    public boolean updatePlayer(Player p, WebDriver driver, int i,  Player existingPlayer, PlayerStat stat,  Elements cols) throws PlayerStatNotFoundException {
         if (existingPlayer == null) {
              LOG.debug("Null returned with:  \n" + p.find(PlayerStat.PLAYER_INDEX));
              LOG.debug("PlayerData (lookup): \n" + p.getData());
              return false;
         }

         //Double check player values match
         if (p.isMatch(existingPlayer)) {
              String dynamicValue = cols.get(13).text();
              existingPlayer.setDynamicValue(stat, dynamicValue);
              return true;
         }

         LOG.warn("WARN: matching up player data: \n " + existingPlayer.getData() + " \n with: \n" + p.getData());
         return false;
    }
     
     
}
