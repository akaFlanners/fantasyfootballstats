package uk.co.kaboom.projets.fantasyfootball.stats.model;

import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import uk.co.kaboom.projets.fantasyfootball.stats.exceptions.PlayerStatNotFoundException;

public interface IPlayerManager {

    public abstract Player generateScrapedPlayer(WebDriver driver, int i);
    public abstract Player generateScrapedPlayer(WebDriver driver, int i, Elements cols);

    public abstract Player generateScrapedPlayerWithoutChecks(WebDriver driver, int i);
    public abstract Player generateScrapedPlayerWithoutChecks(WebDriver driver, int i, Elements cols);

    public abstract boolean updatePlayer(Player p, WebDriver driver, int i, Player existingPlayer, PlayerStat stat)
            throws PlayerStatNotFoundException;
    public abstract boolean updatePlayer(Player p, WebDriver driver, int i, Player existingPlayer, PlayerStat stat, Elements cols)
            throws PlayerStatNotFoundException;

}