package uk.co.kaboom.projets.fantasyfootball.stats.processing;

public interface IPageProcessor {

	public abstract void process(String viewKey, String sortKey);
	public abstract void process2(String viewKey, String sortKey);
	public String getDataToPersist();

}
