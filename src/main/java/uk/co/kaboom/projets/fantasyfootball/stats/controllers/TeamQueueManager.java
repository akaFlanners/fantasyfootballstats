package uk.co.kaboom.projets.fantasyfootball.stats.controllers;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import uk.co.kaboom.projets.fantasyfootball.stats.model.Team;

/**
 * Singleton to manage Queue of teams.
 * Teams come from the teams Enum and are pushed to queue on instantiation, popped off as allocated and completed.
 * @author FlannersAdmin
 *
 */
public enum TeamQueueManager {
	INSTANCE;
	
	private Set<Team> waitingQueue    = Collections.synchronizedSet(EnumSet.allOf(Team.class));
	private Set<Team> processingQueue = Collections.synchronizedSet(EnumSet.noneOf(Team.class));
	private Set<Team> completedQueue  = Collections.synchronizedSet(EnumSet.noneOf(Team.class));
	
	/**
	 * Change state of this team from waiting to processing. i.e. allocated to a thread
	 * @return
	 */
    public synchronized Team getNext() {
    	if(waitingQueue.iterator().hasNext()) {
    		Team team = waitingQueue.iterator().next();
    		waitingQueue.remove(team);
    		processingQueue.add(team);
    		return team;
    	}
    	return null;
    }

    /**
     * Change status of this team from processing to completed.
     * Check if the final team has been completed.
     * @param team
     * @return boolean indicating if this was the last team.
     */
    public synchronized boolean completed(Team team) {
    	processingQueue.remove(team);
    	completedQueue.add(team);

    	if(completedQueue.size() == Team.values().length) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
     
}
