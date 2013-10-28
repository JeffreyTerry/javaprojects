package Daniel;

import java.util.ArrayList;
import java.util.Collection;

public class Scholar {
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

	public void addPaper(Paper p)
	{
		this.papers.put(p.getTitle(), p);
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
		Collection<Paper> papers = this.papers.values();
		for(Paper p: papers)
		{
			if(!(p instanceof JournalArticle))
				papers.remove(p);
		}
		ArrayList<JournalArticle> journalArticles = new ArrayList<JournalArticle>();
		for(Paper p: papers)
		{
			journalArticles.add((JournalArticle) p);
		}
		return journalArticles;
	}
	
	public ArrayList<ConferencePaper> getConferencePapers()
	{
		Collection<Paper> papers = this.papers.values();
		for(Paper p: papers)
		{
			if(!(p instanceof ConferencePaper))
				papers.remove(p);
		}
		ArrayList<ConferencePaper> conferencePapers = new ArrayList<ConferencePaper>();
		for(Paper p: papers)
		{
			conferencePapers.add((ConferencePaper) p);
		}
		return conferencePapers;
	}
	
	public String toString(){
		return name;
	}
}
