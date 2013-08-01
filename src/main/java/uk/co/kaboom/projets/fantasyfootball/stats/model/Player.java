package uk.co.kaboom.projets.fantasyfootball.stats.model;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {

     @SuppressWarnings("unused")
     private static final Logger LOG = LoggerFactory.getLogger(Player.class);

     private Map<PlayerStat, String> playerStatMap = new EnumMap<>(PlayerStat.class);

     /**
      * This only matches on the stats that are present on every page.
      * Thus we can match when a player is first created and have confidence we have selected the correct player again
      * (i.e. There has been no issues with mixing up the player index).
      * Note: This now also checks the playerIndex's match, previously this was an assumed prerequisite of calling match.
      * @param p
      * @return boolean. True if players match.
      */
     public final boolean isMatch(final Player p) {
          if(
                  this.find(PlayerStat.PLAYER_INDEX).equals(p.find(PlayerStat.PLAYER_INDEX))
                  &&
                  this.find(PlayerStat.PLAYER).equals(p.find(PlayerStat.PLAYER))
          ) {
               return true;
          }

          return false;
     }
     
     public final String find(PlayerStat stat) {
         String value = playerStatMap.get(stat);
         return value;
     }
     

     /*
      * Add player data to a map
      */
     public final void setDynamicValue(final PlayerStat statKey, final String value) {
         playerStatMap.put(statKey, value);
     }

     public static final String getHeaders() {
          StringBuilder sb = new StringBuilder();

          for (PlayerStat playerStat :PlayerStat.values()) {
              sb.append(playerStat.getDropdownText());
              sb.append("\t");
          }

          sb.append(System.getProperty("line.separator"));

          return sb.toString();
     }

     public final String getData() {
          StringBuilder sb = new StringBuilder();
          
          Iterator<PlayerStat> enumKeySet = playerStatMap.keySet().iterator();
          while(enumKeySet.hasNext()){
              PlayerStat currentStat = enumKeySet.next();
              sb.append(playerStatMap.get(currentStat));
              sb.append("\t");
          }
          //TODO: REMOVE LAST TAB

          sb.append(System.getProperty("line.separator"));
          
          return sb.toString();
     }

}
