import java.util.ArrayList;
import java.util.Comparator;

/**
 * Project #2
 * CS 2334, Section 011
 * 9/19/2013
 * <P>
 * This class represents a serial publication. It is comprised of an ArrayList of Papers.
 * </P>
 * @version 1.0
 */

public class Serial implements Comparator<Paper>
{
	/* Instance Variables */
    
    /** The name of the serial. */ 
	String name;
	/** The papers published in this serial. */ 
	ArrayList<? extends Paper> papers;
	
	/**
     * This constructor initializes the name of the Serial and assigns an ArrayList of Papers to papers.
     * <P>
     * @param             name      the name of the serial
     * @param             papers    an ArrayList of Paper variables published by this serial.
     *
     * <dt><b>Conditions:</b>
     * <dd>POST -         name and papers are initialized.
     */
	public Serial(String name, ArrayList<? extends Paper> papers)
	{
		this.name = name;
		this.papers = papers;
	}
	
	/*
     * Accessor Methods
     */
    
    /**
     * This returns the name of the serial
     * <P>
     * @return            the name of the serial
     */
	public String getName()
	{
		return name;
	}
	
	/**
     * This returns the ArrayList of Paper (or extensions of Paper) variables associated with this serial.
     * <P>
     * @return            an ArrayList of Paper (or extensions of Paper) variables associated with this serial.
     */
	public ArrayList<? extends Paper> getPapers()
	{
		return papers;
	}
	
	/**
     * This returns an element of papers at a given index.
     * <P>
     * 
     * @param			  index		the index of papers to return
     * @return            the element of papers at the given index
     */
	public Paper getPaper(int index)
	{
		return papers.get(index);
	}
	
	/*
     * Mutator Methods
     */
    
	/**
     * This randomizes the order of papers
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is in a random order
     */
	public void randomize()
	{
		//do stuff
	}
	
    /**
     * This sorts papers by the last name of the primary author
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by the primary author's last name
     */
	public void sortByAuthors()
	{
		//do stuff
	}
	
	 /**
     * This sorts papers by title
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by title
     */
	public void sortByTitle()
	{
		//do stuff
	}

	 /**
     * This sorts papers by the date they were published
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by the date they were published
     */
	public void sortByDate()
	{
		//do stuff
	}
	
	 /**
     * This sorts papers by the type of serial they are (Journal or ConfereneProceeding)
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by the type of serial they are (Journal or ConfereneProceeding)
     */
	public void sortByType()
	{
		//do stuff
	}
	
	/**
     * This sorts papers by the digital identifier associated with it alphanumerically
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by the digital identifier associated with it alphanumerically
     */
	public void sortByDigitalIdentifier()
	{
		//do stuff
	}
    
	 /**
     * This sorts papers by their volume
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by their volume
     */
	public void sortByVolume()
	{
		//do stuff
	}
	
	 /**
     * This sorts papers by their issue
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by their issue
     */
	public void sortByIssue()
	{
		//do stuff
	}
	
	/**
     * This sorts papers by their length
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by their length
     */
	public void sortByLength()
	{
		//do stuff
	}
	
	/**
     * This sorts papers by their first page
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         papers is not void
     * <dd>POST -         papers is sorted by their first page
     */
	public void sortByFirstPage()
	{
		//do stuff
	}
	
    /**
     * This adds a Paper to the ArrayList papers
     * <P>
     * @param             paper      the Paper to be added
     * <dt><b>Conditions:</b>
     * <dd>POST -         pre papers.size()+1 = post papers.size()
     */
	public void addPaper(Paper paper)
	{	
		//do stuff
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
	/*
	 * this is a link that helped me figure out comparators. Hurrah for fruit analogies. 
	 * http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
	 */

	
	/** 
	 * Honestly I'm not sure why this is needed, but the compiler needs it to exist to be happy.
	 * <P>
	 * @param 			  arg0		a Paper I don't plan to do anything with.
	 * @param			  arg1		another Paper I don't plan to do anything with.
	 * @return			  0
	 */
	public int compare(Paper arg0, Paper arg1) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
