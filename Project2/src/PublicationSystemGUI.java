import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class PublicationSystemGUI extends JFrame
{
	private JPanel titlePanel;
	private JPanel defaultUserPanel;
	private JPanel publicationDisplayPanel;
	
	private JLabel title;
	
	private JLabel userPrompt;
	private JTextField userInput;
	
	private JButton importButton;
	private JButton switchViewButton;
	
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
		inputPanel.setPreferredSize(new Dimension(componentDimension.width, componentDimension.height*2 + new FlowLayout().getVgap()*2));
		inputPanel.add(userPrompt);
		inputPanel.add(userInput);
		
		importButton = new JButton("Import Publication");
		importButton.setPreferredSize(componentDimension);
		switchViewButton = new JButton("Switch View");
		switchViewButton.setPreferredSize(componentDimension);
		controlPanel.setPreferredSize(new Dimension(componentDimension.width, componentDimension.height*2 + new FlowLayout().getVgap()*2));
		controlPanel.add(importButton);
		controlPanel.add(switchViewButton);
		
		FlowLayout flowy = new FlowLayout();
		flowy.setHgap(40);
		userPanel.setLayout(flowy);
		userPanel.setPreferredSize(new Dimension(width - new FlowLayout().getHgap()*2, componentDimension.height*2 + new FlowLayout().getVgap()*6));
		userPanel.add(inputPanel);
		userPanel.add(controlPanel);
		
		defaultUserPanel = userPanel;
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
			if(event.getSource() == importButton){
				importPublication();
			}
			else if(event.getSource() == switchViewButton){
				switchView();
			}
		}
	}

	private class ModernInputListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == userInput){
				importPublication();
			}
			else if(event.getSource() == switchViewButton){
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
