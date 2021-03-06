package Daniel;

import java.util.ArrayList;

public class Issue extends AcademicInstance{
	private static final long serialVersionUID = 1L;
	public void setEditors(ScholarMap s)
	{
		super.setLeads(s);
	}
	
	public ScholarMap getEditors()
	{
		return super.getLeads();
	}
	
	public void addEditor(Scholar s)
	{
		super.addLead(s);
	}
	
	public void addReviewer(Scholar s)
	{
		super.addHelper(s);
	}
	public void setReviewers(ScholarMap s)
	{
		super.setHelpers(s);
	}
	
	public ScholarMap getReviewers()
	{
		return super.getHelpers();
	}
	
	public void setJournalArticles(PaperMap papers) {
		boolean allJournalArticles=true;
		ArrayList<Paper> paperArray = (ArrayList<Paper>) papers.values();
		for(Paper p: paperArray)
		{
			if(!(p instanceof JournalArticle))
				allJournalArticles=false;
		}
		if(allJournalArticles)
			super.setPapers(papers);
		else
			ErrorHandling.showMessage("Not all Paper variables were of type JournalArticle. setJournalArticles failed to operate.");
	}

	public void addJournalArticle(Paper p)
	{
		if(p instanceof JournalArticle)
			super.addPaper(p);
		else
			ErrorHandling.showMessage("Not a JournalArticle. removeJournalArticle failed to operate.");
	}
	public void removeJournalArticle(Paper p)
	{
		if(p instanceof JournalArticle)
			super.removePaper(p);
		else
			ErrorHandling.showMessage("Not a JournalArticle. removeJournalArticle failed to operate.");
	}
	public String toString(){
		return getMonth() + " " + getYear();
	}
}
