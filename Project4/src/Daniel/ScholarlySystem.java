package Daniel;

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
