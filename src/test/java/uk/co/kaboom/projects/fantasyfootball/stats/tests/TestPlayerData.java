package uk.co.kaboom.projects.fantasyfootball.stats.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.kaboom.projets.fantasyfootball.stats.model.Player;
import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;

public class TestPlayerData {

     @SuppressWarnings("unused")
     private static final Logger logger = LoggerFactory.getLogger(TestPlayerData.class);

     private Player player;

     @Before
     public void setUp() throws Exception {
          this.player = PlayerDataGenerator.getPlayer();
     }

     @Test
     public void testGetHeaders() {
          StringBuilder sb  = new StringBuilder();
          
          sb.append(PlayerStat.PLAYER_INDEX.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.PLAYER.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.POS.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.TEAM.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.PRICE.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.TOTAL_SCORE.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.EA_SPORTS_PPI.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.MINUTES_PLAYED.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.POINTS_PER_GAME.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.GOALS_SCORED.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.ASSISTS.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.BONUS.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.BONUS_POINTS_SYS.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.CLEAN_SHEETS.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.FORM.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.VALUE_FORM.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.VALUE_SEASON.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.GW.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.TRANSFERS_IN_ROUND.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.TRANSFERS_OUT_ROUND.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.PRICE_RISE_ROUND.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.PRICE_FALL_ROUND.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.TRANSFERS_IN.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.TRANSFERS_OUT.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.PRICE_RISE.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.PRICE_FALL.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.TIMES_IN_DREAM_TEAM.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.SAVES.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.YELLOW_CARDS.getDropdownText());
          sb.append("\t"); 
          sb.append(PlayerStat.RED_CARDS.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.OWN_GOALS.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.PENALTIES_MISSED.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.PENALTIES_SAVED.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.SELECTED.getDropdownText());
          sb.append("\t");
          sb.append(PlayerStat.GOALS_CONCEDED.getDropdownText());
          sb.append("\t");

          sb.append(System.getProperty("line.separator"));

          assertEquals("Player Data Header String is incorrect", sb.toString(), Player.getHeaders());
     }

     @Test
     public void testGetData() {
          StringBuilder sb  = new StringBuilder();
          sb.append("1");   
          sb.append("\t2");
          sb.append("\t3");
          sb.append("\t4");
          sb.append("\t5");
          sb.append("\t6");
          sb.append("\t7");
          sb.append("\t8");
          sb.append("\t9");
          sb.append("\t10");
          sb.append("\t11");
          sb.append("\t12");
          sb.append("\t13");
          sb.append("\t14");
          sb.append("\t15");
          sb.append("\t16");
          sb.append("\t17");
          sb.append("\t18");
          sb.append("\t19");
          sb.append("\t20");
          sb.append("\t21");
          sb.append("\t22");
          sb.append("\t23");
          sb.append("\t24");
          sb.append("\t25");
          sb.append("\t26");
          sb.append("\t27");
          sb.append("\t28");
          sb.append("\t29");
          sb.append("\t30");
          sb.append("\t31");
          sb.append("\t32");
          sb.append("\t33");
          sb.append("\t34");
          sb.append("\t35");
          sb.append("\t");
          sb.append(System.getProperty("line.separator"));
          
          player.setDynamicValue(PlayerStat.ASSISTS,                    "11");
          player.setDynamicValue(PlayerStat.BONUS,                      "12");
          player.setDynamicValue(PlayerStat.CLEAN_SHEETS,               "14");
          player.setDynamicValue(PlayerStat.EA_SPORTS_PPI,              "7");
          player.setDynamicValue(PlayerStat.FORM,                       "15");
          player.setDynamicValue(PlayerStat.GOALS_CONCEDED,             "35");
          player.setDynamicValue(PlayerStat.GOALS_SCORED,               "10");
          player.setDynamicValue(PlayerStat.GW,                         "18");
          player.setDynamicValue(PlayerStat.MINUTES_PLAYED,             "8");
          player.setDynamicValue(PlayerStat.OWN_GOALS,                  "31");
          player.setDynamicValue(PlayerStat.PENALTIES_MISSED,           "32");
          player.setDynamicValue(PlayerStat.PENALTIES_SAVED,            "33");
          player.setDynamicValue(PlayerStat.PLAYER,                     "2");
          player.setDynamicValue(PlayerStat.PLAYER_INDEX,               "1");      
          player.setDynamicValue(PlayerStat.POINTS_PER_GAME,            "9");
          player.setDynamicValue(PlayerStat.POS,                        "3");
          player.setDynamicValue(PlayerStat.PRICE,                      "5");
          player.setDynamicValue(PlayerStat.PRICE_FALL,                 "26");
          player.setDynamicValue(PlayerStat.PRICE_FALL_ROUND,           "22");
          player.setDynamicValue(PlayerStat.PRICE_RISE,                 "25");
          player.setDynamicValue(PlayerStat.PRICE_RISE_ROUND,           "21");
          player.setDynamicValue(PlayerStat.RED_CARDS,                  "30");
          player.setDynamicValue(PlayerStat.SAVES,                      "28");
          player.setDynamicValue(PlayerStat.SELECTED,                   "34");
          player.setDynamicValue(PlayerStat.TEAM,                       "4");
          player.setDynamicValue(PlayerStat.TIMES_IN_DREAM_TEAM,        "27");
          player.setDynamicValue(PlayerStat.TOTAL_SCORE,                "6");
          player.setDynamicValue(PlayerStat.TRANSFERS_IN,               "23");
          player.setDynamicValue(PlayerStat.TRANSFERS_IN_ROUND,         "19");
          player.setDynamicValue(PlayerStat.TRANSFERS_OUT,              "24");
          player.setDynamicValue(PlayerStat.TRANSFERS_OUT_ROUND,        "20");
          player.setDynamicValue(PlayerStat.VALUE_FORM,                 "16");
          player.setDynamicValue(PlayerStat.VALUE_SEASON,               "17");
          player.setDynamicValue(PlayerStat.YELLOW_CARDS,               "29");
          player.setDynamicValue(PlayerStat.BONUS_POINTS_SYS,           "13");
          
         // assertEquals("String length does not match", sb.toString().length(), player.getData().length());
         assertEquals("Player Data returned is incorrect", sb.toString(), player.getData());
     }

     /**
      * Create a new player and set the relevant stats to be the same as an existing one.
      * Check they match.
      * Add an additional stat and check they still match.
      */
    @Test
     public void testIsMatchTrueForBasicMatch() {

         //Create player to test
         Player expected1 = new Player();
         //Set all the stats that are present on every stat screen to match
         expected1.setDynamicValue(PlayerStat.PLAYER_INDEX, player.find(PlayerStat.PLAYER_INDEX));
         expected1.setDynamicValue(PlayerStat.PLAYER, player.find(PlayerStat.PLAYER));
         expected1.setDynamicValue(PlayerStat.TEAM, player.find(PlayerStat.TEAM));
         expected1.setDynamicValue(PlayerStat.POS, player.find(PlayerStat.POS));
         expected1.setDynamicValue(PlayerStat.SELECTED, player.find(PlayerStat.SELECTED));
         expected1.setDynamicValue(PlayerStat.PRICE, player.find(PlayerStat.PRICE));
         expected1.setDynamicValue(PlayerStat.GW, player.find(PlayerStat.GW));

         //Check the players match.
         assertTrue(player.isMatch(expected1));
         assertTrue(player.isMatch(player));
         assertTrue(expected1.isMatch(player));
         assertTrue(expected1.isMatch(expected1));

         //Set one non-matched value to be different
         expected1.setDynamicValue(PlayerStat.BONUS, "400");

         //re-test all conditions still match - the match function should not check any values not on the default screen
         assertTrue(player.isMatch(expected1));
         assertTrue(player.isMatch(player));
         assertTrue(expected1.isMatch(player));
         assertTrue(expected1.isMatch(expected1));
     }

     /**
      * 2 versions of this test - testing the same thing (unsure as to which style is preferred at this moment).
      * Probably it is best to use the rule based approach.
      */
    /*  
     * No longer required as not using Strings anymore - type safe with enums.
     * 
    @Test
     public void testDynamicDataExceptions() {
          try {
               player.setDynamicValue("Key Does Not Exist", "0");
          }
          catch(PlayerStatNotFoundException e) {
               assertEquals("ERROR: Found unknown statId: Key Does Not Exist", e.getMessage());
          }
     }

     @Rule
     public ExpectedException thrown = ExpectedException.none();

     @Test
     public void testDynamicDataExceptionsAlt() throws PlayerStatNotFoundException {
          thrown.expect(PlayerStatNotFoundException.class);
          thrown.expectMessage("ERROR: Found unknown statId: Key Does Not Exist");
          player.setDynamicValue("Key Does Not Exist", "0");
     }
*/

     /**
      * Dynamic setting and retrieval
      */
     @Test
     public void testGoodDynamicData() {
         player.setDynamicValue(PlayerStat.VALUE_SEASON, "0");
         player.setDynamicValue(PlayerStat.POINTS_PER_GAME, "1");
         assertEquals("player.getValueSeason() should be 0",   "0", player.find(PlayerStat.VALUE_SEASON));
         assertEquals("player.getPointsPerGame() should be 1", "1", player.find(PlayerStat.POINTS_PER_GAME));
     }

}
