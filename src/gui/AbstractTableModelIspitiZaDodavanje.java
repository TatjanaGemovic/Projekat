package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaNepolozenihPredmeta;
import model.BazaPredmeta;

public class AbstractTableModelIspitiZaDodavanje extends AbstractTableModel{


	public AbstractTableModelIspitiZaDodavanje() {
		BazaPredmeta.getInstance();
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAtZaDodavanje(rowIndex, columnIndex);	
	}
	
}

