/**
 * Project #1
 * CS 2334, Section 10
 * 9/9/13
 * <P>
 * This class represents a data system object, which reads in a list of magazines from
 * a file. With that list, the user code can get the magazines either unfiltered, or
 * filtered by name, publisher, or date range.
 * </P>
 * @version 1.0
 */

public class DataSystem {
    //Instance Variables
    private MagazineList magazineList;
    
    /**
     * Creates an empty magazine list for the new data system.
     */
    public DataSystem(){
    }
    
    /*
     * Accessor Methods
     */
    
    /**
     * Returns the entire list of magazines
     * <P>
     * Algorithm:<br>
     * 1. Return magazineList<br>
     * </P>
     * @return The entire magazine list
     *
     * <dt><b>Conditions:</b>
     * <dd>PRE  -         List any preconditions here.
     * <dd>POST -         List any postconditions here.
     */
    public MagazineList getMagazineList(){
    }
    /**
     * Returns the magazines in the list matching the given title
     * <P>
     * Algorithm:<br>
     * 1. Return magazineList filtered by title<br>
     * </P>
     * @param title The title to search for
     * @return A MagazineList containing the given title (case insensitive)
     */
    public MagazineList getMagazinesByTitle(String title){
    }
    
    /**
     * Returns the magazines in the list matching the given publisher
     * <P>
     * Algorithm:<br>
     * 1. Return magazineList filtered by publisher<br>
     * </P>
     * @param publisher The publisher to search for
     * @return A MagazineList containing the given publisher (case insensitive)
     */
    public MagazineList getMagazinesByPublisher(String publisher){
    }
    
    /**
     * Returns the magazines in the list matching the given date range
     * <P>
     * Algorithm:<br>
     * 1. Return magazineList filtered by date range<br>
     * </P>
     * @param startDate
     * @param endDate
     * @return All magazines that were being published during the given time frame
     */
    public MagazineList getMagazinesByDate(int startDate, int endDate){
    }
    
    /*
     * Mutator Methods
     */
    
    /**
     * Reads in magazines given a file
     * @param fileName The path to the file
     */
    public void readMagazines(String fileName){
    }
}
