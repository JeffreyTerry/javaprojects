public class Paper implements Comparable<Paper>
{
	String[] authors;
	String title;
	String serialTitle;
	int[] pageNumbers;
	String date;	//look into using Calendar or GregorianCalendar or something cooler
	String digitalIdentifier;
	
	public Paper(String[] authors, String title, String serialTitle, int[] pageNumbers, String date, String digitalIdentifier)
	{
		this.authors=authors;
		this.title=title;
		this.serialTitle=serialTitle;
		this.pageNumbers=pageNumbers;
		this.date=date;
		this.digitalIdentifier=digitalIdentifier;
	}
	
	public String[] getAuthors()
	{
		return authors;
	}
	public String getTitle()
	{
		return title;
	}
	public String getSerialTitle()
	{
		return serialTitle;
	}
	public int[] getPageNumbers()
	{
		return pageNumbers;
	}
	public int getFirstPage()
	{
		return pageNumbers[1];
	}
	public int getLastPage()
	{
		return pageNumbers[2];
	}
	public String getDate()
	{
		return date;
	}
	public String getDigitalIdentifier()
	{
		return digitalIdentifier;
	}

	@Override
	public int compareTo(Paper o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
