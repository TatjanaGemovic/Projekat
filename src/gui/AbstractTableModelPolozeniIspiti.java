package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaPolozenih;
import model.BazaProfesora;

public class AbstractTableModelPolozeniIspiti extends AbstractTableModel {
	
	
	public AbstractTableModelPolozeniIspiti() {
		BazaProfesora.getInstance();
	}

	@Override
	public int getRowCount() {
		return BazaPolozenih.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return BazaPolozenih.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaPolozenih.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPolozenih.getInstance().getValueAt(rowIndex, columnIndex);	
	}
}
