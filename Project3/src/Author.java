import java.util.ArrayList;

public class Author{
	private ArrayList<ConferencePaper> conferencePapers;
	private ArrayList<Article> journalArticles;
	private String name;
	
	public Author(String name){
		this.name = name;
		conferencePapers = new ArrayList<ConferencePaper>();
		journalArticles = new ArrayList<Article>();
	}

	public ArrayList<ConferencePaper> getConferencePapers(){
		return conferencePapers;
	}
	
	public ArrayList<Article> getJournalArticles(){
		return journalArticles;
	}

	public void addConferenceProceeding(ConferencePaper art){
		conferencePapers.add(art);
	}
	
	public void addJournalArticle(Article art){
		journalArticles.add(art);
	}
}
