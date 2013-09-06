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
	public MagazineList getMagazinesByTitle(String title){
		MagazineList mags = new MagazineList();
		for(Magazine m: magazineList)
			if(m.getTitle().toLowerCase().contains(title.toLowerCase()))
				mags.add(m);
		return mags;
	}
	public MagazineList getMagazinesByPublisher(String publisher){
		MagazineList mags = new MagazineList();
		for(Magazine m: magazineList)
			if(m.getPublisher().toLowerCase().contains(publisher.toLowerCase()))
				mags.add(m);
		return mags;
	}
	public MagazineList getMagazinesByDate(int startDate, int endDate){
		MagazineList mags = new MagazineList();
		for(Magazine m: magazineList){
			if(endDate == Integer.MAX_VALUE){
				if(m.getEndDate() >= startDate)
					mags.add(m);
			}
			else if(startDate == Integer.MIN_VALUE){
				if(m.getStartDate() <= endDate)
					mags.add(m);
			}
			else if((m.getEndDate() >= startDate && m.getEndDate() <= endDate) || (m.getStartDate() >= startDate && m.getStartDate() <= endDate))
				mags.add(m);
		}
		return mags;
	}
}
