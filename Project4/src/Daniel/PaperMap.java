package Daniel;

import java.util.ArrayList;
import java.util.HashMap;

public class PaperMap extends HashMap<String,Paper>{
	private static final long serialVersionUID = 1L;

	public ArrayList<JournalArticle> getJournalArticles() {
		ArrayList<JournalArticle> articles=new ArrayList<JournalArticle>();
		for(Paper p: this.values())
		{
			if(p instanceof JournalArticle)
				articles.add((JournalArticle) p);
		}
		return articles;
	}
	
	public ArrayList<ConferencePaper> getConferencePapers() {
		ArrayList<ConferencePaper> papers = new ArrayList<ConferencePaper>();
		for(Paper p: this.values())
		{
			if(p instanceof ConferencePaper)
				papers.add((ConferencePaper) p);
		}
		return papers;
	}
}
