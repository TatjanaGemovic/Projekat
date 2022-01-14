package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaNepolozenihPredmeta;

public class AbstractTableModelNepolozeniPredmeti extends AbstractTableModel{

	private static final long serialVersionUID = -3542608387421982181L;

	public AbstractTableModelNepolozeniPredmeti() {
		BazaNepolozenihPredmeta.getInstance();
	}

	@Override
	public int getRowCount() {
		return BazaNepolozenihPredmeta.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return BazaNepolozenihPredmeta.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaNepolozenihPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaNepolozenihPredmeta.getInstance().getValueAt(rowIndex, columnIndex);	
	}
	
}
