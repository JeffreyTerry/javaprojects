package Daniel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Scholar implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<String> institutionalAffiliations = new ArrayList<String>();
	private ArrayList<String> researchAreas = new ArrayList<String>();
	private PaperMap papers = new PaperMap();
	private ArrayList<Meeting> chairs = new ArrayList<Meeting>();
	private ArrayList<Meeting> committees = new ArrayList<Meeting>();
	private ArrayList<Issue> editingPositions = new ArrayList<Issue>();
	private ArrayList<Issue> reviewingPositions = new ArrayList<Issue>();
	
	public void addInstitutionalAffiliations(String s)
	{
		this.institutionalAffiliations.add(s);
	}
	
	public void addResearchArea(String s)
	{
		this.researchAreas.add(s);
	}

	public void addChair(Meeting m)
	{
		this.chairs.add(m);
	}
	
	public void addCommittee(Meeting m)
	{
		this.committees.add(m);
	}
	
	public void addEditingPosition(Issue i)
	{
		this.editingPositions.add(i);
	}

	public void addReviewingPosition(Issue i)
	{
		this.reviewingPositions.add(i);
	}

	public void removeChair(Meeting m)
	{
		this.chairs.remove(m);
	}
	
	public void removeCommittee(Meeting m)
	{
		this.committees.remove(m);
	}
	
	public void removeEditingPosition(Issue i)
	{
		this.editingPositions.remove(i);
	}

	public void removeReviewingPosition(Issue i)
	{
		this.reviewingPositions.remove(i);
	}

	public void addPaper(Paper p)
	{
		this.papers.put(p.getTitle(), p);
	}

	public void removePaper(Paper p)
	{
		this.papers.remove(p.getTitle());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getInstitutionalAffiliations() {
		return institutionalAffiliations;
	}
	public void setInstitutionalAffiliations(
			ArrayList<String> institutionalAffiliations) {
		this.institutionalAffiliations = institutionalAffiliations;
	}
	public ArrayList<String> getResearchAreas() {
		return researchAreas;
	}
	public void setResearchAreas(ArrayList<String> researchAreas) {
		this.researchAreas = researchAreas;
	}
	public PaperMap getPapers() {
		return papers;
	}
	public void setPapers(PaperMap papers) {
		this.papers = papers;
	}
	public ArrayList<Meeting> getChairs() {
		return chairs;
	}
	public void setChairs(ArrayList<Meeting> chairs) {
		this.chairs = chairs;
	}
	public ArrayList<Meeting> getCommittees() {
		return committees;
	}
	public void setCommittees(ArrayList<Meeting> committees) {
		this.committees = committees;
	}
	public ArrayList<Issue> getEditingPositions() {
		return editingPositions;
	}
	public void setEditingPositions(ArrayList<Issue> editingPositions) {
		this.editingPositions = editingPositions;
	}
	public ArrayList<Issue> getReviewingPositions() {
		return reviewingPositions;
	}
	public void setReviewingPositions(ArrayList<Issue> reviewingPositions) {
		this.reviewingPositions = reviewingPositions;
	}
	
	public ArrayList<JournalArticle> getJournalArticles()
	{
		ArrayList<JournalArticle> journalArticles = new ArrayList<JournalArticle>();
		ArrayList<Paper> papers = new ArrayList<Paper>(this.papers.values());
		for(int i = 0; i < papers.size(); i++){
			if(papers.get(i) instanceof JournalArticle){
				journalArticles.add((JournalArticle)papers.get(i));
			}
		}
		return journalArticles;
	}
	
	public ArrayList<ConferencePaper> getConferencePapers()
	{
		ArrayList<ConferencePaper> conferencePapers = new ArrayList<ConferencePaper>();
		ArrayList<Paper> papers = new ArrayList<Paper>(this.papers.values());
		for(int i = 0; i < papers.size(); i++){
			if(papers.get(i) instanceof ConferencePaper){
				conferencePapers.add((ConferencePaper)papers.get(i));
			}
		}
		return conferencePapers;
	}
	
	public String toString(){
		return name;
	}
}
