import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class PublicationDataGrapher extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	
	public PublicationDataGrapher(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.CYAN);
	}
}
