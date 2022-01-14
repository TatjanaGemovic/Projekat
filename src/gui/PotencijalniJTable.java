package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PotencijalniJTable extends JTable {

	private static final long serialVersionUID = 7503488340915586556L;
	public static int rowSelectedIndex = -1;
	public static JTable tabelaZaDodavanje;
	public static AbstractTableModelIspitiZaDodavanje zaDodavanjeModel;
	
	public PotencijalniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelIspitiZaDodavanje());
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setGridColor(Color.LIGHT_GRAY);
		
		zaDodavanjeModel = (AbstractTableModelIspitiZaDodavanje) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaZaDodavanje = (JTable) e.getComponent();
				if(tabelaZaDodavanje.getSelectedRow()!=-1) {
					rowSelectedIndex = tabelaZaDodavanje.convertRowIndexToModel(tabelaZaDodavanje.getSelectedRow());
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
		zaDodavanjeModel.fireTableDataChanged();
	}
}
