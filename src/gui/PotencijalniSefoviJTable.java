package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PotencijalniSefoviJTable extends JTable{

	private static final long serialVersionUID = 3057837254453574988L;
	public static int rowSelectedIndex = -1;
	public static JTable tabelaPotencijalni;
	public static AbstractTableModelPotencijalniSef potencijalniModel;
	
	public PotencijalniSefoviJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPotencijalniSef());
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setGridColor(Color.LIGHT_GRAY);
		//this.potencijalniModel = new AbstractTableModelPotencijalniSef();
		
		potencijalniModel = (AbstractTableModelPotencijalniSef) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaPotencijalni = (JTable) e.getComponent();
				if(tabelaPotencijalni.getSelectedRow()!=-1) {
					rowSelectedIndex = tabelaPotencijalni.convertRowIndexToModel(tabelaPotencijalni.getSelectedRow());
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
		potencijalniModel.fireTableDataChanged();
	}
	
}
