import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * <P>
 * This class represents a list of publications.
 * </P>
 * @version 2.0
 */
public class PublicationList extends ArrayList<Paper> implements Comparator<Paper>, Serializable{
	/*
     * Mutator Methods
     */
    
	 /**
	 * the serial version ID
	 */
	private static final long serialVersionUID = 1L;

	public PublicationList()
	{
		super();
	}
	
	/**
     * Sorts papers by the date they were published
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     */
	public void sortByDate()
	{
		Collections.sort(this,dateComparator);
	}

	/**
     * Sorts papers by the digital identifier associated with it alphanumerically
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     */
	public void sortByDigitalIdentifier()
	{
		Collections.sort(this,diComparator);
	}

	/**
    * This methods sorts papers by serial title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    */
	public void sortBySerialTitle()
	{
		Collections.sort(this,serialTitleComparator);
	}

	/**
    * This methods sorts papers by paper title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    */
	public void sortByPaperTitle()
	{
		Collections.sort(this,paperTitleComparator);
	}

	/**
    * This methods sorts papers by author
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    */
	public void sortByAuthor()
	{
		Collections.sort(this,authorComparator);
	}

	/**
    * This methods sorts papers by bibliographic info according to MLA format. i.e. author name
    * https://owl.english.purdue.edu/owl/resource/747/07/
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    */
	public void sortByBibliographicInfo()
	{
		Collections.sort(this,authorComparator);
	}

	/**
    * This methods sorts papers by title
    * <P>
    * Algorithm:<br>
    * use Collection.suffle().<br>
    * </P>
    */
	public void randomSort()
	{
		 Collections.shuffle(this);
	}

	public static Comparator<Paper>  authorComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their author
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the p1 is less than, equal to, or greater than p2. Where the primary author being alphanumerically before another is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			return p1.compareTo(p2);
		}
	};


	public static Comparator<Paper>  paperTitleComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their title
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the p1 is less than, equal to, or greater than p2. Where the title being alphanumerically before another is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			int compare=0;
			if(p1.getTitle().compareTo(p2.getTitle())>0)
				compare=1;
			if(p1.getTitle().compareTo(p2.getTitle())<0)
				compare=-1;
			return compare;
		}
	};


	public static Comparator<Paper>  serialTitleComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their serial title
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the o1 is less than, equal to, or greater than o2. Where the serial title being alphanumerically before another is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			return p1.getSerialTitle().compareTo(p2.getSerialTitle());
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
			int compare=0;
			//TODO
			return compare;
		}
	};


	public static Comparator<Paper>  diComparator = new Comparator<Paper>() 
	{	
		/** 
		 * This compares two papers to one another by their digital identifier
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the p1 is less than, equal to, or greater than p2. Where the digital identifier being alphanumerically before another is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			String di1=p1.getDigitalIdentifier();
			String di2=p2.getDigitalIdentifier();
			return di1.compareTo(di2);
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
			
			int compare=0;
			//TODO
			return compare;
		}
	};


	public static Comparator<Paper>  issueComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their issue
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the p1 is less than, equal to, or greater than p2. Where a lower numbered issue is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			int compare=0;
			//TODO
			return compare;
		}
	};


	public static Comparator<Paper>  lengthComparator = new Comparator<Paper>() 
	{
		/** 
		 * This compares two papers to one another by their length
		 * <P>
		 * @param 			  p1		the first paper to be compared
		 * @param			  p2		the second paper to be compared
		 * @return			  -1, 0, or 1 as the p1 is less than, equal to, or greater than p2. Where a shorter length is considered less than.
		 */
		public int compare(Paper p1, Paper p2) 
		{
			int compare=0; 
			//TODO
			return compare;
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
			if(Integer.parseInt(p1.getPageNumbers()[1]) < Integer.parseInt(p2.getPageNumbers()[1])){
				return -1;
			}
			else if(Integer.parseInt(p1.getPageNumbers()[1]) > Integer.parseInt(p2.getPageNumbers()[1])){
				return 1;
			}
			return 0;
		}
	};

	/**
    * This methods compares two papers by the author's last name
    */
	public int compare(Paper p1, Paper p2){
		return p1.compareTo(p2);
	}
}
