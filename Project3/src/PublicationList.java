import java.util.ArrayList;
import java.util.Collections;
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
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		Collections.sort(this,dateComparator);
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
		Collections.sort(this,diComparator);
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
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by paper title
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
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by author
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
    * <dt><b>Conditions:</b>
    * <dd>POST -         Publications are sorted by bibliographic info
    */
	public void sortByBibliographicInfo()
	{
		Collections.sort(this,authorComparator);
	}

	/**
    * This methods sorts papers by title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         The order is ranomized
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
			String[] date1=p1.getDate().split(" ");
			String[] date2=p2.getDate().split(" ");
			int compare=0;
			
			int year1=Integer.parseInt(date1[1]);
	        int year2=Integer.parseInt(date2[1]);
	        if(compare==0)
	        {
	        	if(year1<year2)
	        		compare=-1;
	        	if(year1>year2)
	        		compare=1;
	        }
	        if(compare==0)
	        {
	        	int month1=13;
		        String toSwitch = date1[0].toLowerCase();
		        if(toSwitch.equals("january")){
	            	month1=1;
		        }
		        else if(toSwitch.equals("february")){
	            	month1=2;
		        }
		        else if(toSwitch.equals("march")){
	            	month1=3;
		        }
		        else if(toSwitch.equals("april")){
	            	month1=4;
		        }
		        else if(toSwitch.equals("may")){
	            	month1=5;
		        }
		        else if(toSwitch.equals("june")){
	            	month1=6;
		        }
		        else if(toSwitch.equals("july")){
	            	month1=7;
		        }
		        else if(toSwitch.equals("august")){
	            	month1=8;
		        }
		        else if(toSwitch.equals("september")){
	            	month1=9;
		        }
		        else if(toSwitch.equals("october")){
	            	month1=10;
		        }
		        else if(toSwitch.equals("november")){
	            	month1=11;
		        }
		        else if(toSwitch.equals("december")){
	            	month1=12;
		        }

		        int month2=13;
		        toSwitch = date2[0].toLowerCase();
		        if(toSwitch.equals("january")){
	            	month2=1;
		        }
		        else if(toSwitch.equals("february")){
	            	month2=2;
		        }
		        else if(toSwitch.equals("march")){
	            	month2=3;
		        }
		        else if(toSwitch.equals("april")){
	            	month2=4;
		        }
		        else if(toSwitch.equals("may")){
	            	month2=5;
		        }
		        else if(toSwitch.equals("june")){
	            	month2=6;
		        }
		        else if(toSwitch.equals("july")){
	            	month2=7;
		        }
		        else if(toSwitch.equals("august")){
	            	month2=8;
		        }
		        else if(toSwitch.equals("september")){
	            	month2=9;
		        }
		        else if(toSwitch.equals("october")){
	            	month2=10;
		        }
		        else if(toSwitch.equals("november")){
	            	month2=11;
		        }
		        else if(toSwitch.equals("december")){
	            	month2=12;
		        }
		        
		        if(month1<month2)
		        	compare=-1;
		        if(month1>month2)
		        	compare=1;
	        }
			
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
			Article a1;
			Article a2;
			int v1=-1;
			int v2=-1;
			if(p1 instanceof Article)
			{
				a1=(Article)p1;
				v1=a1.getVolume();
			}
			if(p2 instanceof Article)
			{
				a2=(Article)p2;
				v2=a2.getVolume();
			}
			int compare=0;
			if(v1>v2)
				compare=1;
			else if(v1<v2)
				compare=-1;
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
			Article a1;
			Article a2;
			int i1=-1;
			int i2=-1;
			if(p1 instanceof Article)
			{
				a1=(Article)p1;
				i1=a1.getIssue();
			}
			if(p2 instanceof Article)
			{
				a2=(Article)p2;
				i2=a2.getIssue();
			}
			int compare=0;
			if(i1>i2)
				compare=1;
			else if(i1<i2)
				compare=-1;
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
			int length1=Integer.parseInt(p1.getPageNumbers()[1])-Integer.parseInt(p1.getPageNumbers()[0]);
			int length2=Integer.parseInt(p2.getPageNumbers()[1])-Integer.parseInt(p2.getPageNumbers()[0]);

			int compare=0;
			if(length1<length2)
				compare=-1;
			else if(length1>length2)
				compare=1;
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
