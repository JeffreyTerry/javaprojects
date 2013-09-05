import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BigDan extends JFrame{
	private int width;
	private int height;
	private int toolbarHeight;
	private BigDan thisClass;
	
	public BigDan(){
		thisClass = this;
		init();
	}
	
	private void init(){
		width = 500;
		height = 580;
		toolbarHeight = 80;
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		addToolPanel();
		addContentPanel();
		
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void addToolPanel(){
		JButton pressMeBro = new JButton("Press me bro, I dare you");
		pressMeBro.setPreferredSize(new Dimension(width - 2, toolbarHeight - 4));
		pressMeBro.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				final JDialog lulzDialog = new JDialog(thisClass, "Bro you didn't omg like wow", true);
				JLabel theLabel = new JLabel("Cool story bro.");
				theLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 32));
				JButton theButton = new JButton("yeah");
				theButton.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
				theButton.setMargin(new Insets(8, 8, 8, 8));
				theButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						lulzDialog.setVisible(false);
					}
				});
				lulzDialog.setLayout(new FlowLayout(FlowLayout.CENTER));
				lulzDialog.add(theLabel);
				lulzDialog.add(theButton);
				lulzDialog.setSize(width/2, width/4);
				lulzDialog.setLocationRelativeTo(null);
				lulzDialog.setVisible(true);
			}
		});
		FlowLayout toolLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
		JPanel toolPanel = new JPanel();
		toolPanel.setLayout(toolLayout);
		toolPanel.add(pressMeBro);
		toolPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		toolPanel.setPreferredSize(new Dimension(width, toolbarHeight));
		add(toolPanel);
	}
	
	private void addContentPanel(){
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(3, 3, 0, 0));
		JPanel nextPanel;
		JLabel nextLabel;
		for(int i = 0; i < 9; i++){
			nextPanel = new JPanel();
			nextPanel.setLayout(new GridLayout(3, 3, 0, 0));
			for(int j = 0; j < 9; j++){
				nextLabel = new JLabel("0");
				nextLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				nextLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
				nextLabel.setHorizontalAlignment(JLabel.CENTER);
				nextPanel.add(nextLabel);
			}
			nextPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
			contentPanel.add(nextPanel);
		}
		contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPanel.setPreferredSize(new Dimension(width, height - toolbarHeight - getInsets().top));
		add(contentPanel);
	}
}
