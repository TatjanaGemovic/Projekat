package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetiJTable extends JTable{

	private static PredmetiJTable tabelaPredmeta;
	public static int rowSelectedIndex = -1;
	
	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaPredmeta = (PredmetiJTable) e.getComponent();
				if(tabelaPredmeta.getSelectedRow()!=-1) {
					rowSelectedIndex = tabelaPredmeta.convertRowIndexToModel(tabelaPredmeta.getSelectedRow());
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
		AbstractTableModelPredmeti predmetModel = (AbstractTableModelPredmeti) tabelaPredmeta.getModel();
		predmetModel.fireTableDataChanged();
	}
}
