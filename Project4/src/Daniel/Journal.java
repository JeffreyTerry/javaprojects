package Daniel;

import java.util.ArrayList;

public class Journal extends AcademicOutlet{
	private Location location;
	private ArrayList<Volume> volumes = new ArrayList<Volume>();
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public ArrayList<Volume> getVolumes() {
		return volumes;
	}
	public ArrayList<Issue> getIssues(){
		ArrayList<Issue> issues = new ArrayList<Issue>();
		for(int i = 0; i < volumes.size(); i++){
			issues.addAll(volumes.get(i));
		}
		return issues;
	}
	public void setVolumes(ArrayList<Volume> volumes) {
		this.volumes = volumes;
	}
	public void addVolume(Volume v)
	{
		this.volumes.add(v); 
	}
	public String toString(){
		return this.getOrganizationName();
	}
}
