package Daniel;

import java.util.ArrayList;

public class ConferencePaper extends Paper{
	private Conference conference;

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}
	
	public String getYear()
	{
		ArrayList<Meeting> meetings = conference.getMeetings();
		Meeting containsThis = new Meeting();
		ConferencePaper thisOne = this;
		for(Meeting m : meetings)
		{
			if(m.getConferencePapers().containsKey(thisOne.getTitle()))
					containsThis=m;
		}
		return containsThis.getYear();
	}
}
