package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetiJTable extends JTable{

	public static int rowSelectedIndex = -1;
	public static JTable tabelaPredmeta;
	public static AbstractTableModelPredmeti predmetModel;
	
	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setGridColor(Color.LIGHT_GRAY);
		this.predmetModel = new AbstractTableModelPredmeti();
		
		predmetModel = (AbstractTableModelPredmeti) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaPredmeta = (JTable) e.getComponent();
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
		predmetModel.fireTableDataChanged();
	}
}
