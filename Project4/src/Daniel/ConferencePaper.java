package Daniel;

import java.util.ArrayList;

public class ConferencePaper extends Paper{
	private static final long serialVersionUID = 1L;
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
		for(int i = 0; i < meetings.size(); i++){
			if(meetings.get(i).getConferencePapers().containsValue(this)){
				return meetings.get(i).getYear();
			}
		}
		return null;
	}
}
