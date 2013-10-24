import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * <P>
 * This class represents a publication system, which allows for importing, printing, sorting, and searching of lists of publications.
 * </P>
 * @version 2.0
 */
public class PublicationSystem implements Serializable{
	/* Instance Variables */
	
	/**A list of all publications in the system*/
	private PublicationList publicationList;
	
	/**A map of author names to authors*/
	private AuthorMap authorMap;

	/**
     * Creates a publication system with no publications
     */
	public PublicationSystem(){
		publicationList = new PublicationList();
		authorMap = new AuthorMap();
	}
	
	/**
	 * creates a publication system from a binary file
	 * @param fileName	the file name to be read
	 */
	public PublicationSystem(String fileName)
	{
		//TODO
	}
	/*
     * Mutator Methods
     */
	
	 /**
     * This sorts papers by the date they were published
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     */
	public void sortByDate()
	{
		publicationList.sortByDate();
	}
	
	/**
     * This sorts papers by the digital identifier associated with it alphanumerically
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     */
	public void sortByDigitalIdentifier()
	{
		publicationList.sortByDigitalIdentifier();
	}

	/**
    * This methods sorts papers by serial title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    */
	public void sortBySerialTitle(){
		publicationList.sortBySerialTitle();
	}

	/**
    * This methods sorts papers by paper title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    */
	public void sortByPaperTitle(){
		publicationList.sortByPaperTitle();
	}

	/**
    * This methods sorts papers by author
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    */
	public void sortByAuthor(){
		publicationList.sortByAuthor();
	}

	/**
    * This methods sorts papers by bibliographic info
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    */
	public void sortByBibliographicInfo(){
		publicationList.sortByBibliographicInfo();
	}

	/**
    * This methods sorts papers by title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    */
	public void randomSort(){
		publicationList.randomSort();
	}
	
	/**
	 * Imports a publication from a file given by the user
	 */
	public void importPublication(){
		//TODO
	}
	
	/**
	 * reads a publicationSystem from a text file
	 * @param fileReader	the fileReader to use
	 * @throws IOException
	 */
	private void readPaper(BufferedReader fileReader) throws IOException{
		//TODO
	}
	
	/*
	 * Accessor Methods
	 */
	
	/**
	 * returns the publicationList
	 * @return	the publication list
     * <P>
	 */
	public PublicationList getPublicationList(){
		return publicationList;
	}

	 /**
    * This prints the publications to a text file
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
	 * @throws IOException 
    */
	public void printPublicationsToFile(String fileName) throws IOException{
		//TODO
	}
	
	/**
	 * Searches for a paper by title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * @return a Paper with the title given
	 */
	public Paper getPaperBinary(String title){
		return null;
		//TODO
	}
	
	/**
     * This searches publicationList linearly
     * <P>
     * Algorithm:<br>
     * For loop.<br>
     * @return a Paper with the given title
     * </P>
     */
	public Paper getPaperLinear(String title){
		//TODO
		return null;
	}

	/**
     * This searches publicationList linearly
     * <P>
     * Algorithm:<br>
     * For loop.<br>
     * @return A list of Papers containing the given title
     * </P>
     */
	public ArrayList<Paper> getPapers(String title){
		ArrayList<Paper> papers = new ArrayList<Paper>(); 
		//TODO
		return papers;
	}

	/**
     * Returns how many comparisons must be performed to find a title searching using a binary search.
     * <P>
     * </P>
     * @return the number of comparisons performed
     */
	public int getSearchComparisonsBI(String title)
	{
		int count=0;
		//TODO
		return count;
	}

	/**
     * Returns how many comparisons must be performed to find a title searching using a linear search.
     * <P>
     * @return the number of comparisons performed
     * </P>
     */
	public int getSearchComparisonsLI(String title)
	{
		int count=0;
		//TODO
		return count;
	}

	/**
	 * returns an Author from the authorMap
	 * @param auth		the Author's name
	 * @return			the Author variable
	 */
	public Author getAuthor(String auth){ //TODO
		return authorMap.get(auth);
	}
	
	/**
	 * writes the object to a binary file
	 * @param fileName	the file to write to
	 */
	public void writeToBinaryFile(String fileName)
	{
		//TODO
	}
}
