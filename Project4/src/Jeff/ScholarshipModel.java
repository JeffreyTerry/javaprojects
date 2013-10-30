package Jeff;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Daniel.*;

public class ScholarshipModel extends ScholarlySystem{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ActionListener> listenerList = new ArrayList<ActionListener>();
	
	public void addScholar(Scholar scholar){
		super.addScholar(scholar);
		processEvent(new ActionEvent(this, 0, "scholar added"));
	}
	
	public void addAcademicOutlet(AcademicOutlet outlet){
		super.addAcademicOutlet(outlet);
		processEvent(new ActionEvent(this, 1, "serial added"));
	}
	
	public void addPaper(Paper paper){
		super.addPaper(paper);
		processEvent(new ActionEvent(this, 2, "paper added"));
	}
	
	public synchronized void addListener(ActionListener e){
		listenerList.add(e);
	}

	public synchronized void removeListener(ActionListener e){
		listenerList.remove(e);
	}
	
	public void processEvent(ActionEvent e){
		ArrayList<ActionListener> theList;
		synchronized(this){
			theList = (ArrayList<ActionListener>)listenerList.clone();
		}
		for(int i = 0; i < theList.size(); i++){
			theList.get(i).actionPerformed(e);
		}
	}
}
