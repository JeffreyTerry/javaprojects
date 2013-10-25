package Daniel;

public class AcademicInstance {
	private String month;
	private String year;
	private ScholarMap leads;
	private ScholarMap helpers;
	private PaperMap papers;
	
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
	public void setLeads(ScholarMap leads) {
		this.leads = leads;
	}
	public ScholarMap getHelpers() {
		return helpers;
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
}
