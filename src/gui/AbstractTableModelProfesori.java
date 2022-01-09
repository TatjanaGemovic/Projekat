package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel{

	public AbstractTableModelProfesori() {
		BazaProfesora.getInstance();
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);	
	}
	
}

class AbstractTableModelProfesori2 extends AbstractTableModel{

	public AbstractTableModelProfesori2() {
		BazaProfesora.getInstance();
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount2();
	}
	
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName2(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAt2(rowIndex, columnIndex);	
	}

	
}
