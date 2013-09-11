/**
 * Project #1
 * CS 2334, Section 10
 * 9/9/13
 * <P>
 * This class represents a data system object, which reads in a list of magazines from
 * a file. With that list, the user class can get the magazines either unfiltered, or
 * filtered by name, publisher, or date range.
 * </P>
 * @version 1.0
 */

public class DataSystemGUI extends JFrame{
    
    //Instance Variables
    /** Text fields to receive input */
    private JTextField inputPublisher;
    private JTextField inputMagTitle;
    private JTextField inputStartDate;
    private JTextField inputEndDate;

    /** A button that initiates a new search */
    private JButton searchButton;

    /** A label that shows all magazines which fulfill the requirements laid out by the user through the input fields */
    private JLabel displayLabel;
    
    /** The virtual data system that will be used */
    private DataSystem dataSystem;

    /**
     * Creates a new data system and sets up the GUI
     * 
     * <dt><b>Conditions:</b>
     * <dd>POST -     The data system is created and the GUI is set up to use.
     */
    public DataSystemGUI(){
    }

    /* Mutator Methods */
    
    /**
     * Sets up the GUI
     * 
     * <dt><b>Conditions:</b>
     * <dd>POST -     The GUI is set up to use.
     */
    private void init(){
    }

    /**
     * Reads in magazines given a file
     * @param fileName The path to the file
     */
    public void loadMagazines(String fileName){
    }

    /**
     * Opens the GUI
     */
    public void open(){
    }
    
    /**
     * Closes the GUI
     */
    public void close(){
    }
    
    /**
     * <P>
     * This class is used to listen for search events. That is, the user code wants to search the magazine list
     * for magazines 
     * </P>
     * @version 1.0
     */
    private class SearchListener implements ActionListener, KeyListener{
        public void actionPerformed(ActionEvent event){
        }
        public void keyPressed(KeyEvent event){
        }
        public void keyReleased(KeyEvent event){
        }
        public void keyTyped(KeyEvent event){
        }
        /**
         * This method searches the data system for the proper magazines, then updates the display label with its result.
         * <dt><b>Conditions:</b>
         * <dd>POST -     The display label for the magazines is updated with the proper magazines.
         */
        private void search(){
        }
    }
}
