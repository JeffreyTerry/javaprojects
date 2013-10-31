package Jeff;

import java.awt.event.ActionEvent;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * This class represents a change in data in the model
 * @version 1.0
 */
public class DataChangeEvent extends ActionEvent{
	private static final long serialVersionUID = 1L;
	/** Used to indicate a scholar added event */
	public static final String SCHOLAR_ADDED = "scholaradded";
	/** Used to indicate a serial added event */
	public static final String SERIAL_ADDED = "serialadded";
	/** Used to indicate a paper added event */
	public static final String PAPER_ADDED = "paperadded";
	/** Used to indicate a scholar removed event */
	public static final String SCHOLAR_REMOVED = "scholarremoved";
	/** Used to indicate a serial removed event */
	public static final String SERIAL_REMOVED = "serialremoved";
	/** Used to indicate a paper removed event */
	public static final String PAPER_REMOVED = "paperremoved";

	/** A list of the objects added/removed that caused the event to be fired */
	private Object[] objectsChanged = null;
	
	/**
	 * The default constructor
	 * @param source	 The object that originated the event
	 * @param id		An integer that identifies the event
	 * @param command		A string that may specify a command (possibly one of several) associated with the event
	 * @param objects		The objects that caused the event
	 */
	public DataChangeEvent(Object source, int id, String command, Object[] objects){
		super(source, id, command);
		objectsChanged = objects;
	}
	
	public Object[] getObjectsChanged(){
		return objectsChanged;
	}
}
