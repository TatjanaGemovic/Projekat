package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ProfesoriJTable extends JTable{

	public ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori());
	}
	
}
