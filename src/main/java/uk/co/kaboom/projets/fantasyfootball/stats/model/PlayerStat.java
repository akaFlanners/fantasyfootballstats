package uk.co.kaboom.projets.fantasyfootball.stats.model;

public enum PlayerStat {
     PLAYER_INDEX       ("playerIndex"       ,"Player Index",          false),
     PLAYER             ("player"            ,"Player",                false),
     POS                ("pos"               ,"Pos",                   false),
     TEAM               ("team"              ,"Team",                  false),
     PRICE              ("price"             ,"Price",                 false),
     TOTAL_SCORE        ("totalScore"        ,"Total Score",           false),
     EA_SPORTS_PPI      ("eaSportsPPI"       ,"EA SPORTS PPI",         true ),
     MINUTES_PLAYED     ("minutesPlayed"     ,"Minutes played",        true ),
     POINTS_PER_GAME    ("pointsPerGame"     ,"Points per game",       true ),
     GOALS_SCORED       ("goalsScored"       ,"Goals scored",          true ),
     ASSISTS            ("assists"           ,"Assists",               true ),
     BONUS              ("bonus"             ,"Bonus",                 true ),
     BONUS_POINTS_SYS   ("bonusPointsSystem" ,"Bonus Points System",   true ),
     CLEAN_SHEETS       ("cleanSheets"       ,"Clean sheets",          true ),
     FORM               ("form"              ,"Form",                  true ),
     VALUE_FORM         ("valueForm"         ,"Value (form)",          true ),
     VALUE_SEASON       ("valueSeason"       ,"Value (season)",        true ),
     GW                 ("gw"                ,"GW",                    false),
     TRANSFERS_IN_ROUND ("transfersInRound"  ,"Transfers in (round)",  true ),
     TRANSFERS_OUT_ROUND("transfersOutRound" ,"Transfers out (round)", true ),
     PRICE_RISE_ROUND   ("priceRiseRound"    ,"Price rise (round)",    true ),
     PRICE_FALL_ROUND   ("priceFallRound"    ,"Price fall (round)",    true ),
     TRANSFERS_IN       ("transfersIn"       ,"Transfers in",          true ),
     TRANSFERS_OUT      ("transfersOut"      ,"Transfers out",         true ),
     PRICE_RISE         ("priceRise"         ,"Price rise",            true ),
     PRICE_FALL         ("priceFall"         ,"Price fall",            true ),
     TIMES_IN_DREAM_TEAM("timesInDreamTeam"  ,"Times in Dream Team",   true ),
     SAVES              ("saves"             ,"Saves",                 true ),
     YELLOW_CARDS       ("yellowCards"       ,"Yellow cards",          true ),
     RED_CARDS          ("redCards"          ,"Red cards",             true ),
     OWN_GOALS          ("ownGoals"          ,"Own goals",             true ),
     PENALTIES_MISSED   ("penaltiesMissed"   ,"Penalties missed",      true ),
     PENALTIES_SAVED    ("penaltiesSaved"    ,"Penalties saved",       true ),
     SELECTED           ("selected"          ,"Selected",              false),
     GOALS_CONCEDED     ("goalsConceded"     ,"Goals conceded",        true );

     private final String statName;
     private final String dropdownText;
     private final boolean isDropDownSelection;

     private PlayerStat(String statName, String dropdownText, boolean isDropDownSelection) {
          this.statName = statName;
          this.dropdownText = dropdownText;
          this.isDropDownSelection = isDropDownSelection;
     }

     public String getStatName() {
          return statName;
     }
     public String getDropdownText() {
          return dropdownText;
     }
     public boolean isDropDownDelection() {
          return isDropDownSelection;
     }
}
