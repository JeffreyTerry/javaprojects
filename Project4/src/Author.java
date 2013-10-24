import java.io.Serializable;
import java.util.ArrayList;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * <P>
 * This class represents an Author
 * </P>
 * @version 1.0
 */

public class Author implements Serializable{
	
	/* Instance variables */
	
	/**the conference papers the author has written*/
	private ArrayList<ConferencePaper> conferencePapers;
	/**the journal articles the author has written*/
	private ArrayList<Article> journalArticles;
	/**the author's name*/
	private String name;
	
	/**
     * This constructor initializes all of the variables specific to an Author.
     * @param             name			the Author's name
     */
	public Author(String name){
		this.name = name;
		conferencePapers = new ArrayList<ConferencePaper>();
		journalArticles = new ArrayList<Article>();
	}
	
	/**
     * This returns the conference papers the author has written
     * @return 			  the conference papers the author has written
     */
	public ArrayList<ConferencePaper> getConferencePapers(){
		return conferencePapers;
	}
	
	/**
     * This returns the journal articles the author has written
     * @return 			  the journal articles the author has written
     */
	public ArrayList<Article> getJournalArticles(){
		return journalArticles;
	}
	
	/*
	 * Accessor methods
	 */
	
	/**
     * This returns the author's name
     * @return 			  the author's name
     */
	public String getname(){
		return name;
	}

	
	/*
	 * mutator methods
	 */
	
	/**
     * This adds a conference proceeding to conferencePapers
     * @param			  art		the conference proceeding to add
     */
	public void addConferenceProceeding(ConferencePaper art){
		conferencePapers.add(art);
	}
	
	/**
     * This adds a journal article to journalArticles
     * @param			  art		the journal article to add
     */
	public void addJournalArticle(Article art){
		journalArticles.add(art);
	}
}
