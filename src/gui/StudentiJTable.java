package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentiJTable extends JTable{

	private static StudentiJTable tabelaStudenata;
	public static int rowSelectedIndex = -1;
	
	public StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaStudenata = (StudentiJTable) e.getComponent();
				if(tabelaStudenata.getSelectedRow()!=-1) {
					rowSelectedIndex = tabelaStudenata.convertRowIndexToModel(tabelaStudenata.getSelectedRow());
				}

			}
			});
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if(isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

	public static void azurirajPrikaz() {
		AbstractTableModelStudenti studentModel = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		studentModel.fireTableDataChanged();
	}
	
	
	
}
