package Daniel;

import java.io.Serializable;

public class Paper implements Serializable{
	private static final long serialVersionUID = 1L;
	private ScholarMap authors;
	private String title;
	private int[] pageNumbers = new int[2];
	private String digitalIdentifier;
	public ScholarMap getAuthors() {
		return authors;
	}
	public void setAuthors(ScholarMap authors) {
		this.authors = authors;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int[] getPageNumbers() {
		return pageNumbers;
	}
	public void setPageNumbers(int[] pageNumbers) {
		this.pageNumbers = pageNumbers;
	}
	public String getDigitalIdentifier() {
		if(digitalIdentifier == null){
			return "";
		}
		return digitalIdentifier;
	}
	public void setDigitalIdentifier(String digitalIdentifier) {
		this.digitalIdentifier = digitalIdentifier;
	}
	public void addAuthor(Scholar s)
	{
		authors.put(s.getName(),s);
	}
	public String toString(){
		return title;
	}
}
