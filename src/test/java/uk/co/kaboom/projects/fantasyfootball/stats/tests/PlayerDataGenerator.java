package uk.co.kaboom.projects.fantasyfootball.stats.tests;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Player;
import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;


public class PlayerDataGenerator {

     public static Player getPlayer() {

         Player player = new Player();

         player.setDynamicValue(PlayerStat.ASSISTS, "1");
         player.setDynamicValue(PlayerStat.BONUS, "2");
         player.setDynamicValue(PlayerStat.CLEAN_SHEETS, "3");
         player.setDynamicValue(PlayerStat.EA_SPORTS_PPI, "4");
         player.setDynamicValue(PlayerStat.FORM, "5");
         player.setDynamicValue(PlayerStat.GOALS_CONCEDED, "6");
         player.setDynamicValue(PlayerStat.GOALS_SCORED, "7");
         player.setDynamicValue(PlayerStat.GW, "8");
         player.setDynamicValue(PlayerStat.MINUTES_PLAYED, "9");
         player.setDynamicValue(PlayerStat.OWN_GOALS, "10");
         player.setDynamicValue(PlayerStat.PENALTIES_MISSED, "11");
         player.setDynamicValue(PlayerStat.PENALTIES_SAVED, "12");
         player.setDynamicValue(PlayerStat.PLAYER, "13");
         player.setDynamicValue(PlayerStat.PLAYER_INDEX, "14");
         player.setDynamicValue(PlayerStat.POINTS_PER_GAME, "15");
         player.setDynamicValue(PlayerStat.POS, "16");
         player.setDynamicValue(PlayerStat.PRICE, "17");
         player.setDynamicValue(PlayerStat.PRICE_FALL, "18");
         player.setDynamicValue(PlayerStat.PRICE_FALL_ROUND, "19");
         player.setDynamicValue(PlayerStat.PRICE_RISE, "20");
         player.setDynamicValue(PlayerStat.PRICE_RISE_ROUND, "21");
         player.setDynamicValue(PlayerStat.RED_CARDS, "22");
         player.setDynamicValue(PlayerStat.SAVES, "23");
         player.setDynamicValue(PlayerStat.SELECTED, "24");
         player.setDynamicValue(PlayerStat.TEAM, "25");
         player.setDynamicValue(PlayerStat.TIMES_IN_DREAM_TEAM, "26");
         player.setDynamicValue(PlayerStat.TOTAL_SCORE, "27");
         player.setDynamicValue(PlayerStat.TRANSFERS_IN, "28");
         player.setDynamicValue(PlayerStat.TRANSFERS_IN_ROUND, "29");
         player.setDynamicValue(PlayerStat.TRANSFERS_OUT, "30");
         player.setDynamicValue(PlayerStat.TRANSFERS_OUT_ROUND, "31");
         player.setDynamicValue(PlayerStat.VALUE_FORM, "32");
         player.setDynamicValue(PlayerStat.VALUE_SEASON, "33");
         player.setDynamicValue(PlayerStat.YELLOW_CARDS, "34");
         player.setDynamicValue(PlayerStat.BONUS_POINTS_SYS, "35");

          return player;
     }

}
