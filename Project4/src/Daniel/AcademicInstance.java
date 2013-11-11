package Daniel;

import java.io.Serializable;

public class AcademicInstance implements Serializable{
	private static final long serialVersionUID = 1L; 
	private String month;
	private String year;
	private ScholarMap leads = new ScholarMap();
	private ScholarMap helpers = new ScholarMap();
	private PaperMap papers = new PaperMap();
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public String getDate() {
		return month+"/"+year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public ScholarMap getLeads() {
		return leads;
	}
	public void addLead(Scholar lead)
	{
		this.leads.put(lead.getName(),lead);
	}
	public void setLeads(ScholarMap leads) {
		this.leads = leads;
	}
	public ScholarMap getHelpers() {
		return helpers;
	}
	public void addHelper(Scholar helper)
	{
		this.helpers.put(helper.getName(), helper);
	}
	public void setHelpers(ScholarMap helpers) {
		this.helpers = helpers;
	}
	public PaperMap getPapers() {
		return papers;
	}
	public void setPapers(PaperMap papers) {
		this.papers = papers;
	}
	public void addPaper(Paper p)
	{
		this.papers.put(p.getTitle(), p);
	}
	public void removePaper(Paper p)
	{
		this.papers.remove(p.getTitle());
	}
}
