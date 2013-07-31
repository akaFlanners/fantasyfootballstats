package uk.co.kaboom.projets.fantasyfootball.stats.processing;

import uk.co.kaboom.projets.fantasyfootball.stats.model.PlayerStat;

public interface IPageProcessor {

     public abstract void process(final String viewKey, final PlayerStat stat);
     public abstract void process2(final String viewKey, final PlayerStat stat);
     public String getDataToPersist();

}
