import java.util.ArrayList;

/**
 * Project #2
 * CS 2334, Section 011
 * 9/19/2013
 * <P>
 * This class represents a Conference Proceeding publication. It is comprised of an ArrayList of ConferencePapers.
 * </P>
 * @version 1.0
 */

public class ConferenceProceeding extends Serial
{
	/**
     * This constructor initializes name and papers for the super class Serial, but forces the user to enter only ConferencePaper Papers.
     * @param             name      the name of the serial
     * @param             papers    an ArrayList of ConferencePaper variables published by this conference proceeding.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         name and papers are initialized.
     */
	public ConferenceProceeding(String name,ArrayList<ConferencePaper> papers)
	{
		super(name,new ArrayList<Paper>(papers));
	}
}
