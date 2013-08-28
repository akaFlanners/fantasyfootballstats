package uk.co.kaboom.projets.fantasyfootball.stats.config;

public enum URLConfig {
    MAIN_FPL_URL("http://fantasy.premierleague.com/stats/elements/");
    
    private final String url;
    
    private URLConfig(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
