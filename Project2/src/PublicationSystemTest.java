import static org.junit.Assert.*;

import org.junit.Test;


public class PublicationSystemTest {

	String[] authors={"Joe Bob", "Jonny AppleSeed"};
	String title = "A grand advnture";
	String serialTitle = "children's stuff";
	int[] pageNumbers = {1,100};
	String date = "September 1994";
	String digitalIdentifier = "www.thatonesite.com";
	Paper testPaper1 = new Paper(authors, title, serialTitle, pageNumbers, date, digitalIdentifier);


	String[] authors2={"Joe ABob", "Jonny BAppleSeed"};
	String title2 = "AA Agrand advnture";
	String serialTitle2 = "Achildren's stuff";
	int[] pageNumbers2 = {2,150};
	String date2 = "July 1990";
	String digitalIdentifier2 = "www.thatonesite2.com";
	Paper testPaper2 = new Paper(authors2, title2, serialTitle2, pageNumbers2, date2, digitalIdentifier2);

	String[] authors3={"AJoe ABoAb", "AJonny AppleSeed"};
	String title3 = "AB Bgrand advnture";
	String serialTitle3 = "cAhildren's stuff";
	int[] pageNumbers3 = {3,50};
	String date3 = "January 1989";
	String digitalIdentifier3 = "www.thatonesite3.com";
	Paper testPaper3 = new Paper(authors3, title3, serialTitle3, pageNumbers3, date3, digitalIdentifier3);

	@Test
	public void testSortByDate() {

		PublicationList testList = new PublicationList();

		testList.add(testPaper1);
		testList.add(testPaper2);
		testList.add(testPaper3);

		testList.sortByDate();

		PublicationList correctList = new PublicationList();
		correctList.add(testPaper3);
		correctList.add(testPaper2);
		correctList.add(testPaper1);

		assertEquals(testList, correctList);
	}

	@Test
	public void testSortByType() {

		PublicationList testList = new PublicationList();

		testList.add(testPaper1);
		testList.add(testPaper2);
		testList.add(testPaper3);

		testList.sortByType();

		PublicationList correctList = new PublicationList();

		for(Paper p: testList)
		{
			if(p instanceof Article){
				correctList.add(p);
			}
		}
		for(Paper p: testList)
		{
			if(p instanceof ConferencePaper)
			{
				correctList.add(p);
			}
		}

		assertEquals(testList, correctList);
	}

	@Test
	public void testSortByDigitalIdentifier() {

		PublicationList testList = new PublicationList();

		testList.add(testPaper1);
		testList.add(testPaper3);
		testList.add(testPaper2);

		testList.sortByDigitalIdentifier();

		PublicationList correctList = new PublicationList();
		correctList.add(testPaper1);
		correctList.add(testPaper2);
		correctList.add(testPaper3);

		assertEquals(testList, correctList);
	}

	@Test
	public void testSortBySerialTitle() {

		PublicationList testList = new PublicationList();

		testList.add(testPaper1);
		testList.add(testPaper2);
		testList.add(testPaper3);

		testList.sortBySerialTitle();

		PublicationList correctList = new PublicationList();
		correctList.add(testPaper2);
		correctList.add(testPaper3);
		correctList.add(testPaper1);

		assertEquals(testList, correctList);
	}

	@Test
	public void testSortByPaperTitle() {

		PublicationList testList = new PublicationList();

		testList.add(testPaper1);
		testList.add(testPaper2);
		testList.add(testPaper3);

		testList.sortByDate();

		PublicationList correctList = new PublicationList();
		correctList.add(testPaper2);
		correctList.add(testPaper3);
		correctList.add(testPaper1);

		assertEquals(testList, correctList);
	}

	@Test
	public void testSortByAuthor() {

		PublicationList testList = new PublicationList();

		testList.add(testPaper1);
		testList.add(testPaper2);
		testList.add(testPaper3);

		testList.sortByDate();

		PublicationList correctList = new PublicationList();
		correctList.add(testPaper2);
		correctList.add(testPaper3);
		correctList.add(testPaper1);

		assertEquals(testList, correctList);
	}

	@Test
	public void testSortByBibliographicInfo() {
		fail("Not yet implemented"); // TODO
	}
}
