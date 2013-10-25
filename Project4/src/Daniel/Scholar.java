package Daniel;

import java.util.ArrayList;

public class Scholar {
	private String name;
	private ArrayList<String> institutionalAffiliations;
	private ArrayList<String> researchAreas;
	private PaperMap papers;
	private ArrayList<Meeting> chairs;
	private ArrayList<Meeting> committees;
	private ArrayList<Issue> editingPositions;
	private ArrayList<Issue> reviewingPositions;
	
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
	
	public void addReivewingPosition(Issue i)
	{
		this.reviewingPositions.add(i);
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
}
