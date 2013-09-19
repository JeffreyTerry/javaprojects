
public class Article extends Paper
{
	int volume;
	int issue;
	
	public Article(String[] authors, String title, String serialTitle, int[] pageNumbers,int volume, int issue, String date, String digitalIdentifier)
	{
		super(authors, title, serialTitle, pageNumbers, date, digitalIdentifier);
		this.volume=volume;
		this.issue=issue;
	}
	
}
