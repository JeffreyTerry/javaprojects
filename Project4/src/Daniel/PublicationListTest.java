package Daniel;
import static org.junit.Assert.*;

import org.junit.Test;

public class PublicationListTest {

	/*Variables for testing*/
	
	
	/** The list to be sorted */
	PublicationList testingList = new PublicationList();
	/** What the sorted list should look like */
	PublicationList correctList = new PublicationList();
	
	/** Paper1 */
	String[] scholars={"Bob, Joe", "AppleSeed, Jonny"};
	String title = "AB grand advnture";
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
	
	/** Paper3 */
	String[] scholars3={"ABCob, Joe", "BACppleSeed, Jonny"};
	String title3 = "AAC Agrand advnture";
	String serialTitle3 = "ACchildren's stuff";
	String[] pageNumbers3 = {"5","10"};
	String date3 = "June 1994";
	String digitalIdentifier3 = "www.thatonesite3.com";
	Paper testPaper3 = new Paper(scholars3, title3, serialTitle3, pageNumbers3, date3, digitalIdentifier3);
	
	/**
	 * This tests the sortByDate method
	 */
	@Test
	public void testSortByDate() {
		testingList.add(testPaper1);
		testingList.add(testPaper2);
		testingList.add(testPaper3);
		
		testingList.sortByDate();

		correctList.add(testPaper2);
		correctList.add(testPaper3);
		correctList.add(testPaper1);
		
		assertEquals(testingList,correctList);
	}

	/**
	 * This tests the sortByDigitalIdentifier method
	 */
	@Test
	public void testSortByDigitalIdentifier() {
		testingList.add(testPaper1);
		testingList.add(testPaper2);
		testingList.add(testPaper3);
		
		testingList.sortByDigitalIdentifier();
		
		correctList.add(testPaper1);
		correctList.add(testPaper2);
		correctList.add(testPaper3);
		
		assertEquals(testingList,correctList);
	}

	/**
	 * This tests the sortSerialTitle method
	 */
	@Test
	public void testSortBySerialTitle() {
	testingList.add(testPaper1);
	testingList.add(testPaper2);
	testingList.add(testPaper3);

	testingList.sortBySerialTitle();

	correctList.add(testPaper3);
	correctList.add(testPaper2);
	correctList.add(testPaper1);

	assertEquals(testingList,correctList);
}

	/**
	 * This tests the sortByPaperTitle method
	 */
	@Test
	public void testSortByPaperTitle() {
		testingList.add(testPaper1);
		testingList.add(testPaper2);
		testingList.add(testPaper3);
		
		testingList.sortByPaperTitle();
		for(Paper p: testingList)
		{
			System.out.println(p.getTitle());
		}
		correctList.add(testPaper2);
		correctList.add(testPaper3);
		correctList.add(testPaper1);
		
		assertEquals(testingList,correctList);
	}

	/**
	 * This tests the sortByScholar method
	 */
	@Test
	public void testSortByScholar() {
		testingList.add(testPaper1);
		testingList.add(testPaper2);
		testingList.add(testPaper3);
		
		testingList.sortByScholar();
		
		correctList.add(testPaper3);
		correctList.add(testPaper2);
		correctList.add(testPaper1);
		
		assertEquals(testingList,correctList);
	}

	/**
	 * This tests the sortByBiliograhicInfo method
	 */
	@Test
	public void testSortByBibliographicInfo() {
		testingList.add(testPaper1);
		testingList.add(testPaper2);
		testingList.add(testPaper3);
		
		testingList.sortByBibliographicInfo();
		
		correctList.add(testPaper3);
		correctList.add(testPaper2);
		correctList.add(testPaper1);
		
		assertEquals(testingList,correctList);
	}

	/**
	 * This tests the Compare method
	 */
	@Test
	public void testCompare() {
		assertTrue(testPaper1.compareTo(testPaper2)==1);
	}

}