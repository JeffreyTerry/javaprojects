import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Project #2
 * CS 2334, Section 011
 * 9/24/2013
 * <P>
 * This class represents a publication system, which allows for importing, printing, sorting, and searching of lists of publications.
 * </P>
 * @version 1.0
 */
public class PublicationSystem {
	/* Instance Variables */
	
	/**A list of all publications in the system*/
	private PublicationList publicationList;

	/**
     * Creates a publication system with no publications
     */
	public PublicationSystem(){
		publicationList = new PublicationList();
	}
	
	/*
     * Mutator Methods
     */
	
	 /**
     * This sorts papers by the date they were published
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>POST -         papers is sorted by the date they were published
     */
	public void sortByDate()
	{
		publicationList.sortByDate();
	}
	
	 /**
     * This sorts papers by the type of serial they are (Journal or ConfereneProceeding)
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>POST -         papers is sorted by the type of serial they are (Journal or ConfereneProceeding)
     */
	public void sortByType()
	{
		publicationList.sortByType();
	}
	
	/**
     * This sorts papers by the digital identifier associated with it alphanumerically
     * <P>
     * Algorithm:<br>
     * Algorithm not yet implemented.<br>
     * </P>
     * <dt><b>Conditions:</b>
     * <dd>POST -         papers is sorted by the digital identifier associated with it alphanumerically
     */
	public void sortByDigitalIdentifier()
	{
		publicationList.sortByDigitalIdentifier();
	}

	/**
    * This methods sorts papers by serial title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by serial title
    */
	public void sortBySerialTitle(){
		publicationList.sortBySerialTitle();
	}

	/**
    * This methods sorts papers by paper title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by paper title
    */
	public void sortByPaperTitle(){
		publicationList.sortByPaperTitle();
	}

	/**
    * This methods sorts papers by author
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by author
    */
	public void sortByAuthor(){
		publicationList.sortByAuthor();
	}

	/**
    * This methods sorts papers by bibliographic info
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by bibliographic info
    */
	public void sortByBibliographicInfo(){
		publicationList.sortByBibliographicInfo();
	}

	/**
    * This methods sorts papers by title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         Papers are sorted by a random characteristic
    */
	public void randomSort(){
		publicationList.randomSort();
	}
	
	public void importPublication(){
		String fileName = "";
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("What is the name of your file?");
		try{
			fileName = inputReader.readLine();
			BufferedReader fileReader = new BufferedReader(new FileReader(new File(fileName)));
			
			if(fileReader.readLine().equals("Conference Paper")){
				String authorString = fileReader.readLine();
				String[] authorNames = authorString.split("; ");
				String[] authorList = new String[authorNames.length];
				String lf[];
				for(int i = 0; i < authorNames.length; i++){
					lf = authorNames[i].split(", ");
					authorList[0] = lf[0];
					authorList[0] = lf[1];
				}
				String paperTitle = fileReader.readLine();
				String serialTitle = fileReader.readLine();
				int[] pageNumbers = new int[2];
				String pagesLine = fileReader.readLine();
				String[] pages = pagesLine.split("-");
				pageNumbers[0] = Integer.parseInt(pages[0]);
				pageNumbers[1] = Integer.parseInt(pages[1]);
				String date = fileReader.readLine();
				String digId = fileReader.readLine();
				if(digId != null){
					publicationList.add(new ConferencePaper(authorList, paperTitle, serialTitle, pageNumbers, date, digId));
				}
				else{
					publicationList.add(new ConferencePaper(authorList, paperTitle, serialTitle, pageNumbers, date, ""));
				}
			}
			else{
				String authorString = fileReader.readLine();
				String[] authorNames = authorString.split("; ");
				String[] authorList = new String[authorNames.length];
				String lf[];
				for(int i = 0; i < authorNames.length; i++){
					lf = authorNames[i].split(", ");
					authorList[0] = lf[0];
					authorList[0] = lf[1];
				}
				String paperTitle = fileReader.readLine();
				String serialTitle = fileReader.readLine();
				int[] pageNumbers = new int[2];
				String[] locInfo = fileReader.readLine().split(":");
				String[] pages = locInfo[1].split("-");
				String[] journalInfo = locInfo[1].split("(");
				int volume = Integer.parseInt(journalInfo[0]);
				int issue = Integer.parseInt(journalInfo[1].substring(0,1));
				pageNumbers[0] = Integer.parseInt(pages[0]);
				pageNumbers[1] = Integer.parseInt(pages[1]);
				String date = fileReader.readLine();
				String digId = fileReader.readLine();
				if(digId != null){
					publicationList.add(new ConferencePaper(authorList, paperTitle, serialTitle, pageNumbers, date, digId));
				}
				else{
					publicationList.add(new Article(authorList, paperTitle, serialTitle, pageNumbers, volume, issue, date, ""));
				}
			}
			fileReader.close();
		}
		catch(IOException e){e.printStackTrace();}
	}
	
	/*
	 * Accessor Methods
	 */
	
	public PublicationList getPublicationList(){
		return publicationList;
	}

	 /**
    * This prints the publications to a file
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>PRE  -         papers is not null
    * <dd>POST -         papers is correctly printed to the file <i>fileName</i>
    */
	public void printPublicationsToFile(String fileName){
	}
	
	/**
	 * Searches for a paper by title
    * <P>
    * Algorithm:<br>
    * Algorithm not yet implemented.<br>
    * </P>
    * <dt><b>Conditions:</b>
    * <dd>POST -         The correct paper is returned. A value of null is returned on failure.
	 */
	public Paper getPaper(String title){
		Paper paper = null;
		//TODO
		return paper;
	}
}
