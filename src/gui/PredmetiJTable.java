package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultRowSorter;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class PredmetiJTable extends JTable{

	public static int rowSelectedIndex = -1;
	public static JTable tabelaPredmeta;
	public static AbstractTableModelPredmeti predmetModel;
	public TableRowSorter<AbstractTableModelPredmeti>  sorter;
	
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

		TableRowSorter<AbstractTableModelPredmeti> sorter = new TableRowSorter<AbstractTableModelPredmeti>(predmetModel) {
            @Override
            public Comparator<String> getComparator(int column) {
                Comparator<String> c = new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        boolean ascending = getSortKeys().get(0).getSortOrder() == SortOrder.ASCENDING;
                        if (o1==null || o1.equals("")) {
                            if(ascending)
                                return 1;
                            else
                                return -1;
                        } else if(o2==null || o2.equals("")) {
                        	if(ascending)
                                return -1;
                            else
                                return 1;
                        } else if(o1.matches("^-?\\d+$") || o2.matches("^-?\\d+$")) {
                        	if(Integer.parseInt(o1)>Integer.parseInt(o2))
                                return 1;
                            else
                                return -1;
                        } else {
                        	return o1.compareTo(o2); 
                        }

                    }
                };
                return c;
            }
        };
        this.setRowSorter(sorter);
        sorter.sort();
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
