package Jeff;

import Daniel.*;

/**
 * Project #3
 * CS 2334, Section 011
 * 10/9/2013
 * This class drives it all.
 * @version 2.0
 */
public class PublicationSystemDriver 
{
	public static void main(String args[])
	{
		ScholarshipModel model = new ScholarshipModel();
		DisplayView displayView = new DisplayView(model);
		SelectionView selectionView = new SelectionView(model);
		InformationView informationView = new InformationView();
		ScholarPubController controller = new ScholarPubController(model);
		controller.setSelectionView(selectionView);
		controller.setDisplayView(displayView);
		controller.setInformationView(informationView);
	}
}
