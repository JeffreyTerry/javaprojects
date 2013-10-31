package Daniel;

import java.util.ArrayList;

public class ScholarlySystem {
	/** A map of the scholars in the system */
	private ScholarMap scholarMap = new ScholarMap();
	/** A map of the papers in the system */
	private PaperMap paperMap = new PaperMap();
	/** A list of the academic outlets in the system */
	private OutletList outletList = new OutletList();
	
	/**
	 * The default constructor
	 */
	public ScholarlySystem(){
	}

	/**
	 * Adds a scholar to the model
	 * @param scholar		The scholar to add
	 */
	public void addScholar(Scholar scholar){
		if(scholar == null){
			return;
		}
		scholarMap.put(scholar.getName(), scholar);
		paperMap.putAll(scholar.getPapers());
	}

	/**
	 * Adds a paper to the model
	 * @param paper		The paper to add
	 */
	public void addPaper(Paper paper){
		if(paper == null){
			return;
		}
		paperMap.put(paper.getTitle(), paper);
		scholarMap.putAll(paper.getAuthors());
		ArrayList<Scholar> scholarList = new ArrayList<Scholar>(paper.getAuthors().values());
		for(int i = 0; i < scholarList.size(); i++){
			scholarList.get(i).addPaper(paper);
		}
		if(paper instanceof ConferencePaper){
			ConferencePaper confPap = (ConferencePaper)paper;
			ArrayList<Meeting> meetings = confPap.getConference().getMeetings();
			for(int i = 0; i < meetings.size(); i++){
				meetings.get(i).addConferencePaper(confPap);
			}
		}
		else if(paper instanceof JournalArticle){
			JournalArticle journalArticle = (JournalArticle)paper;
			journalArticle.getIssue().addJournalArticle(journalArticle);
		}
	}

	/**
	 * Adds a paper to the model
	 * @param paper		The paper to add
	 */
	public void removePaper(Paper paper){
		if(paper == null){
			return;
		}
		ArrayList<Scholar> scholarList = new ArrayList<Scholar>(paper.getAuthors().values());
		for(int i = 0; i < scholarList.size(); i++){
			scholarList.get(i).removePaper(paper);
		}
		ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		ArrayList<Issue> issues = new ArrayList<Issue>();
		if(paper instanceof ConferencePaper){
			ConferencePaper confPap = (ConferencePaper)paper;
			meetings = confPap.getConference().getMeetings();
			for(int i = 0; i < meetings.size(); i++){
				meetings.get(i).removeConferencePaper(confPap);
			}
		}
		else if(paper instanceof JournalArticle){
			JournalArticle journalArticle = (JournalArticle)paper;
			journalArticle.getIssue().removePaper(journalArticle);
		}
		paperMap.remove(paper.getTitle());
		//TODO make the papers remove themselves from their conferences
	}

	/**
	 * Adds an academic outlet to the model
	 * @param outlet	The outlet to add
	 */
	public void addAcademicOutlet(AcademicOutlet outlet){
		if(outlet == null){
			return;
		}
		//Add this conference to all authors, chairs, and committee members
		if(outlet instanceof Conference){
			Conference conf = (Conference)outlet;
			ArrayList<ConferencePaper> confPapers = new ArrayList<ConferencePaper>();
			ArrayList<Scholar> chairs;
			ArrayList<Scholar> committeeMembers;
			ArrayList<Paper> papers;
			ArrayList<Scholar> authors;
			for(int i = 0; i < conf.getMeetings().size(); i++){
				chairs = new ArrayList<Scholar>(conf.getMeetings().get(i).getChairs().values());
				for(int j = 0; j < chairs.size(); j++){
					chairs.get(j).addChair(conf.getMeetings().get(i));
				}
				committeeMembers = new ArrayList<Scholar>(conf.getMeetings().get(i).getCommitteeMembers().values());
				for(int j = 0; j < committeeMembers.size(); j++){
					committeeMembers.get(j).addCommittee(conf.getMeetings().get(i));
				}
				papers = new ArrayList<Paper>(conf.getMeetings().get(i).getConferencePapers().values());
				for(int j = 0; j < papers.size(); j++){
					confPapers.add((ConferencePaper)papers.get(j));
				}
			}
			for(int i = 0; i < confPapers.size(); i++){
				authors = new ArrayList<Scholar>(confPapers.get(i).getAuthors().values());
				for(int j = 0; j < authors.size(); j++){
					authors.get(j).addPaper(confPapers.get(i));
				}
			}
		}
		//Add this Journal to all authors, editors, and reviewers
		if(outlet instanceof Journal){
			Journal journal = (Journal)outlet;
			ArrayList<JournalArticle> journalArticles = new ArrayList<JournalArticle>();
			ArrayList<Scholar> editors;
			ArrayList<Scholar> reviewers;
			ArrayList<Paper> articles;
			ArrayList<Scholar> authors;
			for(int i = 0; i < journal.getVolumes().size(); i++){
				for(int k = 0; k < journal.getVolumes().get(i).size(); k++){
					editors = new ArrayList<Scholar>(journal.getVolumes().get(i).get(k).getEditors().values());
					for(int j = 0; j < editors.size(); j++){
						editors.get(j).addEditingPosition(journal.getVolumes().get(i).get(k));
					}
				}
				for(int k = 0; k < journal.getVolumes().get(i).size(); k++){
					reviewers = new ArrayList<Scholar>(journal.getVolumes().get(i).get(k).getReviewers().values());
					for(int j = 0; j < reviewers.size(); j++){
						reviewers.get(j).addReviewingPosition(journal.getVolumes().get(i).get(k));
					}
				}
				for(int k = 0; k < journal.getVolumes().get(i).size(); k++){
					articles = new ArrayList<Paper>(journal.getVolumes().get(i).get(k).getPapers().values());
					for(int j = 0; j < articles.size(); j++){
						journalArticles.add((JournalArticle)articles.get(j));
					}
				}
			}
			for(int i = 0; i < journalArticles.size(); i++){
				authors = new ArrayList<Scholar>(journalArticles.get(i).getAuthors().values());
				for(int j = 0; j < authors.size(); j++){
					authors.get(j).addPaper(journalArticles.get(i));
				}
			}
		}
		outletList.add(outlet);
	}

	/**
	 * Removes scholars from the model
	 * @param scholars		The scholars to remove
	 */
	public void removeScholars(Scholar[] scholars){
		for(int i = 0; i < scholars.length; i++){
			scholarMap.remove(scholars[i].getName());
		}
	}

	/**
	 * Removes papers from the model
	 * @param papers	The papers to remove
	 */
	public void removePapers(Paper[] papers){
		for(int i = 0; i < papers.length; i++){
			paperMap.remove(papers[i].getTitle());
		}
	}

	/**
	 * Removes academic outlets from the model
	 * @param outlets	The academic outlets to remove
	 */
	public void removeAcademicOutlets(AcademicOutlet[] outlets){
		ArrayList<Paper> papers;
		ArrayList<Meeting> meetings;
		ArrayList<Issue> issues;
		ArrayList<Scholar> chairs = new ArrayList<Scholar>();
		ArrayList<Scholar> committeeMembers = new ArrayList<Scholar>();
		ArrayList<Scholar> editors = new ArrayList<Scholar>();
		ArrayList<Scholar> reviewers = new ArrayList<Scholar>();
		Conference conf;
		Journal journal;
		for(int i = 0; i < outlets.length; i++){
			if(outlets[i] instanceof Conference){
				conf = (Conference)outlets[i];
				meetings = conf.getMeetings();
				for(int j = 0; j < meetings.size(); j++){
					chairs = new ArrayList<Scholar>(meetings.get(j).getChairs().values());
					for(int k = 0; k < chairs.size(); k++){
						chairs.get(k).removeChair(meetings.get(j));
					}
					committeeMembers = new ArrayList<Scholar>(meetings.get(j).getCommitteeMembers().values());
					for(int k = 0; k < committeeMembers.size(); k++){
						committeeMembers.get(k).removeCommittee(meetings.get(j));
					}
					papers = new ArrayList<Paper>(meetings.get(j).getPapers().values());
					for(int k = 0; k < papers.size(); k++){
						removePaper(papers.get(i));
					}
				}
			}
			if(outlets[i] instanceof Journal){
				journal = (Journal)outlets[i];
				issues = journal.getIssues();
				for(int j = 0; j < issues.size(); j++){
					editors = new ArrayList<Scholar>(issues.get(j).getEditors().values());
					for(int k = 0; k < editors.size(); k++){
						editors.get(k).removeEditingPosition(issues.get(j));
					}
					reviewers = new ArrayList<Scholar>(issues.get(j).getReviewers().values());
					for(int k = 0; k < reviewers.size(); k++){
						reviewers.get(k).removeReviewingPosition(issues.get(j));
					}
					papers = new ArrayList<Paper>(issues.get(j).getPapers().values());
					for(int k = 0; k < papers.size(); k++){
						removePaper(papers.get(i));
					}
				}
			}
		}
		for(int i = 0; i < outlets.length; i++){
			outletList.remove(outlets[i]);
		}
	}
	
	public ScholarMap getScholarMap() {
		return scholarMap;
	}
	
	public void setScholarMap(ScholarMap scholarMap) {
		this.scholarMap = scholarMap;
	}
	
	public PaperMap getPaperMap() {
		return paperMap;
	}
	
	public void setPaperMap(PaperMap paperMap) {
		this.paperMap = paperMap;
	}
	
	public OutletList getOutletList() {
		return outletList;
	}
	
	public void setOutletList(OutletList outletList) {
		this.outletList = outletList;
	}
}
