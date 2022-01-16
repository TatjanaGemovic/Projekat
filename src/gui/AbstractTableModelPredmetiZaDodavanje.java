package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaNepolozenihPredmeta;
import model.BazaPredmeta;

public class AbstractTableModelPredmetiZaDodavanje extends AbstractTableModel{


	public AbstractTableModelPredmetiZaDodavanje() {
		BazaPredmeta.getInstance();
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCountZaDodavanje();
	}
	
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnNameZaDodavanje(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAtZaDodavanje(rowIndex, columnIndex);	
	}
	
}

