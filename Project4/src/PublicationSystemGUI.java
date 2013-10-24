import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * <P>
 * This class represents a GUI which allows users to use publication systems.
 * </P>
 * @version 2.0
 */
public class PublicationSystemGUI extends JFrame
{
	/* instance variables */
	
	/**
	 * the serial version id
	 */
	private static final long serialVersionUID = 1L;


	/** the publicationSystem to interact with */
	private PublicationSystem publicationSystem;
	
	/** the title panel */
	private JPanel titlePanel;
	/** the default panel for the user */
	private JPanel defaultUserPanel;
	/** the non command line panel for the user */
	private JPanel modernUserPanel;
	/** the display area for the publications */
	private JPanel publicationDisplayPanel;
	
	/** the label for the title */
	private JLabel title;
	
	/** the lable for the user's prompt */
	private JLabel userPrompt;
	/** the lable for the user's input */
	private JTextField userInput;

	/** the JComboBox for the sort drop down */
	private JComboBox sortDropdown;
	/** the text field for searching */
	private JTextField searchTextField;
	/** the JComboBox for the search drop down */
	private JComboBox searchDropdown;

	/** the default import button */
	private JButton defaultImportButton;
	/** the default switch view button */
	private JButton defaultSwitchViewButton;
	/** the default button to toggle the graph*/
	private JButton defaultToggleGraphButton;
	/** the non-commandline import button */
	private JButton modernImportButton;
	/** the non-commandline switch view button */
	private JButton modernSwitchViewButton;
	/** the non-commandline button to toggle the graph*/
	private JButton modernToggleGraphButton;
	/** the button to print */
	private JButton printButton;
	
	/** the display label */
	private JLabel displayLabel;
	/** the object to handle graphing */
	private PublicationDataGrapher dataGrapher;
	/** the input field for the graph */
	private JTextField graphInputField;

	/** the default control listener */
	private DefaultControlListener controlListener;
	/** the non-commandline control listener */
	private ModernControlListener modernControlListener;
	/** the default input listener */
	private DefaultInputListener defaultInputListener;

	/** the height of the frame */
	private int height;
	/** the width of the frame */
	private int width;

	/**
     * Creates a GUI designed to allow a user to quickly access and modify a PublicationSystem.
     * @param             width      			The width of the GUI
     * @param             height        		The height of the GUI
     *
     * <dt><b>Conditions:</b>
     * <dd>PRE -		width >= 520 and height >= 680
     * <dd>POST -		The GUI is ready to go
     */
	public PublicationSystemGUI(int width, int height){
		//TODO
	}
	
	/**
	 * initializes everything
	 */
	private void init(){
		//TODO
	}
	
	/**
	 * creates the title panel
	 */
	private void createTitlePanel(){
		//TODO
	}

	/**
	 * creates the default user panel
	 */
	private void createDefaultUserPanel(){
		//TODO
	}

	/**
	 * creates the non command line user panel
	 */
	private void createModernUserPanel(){
		//TDO
	}
	
	/**
	 * creates the display panel for the publications
	 */
	private void createPublicationDisplayPanel(){
		//TODO
	}
	
	/**
	 * creates the data grapher
	 */
	private void createDataGrapher(){
		//TODO
	}

	/**
    * Makes the GUI visible to the user/
    */
	public void open(){
		setVisible(true);
	}

	/**
    * Makes the GUI invisible to the user/
    */
	public void close(){
		setVisible(false);
	}
	
	/**
	 * switches between graphs
	 */
	private void toggleGraph(){
		//TODO
	}
	
	/**
	 * switches from command line to non command line view or visa versa
	 */
	private void switchView(){
		//TODO
	}
	
	/** 
	 * imports a publication from a txt file
	 */
	private void importPublication(){
		publicationSystem.importPublication();
	}
	
	/**
	 * Sorts according to terms dictated by the sort drop down component
	 */
	private void sortPublications(){
		//TODO
	}
	
	/**
	 * performs the task the user requests
	 */
	private void performTask(String task){
		//TODO
	}

	/**
	 * this is the listener for the command line viewer
	 */
	private class DefaultControlListener implements ActionListener{
		/**
		 * performs the aproprate action based on the user's actions
		 */
		public void actionPerformed(ActionEvent event){
			//TODO
		}
	}

	/**
	 * this is the listener for the non command line viewer
	 */
	private class ModernControlListener implements ActionListener{
		/**
		 * performs the appropriate action based on the user's actions
		 */
		public void actionPerformed(ActionEvent event){
			//TODO
		}
	}

	/**
	 * this is the input listener for the non command line viewer
	 */
	private class DefaultInputListener extends KeyAdapter implements ActionListener{
		/**
		 * performs the appropriate action for when a key is released
		 */
		public void keyReleased(KeyEvent event){
			//TODO
		}
		/**
		 * performs the appropriate action based on the user's actions
		 */
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
}
