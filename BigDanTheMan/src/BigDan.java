import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BigDan extends JFrame{
	private int width;
	private int height;
	private int toolbarHeight;
	private BigDan thisClass;
	private JLabel[][] cellLabels;
	private int[][] sudokuArray;
	private MouseListener cellListener;
	
	public BigDan(){
		thisClass = this;
		init();
	}
	
	private void init(){
		width = 500;
		height = 580;
		toolbarHeight = 80;
		cellLabels = new JLabel[9][9];
		sudokuArray = new int[9][9];
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
				solvePuzzle();
				return;
				/*final JDialog lulzDialog = new JDialog(thisClass, "Bro you didn't omg like wow", true);
				JLabel theLabel = new JLabel("Cool story bro.");
				theLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 32));
				JButton theButton = new JButton("yeah");
				theButton.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
				theButton.setMargin(new Insets(6, 6, 6, 6));
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
				lulzDialog.setVisible(true);*/
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
				nextLabel = new JLabel("-");
				nextLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				nextLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
				nextLabel.setHorizontalAlignment(JLabel.CENTER);
				cellLabels[(i/3)*3+j/3][j%3+(i%3)*3] = nextLabel;
				nextPanel.add(nextLabel);
			}
			nextPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
			contentPanel.add(nextPanel);
		}
		cellListener = new CellListener(cellLabels);
		for(int i = 0; i < cellLabels.length; i++){
			for(int j = 0; j < cellLabels[i].length; j++){
				cellLabels[i][j].addMouseListener(cellListener);
			}
		}
		contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPanel.setPreferredSize(new Dimension(width, height - toolbarHeight - getInsets().top));
		add(contentPanel);
	}
	
	/**
	 * Updates the sudokuArray with values from the cellLabels
	 * Sets empty cells to 0
	 */
	private void updateSudokuArray(){
		for(int i = 0; i < cellLabels.length; i++){
			for(int j = 0; j < cellLabels[i].length; j++){
				try{
					sudokuArray[i][j] = Integer.parseInt(cellLabels[i][j].getText());
				}
				catch(NumberFormatException e){
					sudokuArray[i][j] = 0;
				}
			}
		}
	}
	
	/**
	 * Adds one valid number to the current puzzle
	 * Note that this method implies multiple solutions to many puzzles (if they have few enough numbers already in them)
	 */
	private void solveRandom(){
	}
	
	/**
	 * Adds all valid numbers to the current puzzle
	 */
	private void solvePuzzle(){
		updateSudokuArray();
		ArrayList<int[]> cellsSolved = new ArrayList<int[]>();
		int setk = -1;
		for(int i = 0; i < cellLabels.length; i++){
			for(int j = 0; j < cellLabels[i].length; j++){
				System.out.println(sudokuArray[i][j]);
				if(sudokuArray[i][j] == 0){
					if(cellsSolved.size() != 0 && cellsSolved.get(cellsSolved.size() - 1)[0] == j && cellsSolved.get(cellsSolved.size() - 1)[1] == i){
						setk = cellsSolved.get(cellsSolved.size() - 1)[2] + 1;
						cellsSolved.remove(cellsSolved.size() - 1);
					}
					else setk = -1;
					for(int k = setk==-1? 1:setk; k <= 9; k++){
						//try{Thread.sleep(4);}catch(Exception e){}
						System.out.println(i + "," + j + "," + k);
						sudokuArray[i][j] = k;
						if(solve(sudokuArray, i, j)){
							cellsSolved.add(new int[]{i, j, k});
							cellLabels[i][j].setText(""+sudokuArray[i][j]);
							break;
						}
						else if(k == 9){
							System.out.println("this");
							for(int[] bro: cellsSolved)
								System.out.println("bro: " + bro[0] + ", " + bro[1]);
							System.out.println(cellsSolved.get(cellsSolved.size() - 1)[0]);
							System.out.println(cellsSolved.get(cellsSolved.size() - 1)[1]);
							i = cellsSolved.get(cellsSolved.size() - 1)[0];
							j = cellsSolved.get(cellsSolved.size() - 1)[1];
							sudokuArray[i][j] = 0;
							if(j == cellLabels[i].length - 1)
								i--; //commenting this out might work
							j--;
						}
					}
				}
			}
		}
		
		//print the result for testing
		for(int i = 0; i < sudokuArray.length; i++){
			for(int j = 0; j < sudokuArray[i].length; j++){
				System.out.print(sudokuArray[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private boolean solve(int[][] sudoku, int row, int col){
		ArrayList<Integer> possibleSolutions = getPossibleSolutions(sudoku, row, col);
		if(possibleSolutions.contains(sudoku[row][col]))
			return true;
		return false;
	}
	
	public ArrayList<Integer> getPossibleSolutions(int[][] sudoku, int row, int col){
		ArrayList<Integer> possibleSolutions = new ArrayList<Integer>();
		for(int i = 1; i <= 9; i++)
			possibleSolutions.add(i);
		//Go through the row
		for(int i = 0; i < sudoku[row].length; i++){
			if(sudoku[row][i] != 0 && i != col)
				possibleSolutions.remove(new Integer(sudoku[row][i]));
		}
		//Go through the column
		for(int i = 0; i < sudoku[col].length; i++){
			if(sudoku[i][col] != 0 && i != row)
				possibleSolutions.remove(new Integer(sudoku[i][col]));
		}
		//TODO Go through the box
		
		return possibleSolutions;
	}
	
	private class CellListener implements MouseListener{
		private JLabel[][] cellLabels;
		MouseEvent originalMouseEvent;
		JDialog lulzDialog = new JDialog(thisClass, "Edit Cell Value", true);
		JTextField theTextField = new JTextField();
		public CellListener(JLabel[][] cellLabels){
			this.cellLabels = cellLabels;
			theTextField.setPreferredSize(new Dimension(width/4, 40));
			theTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 32));
			theTextField.setHorizontalAlignment(JTextField.CENTER);
			JButton theButton = new JButton("Update Value");
			theButton.setFont(new Font(Font.SERIF, Font.PLAIN, 28));
			theButton.setMargin(new Insets(6, 6, 6, 6));
			lulzDialog.setLayout(new FlowLayout(FlowLayout.CENTER));
			lulzDialog.add(theTextField);
			lulzDialog.add(theButton);
			lulzDialog.setSize(width/2, width/4);
			lulzDialog.setLocationRelativeTo(null);
			CellDialogActionListener cdal = new CellDialogActionListener();
			theButton.addActionListener(cdal);
			theTextField.addActionListener(cdal);
		}
		public void mouseClicked(MouseEvent event){
			originalMouseEvent = event;
			lulzDialog.setVisible(true);
		}
		public void mouseEntered(MouseEvent arg0){
		}
		public void mouseExited(MouseEvent arg0){
		}
		public void mousePressed(MouseEvent arg0){
		}
		public void mouseReleased(MouseEvent arg0){
		}
		private class CellDialogActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				try{
					if(Integer.parseInt(theTextField.getText()) > 0 && Integer.parseInt(theTextField.getText()) < 10){
						for(int i = 0; i < cellLabels.length; i++){
							for(int j = 0; j < cellLabels[i].length; j++){
								if(cellLabels[i][j] == originalMouseEvent.getSource()){
									cellLabels[i][j].setText(theTextField.getText());
								}
							}
						}
						lulzDialog.setVisible(false);
					}
					else
						throw new NumberFormatException();
				}
				catch(NumberFormatException exc){
					JOptionPane.showMessageDialog(null, "Invalid Cell Value!");
				}
			}
		}
	}
}
