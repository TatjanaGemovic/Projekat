package gui;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import model.BazaProfesora;

public class AbstractTableModelPotencijalniSef extends AbstractTableModel {
	public AbstractTableModelPotencijalniSef() {
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
		return BazaProfesora.getInstance().getValueAt3(rowIndex, columnIndex);	
	}
}
