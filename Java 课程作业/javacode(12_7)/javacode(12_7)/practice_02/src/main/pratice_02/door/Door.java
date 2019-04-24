package main.pratice_02.door;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import main.pratice_02.person.Guest;

/**
 * <p> the base class for all kinds of doors
 * 
 * @author Ping
 * @date 2018Äê12ÔÂ4ÈÕ
 */
public abstract class Door {
	private static final Logger logger = LogManager.getLogger(Door.class) ;
	/*
	 * Door states
	 */
	public enum DOOR_STATE {
		OPEN, CLOSED 
	}
	
	//public final String OPEN = "open" ;
	//public static final String CLOSED = "closed" ;
	/*
	 * ring states
	 */
	public enum RING_STATE {
		RINGED, SLIENT
	}
	protected DOOR_STATE doorState = DOOR_STATE.CLOSED ;
	protected RING_STATE ringState = RING_STATE.SLIENT ;
	/**
	 * 
	 * @function open door for all kinds of guests
	 * @param guest
	 */
	public abstract void open(Guest guest)  ;
	/**
	 * 
	 * @function
	 */
	public void close() {
		if (this.doorState == DOOR_STATE.CLOSED) {
			logger.info(" the door was alread closed .") ;
			return ;
		}
		this.doorState = DOOR_STATE.CLOSED ;
		logger.info(" the door was closed ." ) ;
		this.ringState = RING_STATE.SLIENT ;
		
	}
	
	public void ringBell() {
		this.ringState = RING_STATE.RINGED ;
		logger.info(" the door was ringing by guest now ...");
	}
	
	public boolean isRing() {
		return this.ringState == RING_STATE.RINGED ;
	}
	public DOOR_STATE getDoorState() {
		return this.doorState ;
	}
	
	
	
	
	
	
	
}
