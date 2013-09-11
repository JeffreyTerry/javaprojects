import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Project #1
 * CS 2334, Section 10
 * 9/9/13
 * <P>
 * This class represents a data system object, which reads in a list of magazines from
 * a file. With that list, the user class can get the magazines either unfiltered, or
 * filtered by name, publisher, or date range.
 * </P>
 * @version 1.0
 */

public class DataSystemGUI extends JFrame{
	
	//Instance Variables
	/** Text fields to receive input */
	private JTextField inputPublisher;
	private JTextField inputMagTitle;
	private JTextField inputStartDate;
	private JTextField inputEndDate;

	/** A button that initiates a new search */
	private JButton searchButton;

	/** A label that shows all magazines which fulfill the requirements laid out by the user through the input fields */
	private JLabel displayLabel;
	
	/** The virtual data system that will be used */
	private DataSystem dataSystem;

	/**
     * Creates a new data system and sets up the GUI
     * 
     * <dt><b>Conditions:</b>
     * <dd>POST -     The data system is created and the GUI is set up to use.
     */
	public DataSystemGUI(){
		dataSystem = new DataSystem();
		init();
	}

	/* Mutator Methods */
	
	/**
	 * Sets up the GUI
     * 
     * <dt><b>Conditions:</b>
     * <dd>POST -     The GUI is set up to use.
     */
	private void init(){
		//Set up components
		int width = 500, height = 700;
		JPanel titlePanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel displayPanel = new JPanel();
		JLabel displayTitleLabel = new JLabel("<html><u>Matches</u></html>");
		displayTitleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		JLabel titleLabel = new JLabel("Magazine Data System");
		titleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
		JLabel magTitleLabel = new JLabel("Magazine Title");
		JLabel publisherLabel = new JLabel("Publisher");
		JLabel startDateLabel = new JLabel("Date Range");
		JLabel endDateLabel = new JLabel("-");
		inputPublisher = new JTextField();
		inputMagTitle = new JTextField();
		inputStartDate = new JTextField();
		inputEndDate = new JTextField();
		inputPublisher.setColumns(20);
		inputMagTitle.setColumns(20);
		inputStartDate.setColumns(4);
		inputEndDate.setColumns(4);
		SearchListener searchListener = new SearchListener();
		inputPublisher.addKeyListener(searchListener);
		inputMagTitle.addKeyListener(searchListener);
		inputStartDate.addKeyListener(searchListener);
		inputEndDate.addKeyListener(searchListener);
		searchButton = new JButton("Search Data System");
		displayLabel = new JLabel();
		searchButton.addActionListener(new SearchListener());
		
		//Set up main panels
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		titlePanel.add(titleLabel);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		panel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(magTitleLabel);
		panel1.add(inputMagTitle);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel2.add(publisherLabel);
		panel2.add(inputPublisher);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		panel3.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel3.add(startDateLabel);
		panel3.add(inputStartDate);
		panel3.add(endDateLabel);
		panel3.add(inputEndDate);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		panel4.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel4.add(searchButton);
		inputPanel.add(panel1);
		inputPanel.add(panel2);
		inputPanel.add(panel3);
		inputPanel.add(panel4);
		displayPanel.add(displayTitleLabel);
		displayPanel.add(displayLabel);
		
		//Add main panels to frame
		int inputPanelHeight = 200;
		inputPanel.setPreferredSize(new Dimension(width, inputPanelHeight));
		displayPanel.setPreferredSize(new Dimension(width, height - getInsets().top - inputPanelHeight));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		displayPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titlePanel.setBorder(BorderFactory.createMatteBorder(8, 8, 0, 8, Color.LIGHT_GRAY));
		inputPanel.setBorder(BorderFactory.createMatteBorder(8, 8, 0, 8, Color.LIGHT_GRAY));
		displayPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 8));
		add(titlePanel);
		add(inputPanel);
		add(displayPanel);
		
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	/**
	 * Reads in magazines given a file
	 * @param fileName The path to the file
	 */
	public void loadMagazines(String fileName){
		dataSystem.readMagazines(fileName);
	}

	/**
	 * Opens the GUI
	 */
	public void open(){
		setVisible(true);
	}
	
	/**
	 * Closes the GUI
	 */
	public void close(){
		setVisible(false);
	}
	
	/**
	 * <P>
	 * This class is used to listen for search events. That is, the user code wants to search the magazine list
	 * for magazines 
	 * </P>
	 * @version 1.0
	 */
	private class SearchListener implements ActionListener, KeyListener{
		public void actionPerformed(ActionEvent event){
			search();
		}
		public void keyPressed(KeyEvent event){
		}
		public void keyReleased(KeyEvent event){
			if(dataSystem.getMagazineList().size() < 1000){
				search();
			}
		}
		public void keyTyped(KeyEvent event){
		}
		/**
		 * This method searches the data system for the proper magazines, then updates the display label with its result.
	     * <dt><b>Conditions:</b>
	     * <dd>POST -     The display label for the magazines is updated with the proper magazines.
	     */
		private void search(){
			MagazineList titleFits = new MagazineList();
			MagazineList publisherFits = new MagazineList();
			MagazineList dateFits = new MagazineList();
			if(!inputMagTitle.getText().equals(""))
				titleFits = dataSystem.getMagazinesByTitle(inputMagTitle.getText());
			if(!inputPublisher.getText().equals(""))
				publisherFits = dataSystem.getMagazinesByPublisher(inputPublisher.getText());
			if(!inputStartDate.getText().equals("") && !inputEndDate.getText().equals(""))
				dateFits = dataSystem.getMagazinesByDate(Integer.parseInt(inputStartDate.getText()), Integer.parseInt(inputEndDate.getText()));
			else if(!inputStartDate.getText().equals(""))
				dateFits = dataSystem.getMagazinesByDate(Integer.parseInt(inputStartDate.getText()), Integer.MAX_VALUE);
			else if(!inputEndDate.getText().equals(""))
				dateFits = dataSystem.getMagazinesByDate(Integer.MIN_VALUE, Integer.parseInt(inputEndDate.getText()));

			MagazineList allResults = new MagazineList();
			if(inputMagTitle.getText().length() > 0){
				for(int i = 0; i < titleFits.size(); i++)
					if((inputPublisher.getText().length() == 0 || publisherFits.contains(titleFits.get(i))) && ((inputStartDate.getText().length() == 0 && inputEndDate.getText().length() == 0) || dateFits.contains(titleFits.get(i))))
						allResults.add(titleFits.get(i));
			}
			else if(inputPublisher.getText().length() > 0){
				for(int i = 0; i < publisherFits.size(); i++)
					if((inputStartDate.getText().length() == 0 && inputEndDate.getText().length() == 0) || dateFits.contains(publisherFits.get(i)))
						allResults.add(publisherFits.get(i));
			}
			else if(dateFits.size() > 0){
				allResults = dateFits;
			}
			else if(inputMagTitle.getText().equals("") && inputPublisher.getText().equals("") && inputStartDate.getText().equals("") && inputEndDate.getText().equals("")){
				allResults = dataSystem.getMagazineList();
			}
			displayLabel.setText("<html><ol>");
			for(int i = 0; i < allResults.size(); i++){
				displayLabel.setText(displayLabel.getText() + "<li>" + allResults.get(i) + "</li>");
			}
			displayLabel.setText(displayLabel.getText() + "</ol></html>");
		}
	}
}
