import java.util.ArrayList;
import java.util.Comparator;


public class Serial implements Comparator<Paper>
{
	String name;
	ArrayList<Paper> papers;
	
	public Serial(String name, ArrayList<Paper> papers)
	{
		this.name = name;
		this.papers = papers;
	}
	
	//Accessors
	
	public String getName()
	{
		return name;
	}
	public ArrayList<? extends Paper> getPapers()
	{
		return papers;
	}
	public Paper getPaper(int index)
	{
		return papers.get(index);
	}
	
	//Mutators
	public void sortByAuthors()
	{
		//do stuff
	}
	public void sortByTitle()
	{
		//do stuff
	}
	public void sortBySerial()
	{
		//do stuff
	}
	public void sortByDate()
	{
		//do stuff
	}
	public void sortByType()
	{
		//do stuff
	}
	public void sortByDigitalIdentifier()
	{
		
	}
	public void addPaper(Paper paper)
	{	
		//do stuff
	}
	
	
	@Override
	public int compare(Paper o1, Paper o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
