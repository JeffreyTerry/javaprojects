package Daniel;

public class JournalArticle extends Paper{
	private Issue issue;

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	public String getYear()
	{
		return issue.getYear();
	}
	public String toString(){
		return getTitle();
	}
}
