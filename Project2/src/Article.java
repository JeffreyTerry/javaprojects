/**
 * Project #2
 * CS 2334, Section 011
 * 9/19/2013
 * <P>
 * This class represents an article published in a journal
 * </P>
 * @version 1.0
 */
public class Article extends Paper
{
	/* Instance Variables */
    
    /** The volume the paper is found in */ 
	private int volume;
	/** The issue the paper is found in */
	private int issue;
	
	/**
     * This constructor initializes all of the variables specific to an Article.
     * @param             authors      			an array of the author's names for this article. The first author should be the primary one.
     * @param             title        			the title of this article.
     * @param			  serialTitle  			the title of the journal publishing this article.
     * @param			  pageNumbers  			an array representing the first and last page numbers in the journal where this article is found.
     * @param			  date		   			the date this article was published.
     * @param 			  volume				the volume of the journal this article is found in.
     * @param 			  issue					the issue of the journal this article is found in.
     * @param			  digitalIdentifier		a digital identifier for the article such as a URL.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         all instance variables are initialized.
     */
	public Article(String[] authors, String title, String serialTitle, int[] pageNumbers,int volume, int issue, String date, String digitalIdentifier)
	{
		super(authors, title, serialTitle, pageNumbers, date, digitalIdentifier);
		this.volume=volume;
		this.issue=issue;
	}
	
	/**
     * This constructor initializes all of the variables specific to an Article except digitalIdentifier.
     * @param             authors      			an array of the author's names for this article. The first author should be the primary one.
     * @param             title        			the title of this article.
     * @param			  serialTitle  			the title of the journal publishing this article.
     * @param			  pageNumbers  			an array representing the first and last page numbers in the journal where this article is found.
     * @param			  date		   			the date this article was published.
     * @param 			  volume				the volume of the journal this article is found in.
     * @param 			  issue					the issue of the journal this article is found in.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         all instance variables are initialized except digitalIdentifier.
     */
	public Article(String[] authors, String title, String serialTitle, int[] pageNumbers,int volume, int issue, String date)
	{
		super(authors, title, serialTitle, pageNumbers, date);
		this.volume=volume;
		this.issue=issue;
	}

	/**
     * returns the volume of the journal where this article is found
     * <P>
     * @return            the volume of the journal where this article is found
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         volume is not void
     */
	public int getVolume() 
	{
		return volume;	
	}
	
	/**
     * returns the issue of the journal where this article is found
     * <P>
     * @return            the issue of the journal where this article is found
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         issue is not void
     */
	public int getIssue()
	{
		return issue;
	}
	
	public String toString()
	{
		String print;
		print="Journal Article";
		print+="<br />";
		for(String s:this.getAuthors())
			print+=s + "; ";
		print=print.substring(0, print.length()-2);
		print+="<br />";
		print+=this.getTitle();
		print+="<br />";
		print+=this.getSerialTitle();
		print+="<br />";
		print+=Integer.toString(volume);
		print+="("+Integer.toString(issue)+")";
		print+=":"+Integer.toString(this.getPageNumbers()[0])+"-"+Integer.toString(this.getPageNumbers()[1]);
		print+="<br />";
		print+=this.getDate();
		if(!this.getDigitalIdentifier().equals("N/A"))
			print+=this.getDigitalIdentifier();
		return print;
	}
}
