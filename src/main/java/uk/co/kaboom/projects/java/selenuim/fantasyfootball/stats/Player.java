package uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats.exceptions.PlayerStatNotFoundException;

public class Player {
	
	private static final Logger logger = LoggerFactory.getLogger(Player.class);

	private String playerIndex;
	private String player;    
	private String team;      
	private String pos;       
	private String selected;  
	private String price;     
	private String gw;        
	private String totalScore;
	private String roundScore;
	private String teamsSelectedBy;
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
	
	public String getPlayerIndex() {
		return playerIndex;
	}
	public void setPlayerIndex(String playerIndex) {
		this.playerIndex = playerIndex;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGw() {
		return gw;
	}
	public void setGw(String gw) {
		this.gw = gw;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public String getRoundScore() {
		return roundScore;
	}
	public void setRoundScore(String roundScore) {
		this.roundScore = roundScore;
	}
	public String getTeamsSelectedBy() {
		return teamsSelectedBy;
	}
	public void setTeamsSelectedBy(String teamsSelectedBy) {
		this.teamsSelectedBy = teamsSelectedBy;
	}
	public String getMinutesPlayed() {
		return minutesPlayed;
	}
	public void setMinutesPlayed(String minutesPlayed) {
		this.minutesPlayed = minutesPlayed;
	}
	public String getGoalsScored() {
		return goalsScored;
	}
	public void setGoalsScored(String goalsScored) {
		this.goalsScored = goalsScored;
	}
	public String getAssists() {
		return assists;
	}
	public void setAssists(String assists) {
		this.assists = assists;
	}
	public String getCleanSheets() {
		return cleanSheets;
	}
	public void setCleanSheets(String cleanSheets) {
		this.cleanSheets = cleanSheets;
	}
	public String getGoalsConceded() {
		return goalsConceded;
	}
	public void setGoalsConceded(String goalsConceded) {
		this.goalsConceded = goalsConceded;
	}
	public String getOwnGoals() {
		return ownGoals;
	}
	public void setOwnGoals(String ownGoals) {
		this.ownGoals = ownGoals;
	}
	public String getPenaltiesSaved() {
		return penaltiesSaved;
	}
	public void setPenaltiesSaved(String penaltiesSaved) {
		this.penaltiesSaved = penaltiesSaved;
	}
	public String getPenaltiesMissed() {
		return penaltiesMissed;
	}
	public void setPenaltiesMissed(String penaltiesMissed) {
		this.penaltiesMissed = penaltiesMissed;
	}
	public String getYellowCards() {
		return yellowCards;
	}
	public void setYellowCards(String yellowCards) {
		this.yellowCards = yellowCards;
	}
	public String getRedCards() {
		return redCards;
	}
	public void setRedCards(String redCards) {
		this.redCards = redCards;
	}
	public String getSaves() {
		return saves;
	}
	public void setSaves(String saves) {
		this.saves = saves;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getEaSportsPPI() {
		return eaSportsPPI;
	}
	public void setEaSportsPPI(String eaSportsPPI) {
		this.eaSportsPPI = eaSportsPPI;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getTimesInDreamTeam() {
		return timesInDreamTeam;
	}
	public void setTimesInDreamTeam(String timesInDreamTeam) {
		this.timesInDreamTeam = timesInDreamTeam;
	}
	public String getValueForm() {
		return valueForm;
	}
	public void setValueForm(String valueForm) {
		this.valueForm = valueForm;
	}
	public String getValueSeason() {
		return valueSeason;
	}
	public void setValueSeason(String valueSeason) {
		this.valueSeason = valueSeason;
	}
	public String getPointsPerGame() {
		return pointsPerGame;
	}
	public void setPointsPerGame(String pointsPerGame) {
		this.pointsPerGame = pointsPerGame;
	}
	public String getTransfersIn() {
		return transfersIn;
	}
	public void setTransfersIn(String transfersIn) {
		this.transfersIn = transfersIn;
	}
	public String getTransfersOut() {
		return transfersOut;
	}
	public void setTransfersOut(String transfersOut) {
		this.transfersOut = transfersOut;
	}
	public String getTransfersInRound() {
		return transfersInRound;
	}
	public void setTransfersInRound(String transfersInRound) {
		this.transfersInRound = transfersInRound;
	}
	public String getTransfersOutRound() {
		return transfersOutRound;
	}
	public void setTransfersOutRound(String transfersOutRound) {
		this.transfersOutRound = transfersOutRound;
	}
	public String getPriceRise() {
		return priceRise;
	}
	public void setPriceRise(String priceRise) {
		this.priceRise = priceRise;
	}
	public String getPriceFall() {
		return priceFall;
	}
	public void setPriceFall(String priceFall) {
		this.priceFall = priceFall;
	}
	public String getPriceRiseRound() {
		return priceRiseRound;
	}
	public void setPriceRiseRound(String priceRiseRound) {
		this.priceRiseRound = priceRiseRound;
	}
	public String getPriceFallRound() {
		return priceFallRound;
	}
	public void setPriceFallRound(String priceFallRound) {
		this.priceFallRound = priceFallRound;
	}
	
	public boolean isMatch(Player p) {
		if(
				this.getPlayer().equals(p.getPlayer()) && 
				this.getTeam().equals(p.getTeam()) &&
				this.getPos().equals(p.getPos()) &&	
				this.getSelected().equals(p.getSelected()) &&	
				this.getPrice().equals(p.getPrice()) &&	
				this.getGw().equals(p.getGw())
		) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setDynamicValue(String key, String value) throws PlayerStatNotFoundException {
		switch (key) {
			case "totalScore": this.setTotalScore(value);break;
			case "roundScore": this.setRoundScore(value);break;
			case "price": this.setPrice(value);break;
			case "teamsSelectedBy": this.setTeamsSelectedBy(value);break;
			case "minutesPlayed": this.setMinutesPlayed(value);break;
			case "goalsScored": this.setGoalsScored(value);break;
			case "assists": this.setAssists(value);break;
			case "cleanSheets": this.setCleanSheets(value);break;
			case "goalsConceded": this.setGoalsConceded(value);break;
			case "ownGoals": this.setOwnGoals(value);break;
			case "penaltiesSaved": this.setPenaltiesSaved(value);break;
			case "penaltiesMissed": this.setPenaltiesMissed(value);break;
			case "yellowCards": this.setYellowCards(value);break;
			case "redCards": this.setRedCards(value);break;
			case "saves": this.setSaves(value);break;
			case "bonus": this.setBonus(value);break;
			case "eaSportsPPI": this.setEaSportsPPI(value);break;
			case "form": this.setForm(value);break;
			case "timesInDreamTeam": this.setTimesInDreamTeam(value);break;
			case "valueForm": this.setValueForm(value);break;
			case "valueSeason": this.setValueSeason(value);break;
			case "pointsPerGame": this.setPointsPerGame(value);break;
			case "transfersIn": this.setTransfersIn(value);break;
			case "transfersOut": this.setTransfersOut(value);break;
			case "transfersInRound": this.setTransfersInRound(value);break;
			case "transfersOutRound": this.setTransfersOutRound(value);break;
			case "priceRise": this.setPriceRise(value);break;
			case "priceFall": this.setPriceFall(value);break;
			case "priceRiseRound": this.setPriceRiseRound(value);break;
			case "priceFallRound": this.setPriceFallRound(value);break;
			default: throw new PlayerStatNotFoundException("ERROR: Found unknown statId: " + key);
		}
	}
	
	
	public static String getHeaders() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Assists");
		sb.append("\t Bonus");
		sb.append("\t Clean Sheets");
		sb.append("\t EA Sports PPI");
		sb.append("\t Form");
		sb.append("\t Goals Conceeded");
		sb.append("\t Goals Scored");
		sb.append("\t GW");
		sb.append("\t Minutes Played");
		sb.append("\t Own Goals");
		sb.append("\t Penalties Missed");
		sb.append("\t Penalties Saved");
		sb.append("\t Player");
		sb.append("\t Player Index");
		sb.append("\t Points Per Game");
		sb.append("\t Pos");
		sb.append("\t Price");
		sb.append("\t Price Fall");
		sb.append("\t Price Fall Round");
		sb.append("\t Price Rise");
		sb.append("\t Price Rise Round");
		sb.append("\t Red Cards");
		sb.append("\t Round Score");
		sb.append("\t Saves");
		sb.append("\t Selected");
		sb.append("\t Team");
		sb.append("\t Teams Selected By");
		sb.append("\t Times In Dream Team");
		sb.append("\t Total Score");
		sb.append("\t Transfers In");
		sb.append("\t Transfers In Round");
		sb.append("\t Transfers Out");
		sb.append("\t Transfers Out Round");
		sb.append("\t Value Form");
		sb.append("\t Value Season");
		sb.append("\t Yellow Cards");
		
		sb.append(System.getProperty("line.separator"));
		
		return sb.toString();
	}
	
	public String getData() {
		StringBuilder sb = new StringBuilder();
		//sb.append("\t ");
		sb.append(getAssists());
		
		sb.append("\t ");
		sb.append(getBonus());
		
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
		sb.append(getRoundScore());
		
		sb.append("\t ");
		sb.append(getSaves());
		
		sb.append("\t ");
		sb.append(getSelected());
		
		sb.append("\t ");
		sb.append(getTeam());
		
		sb.append("\t ");
		sb.append(getTeamsSelectedBy());
		
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
		
		sb.append(System.getProperty("line.separator"));

		return sb.toString();
	}

}
