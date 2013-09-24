import java.util.ArrayList;
import java.util.Comparator;

/**
 * Project #2
 * CS 2334, Section 011
 * 9/19/2013
 * <P>
 * This class represents a serial publication. It is comprised of an ArrayList of Papers.
 * </P>
 * @version 1.0
 */

public class Serial implements Comparator<Paper>
{
	/* Instance Variables */
    
    /** The name of the serial. */ 
	String name;
	/** The papers published in this serial. */ 
	ArrayList<? extends Paper> papers;
	
	/**
     * This constructor initializes the name of the Serial and assigns an ArrayList of Papers to papers.
     * <P>
     * @param             name      the name of the serial
     * @param             papers    an ArrayList of Paper variables published by this serial.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         name and papers are initialized.
     */
	public Serial(String name, ArrayList<? extends Paper> papers)
	{
		this.name = name;
		this.papers = papers;
	}
	
	/*
     * Accessor Methods
     */
    
    /**
     * This returns the name of the serial
     * <P>
     * @return            the name of the serial
     */
	public String getName()
	{
		return name;
	}
	
	/**
     * This returns the ArrayList of Paper (or extensions of Paper) variables associated with this serial.
     * <P>
     * @return            an ArrayList of Paper (or extensions of Paper) variables associated with this serial.
     */
	public ArrayList<? extends Paper> getPapers()
	{
		return papers;
	}
	
	/**
     * This returns an element of papers at a given index.
     * <P>
     * 
     * @param			  index		the index of papers to return
     * @return            the element of papers at the given index
     */
	public Paper getPaper(int index)
	{
		return papers.get(index);
	}
	
	/*
     * Mutator Methods
     */
    
    /**
     * This sorts papers by the last name of the primary author
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by the primary author's last name
     */
	public void sortByAuthors()
	{
		//do stuff
	}
	
	 /**
     * This sorts papers by title
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by title
     */
	public void sortByTitle()
	{
		//do stuff
	}

	 /**
     * This sorts papers by the date they were published
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by the date they were published
     */
	public void sortByDate()
	{
		//do stuff
	}
	
	 /**
     * This sorts papers by the type of serial they are (Journal or ConfereneProceeding)
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by the type of serial they are (Journal or ConfereneProceeding)
     */
	public void sortByType()
	{
		//do stuff
	}
	
	/**
     * This sorts papers by the digital identifier associated with it alphanumerically
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by the digital identifier associated with it alphanumerically
     */
	public void sortByDigitalIdentifier()
	{
		//do stuff
	}
	
	/*
     * Mutator Methods
     */
    
    /**
     * This adds a Paper to the ArrayList papers
     * <P>
     * @param             paper      the Paper to be added
     * <dt><b>Conditions:</b>
     * <dd>POST -         pre papers.size()+1 = post papers.size()
     */
	public void addPaper(Paper paper)
	{	
		//do stuff
	}
	
	
	/** 
	 * This compares two papers to one another
	 * <P>
	 * @param 			  o1		the first paper to be compared
	 * @param			  o2		the second paper to be compared
	 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where the primary author being alphanumerically before another is considered less than.
	 */
	public int compare(Paper arg0, Paper arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*
	 * http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
	 */
}
