import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class SelectionView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ScholarshipModel model;
	
	public SelectionView(ScholarshipModel model){
		this.model = model;

		JMenuItem save = new JMenuItem("Save Scholarship");
		JMenuItem load = new JMenuItem("Load Scholarship");
		JMenuItem importItem = new JMenuItem("Import Scholarship");
		JMenuItem export = new JMenuItem("Export Scholarship");
		JMenu fileMenu = new JMenu();
		fileMenu.add(save);
		fileMenu.add(load);
		fileMenu.add(importItem);
		fileMenu.add(export);
		
		JMenuItem type = new JMenuItem("Types of Publication");
		JMenuItem pubsPerYear = new JMenuItem("Publications Per Year");
		JMenuItem confPapsPerYear = new JMenuItem("Conference Papers Per Year");
		JMenuItem jourArtsPerYear = new JMenuItem("Journal Articles Per Year");
		JMenuItem numOfCoauths = new JMenuItem("Number of Co-authors Per Publication");
		JMenu plotMenu = new JMenu();
		plotMenu.add(type);
		plotMenu.add(pubsPerYear);
		plotMenu.add(confPapsPerYear);
		plotMenu.add(jourArtsPerYear);
		plotMenu.add(numOfCoauths);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(plotMenu);

		setJMenuBar(menuBar);
		add(this, BorderLayout.CENTER);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
