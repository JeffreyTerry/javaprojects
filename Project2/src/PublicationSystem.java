public class PublicationSystem {
	private PublicationList publicationList;
	
	public PublicationSystem(){
		publicationList = new PublicationList();
	}

	public void sortBySerialTitle(){
		publicationList.sortBySerialTitle();
	}
	
	public void sortByPaperTitle(){
		publicationList.sortByPaperTitle();
	}

	public void sortByAuthor(){
		publicationList.sortByAuthor();
	}

	public void sortByBibliographicInfo(){
		publicationList.sortByBibliographicInfo();
	}

	public void sortByChronology(){
		publicationList.sortByChronology();
	}
	
	public void randomSort(){
		publicationList.randomSort();
	}
	
	public PublicationList getPublicationList(){
		return publicationList;
	}
	
	public void importPublication(){
		//TODO
	}
}
