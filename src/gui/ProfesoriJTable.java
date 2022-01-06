package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SortOrder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class ProfesoriJTable extends JTable{

	private static JTable tabelaProfesora;
	public static int rowSelectedIndex = -1;
	public static AbstractTableModelProfesori profesorModel;
	public static TableRowSorter<AbstractTableModelProfesori>sortiranje;
	
	public ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori());
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setGridColor(Color.LIGHT_GRAY);
		this.profesorModel = new AbstractTableModelProfesori();
		
		profesorModel = (AbstractTableModelProfesori) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaProfesora = (ProfesoriJTable) e.getComponent();
				if(tabelaProfesora.getSelectedRow()!=-1) {
					rowSelectedIndex = tabelaProfesora.convertRowIndexToModel(tabelaProfesora.getSelectedRow());
				}

			}
		});
		//link sajta: https://www.py4u.net/discuss/597623?fbclid=IwAR3UBeaXJxfMmgkIg47MrvCGO0mPQK4CuULvinA7uyDwnfN1OdYCbt21ygg
		TableRowSorter<AbstractTableModelProfesori> sorter = new TableRowSorter<AbstractTableModelProfesori>(profesorModel) {
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
                        } else {
                        	return o1.compareTo(o2); 
                        }

                    }
                };
                return c;
            }
        };
        this.setRowSorter(sorter);
        
        sortiranje=new TableRowSorter<AbstractTableModelProfesori>(profesorModel);
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
		profesorModel.fireTableDataChanged();
	}
	
	public static void filterProfesora(String s) {
	    RowFilter<AbstractTableModelProfesori, Object> rf = null;
	    List<RowFilter<AbstractTableModelProfesori, Object>>rfs=new ArrayList<RowFilter<AbstractTableModelProfesori, Object>>();
	    try {
	    	String[] temp = s.split(",", 2);
	    	if(temp.length == 1) { //samo prezime profesora
	    		s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
	    		rf = RowFilter.regexFilter(s, 1);
	    	} else if(temp.length == 2){
	    			temp[0] = temp[0].substring(0,1).toUpperCase() + temp[0].substring(1).toLowerCase();
	    			rfs.add(RowFilter.regexFilter(temp[0], 1)); // filter za prezime
					temp[1] = temp[1].substring(0,1).toUpperCase() + temp[1].substring(1).toLowerCase();
	    			rfs.add(RowFilter.regexFilter(temp[1], 0)); // filter za ime
	    			rf = RowFilter.andFilter(rfs);
	    	} else {
	    		sortiranje.setRowFilter(null);
	    		return;
	    	}
	    	
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sortiranje.setRowFilter(rf);
	}
}
