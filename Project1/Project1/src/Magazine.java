import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author jterry
 *
 */

public class Magazine{
	private String title;
	private String publisher;
	private int issuesPerYear;
	private int startDate;
	private int endDate;
	public Magazine(){
		this("", "", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public Magazine(String t, String p, int ipy, int sd){
		this(t, p, ipy, sd, Integer.MAX_VALUE);
	}
	public Magazine(String t, String p, int ipy, int sd, int ed){
		title = t;
		publisher = p;
		issuesPerYear = ipy;
		startDate = sd;
		endDate = ed;
	}
	public String getPublisher(){
		return publisher;
	}
	public int getStartDate(){
		return startDate;
	}
	public int getEndDate(){
		return endDate;
	}
	public String getTitle(){
		return title;
	}
	public int getIssuesPerYear(){
		return issuesPerYear;
	}
	public String toString(){
		if(endDate == Integer.MAX_VALUE)
			return title + ", " + publisher + ", " + issuesPerYear + ", " + startDate;
		return title + ", " + publisher + ", " + issuesPerYear + ", " + startDate + ", " + endDate;
	}
	public boolean equals(Object o){
		if(o instanceof Magazine){
			Magazine mag = (Magazine)o;
			if(mag.getTitle() == title && mag.getIssuesPerYear() == issuesPerYear && mag.getStartDate() == startDate && mag.getEndDate() == endDate && mag.getPublisher() == publisher)
				return true;
		}
		return false;
	}
}
