import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats.Player;
import uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats.exceptions.PlayerStatNotFoundException;

public class TestPlayerData {
	
	private static final Logger logger = LoggerFactory.getLogger(TestPlayerData.class);

	private Player player;
	
	@Before
	public void setUp() throws Exception {
		this.player = PlayerDataGenerator.getPlayer();
	}

	@Test
	public void testGetHeaders() {
		StringBuilder sb  = new StringBuilder();
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
		
	    assertEquals("Player Data Header String is incorrect", Player.getHeaders(), sb.toString());
	}

	@Test
	public void testGetData() {
		StringBuilder sb  = new StringBuilder();
		sb.append("1");
		sb.append("\t 2");
		sb.append("\t 3");
		sb.append("\t 4");
		sb.append("\t 5");
		sb.append("\t 6");
		sb.append("\t 7");
		sb.append("\t 8");
		sb.append("\t 9");
		sb.append("\t 10");
		sb.append("\t 11");
		sb.append("\t 12");
		sb.append("\t 13");
		sb.append("\t 14");
		sb.append("\t 15");
		sb.append("\t 16");
		sb.append("\t 17");
		sb.append("\t 18");
		sb.append("\t 19");
		sb.append("\t 20");
		sb.append("\t 21");
		sb.append("\t 22");
		sb.append("\t 23");
		sb.append("\t 24");
		sb.append("\t 25");
		sb.append("\t 26");
		sb.append("\t 27");
		sb.append("\t 28");
		sb.append("\t 29");
		sb.append("\t 30");
		sb.append("\t 31");
		sb.append("\t 32");
		sb.append("\t 33");
		sb.append("\t 34");
		sb.append("\t 35");
		sb.append("\t 36");
		
		sb.append(System.getProperty("line.separator"));
		
	    assertEquals("Player Data returned is incorrect", player.getData(), sb.toString());
	}
	
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
	public void testDynamicDataExceptions2() throws PlayerStatNotFoundException {
		thrown.expect(PlayerStatNotFoundException.class);
		thrown.expectMessage("ERROR: Found unknown statId: Key Does Not Exist");
		player.setDynamicValue("Key Does Not Exist", "0");
	}
	
	
	@Test
	public void testDynamicData() {
		try {
			player.setDynamicValue("valueSeason", "0");
			player.setDynamicValue("pointsPerGame", "1");
			assertEquals("player.getValueSeason() should be 0",   "0", player.getValueSeason());
			assertEquals("player.getPointsPerGame() should be 1", "1", player.getPointsPerGame());
		}
		catch(PlayerStatNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
