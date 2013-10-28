package Daniel;

import java.util.ArrayList;

public class Meeting extends AcademicInstance{
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setChairs(ScholarMap s)
	{
		super.setLeads(s);
	}
	
	public ScholarMap getChairs()
	{
		return super.getLeads();
	}
	
	public void setCommitteeMembers(ScholarMap s)
	{
		super.setHelpers(s);
	}
	
	public ScholarMap getCommitteeMembers()
	{
		return super.getHelpers();
	}
	
	public PaperMap getConferencePapers()
	{
		return super.getPapers();
	}
	
	public void setConferencePapers(PaperMap papers) {
		boolean allConferencePapers=true;
		ArrayList<Paper> paperArray = (ArrayList<Paper>) papers.values();
		for(Paper p: paperArray)
		{
			if(!(p instanceof ConferencePaper))
				allConferencePapers=false;
		}
		if(allConferencePapers)
			super.setPapers(papers);
		else
			ErrorHandling.showMessage("Not all Paper variables were of type ConferencePaper. setConferencePapers failed to operate.");
	}
	
	public void addConferencePaper(Paper p)
	{
		if(p instanceof ConferencePaper)
			super.addPaper(p);
		else
			ErrorHandling.showMessage("Not a ConferencePaper. addConferencePaper failed to operate.");
	}
}
