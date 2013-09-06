import org.junit.Assert;
import org.junit.Test;


public class DataSystemTest {
	DataSystem dataSystem;
	
	public DataSystemTest(){
		dataSystem = new DataSystem();
		dataSystem.readMagazines("src/MagazineLists/test.txt");
	}
	
	@Test
	public void testDateGetters() {
		Assert.assertEquals(dataSystem.getMagazineList(), dataSystem.getMagazinesByDate(0, 8));
		Assert.assertNotSame(dataSystem.getMagazineList(), dataSystem.getMagazinesByDate(4, 8));
		Assert.assertNotSame(dataSystem.getMagazineList(), dataSystem.getMagazinesByDate(8, 100));
		Assert.assertNotSame(dataSystem.getMagazineList(), dataSystem.getMagazinesByDate(0, 4));
		Assert.assertNotSame(dataSystem.getMagazineList(), dataSystem.getMagazinesByDate(-8, -1));
	}
	
	@Test
	public void testPublisherGetters(){
		Assert.assertEquals(dataSystem.getMagazineList(), dataSystem.getMagazinesByPublisher("Publisher"));
		Assert.assertEquals(dataSystem.getMagazineList(), dataSystem.getMagazinesByPublisher("publisher"));
	}
	
	@Test
	public void testTitleGetters(){
		Assert.assertEquals(dataSystem.getMagazineList(), dataSystem.getMagazinesByTitle("Title"));
		Assert.assertEquals(dataSystem.getMagazineList(), dataSystem.getMagazinesByTitle("title"));
	}
}
