import java.util.ArrayList;
import java.util.Comparator;


/**
 * Project #2
 * CS 2334, Section 011
 * 9/24/2013
 * <P>
 * This class represents a list of publications.
 * </P>
 * @version 1.0
 */
public class PublicationList extends ArrayList<Paper> implements Comparator<Paper>{
	/*
     * Mutator Methods
     */
    
	 /**
     * Sorts papers by the date they were published
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         PublicationList is not empty
     * <dd>POST -         PublicationList is sorted by the date they were published
     */
	public void sortByDate()
	{
		//do stuff
	}
	
	 /**
     * Sorts papers by the type of serial they are (Journal or ConfereneProceeding)
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         PublicationList is not empty
     * <dd>POST -         PublicationList is sorted by the type of serial they are (Journal or ConfereneProceeding)
     */
	public void sortByType()
	{
		//do stuff
	}
	
	/**
     * Sorts papers by the digital identifier associated with it alphanumerically
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         PublicationList is not empty
     * <dd>POST -         PublicationList is sorted by the digital identifier associated with it alphanumerically
     */
	public void sortByDigitalIdentifier()
	{
		//do stuff
	}

	/**
    * This methods sorts papers by serial title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by serial title
    */
	public void sortBySerialTitle(){
		//TODO
	}

	/**
    * This methods sorts papers by paper title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by paper title
    */
	public void sortByPaperTitle(){
		//TODO
	}

	/**
    * This methods sorts papers by author
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by author
    */
	public void sortByAuthor(){
		//TODO
	}

	/**
    * This methods sorts papers by bibliographic info
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by bibliographic info
    */
	public void sortByBibliographicInfo(){
		//TODO
	}

	/**
    * This methods sorts papers by chronology
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by chronology
    */
	public void sortByChronology(){
		//TODO
	}

	/**
    * This methods sorts papers by title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by a random characteristic
    */
	public void randomSort(){
		//TODO
	}
	
	/**
    * This methods compares two papers by the author's last name
    */
	public int compare(Paper p1, Paper p2){
		//TODO
		return 0;
	}
}
