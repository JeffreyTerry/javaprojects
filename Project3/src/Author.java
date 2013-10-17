import java.io.Serializable;
import java.util.ArrayList;

public class Author implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ConferencePaper> conferencePapers;
	private ArrayList<Article> journalArticles;
	private String name;
	
	public Author(String name){
		this.name = name;
		conferencePapers = new ArrayList<ConferencePaper>();
		journalArticles = new ArrayList<Article>();
	}
	
	public String getName(){
		return name;
	}

	public ArrayList<ConferencePaper> getConferencePapers(){
		return conferencePapers;
	}
	
	public ArrayList<Article> getJournalArticles(){
		return journalArticles;
	}
	
	public String getname(){
		return name;
	}

	public void addConferenceProceeding(ConferencePaper art){
		conferencePapers.add(art);
	}
	
	public void addJournalArticle(Article art){
		journalArticles.add(art);
	}
}
