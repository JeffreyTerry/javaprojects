package Jeff;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class ScholarPubController{
	private ScholarshipModel model;
	private SelectionView selectionView;
	private DisplayView displayView;
	
	public ScholarPubController(ScholarshipModel model){
		this.model = model;
	}

	public void setSelectionView(SelectionView view){
		selectionView = view;
		selectionView.getAddScholarsButton().addActionListener(new AddScholarsListener());
		selectionView.getAddSerialsButton().addActionListener(new AddSerialsListener());
		selectionView.getAddPapersButton().addActionListener(new AddPapersListener());
		selectionView.getRemoveScholarsButton().addActionListener(new RemoveScholarsListener());
		selectionView.getRemoveSerialsButton().addActionListener(new RemoveSerialsListener());
		selectionView.getRemovePapersButton().addActionListener(new RemovePapersListener());
		selectionView.getRemoveAllScholarsButton().addActionListener(new RemoveAllScholarsListener());
		selectionView.getRemoveAllSerialsButton().addActionListener(new RemoveAllSerialsListener());
		selectionView.getRemoveAllPapersButton().addActionListener(new RemoveAllPapersListener());

		selectionView.getSaveMenuItem().addActionListener(new SaveListener());
		selectionView.getLoadMenuItem().addActionListener(new LoadListener());
		selectionView.getImportMenuItem().addActionListener(new ImportListener());
		selectionView.getExportMenuItem().addActionListener(new ExportListener());
		
		DisplayViewListener odvl = new DisplayViewListener();
		selectionView.getTypeMenuItem().addActionListener(odvl);
		selectionView.getPubsPerYearMenuItem().addActionListener(odvl);
		selectionView.getConfPapsPerYearMenuItem().addActionListener(odvl);
		selectionView.getJourArtsPerYearMenuItem().addActionListener(odvl);
		selectionView.getNumOfCoauthsMenuItem().addActionListener(odvl);
	}
	
	public void setDisplayView(DisplayView view){
		displayView = view;
	}
	
	private class AddScholarsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class AddSerialsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class AddPapersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemoveScholarsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemoveSerialsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemovePapersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemoveAllScholarsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemoveAllSerialsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class RemoveAllPapersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}

	private class SaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class LoadListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class ImportListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}
	private class ExportListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
		}
	}

	private class DisplayViewListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(displayView == null){
				return;
			}
			if(e.getSource() == selectionView.getTypeMenuItem()){
				displayView.setGraphType(DisplayView.PUBLICATION_TYPE);
			}
			else if(e.getSource() == selectionView.getPubsPerYearMenuItem()){
				displayView.setGraphType(DisplayView.PUBLICATIONS_PER_YEAR);
			}
			else if(e.getSource() == selectionView.getConfPapsPerYearMenuItem()){
				displayView.setGraphType(DisplayView.CONFERENCE_PAPERS_PER_YEAR);
			}
			else if(e.getSource() == selectionView.getJourArtsPerYearMenuItem()){
				displayView.setGraphType(DisplayView.JOURNAL_ARTICLES_PER_YEAR);
			}
			else if(e.getSource() == selectionView.getNumOfCoauthsMenuItem()){
				displayView.setGraphType(DisplayView.NUMBER_OF_COAUTHORS);
			}
			JDialog displayDialog = new JDialog();
			displayDialog.add(displayView, BorderLayout.CENTER);
			displayDialog.setSize(selectionView.getWidth(), selectionView.getHeight());
			displayDialog.setLocationRelativeTo(selectionView);
			displayDialog.setModal(true);
			displayDialog.setVisible(true);
		}
	}
}
