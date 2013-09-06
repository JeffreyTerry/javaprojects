import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 * @author jterry
 *
 */

public class DataSystem {
	private MagazineList magazineList;
	public DataSystem(){
		magazineList = new MagazineList();
	}
	/**
	 * Reads in magazines given a file
	 * @param fileName The path to the file
	 */
	public void readMagazines(String fileName){
		FileReader r;
		String[] attributes;
		try {
			r = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(r);
			String nextLine;
			nextLine = reader.readLine();
			while(nextLine != null){
				attributes = nextLine.split(", ");
				if(attributes.length == 4)
					magazineList.add(new Magazine(attributes[0], attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3])));
				else if(attributes.length == 5)
					magazineList.add(new Magazine(attributes[0], attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4])));
				nextLine = reader.readLine();
			}
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public MagazineList getMagazineList(){
		return magazineList;
	}
	/**
	 * @param title The title to search for
	 * @return A MagazineList containing the given title (case insensitive)
	 */
	public MagazineList getMagazinesByTitle(String title){
		return magazineList.getMagazinesByTitle(title);
	}
	/**
	 * @param publisher The publisher to search for
	 * @return A MagazineList containing the given publisher (case insensitive)
	 */
	public MagazineList getMagazinesByPublisher(String publisher){
		return magazineList.getMagazinesByPublisher(publisher);
	}
	/**
	 * @param startDate
	 * @param endDate
	 * @return All magazines that were being published during the given time frame
	 */
	public MagazineList getMagazinesByDate(int startDate, int endDate){
		return magazineList.getMagazinesByDate(startDate, endDate);
	}
}
