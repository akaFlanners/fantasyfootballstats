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

     /*
     private String playerIndex;
     private String player;
     private String team;
     private String pos;
     private String selected;
     private String price;
     private String gw;
     private String totalScore;
     private String minutesPlayed;
     private String goalsScored;
     private String assists;
     private String cleanSheets;
     private String goalsConceded;
     private String ownGoals;
     private String penaltiesSaved;
     private String penaltiesMissed;
     private String yellowCards;
     private String redCards;
     private String saves;
     private String bonus;
     private String eaSportsPPI;
     private String bonusPointsSystem; 
     private String form;
     private String timesInDreamTeam;
     private String valueForm;
     private String valueSeason;
     private String pointsPerGame;
     private String transfersIn;
     private String transfersOut;
     private String transfersInRound;
     private String transfersOutRound;
     private String priceRise;
     private String priceFall;
     private String priceRiseRound;
     private String priceFallRound;

     public final String getPlayerIndex() {
          return playerIndex;
     }
     public final void setPlayerIndex(String playerIndex) {
          this.playerIndex = playerIndex;
     }
     public final String getPlayer() {
          return player;
     }
     public final void setPlayer(String player) {
          this.player = player;
     }
     public final String getTeam() {
          return team;
     }
     public final void setTeam(String team) {
          this.team = team;
     }
     public final String getPos() {
          return pos;
     }
     public final void setPos(String pos) {
          this.pos = pos;
     }
     public final String getSelected() {
          return selected;
     }
     public final void setSelected(String selected) {
          this.selected = selected;
     }
     public final String getPrice() {
          return price;
     }
     public final void setPrice(String price) {
          this.price = price;
     }
     public final String getGw() {
          return gw;
     }
     public final void setGw(String gw) {
          this.gw = gw;
     }
     public final String getTotalScore() {
          return totalScore;
     }
     public final void setTotalScore(String totalScore) {
          this.totalScore = totalScore;
     }
     public final String getMinutesPlayed() {
          return minutesPlayed;
     }
     public final void setMinutesPlayed(String minutesPlayed) {
          this.minutesPlayed = minutesPlayed;
     }
     public final String getGoalsScored() {
          return goalsScored;
     }
     public final void setGoalsScored(String goalsScored) {
          this.goalsScored = goalsScored;
     }
     public final String getAssists() {
          return assists;
     }
     public final void setAssists(String assists) {
          this.assists = assists;
     }
     public final String getCleanSheets() {
          return cleanSheets;
     }
     public final void setCleanSheets(String cleanSheets) {
          this.cleanSheets = cleanSheets;
     }
     public final String getGoalsConceded() {
          return goalsConceded;
     }
     public final void setGoalsConceded(String goalsConceded) {
          this.goalsConceded = goalsConceded;
     }
     public final String getOwnGoals() {
          return ownGoals;
     }
     public final void setOwnGoals(String ownGoals) {
          this.ownGoals = ownGoals;
     }
     public final String getPenaltiesSaved() {
          return penaltiesSaved;
     }
     public final void setPenaltiesSaved(String penaltiesSaved) {
          this.penaltiesSaved = penaltiesSaved;
     }
     public final String getPenaltiesMissed() {
          return penaltiesMissed;
     }
     public final void setPenaltiesMissed(String penaltiesMissed) {
          this.penaltiesMissed = penaltiesMissed;
     }
     public final String getYellowCards() {
          return yellowCards;
     }
     public final void setYellowCards(String yellowCards) {
          this.yellowCards = yellowCards;
     }
     public final String getRedCards() {
          return redCards;
     }
     public final void setRedCards(String redCards) {
          this.redCards = redCards;
     }
     public final String getSaves() {
          return saves;
     }
     public final void setSaves(String saves) {
          this.saves = saves;
     }
     public final String getBonus() {
          return bonus;
     }
     public final void setBonus(String bonus) {
          this.bonus = bonus;
     }
     public final String getEaSportsPPI() {
          return eaSportsPPI;
     }
     public final void setEaSportsPPI(String eaSportsPPI) {
          this.eaSportsPPI = eaSportsPPI;
     }
     public String getBonusPointsSystem() {
          return bonusPointsSystem;
     }
     public void setBonusPointsSystem(String bonusPointsSystem) {
          this.bonusPointsSystem = bonusPointsSystem;
     }
     public final String getForm() {
          return form;
     }
     public final void setForm(String form) {
          this.form = form;
     }
     public final String getTimesInDreamTeam() {
          return timesInDreamTeam;
     }
     public final void setTimesInDreamTeam(String timesInDreamTeam) {
          this.timesInDreamTeam = timesInDreamTeam;
     }
     public final String getValueForm() {
          return valueForm;
     }
     public final void setValueForm(String valueForm) {
          this.valueForm = valueForm;
     }
     public final String getValueSeason() {
          return valueSeason;
     }
     public final void setValueSeason(String valueSeason) {
          this.valueSeason = valueSeason;
     }
     public final String getPointsPerGame() {
          return pointsPerGame;
     }
     public final void setPointsPerGame(String pointsPerGame) {
          this.pointsPerGame = pointsPerGame;
     }
     public final String getTransfersIn() {
          return transfersIn;
     }
     public final void setTransfersIn(String transfersIn) {
          this.transfersIn = transfersIn;
     }
     public final String getTransfersOut() {
          return transfersOut;
     }
     public final void setTransfersOut(String transfersOut) {
          this.transfersOut = transfersOut;
     }
     public final String getTransfersInRound() {
          return transfersInRound;
     }
     public final void setTransfersInRound(String transfersInRound) {
          this.transfersInRound = transfersInRound;
     }
     public final String getTransfersOutRound() {
          return transfersOutRound;
     }
     public final void setTransfersOutRound(String transfersOutRound) {
          this.transfersOutRound = transfersOutRound;
     }
     public final String getPriceRise() {
          return priceRise;
     }
     public final void setPriceRise(String priceRise) {
          this.priceRise = priceRise;
     }
     public final String getPriceFall() {
          return priceFall;
     }
     public final void setPriceFall(String priceFall) {
          this.priceFall = priceFall;
     }
     public final String getPriceRiseRound() {
          return priceRiseRound;
     }
     public final void setPriceRiseRound(String priceRiseRound) {
          this.priceRiseRound = priceRiseRound;
     }
     public final String getPriceFallRound() {
          return priceFallRound;
     }
     public final void setPriceFallRound(String priceFallRound) {
          this.priceFallRound = priceFallRound;
     }
*/

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
      * Generally considered bad practice to use large switch statements like this.
      * However it was my first chance to try String based switches ... so I took it.
      */
     public final void setDynamicValue(final PlayerStat statKey, final String value) {
         
         playerStatMap.put(statKey, value);
         
         /*
          switch (key) {
               case "totalScore": this.setTotalScore(value); break;
               case "price": this.setPrice(value); break;
               case "minutesPlayed": this.setMinutesPlayed(value); break;
               case "goalsScored": this.setGoalsScored(value); break;
               case "assists": this.setAssists(value); break;
               case "cleanSheets": this.setCleanSheets(value); break;
               case "goalsConceded": this.setGoalsConceded(value); break;
               case "ownGoals": this.setOwnGoals(value); break;
               case "penaltiesSaved": this.setPenaltiesSaved(value); break;
               case "penaltiesMissed": this.setPenaltiesMissed(value); break;
               case "yellowCards": this.setYellowCards(value); break;
               case "redCards": this.setRedCards(value); break;
               case "saves": this.setSaves(value); break;
               case "bonus": this.setBonus(value); break;
               case "eaSportsPPI": this.setEaSportsPPI(value); break;
               case "bonusPointsSystem": this.setBonusPointsSystem(value); break;
               case "form": this.setForm(value); break;
               case "timesInDreamTeam": this.setTimesInDreamTeam(value); break;
               case "valueForm": this.setValueForm(value); break;
               case "valueSeason": this.setValueSeason(value); break;
               case "pointsPerGame": this.setPointsPerGame(value); break;
               case "transfersIn": this.setTransfersIn(value); break;
               case "transfersOut": this.setTransfersOut(value); break;
               case "transfersInRound": this.setTransfersInRound(value); break;
               case "transfersOutRound": this.setTransfersOutRound(value); break;
               case "priceRise": this.setPriceRise(value); break;
               case "priceFall": this.setPriceFall(value); break;
               case "priceRiseRound": this.setPriceRiseRound(value); break;
               case "priceFallRound": this.setPriceFallRound(value); break;
               default: throw new PlayerStatNotFoundException("ERROR: Found unknown statId: " + key);
          }
          */
     }

     public static final String getHeaders() {
          StringBuilder sb = new StringBuilder();

          for (PlayerStat playerStat :PlayerStat.values()) {
              sb.append(playerStat.getDropdownText());
              sb.append("\t");
          }

          /*
          sb.append(PlayerStat.ASSISTS);
          sb.append("\t");
          sb.append(PlayerStat.BONUS);
          sb.append("\t");
          sb.append(PlayerStat.BONUS_POINTS_SYS);
          sb.append("\t");
          sb.append(PlayerStat.CLEAN_SHEETS);
          sb.append("\t");
          sb.append(PlayerStat.EA_SPORTS_PPI);
          sb.append("\t");
          sb.append(PlayerStat.FORM);
          sb.append("\t");
          sb.append(PlayerStat.GOALS_CONCEDED);
          sb.append("\t");
          sb.append(PlayerStat.GOALS_SCORED);
          sb.append("\t");
          sb.append(PlayerStat.GW);
          sb.append("\t");
          sb.append(PlayerStat.MINUTES_PLAYED);
          sb.append("\t");
          sb.append(PlayerStat.OWN_GOALS);
          sb.append("\t");
          sb.append(PlayerStat.PENALTIES_MISSED);
          sb.append("\t");
          sb.append(PlayerStat.PENALTIES_SAVED);
          sb.append("\t");
          sb.append(PlayerStat.PLAYER);
          sb.append("\t");
          sb.append(PlayerStat.PLAYER_INDEX);
          sb.append("\t");
          sb.append(PlayerStat.POINTS_PER_GAME);
          sb.append("\t");
          sb.append(PlayerStat.POS);
          sb.append("\t");
          sb.append(PlayerStat.PRICE);
          sb.append("\t");
          sb.append(PlayerStat.PRICE_FALL);
          sb.append("\t");
          sb.append(PlayerStat.PRICE_FALL_ROUND);
          sb.append("\t");
          sb.append(PlayerStat.PRICE_RISE);
          sb.append("\t");
          sb.append(PlayerStat.PRICE_RISE_ROUND);
          sb.append("\t");
          sb.append(PlayerStat.RED_CARDS);
          sb.append("\t");
          sb.append(PlayerStat.SAVES);
          sb.append("\t");
          sb.append(PlayerStat.SELECTED);
          sb.append("\t");
          sb.append(PlayerStat.TEAM);
          sb.append("\t");
          sb.append(PlayerStat.TIMES_IN_DREAM_TEAM);
          sb.append("\t");
          sb.append(PlayerStat.TOTAL_SCORE);
          sb.append("\t");
          sb.append(PlayerStat.TRANSFERS_IN);
          sb.append("\t");
          sb.append(PlayerStat.TRANSFERS_IN_ROUND);
          sb.append("\t");
          sb.append(PlayerStat.TRANSFERS_OUT);
          sb.append("\t");
          sb.append(PlayerStat.TRANSFERS_OUT_ROUND);
          sb.append("\t");
          sb.append(PlayerStat.VALUE_FORM);
          sb.append("\t");
          sb.append(PlayerStat.VALUE_SEASON);
          sb.append("\t");
          sb.append(PlayerStat.YELLOW_CARDS);
          sb.append("\t"); //Remove 
          */
          
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
  
          
        
          
          /*
          //sb.append("\t ");
          sb.append(getAssists());

          sb.append("\t ");
          sb.append(getBonus());
          
          sb.append("\t ");
          sb.append(getBonusPointsSystem());

          sb.append("\t ");
          sb.append(getCleanSheets());

          sb.append("\t ");
          sb.append(getEaSportsPPI());

          sb.append("\t ");
          sb.append(getForm());

          sb.append("\t ");
          sb.append(getGoalsConceded());

          sb.append("\t ");
          sb.append(getGoalsScored());

          sb.append("\t ");
          sb.append(getGw());

          sb.append("\t ");
          sb.append(getMinutesPlayed());

          sb.append("\t ");
          sb.append(getOwnGoals());

          sb.append("\t ");
          sb.append(getPenaltiesMissed());

          sb.append("\t ");
          sb.append(getPenaltiesSaved());

          sb.append("\t ");
          sb.append(getPlayer());

          sb.append("\t ");
          sb.append(getPlayerIndex());

          sb.append("\t ");
          sb.append(getPointsPerGame());

          sb.append("\t ");
          sb.append(getPos());

          sb.append("\t ");
          sb.append(getPrice());

          sb.append("\t ");
          sb.append(getPriceFall());

          sb.append("\t ");
          sb.append(getPriceFallRound());

          sb.append("\t ");
          sb.append(getPriceRise());

          sb.append("\t ");
          sb.append(getPriceRiseRound());

          sb.append("\t ");
          sb.append(getRedCards());

          sb.append("\t ");
          sb.append(getSaves());

          sb.append("\t ");
          sb.append(getSelected());

          sb.append("\t ");
          sb.append(getTeam());

          sb.append("\t ");
          sb.append(getTimesInDreamTeam());

          sb.append("\t ");
          sb.append(getTotalScore());

          sb.append("\t ");
          sb.append(getTransfersIn());

          sb.append("\t ");
          sb.append(getTransfersInRound());

          sb.append("\t ");
          sb.append(getTransfersOut());

          sb.append("\t ");
          sb.append(getTransfersOutRound());

          sb.append("\t ");
          sb.append(getValueForm());

          sb.append("\t ");
          sb.append(getValueSeason());

          sb.append("\t ");
          sb.append(getYellowCards());
*/
          sb.append(System.getProperty("line.separator"));
          
          return sb.toString();
     }

}
