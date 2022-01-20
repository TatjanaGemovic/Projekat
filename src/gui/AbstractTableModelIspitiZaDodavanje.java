package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaPredmeta;

public class AbstractTableModelIspitiZaDodavanje extends AbstractTableModel{


	private static final long serialVersionUID = -5854601283189548106L;

	public AbstractTableModelIspitiZaDodavanje() {
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

