package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class NepolozeniPredmetiJTable extends JTable{

	private static final long serialVersionUID = -3771680337955633981L;
	public static int rowSelectedIndex = -1;
	private static JTable tabelaNepPredmeta;
	public static AbstractTableModelNepolozeniPredmeti nep_predmetiModel;
	
	public NepolozeniPredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelNepolozeniPredmeti());
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setGridColor(Color.LIGHT_GRAY);
		
		nep_predmetiModel = (AbstractTableModelNepolozeniPredmeti) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaNepPredmeta = (JTable) e.getComponent();
				if(tabelaNepPredmeta.getSelectedRow()!=-1) {
					rowSelectedIndex = tabelaNepPredmeta.convertRowIndexToModel(tabelaNepPredmeta.getSelectedRow());
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
		nep_predmetiModel.fireTableDataChanged();
		nep_predmetiModel.fireTableChanged(null);
	}
	
}
