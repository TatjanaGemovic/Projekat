package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PredmetiJTable extends JTable{

	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
	}
	
}
