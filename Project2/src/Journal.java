import java.util.ArrayList;

/**
 * Project #2
 * CS 2334, Section 011
 * 9/19/2013
 * <P>
 * This class represents a Journal publication. It is comprised of an ArrayList of Articles.
 * </P>
 * @version 1.0
 */

public class Journal extends Serial
{
	/**
     * This constructor initializes name and papers for the super class Serial, but forces the user to enter only Article Papers.
     * @param             name      the name of the serial
     * @param             papers    an ArrayList of Article variables published by this journal.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         name and papers are initialized.
     */
	public Journal(String name, ArrayList<Article> papers) 
	{
		super(name, papers);
	}
}