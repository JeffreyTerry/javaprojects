package Jeff;

import Daniel.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * This class allows for user interaction between a selection view, a display view, and a scholarship model
 * @version 1.0
 */
public class ScholarPubController{
	/** The model */
	private ScholarshipModel model;
	/** The selection view */
	private SelectionView selectionView;
	/** The display view */
	private DisplayView displayView;
	
	/** The default constructor
	 * 
	 * @param model		The model to be used
	 */
	public ScholarPubController(ScholarshipModel model){
		this.model = model;
	}

	/**
	 * Sets the selection view to the given view
	 * @param view		The new selection view
	 */
	public void setSelectionView(SelectionView view){
		selectionView = view;
		ListClickListener listClickListener = new ListClickListener();
		selectionView.getScholarList().addMouseListener(listClickListener);
		selectionView.getSerialList().addMouseListener(listClickListener);
		selectionView.getPaperList().addMouseListener(listClickListener);
		selectionView.getAddScholarsButton().addActionListener(new AddScholarsListener());
		selectionView.getAddSerialsButton().addActionListener(new AddSerialsListener());
		selectionView.getAddPapersButton().addActionListener(new AddPapersListener());
		selectionView.getRemoveScholarsButton().addActionListener(new RemoveScholarsListener());
		selectionView.getRemoveSerialsButton().addActionListener(new RemoveSerialsListener());
		selectionView.getRemovePapersButton().addActionListener(new RemovePapersListener());
		selectionView.getRemoveAllScholarsButton().addActionListener(new RemoveAllScholarsListener());
		selectionView.getRemoveAllSerialsButton().addActionListener(new RemoveAllSerialsListener());
		selectionView.getRemoveAllPapersButton().addActionListener(new RemoveAllPapersListener());

		selectionView.getSaveMenuItem().addActionListener(new SaveListener());
		selectionView.getLoadMenuItem().addActionListener(new LoadListener());
		selectionView.getImportMenuItem().addActionListener(new ImportListener());
		selectionView.getExportMenuItem().addActionListener(new ExportListener());
		
		DisplayViewListener odvl = new DisplayViewListener();
		selectionView.getTypeMenuItem().addActionListener(odvl);
		selectionView.getPubsPerYearMenuItem().addActionListener(odvl);
		selectionView.getConfPapsPerYearMenuItem().addActionListener(odvl);
		selectionView.getJourArtsPerYearMenuItem().addActionListener(odvl);
		selectionView.getNumOfCoauthsMenuItem().addActionListener(odvl);
	}

	/**
	 * Sets the display view to the given view
	 * @param view		The new display view
	 */
	public void setDisplayView(DisplayView view){
		displayView = view;
	}

	/**
	 * Opens a dialog that prompts the user for issue information
	 * @return	A new Issue created using the user input
	 */
	private Issue openCreateIssueDialog(){
		final JComboBox monthSelector = new JComboBox(new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"});
		String[] years = new String[150];
		for(int i = 149; i >= 0; i--){
			years[i] = ""+ (Calendar.getInstance().get(Calendar.YEAR) - i);
		}
		JLabel dateLabel = new JLabel("Date");
		final JComboBox yearSelector = new JComboBox(years);
		JLabel editorLabel = new JLabel("Editors");
		final JList editorList = new JList(model.getScholarMap().values().toArray());
		JLabel reviewerLabel = new JLabel("Reviewers");
		final JList reviewerList = new JList(model.getScholarMap().values().toArray());
		JLabel paperLabel = new JLabel("Papers");
		final JList paperList = new JList(model.getPaperMap().values().toArray());
		JButton saveIssueButton = new JButton("Save Issue");

		JPanel datePanel = new JPanel();
		JPanel editorPanel = new JPanel();
		JPanel reviewerPanel = new JPanel();
		JPanel paperPanel = new JPanel();
		JPanel savePanel = new JPanel();

		datePanel.add(dateLabel);
		datePanel.add(monthSelector);
		datePanel.add(yearSelector);
		editorPanel.add(editorLabel);
		editorPanel.add(editorList);
		reviewerPanel.add(reviewerLabel);
		reviewerPanel.add(reviewerList);
		paperPanel.add(paperLabel);
		paperPanel.add(paperList);
		savePanel.add(saveIssueButton);

		Box addIssueBox = Box.createVerticalBox();
		addIssueBox.add(Box.createVerticalGlue());
		addIssueBox.add(datePanel);
		addIssueBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addIssueBox.add(editorPanel);
		addIssueBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addIssueBox.add(reviewerPanel);
		addIssueBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addIssueBox.add(paperPanel);
		addIssueBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addIssueBox.add(savePanel);
		addIssueBox.add(Box.createVerticalGlue());

		final JDialog addIssueDialog = new JDialog();
		
		final Issue theNewIssue = new Issue();
		saveIssueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Add date
				theNewIssue.setMonth(monthSelector.getSelectedItem().toString());
				theNewIssue.setYear(yearSelector.getSelectedItem().toString());
				//Add editors
				ScholarMap editors = new ScholarMap();
				Object[] editorArr = editorList.getSelectedValues();
				for(int i = 0; i < editorArr.length; i++){
					editors.put(((Scholar)editorArr[i]).getName(), (Scholar)editorArr[i]);
				}
				theNewIssue.setEditors(editors);
				//Add reviewers
				ScholarMap reviewers = new ScholarMap();
				Object[] reviewerArr = reviewerList.getSelectedValues();
				for(int i = 0; i < reviewerArr.length; i++){
					reviewers.put(((Scholar)reviewerArr[i]).getName(), (Scholar)reviewerArr[i]);
				}
				theNewIssue.setReviewers(reviewers);
				//Add papers
				PaperMap papers = new PaperMap();
				Object[] paperArr = paperList.getSelectedValues();
				for(int i = 0; i < paperArr.length; i++){
					papers.put(((Paper)paperArr[i]).getTitle(), (Paper)paperArr[i]);
				}
				theNewIssue.setPapers(papers);
				
				addIssueDialog.dispatchEvent(new WindowEvent(addIssueDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addIssueDialog.setTitle("Add Issue");
		addIssueDialog.add(addIssueBox);
		addIssueDialog.setSize(selectionView.getWidth() - 40, selectionView.getHeight() - 100);
		addIssueDialog.setLocationRelativeTo(selectionView);
		addIssueDialog.setModal(true);
		addIssueDialog.setVisible(true);
		
		if(theNewIssue.getMonth() == null){
			return null;
		}
		return theNewIssue;
	}

	/**
	 * Opens a dialog that prompts the user for meeting information
	 * @return	A new Meeting created using the user input
	 */
	private Meeting openCreateMeetingDialog(){
		final JComboBox monthSelector = new JComboBox(new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"});
		String[] years = new String[150];
		for(int i = 149; i >= 0; i--){
			years[i] = ""+ (Calendar.getInstance().get(Calendar.YEAR) - i);
		}
		JLabel dateLabel = new JLabel("Date");
		final JComboBox yearSelector = new JComboBox(years);
		JLabel cityLabel = new JLabel("City");
		final JTextField cityField = new JTextField();
		JLabel stateLabel = new JLabel("State/Province");
		final JTextField stateField = new JTextField();
		JLabel countryLabel = new JLabel("Country");
		final JTextField countryField = new JTextField();
		JLabel chairLabel = new JLabel("Chair");
		final JList chairList = new JList(model.getScholarMap().values().toArray());
		JLabel committeeLabel = new JLabel("Committee Members");
		final JList committeeList = new JList(model.getScholarMap().values().toArray());
		JLabel paperLabel = new JLabel("Papers");
		final JList paperList = new JList(model.getPaperMap().values().toArray());
		JButton saveMeetingButton = new JButton("Save Meeting");
		
		final Dimension textFieldDimension = new Dimension(160, 30);
		cityField.setPreferredSize(textFieldDimension);
		stateField.setPreferredSize(textFieldDimension);
		countryField.setPreferredSize(textFieldDimension);

		JPanel datePanel = new JPanel();
		JPanel cityPanel = new JPanel();
		JPanel statePanel = new JPanel();
		JPanel countryPanel = new JPanel();
		JPanel chairPanel = new JPanel();
		JPanel committeePanel = new JPanel();
		JPanel paperPanel = new JPanel();
		JPanel savePanel = new JPanel();

		datePanel.add(dateLabel);
		datePanel.add(monthSelector);
		datePanel.add(yearSelector);
		cityPanel.add(cityLabel);
		cityPanel.add(cityField);
		statePanel.add(stateLabel);
		statePanel.add(stateField);
		countryPanel.add(countryLabel);
		countryPanel.add(countryField);
		chairPanel.add(chairLabel);
		chairPanel.add(chairList);
		committeePanel.add(committeeLabel);
		committeePanel.add(committeeList);
		paperPanel.add(paperLabel);
		paperPanel.add(paperList);
		savePanel.add(saveMeetingButton);

		Box addMeetingBox = Box.createVerticalBox();
		addMeetingBox.add(Box.createVerticalGlue());
		addMeetingBox.add(datePanel);
		addMeetingBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addMeetingBox.add(cityPanel);
		addMeetingBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addMeetingBox.add(statePanel);
		addMeetingBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addMeetingBox.add(countryPanel);
		addMeetingBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addMeetingBox.add(chairPanel);
		addMeetingBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addMeetingBox.add(committeePanel);
		addMeetingBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addMeetingBox.add(paperPanel);
		addMeetingBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addMeetingBox.add(savePanel);
		addMeetingBox.add(Box.createVerticalGlue());

		final JDialog addMeetingDialog = new JDialog();
		
		final Meeting theNewMeeting = new Meeting();
		saveMeetingButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Add date
				theNewMeeting.setMonth(monthSelector.getSelectedItem().toString());
				theNewMeeting.setYear(yearSelector.getSelectedItem().toString());
				//Add location
				if(cityField.getText().length() == 0){
					JOptionPane.showMessageDialog(addMeetingDialog, "Please enter a city", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(countryField.getText().length() == 0){
					JOptionPane.showMessageDialog(addMeetingDialog, "Please enter a country", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(stateField.getText().length() != 0){
					theNewMeeting.setLocation(new Location(cityField.getText(), stateField.getText(), countryField.getText()));
				}
				else{
					theNewMeeting.setLocation(new Location(cityField.getText(), countryField.getText()));
				}
				//Add chairs
				ScholarMap chairs = new ScholarMap();
				Object[] chairArr = chairList.getSelectedValues();
				for(int i = 0; i < chairArr.length; i++){
					chairs.put(((Scholar)chairArr[i]).getName(), (Scholar)chairArr[i]);
				}
				theNewMeeting.setChairs(chairs);
				//Add committee members
				ScholarMap members = new ScholarMap();
				Object[] memberArr = committeeList.getSelectedValues();
				for(int i = 0; i < memberArr.length; i++){
					members.put(((Scholar)memberArr[i]).getName(), (Scholar)memberArr[i]);
				}
				theNewMeeting.setCommitteeMembers(members);
				//Add papers
				PaperMap papers = new PaperMap();
				Object[] paperArr = paperList.getSelectedValues();
				for(int i = 0; i < paperArr.length; i++){
					papers.put(((Paper)paperArr[i]).getTitle(), (Paper)paperArr[i]);
				}
				theNewMeeting.setPapers(papers);

				addMeetingDialog.dispatchEvent(new WindowEvent(addMeetingDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addMeetingDialog.setTitle("Add Meeting");
		addMeetingDialog.add(addMeetingBox);
		addMeetingDialog.setSize(selectionView.getWidth() - 40, selectionView.getHeight() - 100);
		addMeetingDialog.setLocationRelativeTo(selectionView);
		addMeetingDialog.setModal(true);
		addMeetingDialog.setVisible(true);

		if(theNewMeeting.getMonth() == null){
			return null;
		}
		return theNewMeeting;
	}

	/**
	 * Opens a dialog that prompts the user for volume information
	 * @return	A new Volume created using the user input
	 */
	private Volume openCreateVolumeDialog(){
		JButton addIssueButton = new JButton("Add Issue");
		JButton saveVolumeButton = new JButton("Save Volume");

		final JPanel issuesPanel = new JPanel();
		JPanel savePanel = new JPanel();

		issuesPanel.add(addIssueButton);
		savePanel.add(saveVolumeButton);

		Box addVolumeBox = Box.createVerticalBox();
		addVolumeBox.add(Box.createVerticalGlue());
		addVolumeBox.add(issuesPanel);
		addVolumeBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addVolumeBox.add(savePanel);
		addVolumeBox.add(Box.createVerticalGlue());

		final JDialog addVolumeDialog = new JDialog();
		final Volume theNewVolume = new Volume();
		
		addIssueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Issue newIssue = openCreateIssueDialog();
				if(newIssue != null){
					theNewVolume.add(newIssue);
					issuesPanel.add(new JLabel(newIssue.toString()), issuesPanel.getComponentCount() - 1);
					addVolumeDialog.validate();
				}
			}
		});
		
		saveVolumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addVolumeDialog.dispatchEvent(new WindowEvent(addVolumeDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addVolumeDialog.setTitle("Add Volume");
		addVolumeDialog.add(addVolumeBox);
		addVolumeDialog.setSize(selectionView.getWidth() - 40, selectionView.getHeight() - 100);
		addVolumeDialog.setLocationRelativeTo(selectionView);
		addVolumeDialog.setModal(true);
		addVolumeDialog.setVisible(true);

		if(theNewVolume.size() == 0){
			return null;
		}
		return theNewVolume;
	}

	/**
	 * Opens a dialog that prompts the user for scholar information
	 * @return	A new Scholar created using the user input
	 */
	private Scholar openCreateScholarDialog(){
		JLabel nameLabel = new JLabel("Name");
		final JTextField nameField = new JTextField();
		JLabel institutionLabel = new JLabel("Institution");
		final ArrayList<JTextField> institutionFields = new ArrayList<JTextField>();
		institutionFields.add(new JTextField());
		JButton addInstitutionButton = new JButton("Add Institution");
		JLabel researchAreaLabel = new JLabel("Research Area");
		final ArrayList<JTextField> researchAreaFields = new ArrayList<JTextField>();
		researchAreaFields.add(new JTextField());
		JButton addResearchAreaButton = new JButton("Add Research Area");
		JButton saveScholarButton = new JButton("Save Scholar");
		
		final Dimension textFieldDimension = new Dimension(160, 30);
		nameField.setPreferredSize(textFieldDimension);
		institutionFields.get(0).setPreferredSize(textFieldDimension);
		researchAreaFields.get(0).setPreferredSize(textFieldDimension);
		
		JPanel namePanel = new JPanel();
		final JPanel institutionPanel = new JPanel();
		final JPanel researchAreaPanel = new JPanel();
		JPanel savePanel = new JPanel();
		
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		institutionPanel.add(institutionLabel);
		institutionPanel.add(institutionFields.get(0));
		institutionPanel.add(addInstitutionButton);
		researchAreaPanel.add(researchAreaLabel);
		researchAreaPanel.add(researchAreaFields.get(0));
		researchAreaPanel.add(addResearchAreaButton);
		savePanel.add(saveScholarButton);

		Box addScholarBox = Box.createVerticalBox();
		addScholarBox.add(Box.createVerticalGlue());
		addScholarBox.add(namePanel);
		addScholarBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addScholarBox.add(institutionPanel);
		addScholarBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addScholarBox.add(researchAreaPanel);
		addScholarBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addScholarBox.add(savePanel);
		addScholarBox.add(Box.createVerticalGlue());

		final JDialog addScholarDialog = new JDialog();
		final Scholar theNewScholar = new Scholar();

		addInstitutionButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				institutionFields.add(new JTextField());
				institutionFields.get(institutionFields.size() - 1).setPreferredSize(textFieldDimension);;
				institutionPanel.add(institutionFields.get(institutionFields.size() - 1), institutionPanel.getComponentCount() - 1);
				addScholarDialog.validate();
			}
		});

		addResearchAreaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				researchAreaFields.add(new JTextField());
				researchAreaFields.get(researchAreaFields.size() - 1).setPreferredSize(textFieldDimension);;
				researchAreaPanel.add(researchAreaFields.get(researchAreaFields.size() - 1), researchAreaPanel.getComponentCount() - 1);
				addScholarDialog.validate();
			}
		});

		saveScholarButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Add name
				if(nameField.getText().length() == 0){
					JOptionPane.showMessageDialog(addScholarDialog, "Please enter a name", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					theNewScholar.setName(nameField.getText());
				}
				
				//Add institution(s)
				if(institutionFields.get(0).getText().length() == 0){
					JOptionPane.showMessageDialog(addScholarDialog, "Please enter an institution", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					for(int i = 0; i < institutionFields.size(); i++){
						if(institutionFields.get(i).getText().length() != 0){
							theNewScholar.addInstitutionalAffiliations(institutionFields.get(i).getText());
						}
					}
				}
				
				//Add research area(s)
				if(researchAreaFields.get(0).getText().length() == 0){
					JOptionPane.showMessageDialog(addScholarDialog, "Please enter a research area", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					for(int i = 0; i < researchAreaFields.size(); i++){
						if(researchAreaFields.get(i).getText().length() != 0){
							theNewScholar.addResearchArea(researchAreaFields.get(i).getText());
						}
					}
				}
				
				addScholarDialog.dispatchEvent(new WindowEvent(addScholarDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addScholarDialog.setTitle("Add Scholar");
		addScholarDialog.add(addScholarBox);
		addScholarDialog.setSize(selectionView.getWidth() - 40, selectionView.getHeight() - 100);
		addScholarDialog.setLocationRelativeTo(selectionView);
		addScholarDialog.setModal(true);
		addScholarDialog.setVisible(true);

		if(theNewScholar.getName() == null){
			return null;
		}
		return theNewScholar;
	}

	/**
	 * Opens a dialog that prompts the user for conference information
	 * @return	A new Conference created using the user input
	 */
	private Conference openCreateConferenceDialog(){
		JLabel organizationLabel = new JLabel("Organization");
		final JTextField organizationField = new JTextField();
		JButton addMeetingButton = new JButton("Add Meeting");
		JButton saveConferenceButton = new JButton("Save Conference");
		
		final Dimension textFieldDimension = new Dimension(160, 30);
		organizationField.setPreferredSize(textFieldDimension);
		
		JPanel organizationPanel = new JPanel();
		final JPanel addMeetingPanel = new JPanel();
		JPanel savePanel = new JPanel();
		
		organizationPanel.add(organizationLabel);
		organizationPanel.add(organizationField);
		addMeetingPanel.add(addMeetingButton);
		savePanel.add(saveConferenceButton);

		Box addConferenceBox = Box.createVerticalBox();
		addConferenceBox.add(Box.createVerticalGlue());
		addConferenceBox.add(organizationPanel);
		addConferenceBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addConferenceBox.add(addMeetingPanel);
		addConferenceBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addConferenceBox.add(savePanel);
		addConferenceBox.add(Box.createVerticalGlue());

		final JDialog addConferenceDialog = new JDialog();
		
		final ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		addMeetingButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Meeting newMeeting = openCreateMeetingDialog();
				if(newMeeting != null){
					meetings.add(newMeeting);
					addMeetingPanel.add(new JLabel(meetings.get(meetings.size() - 1).getLocation().toString()), addMeetingPanel.getComponentCount() - 1);
					addConferenceDialog.validate();
				}
			}
		});

		final Conference theNewConference = new Conference();
		saveConferenceButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Add name
				if(organizationField.getText().length() == 0){
					JOptionPane.showMessageDialog(addConferenceDialog, "Please enter an organization", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					theNewConference.setOrganizationName(organizationField.getText());
				}
				
				//Add meetings
				theNewConference.setMeetings(meetings);

				addConferenceDialog.dispatchEvent(new WindowEvent(addConferenceDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addConferenceDialog.setTitle("Add Conference");
		addConferenceDialog.add(addConferenceBox);
		addConferenceDialog.setSize(selectionView.getWidth() - 40, selectionView.getHeight() - 100);
		addConferenceDialog.setLocationRelativeTo(selectionView);
		addConferenceDialog.setModal(true);
		addConferenceDialog.setVisible(true);

		if(theNewConference.getOrganizationName() == null){
			return null;
		}
		return theNewConference;
	}

	/**
	 * Opens a dialog that prompts the user for journal information
	 * @return	A new Journal created using the user input
	 */
	private Journal openCreateJournalDialog(){
		JLabel organizationLabel = new JLabel("Organization");
		final JTextField organizationField = new JTextField();
		JLabel cityLabel = new JLabel("City");
		final JTextField cityField = new JTextField();
		JLabel stateLabel = new JLabel("State/Province");
		final JTextField stateField = new JTextField();
		JLabel countryLabel = new JLabel("Country");
		final JTextField countryField = new JTextField();
		JButton addVolumeButton = new JButton("Add Volume");
		JButton saveJournalButton = new JButton("Save Journal");
		
		final Dimension textFieldDimension = new Dimension(160, 30);
		organizationField.setPreferredSize(textFieldDimension);
		cityField.setPreferredSize(textFieldDimension);
		stateField.setPreferredSize(textFieldDimension);
		countryField.setPreferredSize(textFieldDimension);

		JPanel organizationPanel = new JPanel();
		JPanel cityPanel = new JPanel();
		JPanel statePanel = new JPanel();
		JPanel countryPanel = new JPanel();
		final JPanel addVolumePanel = new JPanel();
		JPanel savePanel = new JPanel();

		organizationPanel.add(organizationLabel);
		organizationPanel.add(organizationField);
		cityPanel.add(cityLabel);
		cityPanel.add(cityField);
		statePanel.add(stateLabel);
		statePanel.add(stateField);
		countryPanel.add(countryLabel);
		countryPanel.add(countryField);
		addVolumePanel.add(addVolumeButton);
		savePanel.add(saveJournalButton);

		Box addJournalBox = Box.createVerticalBox();
		addJournalBox.add(Box.createVerticalGlue());
		addJournalBox.add(organizationPanel);
		addJournalBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalBox.add(cityPanel);
		addJournalBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalBox.add(statePanel);
		addJournalBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalBox.add(countryPanel);
		addJournalBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalBox.add(addVolumePanel);
		addJournalBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalBox.add(savePanel);
		addJournalBox.add(Box.createVerticalGlue());

		final JDialog addJournalDialog = new JDialog();
		
		final ArrayList<Volume> volumes = new ArrayList<Volume>();
		addVolumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Volume newVolume = openCreateVolumeDialog();
				if(newVolume != null){
					volumes.add(newVolume);
					addVolumePanel.add(new JLabel(volumes.get(volumes.size() - 1).toString()), addVolumePanel.getComponentCount() - 1);
					addJournalDialog.validate();
				}
			}
		});

		final Journal theNewJournal = new Journal();
		saveJournalButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Add name
				if(organizationField.getText().length() == 0){
					JOptionPane.showMessageDialog(addJournalDialog, "Please enter an organization", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					theNewJournal.setOrganizationName(organizationField.getText());
				}
				//Add location
				if(cityField.getText().length() == 0){
					JOptionPane.showMessageDialog(addJournalDialog, "Please enter a city", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(countryField.getText().length() == 0){
					JOptionPane.showMessageDialog(addJournalDialog, "Please enter a country", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(stateField.getText().length() != 0){
					theNewJournal.setLocation(new Location(cityField.getText(), stateField.getText(), countryField.getText()));
				}
				else{
					theNewJournal.setLocation(new Location(cityField.getText(), countryField.getText()));
				}
				//Add volumes
				theNewJournal.setVolumes(volumes);

				addJournalDialog.dispatchEvent(new WindowEvent(addJournalDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addJournalDialog.setTitle("Add Journal");
		addJournalDialog.add(addJournalBox);
		addJournalDialog.setSize(selectionView.getWidth() - 40, selectionView.getHeight() - 100);
		addJournalDialog.setLocationRelativeTo(selectionView);
		addJournalDialog.setModal(true);
		addJournalDialog.setVisible(true);

		if(theNewJournal.getOrganizationName() == null){
			return null;
		}
		return theNewJournal;
	}

	/**
	 * Opens a dialog that prompts the user for conference paper information
	 * @return	A new ConferencePaper created using the user input
	 */
	private ConferencePaper openCreateConferencePaperDialog(){
		JLabel titleLabel = new JLabel("Title");
		final JTextField titleField = new JTextField();
		JLabel pagesLabel = new JLabel("Pages");
		final JTextField startPageField = new JTextField();
		JLabel pagesHyphen = new JLabel("-");
		final JTextField endPageField = new JTextField();
		JLabel confLabel = new JLabel("Conference");
		OutletList outletList = model.getOutletList();
		ArrayList<Conference> conferences = new ArrayList<Conference>();
		for(int i = 0; i < outletList.size(); i++){
			if(outletList.get(i) instanceof Conference){
				conferences.add((Conference)outletList.get(i));
			}
		}
		final JList confList = new JList(conferences.toArray());
		confList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JLabel scholarLabel = new JLabel("Authors");
		final JList scholarList = new JList(model.getScholarMap().values().toArray());
		JLabel diLabel = new JLabel("Digital Identifier (optional)");
		final JTextField diField = new JTextField();
		JButton saveConferencePaperButton = new JButton("Save ConferencePaper");
		
		final Dimension textFieldDimension = new Dimension(160, 30);
		titleField.setPreferredSize(textFieldDimension);
		startPageField.setPreferredSize(textFieldDimension);
		endPageField.setPreferredSize(textFieldDimension);
		diField.setPreferredSize(textFieldDimension);

		JPanel titlePanel = new JPanel();
		JPanel pagesPanel = new JPanel();
		JPanel confPanel = new JPanel();
		JPanel scholarPanel = new JPanel();
		JPanel diPanel = new JPanel();
		JPanel savePanel = new JPanel();

		titlePanel.add(titleLabel);
		titlePanel.add(titleField);
		pagesPanel.add(pagesLabel);
		pagesPanel.add(startPageField);
		pagesPanel.add(pagesHyphen);
		pagesPanel.add(endPageField);
		confPanel.add(confLabel);
		confPanel.add(confList);
		scholarPanel.add(scholarLabel);
		scholarPanel.add(scholarList);
		diPanel.add(diLabel);
		diPanel.add(diField);
		savePanel.add(saveConferencePaperButton);

		Box addConferencePaperBox = Box.createVerticalBox();
		addConferencePaperBox.add(Box.createVerticalGlue());
		addConferencePaperBox.add(titlePanel);
		addConferencePaperBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addConferencePaperBox.add(pagesPanel);
		addConferencePaperBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addConferencePaperBox.add(confPanel);
		addConferencePaperBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addConferencePaperBox.add(scholarPanel);
		addConferencePaperBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addConferencePaperBox.add(diPanel);
		addConferencePaperBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addConferencePaperBox.add(savePanel);
		addConferencePaperBox.add(Box.createVerticalGlue());

		final JDialog addConferencePaperDialog = new JDialog();
		
		final ConferencePaper theNewConferencePaper = new ConferencePaper();
		saveConferencePaperButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Add title
				if(titleField.getText().length() == 0){
					JOptionPane.showMessageDialog(addConferencePaperDialog, "Please enter a title", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					theNewConferencePaper.setTitle(titleField.getText());
				}
				//Add pages
				if(startPageField.getText().length() == 0 || endPageField.getText().length() == 0){
					JOptionPane.showMessageDialog(addConferencePaperDialog, "Please enter pages", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					try{
						theNewConferencePaper.setPageNumbers(new int[]{Integer.parseInt(startPageField.getText()), Integer.parseInt(endPageField.getText())});
					}
					catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(addConferencePaperDialog, "Invalid page numbers", "", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				//Add conference
				if(confList.getSelectedValue() == null){
					JOptionPane.showMessageDialog(addConferencePaperDialog, "Please select a conference", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				theNewConferencePaper.setConference((Conference)confList.getSelectedValue());
				//Add scholars
				ScholarMap scholars = new ScholarMap();
				Object[] scholarArr = scholarList.getSelectedValues();
				for(int i = 0; i < scholarArr.length; i++){
					scholars.put(((Scholar)scholarArr[i]).getName(), (Scholar)scholarArr[i]);
				}
				if(scholars.isEmpty()){
					JOptionPane.showMessageDialog(addConferencePaperDialog, "Please add authors", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				theNewConferencePaper.setAuthors(scholars);
				//Add digital object identifier
				if(diField.getText().length() != 0){
					theNewConferencePaper.setDigitalIdentifier(diField.getText());
				}

				addConferencePaperDialog.dispatchEvent(new WindowEvent(addConferencePaperDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addConferencePaperDialog.setTitle("Add ConferencePaper");
		addConferencePaperDialog.add(addConferencePaperBox);
		addConferencePaperDialog.setSize(selectionView.getWidth() - 40, selectionView.getHeight() - 100);
		addConferencePaperDialog.setLocationRelativeTo(selectionView);
		addConferencePaperDialog.setModal(true);
		addConferencePaperDialog.setVisible(true);

		if(theNewConferencePaper.getTitle() == null){
			return null;
		}
		return theNewConferencePaper;
	}

	/**
	 * Opens a dialog that prompts the user for journal article information
	 * @return	A new JournalArticle created using the user input
	 */
	private JournalArticle openCreateJournalArticleDialog(){
		JLabel titleLabel = new JLabel("Title");
		final JTextField titleField = new JTextField();
		JLabel pagesLabel = new JLabel("Pages");
		final JTextField startPageField = new JTextField();
		JLabel pagesHyphen = new JLabel("-");
		final JTextField endPageField = new JTextField();
		JLabel issueLabel = new JLabel("Issue");
		OutletList outletList = model.getOutletList();
		ArrayList<Journal> journals = new ArrayList<Journal>();
		for(int i = 0; i < outletList.size(); i++){
			if(outletList.get(i) instanceof Journal){
				journals.add((Journal)outletList.get(i));
			}
		}
		ArrayList<Issue> issues = new ArrayList<Issue>();
		for(int i = 0; i < journals.size(); i++){
			for(int j = 0; j < journals.get(i).getVolumes().size(); j++){
				issues.addAll(journals.get(i).getVolumes().get(j));
			}
		}
		final JList issueList = new JList(issues.toArray());
		issueList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JLabel scholarLabel = new JLabel("Authors");
		final JList scholarList = new JList(model.getScholarMap().values().toArray());
		JLabel diLabel = new JLabel("Digital Identifier (optional)");
		final JTextField diField = new JTextField();
		JButton saveJournalArticleButton = new JButton("Save JournalArticle");
		
		final Dimension textFieldDimension = new Dimension(160, 30);
		titleField.setPreferredSize(textFieldDimension);
		startPageField.setPreferredSize(textFieldDimension);
		endPageField.setPreferredSize(textFieldDimension);
		diField.setPreferredSize(textFieldDimension);

		JPanel titlePanel = new JPanel();
		JPanel pagesPanel = new JPanel();
		JPanel issuePanel = new JPanel();
		JPanel scholarPanel = new JPanel();
		JPanel diPanel = new JPanel();
		JPanel savePanel = new JPanel();

		titlePanel.add(titleLabel);
		titlePanel.add(titleField);
		pagesPanel.add(pagesLabel);
		pagesPanel.add(startPageField);
		pagesPanel.add(pagesHyphen);
		pagesPanel.add(endPageField);
		issuePanel.add(issueLabel);
		issuePanel.add(issueList);
		scholarPanel.add(scholarLabel);
		scholarPanel.add(scholarList);
		diPanel.add(diLabel);
		diPanel.add(diField);
		savePanel.add(saveJournalArticleButton);

		Box addJournalArticleBox = Box.createVerticalBox();
		addJournalArticleBox.add(Box.createVerticalGlue());
		addJournalArticleBox.add(titlePanel);
		addJournalArticleBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalArticleBox.add(pagesPanel);
		addJournalArticleBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalArticleBox.add(issuePanel);
		addJournalArticleBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalArticleBox.add(scholarPanel);
		addJournalArticleBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalArticleBox.add(diPanel);
		addJournalArticleBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalArticleBox.add(savePanel);
		addJournalArticleBox.add(Box.createVerticalGlue());

		final JDialog addJournalArticleDialog = new JDialog();
		
		final JournalArticle theNewJournalArticle = new JournalArticle();
		saveJournalArticleButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Add title
				if(titleField.getText().length() == 0){
					JOptionPane.showMessageDialog(addJournalArticleDialog, "Please enter a title", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					theNewJournalArticle.setTitle(titleField.getText());
				}
				//Add pages
				if(startPageField.getText().length() == 0 || endPageField.getText().length() == 0){
					JOptionPane.showMessageDialog(addJournalArticleDialog, "Please enter pages", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					try{
						theNewJournalArticle.setPageNumbers(new int[]{Integer.parseInt(startPageField.getText()), Integer.parseInt(endPageField.getText())});
					}
					catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(addJournalArticleDialog, "Invalid page numbers", "", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				//Add issue
				if(issueList.getSelectedValue() == null){
					JOptionPane.showMessageDialog(addJournalArticleDialog, "Please select an issue", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				theNewJournalArticle.setIssue((Issue)issueList.getSelectedValue());
				//Add scholars
				ScholarMap scholars = new ScholarMap();
				Object[] scholarArr = scholarList.getSelectedValues();
				for(int i = 0; i < scholarArr.length; i++){
					scholars.put(((Scholar)scholarArr[i]).getName(), (Scholar)scholarArr[i]);
				}
				if(scholars.isEmpty()){
					JOptionPane.showMessageDialog(addJournalArticleDialog, "Please add authors", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				theNewJournalArticle.setAuthors(scholars);
				//Add digital object identifier
				if(diField.getText().length() != 0){
					theNewJournalArticle.setDigitalIdentifier(diField.getText());
				}

				addJournalArticleDialog.dispatchEvent(new WindowEvent(addJournalArticleDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addJournalArticleDialog.setTitle("Add JournalArticle");
		addJournalArticleDialog.add(addJournalArticleBox);
		addJournalArticleDialog.setSize(selectionView.getWidth() - 40, selectionView.getHeight() - 100);
		addJournalArticleDialog.setLocationRelativeTo(selectionView);
		addJournalArticleDialog.setModal(true);
		addJournalArticleDialog.setVisible(true);

		if(theNewJournalArticle.getTitle() == null){
			return null;
		}
		return theNewJournalArticle;
	}

	/**
	 * Opens a dialog that allows the user to select from a list of existing conferences
	 * @return	The selected conference
	 */
	private Conference openAddConferenceDialog(){
		ArrayList<Conference> confList = new ArrayList<Conference>();
		for(int i = 0; i < model.getOutletList().size(); i++){
			if(model.getOutletList().get(i) instanceof Conference){
				confList.add((Conference)model.getOutletList().get(i));
			}
		}
		final JComboBox selector = new JComboBox(confList.toArray());
		JButton saveButton = new JButton("Add Conference");

		JPanel selectorPanel = new JPanel();
		JPanel savePanel = new JPanel();
		
		selectorPanel.add(selector);
		savePanel.add(saveButton);

		Box addConferenceBox = Box.createVerticalBox();
		addConferenceBox.add(Box.createVerticalGlue());
		addConferenceBox.add(selectorPanel);
		addConferenceBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addConferenceBox.add(savePanel);
		addConferenceBox.add(Box.createVerticalGlue());
		
		final JDialog addConferenceDialog = new JDialog();

		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addConferenceDialog.dispatchEvent(new WindowEvent(addConferenceDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addConferenceDialog.setTitle("Add Conference");
		addConferenceDialog.add(addConferenceBox);
		addConferenceDialog.setSize(selectionView.getWidth() - 80, selectionView.getHeight() - 200);
		addConferenceDialog.setLocationRelativeTo(selectionView);
		addConferenceDialog.setModal(true);
		addConferenceDialog.setVisible(true);
		
		return ((Conference)selector.getSelectedItem());
	}

	/**
	 * Opens a dialog allows the user to select from a list of existing journals
	 * @return	The selected journal
	 */
	private Journal openAddJournalDialog(){
		ArrayList<Journal> journList = new ArrayList<Journal>();
		for(int i = 0; i < model.getOutletList().size(); i++){
			if(model.getOutletList().get(i) instanceof Journal){
				journList.add((Journal)model.getOutletList().get(i));
			}
		}
		final JComboBox selector = new JComboBox(journList.toArray());
		JButton saveButton = new JButton("Add Journal");

		JPanel selectorPanel = new JPanel();
		JPanel savePanel = new JPanel();
		
		selectorPanel.add(selector);
		savePanel.add(saveButton);

		Box addJournalBox = Box.createVerticalBox();
		addJournalBox.add(Box.createVerticalGlue());
		addJournalBox.add(selectorPanel);
		addJournalBox.add(Box.createVerticalStrut(dialogVerticalMargin));
		addJournalBox.add(savePanel);
		addJournalBox.add(Box.createVerticalGlue());
		
		final JDialog addJournalDialog = new JDialog();

		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addJournalDialog.dispatchEvent(new WindowEvent(addJournalDialog, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		addJournalDialog.setTitle("Add Journal");
		addJournalDialog.add(addJournalBox);
		addJournalDialog.setSize(selectionView.getWidth() - 80, selectionView.getHeight() - 200);
		addJournalDialog.setLocationRelativeTo(selectionView);
		addJournalDialog.setModal(true);
		addJournalDialog.setVisible(true);
		
		return ((Journal)selector.getSelectedItem());
	}

	/** The height of the vertical margins between panels in the information dialogs */
	private final int dialogVerticalMargin = 5;
	
	private class AddScholarsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Scholar newScholar = openCreateScholarDialog();
			if(newScholar != null){
				model.addScholar(newScholar);
			}
		}
	}
	private class AddSerialsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(model.getScholarMap().isEmpty()){
				return;
			}
			int choice = JOptionPane.showOptionDialog(selectionView, "What type of serial would you like to create?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Journal","Conference"}, null);
			if(choice == 0){
				AcademicOutlet newOutlet = openCreateJournalDialog();
				if(newOutlet != null){
					model.addAcademicOutlet(newOutlet);
				}
			}
			else if(choice == 1){
				AcademicOutlet newOutlet = openCreateConferenceDialog();
				if(newOutlet != null){
					model.addAcademicOutlet(newOutlet);
				}
			}
		}
	}
	private class AddPapersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(model.getScholarMap().isEmpty() || model.getOutletList().isEmpty()){
				return;
			}
			int choice = JOptionPane.showOptionDialog(selectionView, "What type of paper would you like to create?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Journal Article","Conference Paper"}, null);
			if(choice == 0){
				Paper newPaper = openCreateJournalArticleDialog();
				if(newPaper != null){
					model.addPaper(newPaper);
				}
			}
			else if(choice == 1){
				Paper newPaper = openCreateConferencePaperDialog();
				if(newPaper != null){
					model.addPaper(newPaper);
				}
			}
		}
	}
	private class RemoveScholarsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object[] selectedObjects = selectionView.getScholarList().getSelectedValues();
			Scholar[] scholarList = new Scholar[selectedObjects.length];
			for(int i = 0; i < selectedObjects.length; i++){
				scholarList[i] = (Scholar)selectedObjects[i];
			}
			model.removeScholars(scholarList);
		}
	}
	private class RemoveSerialsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemovePapersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemoveAllScholarsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemoveAllSerialsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemoveAllPapersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}

	private class SaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class LoadListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class ImportListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class ExportListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	
	/**
	 * Listens for right clicks on the list
	 *
	 */
	private class ListClickListener extends MouseAdapter{
		public void mousePressed(final MouseEvent e){
			if(e.isPopupTrigger()){
				final int verticalMargin = 10;
				JPopupMenu infoMenu = new JPopupMenu();
				JMenuItem infoItem = new JMenuItem("Get Info");
				infoMenu.add(infoItem);
				if(e.getSource() == selectionView.getScholarList()){
					selectionView.getScholarList().setSelectedIndex(selectionView.getScholarList().locationToIndex(e.getPoint()));
					infoMenu.show(selectionView.getScholarList(), e.getX(), e.getY());
					infoItem.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent event){
							Scholar scholar = (Scholar)selectionView.getScholarList().getModel().getElementAt(selectionView.getScholarList().locationToIndex(e.getPoint()));
							JDialog infoDialog = new JDialog();
							JPanel namePanel = new JPanel();
							JPanel institutionPanel = new JPanel();
							JPanel researchAreaPanel = new JPanel();
							JPanel conferencePaperPanel = new JPanel();
							JPanel journalArticlePanel = new JPanel();
							JPanel chairPanel = new JPanel();
							JPanel committeePanel = new JPanel();
							JPanel editorPanel = new JPanel();
							JPanel reviewerPanel = new JPanel();
							
							namePanel.add(new JLabel("Name "));
							institutionPanel.add(new JLabel("Institutional Affiliations "));
							researchAreaPanel.add(new JLabel("Research Areas "));
							conferencePaperPanel.add(new JLabel("Conference Papers "));
							journalArticlePanel.add(new JLabel("Journal Articles "));
							chairPanel.add(new JLabel("Committees Chaired"));
							committeePanel.add(new JLabel("Committees"));
							editorPanel.add(new JLabel("Issues Edited"));
							reviewerPanel.add(new JLabel("Issues Reviewed"));
							namePanel.add(new JLabel(scholar.getName()));
							for(int i = 0; i < scholar.getInstitutionalAffiliations().size(); i++){
								institutionPanel.add(new JLabel(scholar.getInstitutionalAffiliations().get(i)));
							}
							for(int i = 0; i < scholar.getResearchAreas().size(); i++){
								researchAreaPanel.add(new JLabel(scholar.getResearchAreas().get(i)));
							}
							for(int i = 0; i < scholar.getConferencePapers().size(); i++){
								conferencePaperPanel.add(new JLabel(scholar.getConferencePapers().get(i).toString()));
							}
							for(int i = 0; i < scholar.getJournalArticles().size(); i++){
								journalArticlePanel.add(new JLabel(scholar.getJournalArticles().get(i).toString()));
							}
							for(int i = 0; i < scholar.getChairs().size(); i++){
								chairPanel.add(new JLabel(scholar.getChairs().get(i).toString()));
							}
							for(int i = 0; i < scholar.getCommittees().size(); i++){
								committeePanel.add(new JLabel(scholar.getCommittees().get(i).toString()));
							}
							for(int i = 0; i < scholar.getEditingPositions().size(); i++){
								editorPanel.add(new JLabel(scholar.getEditingPositions().get(i).toString()));
							}
							for(int i = 0; i < scholar.getReviewingPositions().size(); i++){
								reviewerPanel.add(new JLabel(scholar.getReviewingPositions().get(i).toString()));
							}
							Box infoBox = Box.createVerticalBox();
							infoBox.add(Box.createVerticalGlue());
							infoBox.add(namePanel);
							infoBox.add(Box.createVerticalStrut(verticalMargin));
							if(scholar.getInstitutionalAffiliations().size() > 0){
								infoBox.add(institutionPanel);
								infoBox.add(Box.createVerticalStrut(verticalMargin));
							}
							if(scholar.getResearchAreas().size() > 0){
								infoBox.add(researchAreaPanel);
								infoBox.add(Box.createVerticalStrut(verticalMargin));
							}
							if(scholar.getConferencePapers().size() > 0){
								infoBox.add(conferencePaperPanel);
								infoBox.add(Box.createVerticalStrut(verticalMargin));
							}
							if(scholar.getJournalArticles().size() > 0){
								infoBox.add(journalArticlePanel);
								infoBox.add(Box.createVerticalStrut(verticalMargin));
							}
							if(scholar.getChairs().size() > 0){
								infoBox.add(chairPanel);
								infoBox.add(Box.createVerticalStrut(verticalMargin));
							}
							if(scholar.getCommittees().size() > 0){
								infoBox.add(committeePanel);
								infoBox.add(Box.createVerticalStrut(verticalMargin));
							}
							if(scholar.getEditingPositions().size() > 0){
								infoBox.add(editorPanel);
								infoBox.add(Box.createVerticalStrut(verticalMargin));
							}
							if(scholar.getReviewingPositions().size() > 0){
								infoBox.add(reviewerPanel);
								infoBox.add(Box.createVerticalStrut(verticalMargin));
							}
							infoDialog.add(infoBox, BorderLayout.CENTER);
							infoDialog.pack();
							infoDialog.setLocationRelativeTo(selectionView);
							infoDialog.setModal(true);
							infoDialog.setVisible(true);
						}
					});
				}
				else if(e.getSource() == selectionView.getSerialList()){
				}
				else if(e.getSource() == selectionView.getPaperList()){
				}
			}
		}
	}
	
	/**
	 * Listens for clicks to open up the display view
	 */
	private class DisplayViewListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(displayView == null || model.getScholarMap().isEmpty()){
				return;
			}
			if(e.getSource() == selectionView.getTypeMenuItem()){
				displayView.setGraphType(DisplayView.PUBLICATION_TYPE);
			}
			else if(e.getSource() == selectionView.getPubsPerYearMenuItem()){
				displayView.setGraphType(DisplayView.PUBLICATIONS_PER_YEAR);
			}
			else if(e.getSource() == selectionView.getConfPapsPerYearMenuItem()){
				displayView.setGraphType(DisplayView.CONFERENCE_PAPERS_PER_YEAR);
			}
			else if(e.getSource() == selectionView.getJourArtsPerYearMenuItem()){
				displayView.setGraphType(DisplayView.JOURNAL_ARTICLES_PER_YEAR);
			}
			else if(e.getSource() == selectionView.getNumOfCoauthsMenuItem()){
				displayView.setGraphType(DisplayView.NUMBER_OF_COAUTHORS);
			}
			JDialog displayDialog = new JDialog();
			displayDialog.add(displayView, BorderLayout.CENTER);
			displayDialog.setSize(selectionView.getWidth(), selectionView.getHeight());
			displayDialog.setLocationRelativeTo(selectionView);
			displayDialog.setModal(true);
			displayDialog.setVisible(true);
		}
	}
}
