import java.util.ArrayList;
import java.util.Comparator;


/**
 * Project #2
 * CS 2334, Section 011
 * 9/24/2013
 * <P>
 * This class represents a list of publications.
 * </P>
 * @version 1.0
 */
public class PublicationList extends ArrayList<Paper> implements Comparator<Paper>{
	/*
     * Mutator Methods
     */
    
	 /**
     * Sorts papers by the date they were published
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         PublicationList is not empty
     * <dd>POST -         PublicationList is sorted by the date they were published
     */
	public void sortByDate()
	{
		//do stuff
	}
	
	 /**
     * Sorts papers by the type of serial they are (Journal or ConfereneProceeding)
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         PublicationList is not empty
     * <dd>POST -         PublicationList is sorted by the type of serial they are (Journal or ConfereneProceeding)
     */
	public void sortByType()
	{
		//do stuff
	}
	
	/**
     * Sorts papers by the digital identifier associated with it alphanumerically
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         PublicationList is not empty
     * <dd>POST -         PublicationList is sorted by the digital identifier associated with it alphanumerically
     */
	public void sortByDigitalIdentifier()
	{
		//do stuff
	}

	/**
    * This methods sorts papers by serial title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by serial title
    */
	public void sortBySerialTitle(){
		//TODO
	}

	/**
    * This methods sorts papers by paper title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by paper title
    */
	public void sortByPaperTitle(){
		//TODO
	}

	/**
    * This methods sorts papers by author
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by author
    */
	public void sortByAuthor(){
		//TODO
	}

	/**
    * This methods sorts papers by bibliographic info
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by bibliographic info
    */
	public void sortByBibliographicInfo(){
		//TODO
	}

	/**
    * This methods sorts papers by title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by a random characteristic
    */
	public void randomSort(){
		//TODO
	}
	
	public static Comparator<Paper>  authorComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their author
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where the primary author being alphanumerically before another is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			//do Stuff
			return 0;
		}
	};
	
	
	public static Comparator<Paper>  titleComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their title
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where the title being alphanumerically before another is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			//do Stuff
			return 0;
		}
	};

	public static Comparator<Paper>  dateComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their date of publication
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where the date being before another is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			//do Stuff
			return 0;
		}
	};

	
	public static Comparator<Paper>  typeComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their type of Paper (Article/ConferencePaper)
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where an Article is considered less than a ConferencePaper.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			//do Stuff
			return 0;
		}
	};
	

	public static Comparator<Paper>  diComparator = new Comparator<Paper>() 
	{	
		/** 
		 * This compares two papers to one another by their digital identifier
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where the digital identifier being alphanumerically before another is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			//do Stuff
			return 0;
		}
	};
	

	public static Comparator<Paper>  volumeComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their volume
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where a lower numbered volume is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			//do Stuff
			return 0;
		}
	};
	
	
	public static Comparator<Paper>  issueComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their issue
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where a lower numbered issue is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			//do Stuff
			return 0;
		}
	};
	
	
	public static Comparator<Paper>  lengthComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their length
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where a shorter length is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			//do Stuff
			return 0;
		}
	};
	
	
	public static Comparator<Paper>  firstPageComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their first page
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where the an earlier page is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			//do Stuff
			return 0;
		}
	};
	
	/**
    * This methods compares two papers by the author's last name
    */
	public int compare(Paper p1, Paper p2){
		//TODO
		return 0;
	}
}
