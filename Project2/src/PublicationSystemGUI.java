import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PublicationSystemGUI extends JFrame
{
	private JPanel titlePanel;
	private JPanel defaultUserPanel;
	private JPanel modernUserPanel;
	private JPanel publicationDisplayPanel;
	
	private JLabel title;
	
	private JLabel userPrompt;
	private JTextField userInput;

	JComboBox sortDropdown;
	JComboBox searchDropdown;

	private JButton defaultImportButton;
	private JButton defaultSwitchViewButton;
	private JButton modernImportButton;
	private JButton modernSwitchViewButton;
	
	private JLabel displayLabel;

	private ControlListener controlListener;
	private ModernInputListener modernInputListener;
	private DefaultInputListener defaultInputListener;

	private int height;
	private int width;
	
	public PublicationSystemGUI(int width, int height){
		this.width = width;
		this.height = height;
		init();
	}
	
	private void init(){
		controlListener = new ControlListener();
		modernInputListener = new ModernInputListener();
		defaultInputListener = new DefaultInputListener();
		
		createTitlePanel();
		createDefaultUserPanel();
		createModernUserPanel();
		createPublicationDisplayPanel();
		
		FlowLayout flowy = new FlowLayout();
		flowy.setAlignment(FlowLayout.LEADING);
		setLayout(flowy);
		add(titlePanel);
		add(defaultUserPanel);
		add(publicationDisplayPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);

	}
	
	private void createTitlePanel(){
		title = new JLabel("PUBLICATION SYSTEM");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font(Font.MONOSPACED, Font.TRUETYPE_FONT, 40));
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(width, 50));
		titlePanel.setLayout(new BorderLayout());
		titlePanel.add(title, BorderLayout.CENTER);
		this.titlePanel = titlePanel;
	}

	private void createDefaultUserPanel(){
		JPanel userPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel controlPanel = new JPanel();
		Dimension componentDimension = new Dimension(160, 32);
		
		userPrompt = new JLabel("Enter command");
		userPrompt.setHorizontalAlignment(JLabel.CENTER);
		userInput = new JTextField();
		userPrompt.setPreferredSize(componentDimension);
		userInput.setPreferredSize(componentDimension);
		userInput.addKeyListener(defaultInputListener);
		inputPanel.setPreferredSize(new Dimension(componentDimension.width, componentDimension.height*2 + new FlowLayout().getVgap()*3));
		inputPanel.add(userPrompt);
		inputPanel.add(userInput);
		
		defaultImportButton = new JButton("Import Publication");
		defaultImportButton.setPreferredSize(componentDimension);
		defaultImportButton.addActionListener(controlListener);
		defaultSwitchViewButton = new JButton("Switch View");
		defaultSwitchViewButton.setPreferredSize(componentDimension);
		defaultSwitchViewButton.addActionListener(controlListener);
		controlPanel.setPreferredSize(new Dimension(componentDimension.width, componentDimension.height*2 + new FlowLayout().getVgap()*3));
		controlPanel.add(defaultImportButton);
		controlPanel.add(defaultSwitchViewButton);

		FlowLayout flowy = new FlowLayout();
		flowy.setHgap(40);
		userPanel.setLayout(flowy);
		userPanel.setPreferredSize(new Dimension(width - new FlowLayout().getHgap()*2, componentDimension.height*2 + new FlowLayout().getVgap()*6));
		userPanel.add(inputPanel);
		userPanel.add(controlPanel);

		defaultUserPanel = userPanel;
	}

	private void createModernUserPanel(){
		JPanel userPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel controlPanel = new JPanel();
		Dimension componentDimension = new Dimension(160, 32);
		Dimension smallComponentDimension = new Dimension(80, 32);

		String[] sortOptions = {""};  //Sort panel stuff
		JLabel sortLabel = new JLabel("Sort by ");
		sortLabel.setPreferredSize(smallComponentDimension);
		sortDropdown = new JComboBox(sortOptions);
		sortDropdown.setPreferredSize(smallComponentDimension);
		JPanel sortPanel = new JPanel();
		sortPanel.setPreferredSize(new Dimension(smallComponentDimension.width * 2 + new FlowLayout().getHgap()*3, smallComponentDimension.height + new FlowLayout().getVgap()*2));
		sortPanel.add(sortLabel);
		sortPanel.add(sortDropdown);
		JLabel searchLabel = new JLabel("Search for ");  //Search panel stuff
		searchLabel.setPreferredSize(smallComponentDimension);
		String[] searchOptions = {""};
		searchDropdown = new JComboBox(searchOptions);
		searchDropdown.setPreferredSize(smallComponentDimension);
		JPanel searchPanel = new JPanel();
		searchPanel.add(searchLabel);
		searchPanel.add(searchDropdown);
		inputPanel.setPreferredSize(new Dimension(smallComponentDimension.width * 2 + new FlowLayout().getHgap()*3, smallComponentDimension.height*2 + new FlowLayout().getVgap()*3));
		JButton printButton = new JButton("Print to File"); //Print panel stuff
		JPanel printPanel = new JPanel();
		printPanel.add(printButton);
		printPanel.setPreferredSize(new Dimension(smallComponentDimension.width * 2 + new FlowLayout().getHgap()*3, smallComponentDimension.height*2 + new FlowLayout().getVgap()*3));
		inputPanel.setPreferredSize(new Dimension(componentDimension.width * 2 + new FlowLayout().getHgap()*3, componentDimension.height*4 + new FlowLayout().getVgap()*3));
		inputPanel.add(sortPanel);
		inputPanel.add(searchPanel);
		inputPanel.add(printPanel);

		modernImportButton = new JButton("Import Publication");
		modernImportButton.setPreferredSize(componentDimension);
		modernImportButton.addActionListener(controlListener);
		modernSwitchViewButton = new JButton("Switch View");
		modernSwitchViewButton.setPreferredSize(componentDimension);
		modernSwitchViewButton.addActionListener(controlListener);
		controlPanel.setPreferredSize(new Dimension(componentDimension.width, componentDimension.height*2 + new FlowLayout().getVgap()*3));
		controlPanel.add(modernImportButton);
		controlPanel.add(modernSwitchViewButton);
		
		FlowLayout flowy = new FlowLayout();
		flowy.setHgap(40);
		userPanel.setLayout(flowy);
		userPanel.setPreferredSize(new Dimension(width - new FlowLayout().getHgap()*2, componentDimension.height*4 + new FlowLayout().getVgap()*6));
		userPanel.add(inputPanel);
		userPanel.add(controlPanel);
		
		modernUserPanel = userPanel;
	}
	
	private void createPublicationDisplayPanel(){
		displayLabel = new JLabel();
		JScrollPane pane = new JScrollPane(displayLabel);
		JPanel displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(width - new FlowLayout().getHgap()*2, 400));
		displayPanel.setLayout(new BorderLayout());
		displayPanel.add(pane, BorderLayout.CENTER);
		publicationDisplayPanel = displayPanel;
	}
	
	public void open(){
		setVisible(true);
	}
	
	public void close(){
		setVisible(false);
	}
	
	private void switchView(){
		this.remove(defaultUserPanel);
		this.add(modernUserPanel, 1);
		this.validate();
		//TODO
	}
	
	private void importPublication(){
		//TODO
	}
	
	private void performTask(String task){
		//TODO
	}

	private class ControlListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource().equals(defaultImportButton)){
				importPublication();
			}
			else if(event.getSource().equals(defaultSwitchViewButton)){
				switchView();
			}
		}
	}

	private class ModernInputListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == modernImportButton){
				importPublication();
			}
			else if(event.getSource() == modernSwitchViewButton){
				switchView();
			}
		}
	}

	private class DefaultInputListener extends KeyAdapter{
		public void keyPressed(KeyEvent event){
			if(event.getSource() == userInput){
				performTask(userInput.getText().toUpperCase());
			}
		}
	}
}
