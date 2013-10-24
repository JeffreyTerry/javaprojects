import java.io.Serializable;
import java.util.ArrayList;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * <P>
 * This class represents an Scholar
 * </P>
 * @version 1.0
 */

public class Scholar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** A list of conference papers published by this scholar */
	private ArrayList<ConferencePaper> conferencePapers;
	/** A list of journal articles published by this scholar */
	private ArrayList<Article> journalArticles;
	/** The name of this scholar */
	private String name;
	
	/**
	 * This constructor sets the name of the scholar and creates new instances of conferencePapers and journalArticles
	 * @param name	The name of the scholar
	 */
	public Scholar(String name){
		this.name = name;
		conferencePapers = new ArrayList<ConferencePaper>();
		journalArticles = new ArrayList<Article>();
	}
	
	/**
	 * This method returns the name of the Scholar
	 * @return	the name of the Scholar
	 */
	public String getName(){
		return name;
	}

	/**
	 * This method returns the ArrayList of conference papers the scholar has published
	 * @return	the ArrayList of conference papers the scholar has published
	 */
	public ArrayList<ConferencePaper> getConferencePapers(){
		return conferencePapers;
	}
	
	/**
	 * This method returns the ArrayList of journal articles the scholar has published
	 * @return	the ArrayList of journal articles the scholar has published
	 */
	public ArrayList<Article> getJournalArticles(){
		return journalArticles;
	}
	
	/**
	 * This method adds a conference proceeding to conferencePapers
	 * @param pro	The conference proceeding to add
	 */
	public void addConferenceProceeding(ConferencePaper pro){
		conferencePapers.add(pro);
	}
	
	/**
	 * This method adds a journal article to add to journalArticles
	 * @param art	The article to add
	 */
	public void addJournalArticle(Article art){
		journalArticles.add(art);
	}
}
