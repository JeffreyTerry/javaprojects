package Daniel;

import java.util.ArrayList;

public class Conference extends AcademicOutlet{
	private ArrayList<Meeting> meetings = new ArrayList<Meeting>();

	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(ArrayList<Meeting> meetings) {
		this.meetings = meetings;
	}
	
	public void addMeeting(Meeting m)
	{
		this.meetings.add(m);
	}
	
	public String toString(){
		return getOrganizationName();
	}
}
