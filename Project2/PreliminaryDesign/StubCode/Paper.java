
/**
 * Project #2
 * CS 2334, Section 011
 * 9/19/2013
 * <P>
 * This class represents a paper. It has fields that represent its authors, title, the title of its serial publication, page numbers, date pubished, and a didgital identifier.
 * </P>
 * @version 1.0
 */

public class Paper implements Comparable<Paper>
{
	/* Instance Variables */
    
    /** The authors of the paper */ 	
	String[] authors;
	/** The title of the paper */
	String title;
	/** The title of the serial that published the paper */
	String serialTitle;
	/** The first and last page number in the serial where this paper is found */
	int[] pageNumbers;
	/** The date the paper was published */
	String date;	//look into using Calendar or GregorianCalendar or something cooler
	/** A digital identifier such as a URL for the paper */
	String digitalIdentifier;
	
	/**
     * Initializes all of the variables specific to a paper.
     * @param             authors      			an array of the author's names for this paper. The first author should be the primary one.
     * @param             title        			the title of this paper.
     * @param			  serialTitle  			the title of the serial publishing this paper.
     * @param			  pageNumbers  			an array representing the first and last page numbers in the serial where this paper is found.
     * @param			  date		   			the date this paper was published.
     * @param			  digitalIdentifier		a digital identifier for the paper such as a URL.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         all instance variables are initialized.
     */
	public Paper(String[] authors, String title, String serialTitle, int[] pageNumbers, String date, String digitalIdentifier)
	{
	}
	
	/**
     * This constructor initializes all of the variables specific to a paper except the digital identifier.
     * @param             authors      			an array of the author's names for this paper. The first author should be the primary one.
     * @param             title        			the title of this paper.
     * @param			  serialTitle  			the title of the serial publishing this paper.
     * @param			  pageNumbers  			an array representing the first and last page numbers in the serial where this paper is found.
     * @param			  date		   			the date this paper was published.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         all instance variables are initialized except digitalIdentifier
     */
	public Paper(String[] authors, String title, String serialTitle, int[] pageNumbers, String date)
	{
	}
	
	/*
     * Accessor Methods
     */
    
    /**
     * returns the authors of the paper
     * <P>
     * @return            the authors of the paper
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         authors is not void
     */
	public String[] getAuthors()
	{
	}
	
	/**
     * returns the title of the paper
     * <P>
     * @return            the title of the paper
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         title is not void
     */
	public String getTitle()
	{
	}
	
	/**
     * returns the name of the serial the paper is published in
     * <P>
     * @return            the name of the serial the paper is published in
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         serialTitle is not void
     */
	public String getSerialTitle()
	{
	}
	
	/**
     * returns the page numbers in the serial where this paper is found
     * <P>
     * @return            the page numbers in the serial where this paper is found
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         pageNumbers is not void
     */
	public int[] getPageNumbers()
	{
	}
	
	/**
     * returns the first page in the serial where this paper is found
     * <P>
     * @return            the first page in the serial where this paper is found
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         pageNumbers is not void
     */
	public int getFirstPage()
	{
	}
	
	/**
     * returns the last page in the serial where this paper is found
     * <P>
     * @return            the last page in the serial where this paper is found
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         pageNumbers is not void
     */
	public int getLastPage()
	{
	}
	
	/**
     * returns the date that the paper was published
     * <P>
     * @return            the date that the paper was published
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         date is not void
     */
	public String getDate()
	{
	}
	
	/**
     * returns the digital identifier associated with this paper. "N/A" is returned if there is no digital identifier
     * <P>
     * @return            digital identifier associated with this paper. "N/A" is returned if there is no digital identifier
     */
	public String getDigitalIdentifier()
	{
	}

	/**
	 * Compares two papers using MLA bibliographic ordering
	 * <P>
	 * @param 			  other			the second Paper to compare
	 * @return			  0
	 */
	public int compareTo(Paper other) 
	{
	}
}
