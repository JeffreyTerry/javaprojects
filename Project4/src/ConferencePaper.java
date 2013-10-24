import java.io.Serializable;


/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * <P>
 * This class represents a conference paper published in a conference proceeding.
 * </P>
 * @version 2.0
 */

public class ConferencePaper extends Paper implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The default constructor
	 */
	public ConferencePaper(){
		super(new String[]{"",""}, "", "", new String[]{"",""}, "", "");
	}
	
	/**
     * This constructor initializes all of the variables specific to a ConferencePaper.
     * @param             scholars      			an array of the scholar's names for this conference paper. The first scholar should be the primary one.
     * @param             title        			the title of this conference paper.
     * @param			  serialTitle  			the title of the serial publishing this conference paper.
     * @param			  pageNumbers  			an array representing the first and last page numbers in the serial where this conference paper is found.
     * @param			  date		   			the date this conference paper was published.
     * @param			  digitalIdentifier		a digital identifier for the conference paper such as a URL.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         all instance variables are initialized.
     */
	public ConferencePaper(String[] scholars, String title, String serialTitle, String[] pageNumbers, String date, String digitalIdentifier)
	{
		super(scholars, title, serialTitle, pageNumbers, date, digitalIdentifier);
	}
	
	/**
     * returns a String representation of the object in the same format it was read in.
     * <P>
     * @return            a String representation of the object in the same format it was read in.
     */
	public String toString()
	{
		String print;
		print="Conference Paper";
		print+="<br />";
		for(String s:this.getScholars())
			print+=s + "; ";
		print=print.substring(0, print.length()-2);
		print+="<br />";
		print+=this.getTitle();
		print+="<br />";
		print+=this.getSerialTitle();
		print+="<br />";
		print+=getPageNumbers()[0]+"-"+getPageNumbers()[1];
		print+="<br />";
		print+=this.getDate();
		print+="<br />";
		if(!this.getDigitalIdentifier().equals("N/A"))
			print+=this.getDigitalIdentifier();
		return print;
	}
}
