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
	public static final int NUMBER_OF_COAUTHORS = 4;
	
	/** width of the panel */
	private int width;
	/** height of the panel */
	private int height;
	/** the int representation of the graph type */
	private int graphType;
	/** the Author being looked at */
	private Author author;
	/** the type selector */
	private JComboBox<String> typeSelector;

	
	/**
     * Initializes all of the variables specific to a publication date grapher excepting the Author
     * @param             width					width of the panel
     * @param             height				height of the panel
     * @param			  authorSelector		the selector for the authors
     */
	public PublicationDataGrapher(int width, int height, JSpinner authorSelector){
		this.width = width;
		this.height = height;
		graphType = -1;
		
		//This stuff creates the control panel stuff
		add(new JLabel("Author"));
		add(authorSelector);
		String[] types = {"Select Graph Parameter", "Publication Type", "Publications Per Year", "Conference Papers Per Year", "Journal Articles Per Year", "Coauthors"};
		typeSelector = new JComboBox<String>(types);
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
	public PublicationDataGrapher(int width, int height, JSpinner authorSelector, Author author){
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
		if(author == null){
			return;
		}
		
		if(graphType == PUBLICATION_TYPE){
			int[] values = {author.getConferencePapers().size(), author.getJournalArticles().size()};
			String[] labels = {"Conference Papers", "Journal Articles"};
			drawBars(values, labels, g);
		}
		else if(graphType == PUBLICATIONS_PER_YEAR || graphType == CONFERENCE_PAPERS_PER_YEAR || graphType == JOURNAL_ARTICLES_PER_YEAR){
			HashMap<String, Integer> dateMap = new HashMap<String, Integer>();
			ArrayList<ConferencePaper> conPaps = author.getConferencePapers();
			ArrayList<Article> jourArts = author.getJournalArticles();
			int tempVal = 0;
			String nextDate = "";
			if(graphType != JOURNAL_ARTICLES_PER_YEAR){
				for(int i = 0; i < conPaps.size(); i++){
					nextDate = conPaps.get(i).getDate();
					if(nextDate.split(" ").length > 1){
						nextDate = nextDate.split(" ")[1];
					}
					if(!dateMap.containsKey(nextDate)){
						dateMap.put(nextDate, 1);
					}
					else{
						tempVal = dateMap.get(nextDate);
						dateMap.put(nextDate, tempVal + 1);
					}
				}
			}
			if(graphType != CONFERENCE_PAPERS_PER_YEAR){
				for(int i = 0; i < jourArts.size(); i++){
					nextDate = jourArts.get(i).getDate();
					if(nextDate.split(" ").length > 1){
						nextDate = nextDate.split(" ")[1];
					}
					if(!dateMap.containsKey(nextDate)){
						dateMap.put(nextDate, 1);
					}
					else{
						tempVal = dateMap.get(nextDate);
						dateMap.put(nextDate, tempVal + 1);
					}
				}
			}
			ArrayList<String> keys = new ArrayList<String>(dateMap.keySet());
			String minDate = "9999";
			String maxDate = "0000";
			if(keys.size() == 0){
				return;
			}
			for(int i = 0; i < keys.size(); i++){
				if(keys.get(i).compareTo(minDate) < 0){
					minDate = keys.get(i);
				}
				if(keys.get(i).compareTo(maxDate) > 0){
					maxDate = keys.get(i);
				}
			}
			int[] values;
			String[] labels;
			int min = 0;
			int max = 0;
			try{
				min = Integer.parseInt(minDate);
				max = Integer.parseInt(maxDate);
			}
			catch(NumberFormatException e){
				return;
			}
			if(min > max){
				int temp = min;
				min = max;
				max = temp;
			}
			values = new int[max - min + 1];
			labels = new String[max - min + 1];
			for(int i = min; i <= max; i++){
				if(dateMap.get(""+i) == null){
					values[i - min] = 0;
				}
				else{
					values[i - min] = dateMap.get(""+i);
				}
				labels[i - min] = ""+i;
			}
			drawBars(values, labels, g);
		}
		else if(graphType == NUMBER_OF_COAUTHORS){
			HashMap<Integer, Integer> coauthorMap = new HashMap<Integer, Integer>();
			ArrayList<ConferencePaper> conPaps = author.getConferencePapers();
			ArrayList<Article> jourArts = author.getJournalArticles();
			int tempVal = 0;
			if(graphType != JOURNAL_ARTICLES_PER_YEAR){
				for(int i = 0; i < conPaps.size(); i++){
					if(!coauthorMap.containsKey(conPaps.get(i).getAuthors().length - 1)){
						coauthorMap.put(conPaps.get(i).getAuthors().length - 1, 1);
					}
					else{
						tempVal = coauthorMap.get(conPaps.get(i).getAuthors().length - 1);
						coauthorMap.put(conPaps.get(i).getAuthors().length - 1, tempVal + 1);
					}
				}
			}
			if(graphType != CONFERENCE_PAPERS_PER_YEAR){
				for(int i = 0; i < jourArts.size(); i++){
					if(!coauthorMap.containsKey(jourArts.get(i).getAuthors().length - 1)){
						coauthorMap.put(jourArts.get(i).getAuthors().length - 1, 1);
					}
					else{
						tempVal = coauthorMap.get(jourArts.get(i).getAuthors().length - 1);
						coauthorMap.put(jourArts.get(i).getAuthors().length - 1, tempVal + 1);
					}
				}
			}
			ArrayList<Integer> keys = new ArrayList<Integer>(coauthorMap.keySet());
			int minCoauthors = 9999;
			int maxCoauthors = -9999;
			for(int i = 0; i < keys.size(); i++){
				if(keys.get(i) < minCoauthors){
					minCoauthors = keys.get(i);
				}
				if(keys.get(i) > maxCoauthors){
					maxCoauthors = keys.get(i);
				}
			}
			int[] values = new int[maxCoauthors - minCoauthors + 1];
			String[] labels = new String[maxCoauthors - minCoauthors + 1];
			for(int i = minCoauthors; i <= maxCoauthors; i++){
				if(coauthorMap.get(i) == null){
					values[i - minCoauthors] = 0;
				}
				else{
					values[i - minCoauthors] = coauthorMap.get(i);
				}
				labels[i - minCoauthors] = ""+i;
			}
			drawBars(values, labels, g);
		}
		drawDecor(g);
	}
	
	/**
	 * draws the decor
	 * @param g			the Graphics to use
	 */
	private void drawDecor(Graphics g){
		int yTopOffset = 80;  //Should be the same as below
		int yBottomOffset = 28;  //Should be the same as below
		int xMargin = 28;  //Should be the same as below
		Font titleFont = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
		FontMetrics titleStick = g.getFontMetrics(titleFont);
		g.setColor(Color.DARK_GRAY);
		g.setFont(titleFont);

		g.drawLine(xMargin, height - yBottomOffset, width - xMargin, height - yBottomOffset);
		g.drawString(typeSelector.getSelectedItem().toString(), (width - titleStick.stringWidth(typeSelector.getSelectedItem().toString()))/2, yTopOffset - 10);
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
		if(values.length == 0){
			return;
		}
		Font labelFont = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
		FontMetrics labelStick = g.getFontMetrics(labelFont);
		g.setFont(labelFont);
		int yTopOffset = 80;  //Should be the same as above
		int yBottomOffset = 28;  //Should be the same as above
		int xMargin = 28;  //Should be the same as above
		int xPadding = 5 + (int)(400/Math.pow(values.length + 1, 2));
		int columnWidth = (width - ((values.length + 1) * xPadding) - xMargin * 2) / values.length;
		int maxValue = 1;
		for(int i = 0; i < values.length; i++){
			if(values[i] > maxValue){
				maxValue = values[i];
			}
		}
		int singleValueHeight = (height - yTopOffset - yBottomOffset - 10) / maxValue; // the (-10) is for padding within the graph
		for(int i = 0; i < values.length; i++){
			g.setColor(colors[i % colors.length]);
			g.fillRect(xMargin + (i + 1) * xPadding + i * columnWidth, height - yBottomOffset - values[i]*singleValueHeight, columnWidth, values[i]*singleValueHeight);
			g.setColor(Color.BLACK);
			g.drawString(labels[i], xMargin + (i + 1) * xPadding + i * columnWidth + (columnWidth - labelStick.stringWidth(labels[i]))/2, height - yBottomOffset + labelStick.getHeight());
			g.drawString(""+values[i], xMargin + (i + 1) * xPadding + i * columnWidth + (columnWidth - labelStick.stringWidth(""+values[i]))/2, height - yBottomOffset - values[i]*singleValueHeight - 4);
		}
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
