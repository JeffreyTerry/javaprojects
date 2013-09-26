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

/**
 * Project #2
 * CS 2334, Section 011
 * 9/19/2013
 * <P>
 * This class represents a GUI which allows users to use publication systems.
 * </P>
 * @version 1.0
 */
public class PublicationSystemGUI extends JFrame
{
	private JPanel titlePanel;
	private JPanel defaultUserPanel;
	private JPanel modernUserPanel;
	private JPanel publicationDisplayPanel;
	
	private JLabel title;
	
	private JLabel userPrompt;
	private JTextField userInput;

	private JComboBox sortDropdown;
	private JTextField searchTextField;
	private JComboBox searchDropdown;

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
	}
	
	private void init(){

	}
	
	private void createTitlePanel(){
	}

	private void createDefaultUserPanel(){
	}

	private void createModernUserPanel(){
	}
	
	private void createPublicationDisplayPanel(){
	}

	/**
    * Makes the GUI visible to the user/
    */
	public void open(){
	}

	/**
    * Makes the GUI invisible to the user/
    */
	public void close(){
	}
	
	private void switchView(){
	}
	
	private void importPublication(){
		//TODO
	}
	
	private void performTask(String task){
		//TODO
	}

	private class DefaultControlListener implements ActionListener{
	}

	private class ModernControlListener implements ActionListener{
	}

	private class DefaultInputListener extends KeyAdapter{
	}
}
