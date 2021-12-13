package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class StudentiJTable extends JTable{

	public StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
	}
	
}
