package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaStudenata;


public class AbstractTableModelStudenti extends AbstractTableModel {


	public AbstractTableModelStudenti() {
		BazaStudenata.getInstance();
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);	
	}
	
}
