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

public class ProfesoriJTable extends JTable{

	private static final long serialVersionUID = 5028665682816571467L;
	private static JTable tabelaProfesora;
	public static int rowSelectedIndex = -1;
	public static AbstractTableModelProfesori profesorModel;
	
	public ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori());
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setGridColor(Color.LIGHT_GRAY);
		
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
}
