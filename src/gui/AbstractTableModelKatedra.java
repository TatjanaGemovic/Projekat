package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaKatedri;

public class AbstractTableModelKatedra extends AbstractTableModel{


	public AbstractTableModelKatedra() {
		BazaKatedri.getInstance();
	}

	@Override
	public int getRowCount() {
		return BazaKatedri.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return BazaKatedri.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaKatedri.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaKatedri.getInstance().getValueAt(rowIndex, columnIndex);	
	}
	
}