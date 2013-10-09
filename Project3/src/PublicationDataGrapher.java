import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PublicationDataGrapher extends JPanel{
	private static final long serialVersionUID = 1L;
	private static final Color[] BAR_COLORS = {Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.RED};
	public static final int PUBLICATION_TYPE = 0;
	public static final int PUBLICATIONS_PER_YEAR = 1;
	public static final int CONFERENCE_PAPERS_PER_YEAR = 2;
	public static final int JOURNAL_ARTICLES_PER_YEAR = 3;
	public static final int NUMBER_OF_COAUTHORSHIPS = 4;
	
	private int width;
	private int height;
	private int graphType;
	private Author author;
	private JComboBox typeSelector;

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
	
	public PublicationDataGrapher(int width, int height, JTextField authorSelector, Author author){
		this(width, height, authorSelector);
		this.author = author;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(new Color(218, 223, 245));
		
		drawBarGraph(g);
		drawDecor(g);
	}
	
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
				for(int i = 0; i < conPaps.size(); i++){  //TODO TEST THIS ALGORITHM
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
			int min = Integer.parseInt(minDate);
			int max = Integer.parseInt(maxDate);
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
		else if(graphType == NUMBER_OF_COAUTHORSHIPS){
			HashMap<Integer, Integer> coauthorMap = new HashMap<Integer, Integer>();
			ArrayList<ConferencePaper> conPaps = author.getConferencePapers();
			ArrayList<Article> jourArts = author.getJournalArticles();
			int tempVal = 0;
			if(graphType != JOURNAL_ARTICLES_PER_YEAR){
				for(int i = 0; i < conPaps.size(); i++){  //TODO TEST THIS ALGORITHM
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

	private void drawBars(int[] values, String[] labels, Graphics g){
		drawBars(values, labels, BAR_COLORS, g);
	}

	private void drawBars(int[] values, String[] labels, Color[] colors, Graphics g){
		for(int i = 0; i < values.length; i++){
			System.out.print(labels[i]+": "+values[i]+", ");
		}
		System.out.println();
		Font labelFont = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
		FontMetrics labelStick = g.getFontMetrics(labelFont);
		g.setFont(labelFont);
		int yTopOffset = 80;  //Should be the same as above
		int yBottomOffset = 28;  //Should be the same as above
		int xMargin = 28;  //Should be the same as above
		int xPadding = 4 + 5/values.length;
		int columnWidth = (width - ((values.length + 1) * xPadding) - xMargin * 2) / values.length;
		int maxValue = 0;
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
	
	public void setAuthor(Author auth){
		author = auth;
	}
	
	public void setGraphType(int graphType){
		this.graphType = graphType;
	}
}
