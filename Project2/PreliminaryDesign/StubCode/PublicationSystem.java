/**
 * Project #2
 * CS 2334, Section 011
 * 9/24/2013
 * <P>
 * This class represents a publication system, which allows for importing, printing, sorting, and searching of lists of publications.
 * </P>
 * @version 1.0
 */
public class PublicationSystem {
	/* Instance Variables */
	
	/**A list of all publications in the system*/
	private PublicationList publicationList;

	/**
     * Creates a publication system with no publications
     */
	public PublicationSystem(){
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
     * <dt><b>Conditions:</b>
     * <dd>POST -         papers is sorted by the date they were published
     */
	public void sortByDate()
	{
		publicationList.sortByDate();
	}
	
	 /**
     * This sorts papers by the type of serial they are (Journal or ConfereneProceeding)
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>POST -         papers is sorted by the type of serial they are (Journal or ConfereneProceeding)
     */
	public void sortByType()
	{
		publicationList.sortByType();
	}
	
	/**
     * This sorts papers by the digital identifier associated with it alphanumerically
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>POST -         papers is sorted by the digital identifier associated with it alphanumerically
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
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by serial title
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
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by paper title
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
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by author
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
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by bibliographic info
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
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by a random characteristic
    */
	public void randomSort(){
		publicationList.randomSort();
	}
	
	public void importPublication(){
		//TODO
	}
	
	/*
	 * Accessor Methods
	 */
	
	public PublicationList getPublicationList(){
		return publicationList;
	}

	 /**
    * This prints the publications to a file
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>PRE  -         papers is not null
    * <dd>POST -         papers is correctly printed to the file <i>fileName</i>
    */
	public void printPublicationsToFile(String fileName){
	}
	
	/**
	 * Searches for a paper by title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         The correct paper is returned. A value of null is returned on failure.
	 */
	public Paper getPaper(String title){
		Paper paper = null;
		//TODO
		return paper;
	}
}
