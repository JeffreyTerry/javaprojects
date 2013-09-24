import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
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
	JTextField searchTextField;
	JComboBox searchDropdown;

	private JButton defaultImportButton;
	private JButton defaultSwitchViewButton;
	private JButton modernImportButton;
	private JButton modernSwitchViewButton;
	
	private JLabel displayLabel;

	private DefaultControlListener controlListener;
	private ModernControlListener modernControlListener;
	private DefaultInputListener defaultInputListener;

	private int height;
	private int width;
	
	public PublicationSystemGUI(int width, int height){
		if(width < 520){
			width = 520;
		}
		if(height < 680){
			height = 680;
		}
		this.width = width;
		this.height = height;
		init();
	}
	
	private void init(){
		controlListener = new DefaultControlListener();
		modernControlListener = new ModernControlListener();
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
		sortLabel.setHorizontalAlignment(JLabel.RIGHT);
		sortDropdown = new JComboBox(sortOptions);
		sortDropdown.setPreferredSize(smallComponentDimension);
		JPanel sortPanel = new JPanel();
		sortPanel.setPreferredSize(new Dimension(smallComponentDimension.width * 2 + new FlowLayout().getHgap()*3, smallComponentDimension.height + new FlowLayout().getVgap()));
		sortPanel.add(sortLabel);
		sortPanel.add(sortDropdown);
		JLabel searchLabel1 = new JLabel("Search for ");  //Search panel stuff
		searchLabel1.setPreferredSize(smallComponentDimension);
		searchLabel1.setHorizontalAlignment(JLabel.RIGHT);
		JLabel searchLabel2 = new JLabel("Search by ");  //Search panel stuff
		searchLabel2.setPreferredSize(smallComponentDimension);
		searchLabel2.setHorizontalAlignment(JLabel.RIGHT);
		String[] searchOptions = {""};
		searchDropdown = new JComboBox(searchOptions);
		searchDropdown.setPreferredSize(smallComponentDimension);
		searchTextField = new JTextField();
		searchTextField.setPreferredSize(smallComponentDimension);
		JPanel searchPanel1 = new JPanel();
		JPanel searchPanel2 = new JPanel();
		searchPanel1.add(searchLabel1);
		searchPanel1.add(searchTextField);
		searchPanel2.add(searchLabel2);
		searchPanel2.add(searchDropdown);
		searchPanel1.setPreferredSize(new Dimension(smallComponentDimension.width * 2 + new FlowLayout().getHgap()*3, smallComponentDimension.height + new FlowLayout().getVgap()));
		searchPanel2.setPreferredSize(new Dimension(smallComponentDimension.width * 2 + new FlowLayout().getHgap()*3, smallComponentDimension.height + new FlowLayout().getVgap()));
		JButton printButton = new JButton("Print to File"); //Print panel stuff
		printButton.setPreferredSize(componentDimension);
		JPanel printPanel = new JPanel();
		printPanel.add(printButton);
		printPanel.setPreferredSize(new Dimension(smallComponentDimension.width * 2 + new FlowLayout().getHgap()*3, smallComponentDimension.height + new FlowLayout().getVgap()));
		inputPanel.setPreferredSize(new Dimension(smallComponentDimension.width * 2 + new FlowLayout().getHgap()*3, smallComponentDimension.height*4 + new FlowLayout().getVgap()*10));
		inputPanel.add(sortPanel);
		inputPanel.add(searchPanel1);
		inputPanel.add(searchPanel2);
		inputPanel.add(printPanel);

		modernImportButton = new JButton("Import Publication");
		modernImportButton.setPreferredSize(componentDimension);
		modernImportButton.addActionListener(modernControlListener);
		modernSwitchViewButton = new JButton("Switch View");
		modernSwitchViewButton.setPreferredSize(componentDimension);
		modernSwitchViewButton.addActionListener(modernControlListener);
		controlPanel.setPreferredSize(new Dimension(componentDimension.width, componentDimension.height*2 + new FlowLayout().getVgap()*3));
		controlPanel.add(modernImportButton);
		controlPanel.add(modernSwitchViewButton);
		
		FlowLayout flowy = new FlowLayout();
		flowy.setHgap(40);
		userPanel.setLayout(flowy);
		userPanel.setPreferredSize(new Dimension(width - new FlowLayout().getHgap()*2, smallComponentDimension.height*4 + new FlowLayout().getVgap()*12));
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
		if(getContentPane().getComponent(1) == defaultUserPanel){
			remove(defaultUserPanel);
			add(modernUserPanel, 1);
		}
		else if(getContentPane().getComponent(1) == modernUserPanel){
			remove(modernUserPanel);
			add(defaultUserPanel, 1);
		}
		validate();
		getContentPane().repaint();
	}
	
	private void importPublication(){
		//TODO
	}
	
	private void performTask(String task){
		//TODO
	}

	private class DefaultControlListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource().equals(defaultImportButton)){
				importPublication();
			}
			else if(event.getSource().equals(defaultSwitchViewButton)){
				switchView();
			}
		}
	}

	private class ModernControlListener implements ActionListener{
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
