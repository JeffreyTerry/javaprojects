import java.io.Serializable;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * <P>
 * This class represents a paper. It has fields that represent its scholars, title, the title of its serial publication, page numbers, date pubished, and a didgital identifier.
 * </P>
 * @version 2.0
 */


public class Paper implements Comparable<Paper>, Serializable
{
	/* Instance Variables */
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The scholars of the paper */ 	
	private String[] scholars;
	/** The title of the paper */
	private String title;
	/** The title of the serial that published the paper */
	private String serialTitle;
	/** The first and last page number in the serial where this paper is found */
	private String[] pageNumbers;
	/** The date the paper was published */
	private String date;	//look into using Calendar or GregorianCalendar or something cooler
	/** A digital identifier such as a URL for the paper */
	private String digitalIdentifier;

	/**
	 * The default constructor
	 */
	public Paper(){
		scholars = new String[2];
		title = "";
		serialTitle = "";
		pageNumbers = new String[2];
		date = "";
		digitalIdentifier = "";
	}
	
	/**
     * Initializes all of the variables specific to a paper.
     * @param             scholars      			an array of the scholar's names for this paper. The first scholar should be the primary one.
     * @param             title        			the title of this paper.
     * @param			  serialTitle  			the title of the serial publishing this paper.
     * @param			  pageNumbers  			an array representing the first and last page numbers in the serial where this paper is found.
     * @param			  date		   			the date this paper was published.
     * @param			  digitalIdentifier		a digital identifier for the paper such as a URL.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         all instance variables are initialized.
     */
	public Paper(String[] scholars, String title, String serialTitle, String[] pageNumbers, String date, String digitalIdentifier)
	{
		this.scholars=scholars;
		this.title=title;
		this.serialTitle=serialTitle;
		this.pageNumbers=pageNumbers;
		this.date=date;
		this.digitalIdentifier=digitalIdentifier;
	}
	
	/**
     * This constructor initializes all of the variables specific to a paper except the digital identifier.
     * @param             scholars      			an array of the scholar's names for this paper. The first scholar should be the primary one.
     * @param             title        			the title of this paper.
     * @param			  serialTitle  			the title of the serial publishing this paper.
     * @param			  pageNumbers  			an array representing the first and last page numbers in the serial where this paper is found.
     * @param			  date		   			the date this paper was published.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         all instance variables are initialized except digitalIdentifier
     */
	public Paper(String[] scholars, String title, String serialTitle, String[] pageNumbers, String date)
	{
		this.scholars=scholars;
		this.title=title;
		this.serialTitle=serialTitle;
		this.pageNumbers=pageNumbers;
		this.date=date;
	}
	
	/*
     * Accessor Methods
     */
    
    /**
     * returns the scholars of the paper
     * <P>
     * @return            the scholars of the paper
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         scholars is not void
     */
	public String[] getScholars()
	{
		return scholars;
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
		return title;
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
		return serialTitle;
	}
	
	/**
     * returns the page numbers in the serial where this paper is found
     * <P>
     * @return            the page numbers in the serial where this paper is found
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         pageNumbers is not void
     */
	public String[] getPageNumbers()
	{
		return pageNumbers;
	}
	
	/**
     * returns the first page in the serial where this paper is found
     * <P>
     * @return            the first page in the serial where this paper is found
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         pageNumbers is not void
     */
	public String getFirstPage()
	{
		return pageNumbers[0];
	}
	
	/**
     * returns the last page in the serial where this paper is found
     * <P>
     * @return            the last page in the serial where this paper is found
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         pageNumbers is not void
     */
	public String getLastPage()
	{
		return pageNumbers[1];
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
		return date;
	}
	
	/**
     * returns the digital identifier associated with this paper. "N/A" is returned if there is no digital identifier
     * <P>
     * @return            digital identifier associated with this paper. "N/A" is returned if there is no digital identifier
     */
	public String getDigitalIdentifier()
	{
		if(!digitalIdentifier.equals(null))
			return digitalIdentifier;
		return "N/A";
	}

	/**
	 * Compares two papers using MLA bibliographic ordering
	 * <P>
	 * @param 			  other			the second Paper to compare
	 * @return			  -1,0, or 1
	 */
	public int compareTo(Paper other) 
	{
		String[] firstScholars = this.getScholars();
		String[] secondScholars = other.getScholars();
		
		int compare=0;
		int firstLength=firstScholars.length;
		int secondLength=secondScholars.length;
		int shorterLength = firstLength;
		if(firstLength>secondLength)
			shorterLength=secondLength;
		String scholar1;
		String scholar2;
		
		int i=0;
		while(compare == 0 && i<shorterLength)
		{
			scholar1=firstScholars[i].split(" ")[0];
			scholar2=secondScholars[i].split(" ")[0];
			compare=scholar1.compareTo(scholar2);
			i++;
		}
		if(compare == 0)
		{
			if(firstLength>secondLength)
				compare=1;
			if(firstLength<secondLength)
				compare=-1;
		}
		return compare;
	}
	
	/**
	 * This method returns the title of this paper
	 * @return	the title of this paper
	 */
	public String toString()
	{
		return this.getTitle();
	}
}
