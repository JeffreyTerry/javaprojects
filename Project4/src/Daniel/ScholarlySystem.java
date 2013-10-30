package Daniel;

import java.util.ArrayList;

public class ScholarlySystem {
	private ScholarMap scholarMap = new ScholarMap();
	private PaperMap paperMap = new PaperMap();
	private OutletList outletList = new OutletList();
	
	public ScholarlySystem(){
		scholarMap = new ScholarMap();
		paperMap = new PaperMap();
		outletList = new OutletList();
	}

	public void addScholar(Scholar scholar){
		scholarMap.put(scholar.getName(), scholar);
		paperMap.putAll(scholar.getPapers());
	}

	public void addPaper(Paper paper){
		paperMap.put(paper.getTitle(), paper);
		scholarMap.putAll(paper.getAuthors());
	}

	public void addAcademicOutlet(AcademicOutlet outlet){
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
				committeeMembers = new ArrayList<Scholar>(conf.getMeetings().get(i).getChairs().values());
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
