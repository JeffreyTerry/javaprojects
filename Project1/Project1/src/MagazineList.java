import java.util.ArrayList;

public class MagazineList extends ArrayList<Magazine>{
	/**
	 * @param title The title to search for
	 * @return A MagazineList containing the given title (case insensitive)
	 */
	public MagazineList getMagazinesByTitle(String title){
		MagazineList mags = new MagazineList();
		for(Magazine m: this)
			if(m.getTitle().toLowerCase().contains(title.toLowerCase()))
				mags.add(m);
		return mags;
	}
	/**
	 * @param publisher The publisher to search for
	 * @return A MagazineList containing the given publisher (case insensitive)
	 */
	public MagazineList getMagazinesByPublisher(String publisher){
		MagazineList mags = new MagazineList();
		for(Magazine m: this)
			if(m.getPublisher().toLowerCase().contains(publisher.toLowerCase()))
				mags.add(m);
		return mags;
	}
	/**
	 * @param startDate
	 * @param endDate
	 * @return All magazines that were being published during the given time frame
	 */
	public MagazineList getMagazinesByDate(int startDate, int endDate){
		MagazineList mags = new MagazineList();
		for(Magazine m: this){
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
