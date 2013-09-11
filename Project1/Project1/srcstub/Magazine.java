/**
 * Project #1
 * CS 2334, Section 10
 * 9/9/13
 * <P>
 * This class represents a magazine object
 * </P>
 * @version 1.0
 */

public class Magazine{
    //Instance Variables
    private String title;
    private String publisher;
    private int issuesPerYear;
    private int startDate;
    private int endDate;
    /**
     * Default constructor; creates a new magazine with no title or publisher, 0 issues per year, and the largest possible date range.
     */
    public Magazine(){
    }
    /**
     * A constructor that does not take and end date
     *
     * @param     t    The title of the magazine
     * @param     p    The publisher of the magazine
     * @param     ipy    The issues published per year by the magazine
     * @param     sd    The date the magazine started publishing
     * <dt><b>Conditions:</b>
     * <dd>POST -     The magazine is created
     */
    public Magazine(String t, String p, int ipy, int sd){
    }
    /**
     * A constructor that does take an end date 
     *
     * @param     t    The title of the magazine
     * @param     p    The publisher of the magazine
     * @param     ipy    The issues published per year by the magazine
     * @param     sd    The date the magazine stopped publishing
     * <dt><b>Conditions:</b>
     * <dd>POST -     The magazine is created
     */
    public Magazine(String t, String p, int ipy, int sd, int ed){
    }
    /* Accessor methods */
    public String getPublisher(){
    }
    public int getStartDate(){
    }
    public int getEndDate(){
    }
    public String getTitle(){
    }
    public int getIssuesPerYear(){
    }
    
    /**
     * Formats the objects toString method to reflect a magazine's properties:
     * title, publisher, issuesPerYear, startDate[, endDate]
     */
    public String toString(){
    }
    
    /**
     * Overridden to reflect the traits necessary for magazine equality
     */
    public boolean equals(Object o){
    }
}
