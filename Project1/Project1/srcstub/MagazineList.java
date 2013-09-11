/**
 * Project #1
 * CS 2334, Section 10
 * 9/9/13
 * <P>
 * This class represents a list of magazines with which the user code can get
 * the magazines either unfiltered, or filtered by name, publisher, or date range.
 * It inherits from ArrayList<Magazine>.
 * </P>
 * @version 1.0
 */

public class MagazineList extends ArrayList<Magazine>{
     /**
     * Returns the magazines in the list matching the given title
     * <P>
     * Algorithm:<br>
     * 1. Return magazineList filtered by title<br>
     * </P>
      * @param title The title to search for
      * @return A MagazineList containing the given title (case insensitive)
     * <dt><b>Conditions:</b>
     * <dd>POST -     All magazines in the returned list match the title
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
     * <dt><b>Conditions:</b>
     * <dd>POST -     All magazines in the returned list match the publisher
     */
     public MagazineList getMagazinesByPublisher(String publisher){
     }
     /**
     * Returns the magazines in the list matching the given date range
     * <P>
     * Algorithm:<br>
     * 1. For every magazine in the list, check to see if it was publishing during the given time frame<br>
     * </P>
      * @param startDate
      * @param endDate
      * @return All magazines that were being published during the given time frame
     * <dt><b>Conditions:</b>
     * <dd>POST -     All magazines in the returned list match the date range
     */
     public MagazineList getMagazinesByDate(int startDate, int endDate){
     }
}
