package uk.co.kaboom.projets.fantasyfootball.stats.processing;

public interface IPageProcessor {

     public abstract void process(final String viewKey, final String sortKey);
     public abstract void process2(final String viewKey, final String sortKey);
     public String getDataToPersist();

}
