import org.junit.Assert;
import org.junit.Test;


public class PaperTest {
	/*Variables for testing*/
	
	/** Paper1 */
	String[] scholars={"Bob, Joe", "AppleSeed, Jonny"};
	String title = "A grand advnture";
	String serialTitle = "children's stuff";
	String[] pageNumbers = {"1","100"};
	String date = "September 1994";
	String digitalIdentifier = "www.thatonesite.com";
	Paper testPaper1 = new Paper(scholars, title, serialTitle, pageNumbers, date, digitalIdentifier);

	/** Paper2 */
	String[] scholars2={"ABob, Joe", "BAppleSeed, Jonny"};
	String title2 = "AA Agrand advnture";
	String serialTitle2 = "Achildren's stuff";
	String[] pageNumbers2 = {"2","150"};
	String date2 = "July 1990";
	String digitalIdentifier2 = "www.thatonesite2.com";
	Paper testPaper2 = new Paper(scholars2, title2, serialTitle2, pageNumbers2, date2, digitalIdentifier2);
	Paper testPaper3 = new Paper(scholars2, title2, serialTitle2, pageNumbers2, date2, digitalIdentifier2);
	
	/**
	 * This tests the Comparable method
	 */
	@Test
	public void testComparable() {
		Assert.assertEquals(1, testPaper1.compareTo(testPaper2));
		Assert.assertEquals(-1, testPaper2.compareTo(testPaper1));
		Assert.assertEquals(0, testPaper2.compareTo(testPaper3));
	}
}