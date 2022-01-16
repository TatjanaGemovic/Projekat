package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SortOrder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class KatedreJTable extends JTable{

	public static int rowSelectedIndex = -1;
	public static JTable tabelaKatedri;
	public static AbstractTableModelKatedra katedraModel;
	
	public KatedreJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelKatedra());
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setGridColor(Color.LIGHT_GRAY);
		
		katedraModel = (AbstractTableModelKatedra) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaKatedri = (JTable) e.getComponent();
				if(tabelaKatedri.getSelectedRow()!=-1) {
					rowSelectedIndex = tabelaKatedri.convertRowIndexToModel(tabelaKatedri.getSelectedRow());
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
		katedraModel.fireTableDataChanged();
	}
}
