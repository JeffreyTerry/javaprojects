package Daniel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationView extends JPanel{

	private static final long serialVersionUID = -4977512579106035474L;

	public InformationView()
	{
		JPanel masterPanel = new JPanel();
		
		String openHTML = "<html>";
		String lineBreak = "<br></br>";
		String closeHTML = "</html>";
		
		String title = "<div style='text-align:center;'><h3>Information</h3></div>";
		
		String welcome1="Hello, and welcome to the Publication System! This program allows you to explore scholars through lists";
		String welcome2="of their works and through colored graphs. There are two ways to add information: you can enter each scholar";
		String welcome3="manually for optimal controll, or you can load previusly assembled scholars from a .schsys file for optimal speed.";
		String welcome=welcome1+lineBreak+welcome2+lineBreak+welcome3;
		
		String manualInstructions1="To enter a scholar manually, click the \"Add Scholar\" button and fill in all of the information areas.";
		String manualInstructions2="To add further information on the scholar, click the \"Add Serial\" or \"Add Paper\" button. Do note,";
		String manualInstructions3="however, that you must have at least one scholar to make a serial, and at least one serial to make a paper.";
		String manualInstructions4="In general, to add anything, perform operations from left to right.";
		String manualInstructions=manualInstructions1+lineBreak+manualInstructions2+lineBreak+manualInstructions3+lineBreak+manualInstructions4;
		
		String loadInstructions1="To load existing data, click \"File\" in the top left-hand corner of the screen and select \"Load Scholarship\".";
		String loadInstructions2="A file selection dialog will open, and you may select the data system you wish to upload. This will";
		String loadInstructions3="by default erase existing data, but you will be given first the option to save existing data, and then the";
		String loadInstructions4="option to maintain the existing information. Saving data is done through the \"File\" button in the same way";
		String loadInstructions5="you would load information.";
		String loadInstructions=loadInstructions1+lineBreak+loadInstructions2+lineBreak+loadInstructions3+lineBreak+loadInstructions4+lineBreak+loadInstructions5;
		
		String graphInstructions1="To graph data, simply select \"Plot\" and select the filter you wish to graph. This will open up a new";
		String graphInstructions2="window where you can view the graph as well as change the focused scholar or the filter. Closing this window";
		String graphInstructions3="will not shut down this program.";
		String graphInstructions=graphInstructions1+lineBreak+graphInstructions2+lineBreak+graphInstructions3;
		
		String additionalInformation1="Additionally, you may right click any scholar, serial, or paper to view the information it contains";
		String additionalInformation2="or delete it from the data system. Do note, however, that deleting a scholar will remove that scholar from";
		String additionalInformation3="any of his works, and, if relevent, delete those works from the system as well. To select multiple items,";
		String additionalInformation4="control+click on a windows computer or command+click on a mac. Multiple selection only for deletion,";
		String additionalInformation5="and only one item may be selected whe using \"Get Info\".";
		String additionalInformation=additionalInformation1+lineBreak+additionalInformation2+lineBreak+additionalInformation3+lineBreak+additionalInformation4+lineBreak+additionalInformation5;
		
		
		String finalText=openHTML+title+lineBreak+welcome+lineBreak+lineBreak+manualInstructions+lineBreak+lineBreak+loadInstructions+lineBreak+lineBreak+graphInstructions+lineBreak+lineBreak+additionalInformation+closeHTML;
		JLabel titleL = new JLabel(finalText);
		
		
		masterPanel.add(titleL);
		this.add(masterPanel);
		this.setVisible(true);
	}
}
