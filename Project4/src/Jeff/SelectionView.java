package Jeff;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import Daniel.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class SelectionView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ScholarshipModel model;
	
	/* Menu Items */
	private JMenuItem save = new JMenuItem("Save Scholarship");
	private JMenuItem load = new JMenuItem("Load Scholarship");
	private JMenuItem importItem = new JMenuItem("Import Scholarship");
	private JMenuItem export = new JMenuItem("Export Scholarship");
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem type = new JMenuItem("Types of Publication");
	private JMenuItem pubsPerYear = new JMenuItem("Publications Per Year");
	private JMenuItem confPapsPerYear = new JMenuItem("Conference Papers Per Year");
	private JMenuItem jourArtsPerYear = new JMenuItem("Journal Articles Per Year");
	private JMenuItem numOfCoauths = new JMenuItem("Number of Co-authors Per Publication");
	private JMenu plotMenu = new JMenu("Plot");
	private JMenuBar menuBar = new JMenuBar();
	
	/* GUI Items */
	private Box titleBox = Box.createVerticalBox();
	private JLabel titleLabel = new JLabel("ScholarPub");
	private JPanel itemPanel = new JPanel();
	private Box scholarBox = Box.createVerticalBox();
	private JLabel scholarLabel = new JLabel("Scholars");
	private DefaultListModel scholarListModel = new DefaultListModel();
	private JList scholarList = new JList(scholarListModel);
	private JButton addScholarButton = new JButton("Add Scholar");
	private JButton removeScholarButton = new JButton("Delete Selected Scholar");
	private JButton removeAllScholarsButton = new JButton("Delete All Scholars");
	private Box serialBox = Box.createVerticalBox();
	private JLabel serialLabel = new JLabel("Serials");
	private DefaultListModel serialListModel = new DefaultListModel();
	private JList serialList = new JList(serialListModel);
	private JButton addSerialButton = new JButton("Add Serial");
	private JButton removeSerialButton = new JButton("Delete Selected Serial");
	private JButton removeAllSerialsButton = new JButton("Delete All Serials");
	private Box paperBox = Box.createVerticalBox();
	private JLabel paperLabel = new JLabel("Papers");
	private DefaultListModel paperListModel = new DefaultListModel();
	private JList paperList = new JList(paperListModel);
	private JButton addPaperButton = new JButton("Add Paper");
	private JButton removePaperButton = new JButton("Delete Selected Paper");
	private JButton removeAllPapersButton = new JButton("Delete All Papers");
	
	public SelectionView(ScholarshipModel model){
		this.model = model;
		
		createMenu();
		addComponents();
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void createMenu(){
		fileMenu.add(save);
		fileMenu.add(load);
		fileMenu.add(importItem);
		fileMenu.add(export);
		
		plotMenu.add(type);
		plotMenu.add(pubsPerYear);
		plotMenu.add(confPapsPerYear);
		plotMenu.add(jourArtsPerYear);
		plotMenu.add(numOfCoauths);
		
		menuBar.add(fileMenu);
		menuBar.add(plotMenu);

		setJMenuBar(menuBar);		
	}
	
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
}
