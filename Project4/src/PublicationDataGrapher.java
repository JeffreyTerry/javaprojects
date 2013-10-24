import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * <P>
 * This class is the JPanel that handles the graphing
 * </P>
 * @version 1.0
 */

public class PublicationDataGrapher extends JPanel{
	/* Instance variables */
	
	/** the serialVersionID */
	private static final long serialVersionUID = 1L;
	/** the colors to be used for the graph*/
	private static final Color[] BAR_COLORS = {Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.RED};
	/** the location for the publication type label */
	public static final int PUBLICATION_TYPE = 0;
	/** the location for the publications per year label */
	public static final int PUBLICATIONS_PER_YEAR = 1;
	/** the location for the conference papers per year label */
	public static final int CONFERENCE_PAPERS_PER_YEAR = 2;
	/** the location for the journal articles per year label */
	public static final int JOURNAL_ARTICLES_PER_YEAR = 3;
	/** the location for the number of coauthorships label */
	public static final int NUMBER_OF_COAUTHORSHIPS = 4;
	
	/** width of the panel */
	private int width;
	/** height of the panel */
	private int height;
	/** the int representation of the graph type */
	private int graphType;
	/** the Author being looked at */
	private Author author;
	/** the type selector */
	private JComboBox typeSelector;

	/**
     * Initializes all of the variables specific to a publication date grapher
     * @param             width					width of the panel
     * @param             height				height of the panel
     * @param			  authorSelector		the selector for the authors
     */
	public PublicationDataGrapher(int width, int height, JTextField authorSelector){
		this.width = width;
		this.height = height;
		
		//This stuff creates the control panel stuff
		add(new JLabel("Author"));
		add(authorSelector);
		String[] types = {"Select Graph Parameter", "Publication Type", "Publications Per Year", "Conference Papers Per Year", "Journal Articles Per Year", "Coauthorships"};
		typeSelector = new JComboBox(types);
		typeSelector.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				graphType = typeSelector.getSelectedIndex() - 1;
				repaint();
			}
		});
		add(typeSelector);
	}
	
	/**
     * Initializes all of the variables specific to a publication date grapher
     * @param             width					width of the panel
     * @param             height				height of the panel
     * @param			  authorSelector		the selector for the authors
     * @param			  author				the Author to look at
     */
	public PublicationDataGrapher(int width, int height, JTextField authorSelector, Author author){
		this(width, height, authorSelector);
		this.author = author;
	}
	
	/**
	 * sets the background and draws the graph and decor
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(new Color(218, 223, 245));
		
		drawBarGraph(g);
		drawDecor(g);
	}
	
	/**
	 * draws the graph
	 * @param g			the Graphics to use
	 */
	private void drawBarGraph(Graphics g){
		//TODO
	}
	
	/**
	 * draws the decor
	 * @param g			the Graphics to use
	 */
	private void drawDecor(Graphics g){
		//TODO
	}

	/**
	 * draws the bars
	 * @param values	the values to graph
	 * @param labels	the labels to give the bars
	 * @param g			the Graphics to use
	 */
	private void drawBars(int[] values, String[] labels, Graphics g){
		drawBars(values, labels, BAR_COLORS, g);
	}

	/**
	 * draws the bars
	 * @param values	the values to graph
	 * @param labels	the labels to give the bars
	 * @param colors	the colors for the bars
	 * @param g			the Graphics to use
	 */
	private void drawBars(int[] values, String[] labels, Color[] colors, Graphics g){
		//TODO
	}
	
	/*
	 * Mutator Methods
	 */
	
	/**
	 * sets the Author		
	 * @param auth			the Author to look at
	 */
	public void setAuthor(Author auth){
		author = auth;
	}
	
	/**
	 * sets the graphType
	 * @param graphType		the graph type
	 */
	public void setGraphType(int graphType){
		this.graphType = graphType;
	}
}
