import java.util.ArrayList;

public class Author{
	private ArrayList<ConferencePaper> conferencePapers;
	private ArrayList<Article> journalArticles;

	public ArrayList<ConferencePaper> getConferencePapers(){
		return conferencePapers;
	}
	
	public ArrayList<Article> getJournalArticles(){
		return journalArticles;
	}
}
