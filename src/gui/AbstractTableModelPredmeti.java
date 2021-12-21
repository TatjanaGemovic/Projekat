package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaPredmeta;


public class AbstractTableModelPredmeti extends AbstractTableModel{

	private static final long serialVersionUID = -7674380857889541927L;

	public AbstractTableModelPredmeti() {
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
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);	
	}
	
}
