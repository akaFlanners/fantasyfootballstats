package uk.co.kaboom.projets.fantasyfootball.stats.model;

public enum PlayerStat {
	PLAYER_INDEX       ("playerIndex"       ,"",                      false),
	PLAYER             ("player"            ,"",                      false),
	TEAM               ("team"              ,"",                      false),
	POS                ("pos"               ,"",                      false),
	SELECTED           ("selected"          ,"",                      false),
	PRICE              ("price"             ,"",                      false),
	GW                 ("gw"                ,"",                      false),
	TOTAL_SCORE        ("totalScore"        ,"",                      false),
	MINUTES_PLAYED     ("minutesPlayed"     ,"Minutes played",        true ),
	GOALS_SCORED       ("goalsScored"       ,"Goals scored",          true ),
	ASSISTS            ("assists"           ,"Assists",               true ),
	CLEAN_SHEETS       ("cleanSheets"       ,"Clean sheets",          true ),
	GOALS_CONCEDED     ("goalsConceded"     ,"Goals conceded",        true ),
	OWN_GOALS          ("ownGoals"          ,"Own goals",             true ),
	PENALTIES_SAVED    ("penaltiesSaved"    ,"Penalties saved",       true ),
	PENALTIES_MISSED   ("penaltiesMissed"   ,"Penalties missed",      true ),
	YELLOW_CARDS       ("yellowCards"       ,"Yellow cards",          true ),
	RED_CARDS          ("redCards"          ,"Red cards",             true ),
	SAVES              ("saves"             ,"Saves",                 true ),
	BONUS              ("bonus"             ,"Bonus",                 true ),
	EA_SPORTS_PPI      ("eaSportsPPI"       ,"EA SPORTS PPI",         true ),
	FORM               ("form"              ,"Form",                  true ),
	TIMES_IN_DREAM_TEAM("timesInDreamTeam"  ,"Times in Dream Team",   true ),
	VALUE_FORM         ("valueForm"         ,"Value (form)",          true ),
	VALUE_SEASON       ("valueSeason"       ,"Value (season)",        true ),
	POINTS_PER_GAME    ("pointsPerGame"     ,"Points per game",       true ),
	TRANSFERS_IN       ("transfersIn"       ,"Transfers in",          true ),
	TRANSFERS_OUT      ("transfersOut"      ,"Transfers out",         true ),
	TRANSFERS_IN_ROUND ("transfersInRound"  ,"Transfers in (round)",  true ),
	TRANSFERS_OUT_ROUND("transfersOutRound" ,"Transfers out (round)", true ),
	PRICE_RISE         ("priceRise"         ,"Price rise",            true ),
	PRICE_FALL         ("priceFall"         ,"Price fall",            true ),
	PRICE_RISE_ROUND   ("priceRiseRound"    ,"Price rise (round)",    true ),
	PRICE_FALL_ROUND   ("priceFallRound"    ,"Price fall (round)",    true );
	
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
