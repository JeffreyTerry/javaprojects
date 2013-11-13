package Jeff;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Daniel.*;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * This class is used as a model for a scholarly system
 * @version 1.0
 */
public class ScholarshipModel extends ScholarlySystem{
	private static final long serialVersionUID = 1L;
	
	/** A list of ActionListeners listening to changes in this model */
	transient private ArrayList<ActionListener> listenerList = new ArrayList<ActionListener>();

	/**
	 * Adds a scholar to the model
	 * @param scholar		The scholar to add
	 */
	public void addScholar(Scholar scholar){
		super.addScholar(scholar);
		processEvent(new DataChangeEvent(this, 0, DataChangeEvent.SCHOLAR_ADDED, new Object[]{scholar}));
	}

	/**
	 * Adds an academic outlet to the model
	 * @param outlet	The outlet to add
	 */
	public void addAcademicOutlet(AcademicOutlet outlet){
		super.addAcademicOutlet(outlet);
		processEvent(new DataChangeEvent(this, 1, DataChangeEvent.SERIAL_ADDED, new Object[]{outlet}));
	}

	/**
	 * Adds a paper to the model
	 * @param paper		The paper to add
	 */
	public void addPaper(Paper paper){
		super.addPaper(paper);
		processEvent(new DataChangeEvent(this, 2, DataChangeEvent.PAPER_ADDED, new Object[]{paper}));
	}

	/**
	 * Removes scholars from the model
	 * @param scholars		The scholars to remove
	 */
	public void removeScholars(Scholar[] scholars){
			super.removeScholars(scholars);
			processEvent(new DataChangeEvent(this, 3, DataChangeEvent.SCHOLAR_REMOVED, scholars));
	}

	/**
	 * Removes academic outlets from the model
	 * @param outlets	The academic outlets to remove
	 */
	public void removeAcademicOutlets(AcademicOutlet[] outlets){
		super.removeAcademicOutlets(outlets);
		processEvent(new DataChangeEvent(this, 4, DataChangeEvent.SERIAL_REMOVED, outlets));
	}

	/**
	 * Removes papers from the model
	 * @param papers	The papers to remove
	 */
	public void removePapers(Paper[] papers){
		super.removePapers(papers);
		processEvent(new DataChangeEvent(this, 5, DataChangeEvent.PAPER_REMOVED, papers));
	}

	/**
	 * Removes all scholars from the model
	 */
	public Scholar[] removeAllScholars(){
		Scholar[] scholarsRemoved = super.removeAllScholars();
		processEvent(new DataChangeEvent(this, 5, DataChangeEvent.SCHOLAR_REMOVED, scholarsRemoved));
		return scholarsRemoved;
	}

	/**
	 * Removes all serials from the model
	 */
	public AcademicOutlet[] removeAllAcademicOutlets(){
		AcademicOutlet[] outletsRemoved = super.removeAllAcademicOutlets();
		processEvent(new DataChangeEvent(this, 5, DataChangeEvent.SERIAL_REMOVED, outletsRemoved));
		return outletsRemoved;
	}

	/**
	 * Removes all papers from the model
	 */
	public Paper[] removeAllPapers(){
		Paper[] papersRemoved = super.removeAllPapers();
		processEvent(new DataChangeEvent(this, 5, DataChangeEvent.PAPER_REMOVED, papersRemoved));
		return papersRemoved;
	}
	
	public ScholarlySystem getSystem(){
		ScholarlySystem system = new ScholarlySystem();
		system.setOutletList(getOutletList());
		system.setPaperMap(getPaperMap());
		system.setScholarMap(getScholarMap());
		return system;
	}
	
	/**
	 * Adds a listener to the model
	 * @param e		The listener to add
	 */
	public synchronized void addListener(ActionListener e){
		listenerList.add(e);
	}

	/**
	 * Removes a listener from the model
	 * @param e		The listener to remove
	 */
	public synchronized void removeListener(ActionListener e){
		listenerList.remove(e);
	}
	
	/**
	 * Fires an event at all of the registered listeners of the model
	 * @param e		The event to fire
	 */
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
