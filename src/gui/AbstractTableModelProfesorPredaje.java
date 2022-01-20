package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaPredmeta;


public class AbstractTableModelProfesorPredaje extends AbstractTableModel{


	public AbstractTableModelProfesorPredaje() {
		BazaPredmeta.getInstance();
	}

	@Override
	public int getRowCount() {
		//return 20;
		return BazaPredmeta.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCountProfPredaje();
	}
	
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnNameProfPredaje(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAtProfesorPredaje(rowIndex, columnIndex);	
	}
	
}
