package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel{

	public AbstractTableModelProfesori() {
		BazaProfesora.getInstance();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
