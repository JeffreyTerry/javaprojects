
/**
 * Project #2
 * CS 2334, Section 011
 * 9/19/2013
 * <P>
 * This class represents a conference paper published in a conference proceeding.
 * </P>
 * @version 1.0
 */

public class ConferencePaper extends Paper
{
	/**
     * This constructor initializes all of the variables specific to a ConferencePaper.
     * @param             authors      			an array of the author's names for this conference paper. The first author should be the primary one.
     * @param             title        			the title of this conference paper.
     * @param			  serialTitle  			the title of the serial publishing this conference paper.
     * @param			  pageNumbers  			an array representing the first and last page numbers in the serial where this conference paper is found.
     * @param			  date		   			the date this conference paper was published.
     * @param			  digitalIdentifier		a digital identifier for the conference paper such as a URL.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         all instance variables are initialized.
     */
	public ConferencePaper(String[] authors, String title, String serialTitle, int[] pageNumbers, String date, String digitalIdentifier)
	{
		super(authors, title, serialTitle, pageNumbers, date, digitalIdentifier);
	}
	public String toString()
	{
		String print;
		print="Conference Paper";
		print+="<br />";
		for(String s:this.getAuthors())
			print+=s + "; ";
		print=print.substring(0, print.length()-2);
		print+="<br />";
		print+=this.getTitle();
		print+="<br />";
		print+=this.getSerialTitle();
		print+="<br />";
		print+=Integer.toString(this.getPageNumbers()[0])+"-"+Integer.toString(this.getPageNumbers()[1]);
		print+="<br />";
		print+=this.getDate();
		print+="<br />";
		if(!this.getDigitalIdentifier().equals("N/A"))
			print+=this.getDigitalIdentifier();
		return print;
	}
}
