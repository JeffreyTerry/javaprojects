package Jeff;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Daniel.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * This class represents the selection view
 * @version 1.0
 */
public class SelectionView extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The model to use */
	private ScholarshipModel model;
	
	/* Menu Items */
	private JMenuItem save = new JMenuItem("Save Scholarship");
	private JMenuItem load = new JMenuItem("Load Scholarship");
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem type = new JMenuItem("Types of Publication");
	private JMenuItem pubsPerYear = new JMenuItem("Publications Per Year");
	private JMenuItem confPapsPerYear = new JMenuItem("Conference Papers Per Year");
	private JMenuItem jourArtsPerYear = new JMenuItem("Journal Articles Per Year");
	private JMenuItem numOfCoauths = new JMenuItem("Number of Co-authors Per Publication");
	private JMenu plotMenu = new JMenu("Plot");
	private JMenuItem information = new JMenuItem("Information");
	private JMenu helpMenu = new JMenu("Help");
	private JMenuBar menuBar = new JMenuBar();
	
	/* GUI Items */
	private Box titleBox = Box.createVerticalBox();
	private JLabel titleLabel = new JLabel("ScholarPub");
	private JPanel itemPanel = new JPanel();
	private Box scholarBox = Box.createVerticalBox();
	private JLabel scholarLabel = new JLabel("Scholars");
	private DefaultListModel<Scholar> scholarListModel = new DefaultListModel<Scholar>();
	private JList<Scholar> scholarList = new JList<Scholar>(scholarListModel);
	private JButton addScholarButton = new JButton("Add Scholar");
	private JButton removeScholarButton = new JButton("Delete Selected Scholar");
	private JButton removeAllScholarsButton = new JButton("Delete All Scholars");
	private Box serialBox = Box.createVerticalBox();
	private JLabel serialLabel = new JLabel("Serials");
	private DefaultListModel<AcademicOutlet> serialListModel = new DefaultListModel<AcademicOutlet>();
	private JList<AcademicOutlet> serialList = new JList<AcademicOutlet>(serialListModel);
	private JButton addSerialButton = new JButton("Add Serial");
	private JButton removeSerialButton = new JButton("Delete Selected Serial");
	private JButton removeAllSerialsButton = new JButton("Delete All Serials");
	private Box paperBox = Box.createVerticalBox();
	private JLabel paperLabel = new JLabel("Papers");
	private DefaultListModel<Paper> paperListModel = new DefaultListModel<Paper>();
	private JList<Paper> paperList = new JList<Paper>(paperListModel);
	private JButton addPaperButton = new JButton("Add Paper");
	private JButton removePaperButton = new JButton("Delete Selected Paper");
	private JButton removeAllPapersButton = new JButton("Delete All Papers");
	
	/**
	 * The default constructor
	 * @param model		The model to use
	 */
	public SelectionView(ScholarshipModel model){
		this.model = model;
		this.model.addListener(this);
		
		createMenu();
		addComponents();
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Creates the menu
	 */
	private void createMenu(){
		fileMenu.add(save);
		fileMenu.add(load);
		
		plotMenu.add(type);
		plotMenu.add(pubsPerYear);
		plotMenu.add(confPapsPerYear);
		plotMenu.add(jourArtsPerYear);
		plotMenu.add(numOfCoauths);
		
		helpMenu.add(information);
		
		menuBar.add(fileMenu);
		menuBar.add(plotMenu);
		menuBar.add(helpMenu);
		plotMenu.setEnabled(false);

		setJMenuBar(menuBar);		
	}
	
	/**
	 * Add the components to the frame
	 */
	private void addComponents(){
		int verticalMargin = 5;

		Font titleFont = new Font(Font.SERIF, Font.PLAIN, 36);
		Font labelFont = new Font(Font.SERIF, Font.PLAIN, 28);
		titleLabel.setFont(titleFont);
		scholarLabel.setFont(labelFont);
		serialLabel.setFont(labelFont);
		paperLabel.setFont(labelFont);

		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		scholarLabel.setAlignmentX(CENTER_ALIGNMENT);
		scholarList.setAlignmentX(CENTER_ALIGNMENT);
		addScholarButton.setAlignmentX(CENTER_ALIGNMENT);
		removeScholarButton.setAlignmentX(CENTER_ALIGNMENT);
		removeAllScholarsButton.setAlignmentX(CENTER_ALIGNMENT);
		serialLabel.setAlignmentX(CENTER_ALIGNMENT);
		serialList.setAlignmentX(CENTER_ALIGNMENT);
		addSerialButton.setAlignmentX(CENTER_ALIGNMENT);
		removeSerialButton.setAlignmentX(CENTER_ALIGNMENT);
		removeAllSerialsButton.setAlignmentX(CENTER_ALIGNMENT);
		paperLabel.setAlignmentX(CENTER_ALIGNMENT);
		paperList.setAlignmentX(CENTER_ALIGNMENT);
		addPaperButton.setAlignmentX(CENTER_ALIGNMENT);
		removePaperButton.setAlignmentX(CENTER_ALIGNMENT);
		removeAllPapersButton.setAlignmentX(CENTER_ALIGNMENT);
		
		removeScholarButton.setEnabled(false);
		removeAllScholarsButton.setEnabled(false);
		addSerialButton.setEnabled(false);
		removeSerialButton.setEnabled(false);
		removeAllSerialsButton.setEnabled(false);
		addPaperButton.setEnabled(false);
		removePaperButton.setEnabled(false);
		removeAllPapersButton.setEnabled(false);
		
		scholarBox.add(Box.createVerticalStrut(verticalMargin));
		scholarBox.add(scholarLabel);
		scholarBox.add(Box.createVerticalStrut(verticalMargin));
		scholarBox.add(scholarList);
		scholarBox.add(Box.createVerticalStrut(verticalMargin));
		scholarBox.add(addScholarButton);
		scholarBox.add(Box.createVerticalStrut(verticalMargin));
		scholarBox.add(removeScholarButton);
		scholarBox.add(Box.createVerticalStrut(verticalMargin));
		scholarBox.add(removeAllScholarsButton);

		serialBox.add(Box.createVerticalStrut(verticalMargin));
		serialBox.add(serialLabel);
		serialBox.add(Box.createVerticalStrut(verticalMargin));
		serialBox.add(serialList);
		serialBox.add(Box.createVerticalStrut(verticalMargin));
		serialBox.add(addSerialButton);
		serialBox.add(Box.createVerticalStrut(verticalMargin));
		serialBox.add(removeSerialButton);
		serialBox.add(Box.createVerticalStrut(verticalMargin));
		serialBox.add(removeAllSerialsButton);

		paperBox.add(Box.createVerticalStrut(verticalMargin));
		paperBox.add(paperLabel);
		paperBox.add(Box.createVerticalStrut(verticalMargin));
		paperBox.add(paperList);
		paperBox.add(Box.createVerticalStrut(verticalMargin));
		paperBox.add(addPaperButton);
		paperBox.add(Box.createVerticalStrut(verticalMargin));
		paperBox.add(removePaperButton);
		paperBox.add(Box.createVerticalStrut(verticalMargin));
		paperBox.add(removeAllPapersButton);

		titleBox.add(Box.createVerticalStrut(verticalMargin));
		titleBox.add(titleLabel);
		titleBox.add(Box.createVerticalStrut(verticalMargin));

		Color borderColor = new Color(100, 100, 100);
		int borderSize = 4;
		titleBox.setBorder(BorderFactory.createMatteBorder(borderSize, 0, borderSize, 0, borderColor));
		serialBox.setBorder(BorderFactory.createMatteBorder(0, borderSize, 0, 0, borderColor));
		paperBox.setBorder(BorderFactory.createMatteBorder(0, borderSize, 0, 0, borderColor));

		itemPanel.setLayout(new GridLayout(1,3));
		itemPanel.add(scholarBox);
		itemPanel.add(serialBox);
		itemPanel.add(paperBox);
		
		add(titleBox, BorderLayout.NORTH);
		add(itemPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Listens for changes in the model
	 */
	public void actionPerformed(ActionEvent ev){
		DataChangeEvent e;
		if(ev instanceof DataChangeEvent){
			e = (DataChangeEvent)ev;
		}
		else{
			return;
		}
		if(e.getActionCommand() == DataChangeEvent.SCHOLAR_ADDED){
			for(int i = 0; i < e.getObjectsChanged().length; i++){
				scholarListModel.addElement((Scholar) e.getObjectsChanged()[i]);
			}
			addSerialButton.setEnabled(true);
			removeScholarButton.setEnabled(true);
			removeAllScholarsButton.setEnabled(true);
			plotMenu.setEnabled(true);
			type.setEnabled(true);
			pubsPerYear.setEnabled(true);
			confPapsPerYear.setEnabled(true);
			jourArtsPerYear.setEnabled(true);
			numOfCoauths.setEnabled(true);
		}
		if(e.getActionCommand() == DataChangeEvent.SERIAL_ADDED){
			for(int i = 0; i < e.getObjectsChanged().length; i++){
				serialListModel.addElement((AcademicOutlet) e.getObjectsChanged()[i]);
			}
			addPaperButton.setEnabled(true);
			removeSerialButton.setEnabled(true);
			removeAllSerialsButton.setEnabled(true);
		}
		if(e.getActionCommand() == DataChangeEvent.PAPER_ADDED){
			for(int i = 0; i < e.getObjectsChanged().length; i++){
				paperListModel.addElement((Paper) e.getObjectsChanged()[i]);
			}
			removePaperButton.setEnabled(true);
			removeAllPapersButton.setEnabled(true);
		}
		if(e.getActionCommand() == DataChangeEvent.SCHOLAR_REMOVED){
			int choice=JOptionPane.showConfirmDialog(null,"WARNING! You are about to delete one or more Scholars. This will delete their information from any Serial or Paper they are involved in, deleting the item if relevent. Are you sure you want to delete?");
			if(choice==JOptionPane.YES_OPTION)
			{
				for(int i = 0; i < e.getObjectsChanged().length; i++){
					scholarListModel.removeElement(e.getObjectsChanged()[i]);
				}
				if(scholarListModel.isEmpty())
				{
					model.setOutletList(new OutletList());
					model.setPaperMap(new PaperMap());
					model.setScholarMap(new ScholarMap());
					serialListModel.clear();
					paperListModel.clear();

					removeScholarButton.setEnabled(false);
					removeAllScholarsButton.setEnabled(false);
					addSerialButton.setEnabled(false);
					removeSerialButton.setEnabled(false);
					removeAllSerialsButton.setEnabled(false);
					addPaperButton.setEnabled(false);
					removePaperButton.setEnabled(false);
					removeAllPapersButton.setEnabled(false);
					plotMenu.setEnabled(false);
					type.setEnabled(false);
					pubsPerYear.setEnabled(false);
					confPapsPerYear.setEnabled(false);
					jourArtsPerYear.setEnabled(false);
					numOfCoauths.setEnabled(false);
				}
			}
		}
		if(e.getActionCommand() == DataChangeEvent.SERIAL_REMOVED){
			for(int i = 0; i < e.getObjectsChanged().length; i++){
				serialListModel.removeElement(e.getObjectsChanged()[i]);
			}
			if(serialListModel.isEmpty())
			{
				model.setPaperMap(new PaperMap());
				paperListModel.clear();

				removeSerialButton.setEnabled(false);
				removeAllSerialsButton.setEnabled(false);
				addPaperButton.setEnabled(false);
				removePaperButton.setEnabled(false);
				removeAllPapersButton.setEnabled(false);
			}
		}
		if(e.getActionCommand() == DataChangeEvent.PAPER_REMOVED){
			for(int i = 0; i < e.getObjectsChanged().length; i++){
				paperListModel.removeElement(e.getObjectsChanged()[i]);
			}
			if(paperListModel.isEmpty())
			{
				removePaperButton.setEnabled(false);
				removeAllPapersButton.setEnabled(false);
			}
		}
	}

	/* GETTERS AND SETTERS */
	
	public JMenuItem getSaveMenuItem() {
		return save;
	}

	public JMenuItem getLoadMenuItem() {
		return load;
	}

	public JMenuItem getTypeMenuItem() {
		return type;
	}

	public JMenuItem getPubsPerYearMenuItem() {
		return pubsPerYear;
	}

	public JMenuItem getConfPapsPerYearMenuItem() {
		return confPapsPerYear;
	}

	public JMenuItem getJourArtsPerYearMenuItem() {
		return jourArtsPerYear;
	}

	public JMenuItem getNumOfCoauthsMenuItem() {
		return numOfCoauths;
	}
	
	public JMenuItem getInformationItem() {
		return information;
	}

	public JList<Scholar> getScholarList() {
		return scholarList;
	}

	public JButton getAddScholarsButton() {
		return addScholarButton;
	}

	public JButton getRemoveScholarsButton() {
		return removeScholarButton;
	}

	public JButton getRemoveAllScholarsButton() {
		return removeAllScholarsButton;
	}

	public JList<AcademicOutlet> getSerialList() {
		return serialList;
	}

	public JButton getAddSerialsButton() {
		return addSerialButton;
	}

	public JButton getRemoveSerialsButton() {
		return removeSerialButton;
	}

	public JButton getRemoveAllSerialsButton() {
		return removeAllSerialsButton;
	}

	public JList<Paper> getPaperList() {
		return paperList;
	}

	public JButton getAddPapersButton() {
		return addPaperButton;
	}

	public JButton getRemovePapersButton() {
		return removePaperButton;
	}

	public JButton getRemoveAllPapersButton() {
		return removeAllPapersButton;
	}
}
