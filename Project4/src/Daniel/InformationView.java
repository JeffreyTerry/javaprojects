package Daniel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationView extends JPanel{

	private static final long serialVersionUID = -4977512579106035474L;

	public InformationView()
	{
		JPanel masterPanel = new JPanel();
		String title = "<html><div style='text-align:center;'><h3>Information</h3></div></html>";
		String message = "<html><div style='text-align:left;'>Hello, and welcome to the Publication System! This program allows you to track the works of varius scholars through simple lists of individuals and the works created by those individuals and by a set of graphs.</div></html>";
		JLabel body = new JLabel(title+message);
		
		
		//masterPanel.add(title);
		masterPanel.add(body);
		this.add(masterPanel);
		this.setVisible(true);
	}
}
