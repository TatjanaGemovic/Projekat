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
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class PredmetiJTable extends JTable{

	public static int rowSelectedIndex = -1;
	public static JTable tabelaPredmeta;
	public static AbstractTableModelPredmeti predmetModel;
	public static TableRowSorter<AbstractTableModelPredmeti>sortiranje;
	
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
        
        sortiranje=new TableRowSorter<AbstractTableModelPredmeti>(predmetModel);
        this.setRowSorter(sortiranje);
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
	
	public static void filterPredmeta(String s) {
	    RowFilter<AbstractTableModelPredmeti, Object> rf = null;
	    List<RowFilter<AbstractTableModelPredmeti, Object>>rfs=new ArrayList<RowFilter<AbstractTableModelPredmeti, Object>>();
	    try {
	    	String[] temp = s.split(",", 2);
	    	if(temp.length == 1) { //samo nazivi predmeta
	    		s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
	    		rf = RowFilter.regexFilter(s, 1);
	    	} else if(temp.length == 2){
	    			temp[0] = temp[0].substring(0,1).toUpperCase() + temp[0].substring(1).toLowerCase();
	    			rfs.add(RowFilter.regexFilter(temp[0], 1)); // filter za naziv
					temp[1] = temp[1].toUpperCase();
	    			rfs.add(RowFilter.regexFilter(temp[1], 0)); // filter za sifru
	    			rf = RowFilter.andFilter(rfs);
	    	} else{
	    		sortiranje.setRowFilter(null);
	    		return;
	    	}
	    	
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sortiranje.setRowFilter(rf);
	}
}
