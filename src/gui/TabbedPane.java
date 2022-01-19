package gui;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;

public class TabbedPane extends JTabbedPane{

	private static final long serialVersionUID = -5424422775845237928L;
	public static TrenTab tabIndex = TrenTab.Student;
	public static JTable predmeti;
	public static JTable studenti;
	public static JTable profesori;
	
	public TabbedPane() {
		
		studenti = new StudentiJTable();
		JScrollPane studentiPane = new JScrollPane(studenti);
		this.addTab("Studenti", studentiPane);
		this.setMnemonicAt(0, KeyEvent.VK_M);
		
		profesori = new ProfesoriJTable();
		JScrollPane profesoriPane = new JScrollPane(profesori);
		this.addTab("Profesori", profesoriPane);
		this.setMnemonicAt(1, KeyEvent.VK_L);
		
		predmeti = new PredmetiJTable();
		JScrollPane predmetiPane = new JScrollPane(predmeti);
		this.addTab("Predmeti", predmetiPane);
		this.setMnemonicAt(2, KeyEvent.VK_K);
		
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
	            int tabIndex1 = (int) ((JTabbedPane) e.getComponent()).getSelectedIndex();
	            if(tabIndex1==0) {
	            	tabIndex = TrenTab.Student;
	            	StatusBar.nazivTaba.setText("- " + MainFrame.getInstance().getResourceBundle().getString("open_studenti"));
	            }
	            else if(tabIndex1==1) {
	            	tabIndex = TrenTab.Profesor;
	            	StatusBar.nazivTaba.setText("- " + MainFrame.getInstance().getResourceBundle().getString("open_profesori"));
	            }
	            else if(tabIndex1==2) {
	            	tabIndex = TrenTab.Predmet;
	            	StatusBar.nazivTaba.setText("- " + MainFrame.getInstance().getResourceBundle().getString("open_predmeti"));
	            }
	            
	        }
		});
		
		
	}
	
	public static void filterPredmeta(String s) {
	    RowFilter<AbstractTableModelPredmeti, Object> rf = null;
	    List<RowFilter<AbstractTableModelPredmeti, Object>>rfs=new ArrayList<RowFilter<AbstractTableModelPredmeti, Object>>();
	    TableRowSorter<AbstractTableModelPredmeti>sortiranje=new TableRowSorter<AbstractTableModelPredmeti>(PredmetiJTable.predmetModel);
		predmeti.setRowSorter(sortiranje);
	    if(s.isEmpty()) {
	    	 sortiranje.setRowFilter(null);
	    	 TableRowSorter<AbstractTableModelPredmeti> sorter = new TableRowSorter<AbstractTableModelPredmeti>(PredmetiJTable.predmetModel) {
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
	         predmeti.setRowSorter(sorter);
	    	 return;
	    }
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
	
	public static void filterProfesora(String s) {
	    RowFilter<AbstractTableModelProfesori, Object> rf = null;
	    List<RowFilter<AbstractTableModelProfesori, Object>>rfs=new ArrayList<RowFilter<AbstractTableModelProfesori, Object>>();
	    TableRowSorter<AbstractTableModelProfesori>sortiranje=new TableRowSorter<AbstractTableModelProfesori>(ProfesoriJTable.profesorModel);
	    profesori.setRowSorter(sortiranje);
	    if(s.isEmpty()) {
	    	 sortiranje.setRowFilter(null);
	    	 TableRowSorter<AbstractTableModelProfesori> sorter = new TableRowSorter<AbstractTableModelProfesori>(ProfesoriJTable.profesorModel) {
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
	         profesori.setRowSorter(sorter);
	    	 return;
	    }
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
	public static void filterStudenata(String s) {
	    RowFilter<AbstractTableModelStudenti, Object> rf = null;
	    List<RowFilter<AbstractTableModelStudenti, Object>>rfs=new ArrayList<RowFilter<AbstractTableModelStudenti, Object>>();
	    TableRowSorter<AbstractTableModelStudenti>sortiranje=new TableRowSorter<AbstractTableModelStudenti>(StudentiJTable.studentModel);
	    studenti.setRowSorter(sortiranje);
	    if(s.isEmpty()) {
	    	 sortiranje.setRowFilter(null);
	    	 TableRowSorter<AbstractTableModelStudenti> sorter = new TableRowSorter<AbstractTableModelStudenti>(StudentiJTable.studentModel) {
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
		     studenti.setRowSorter(sorter);
	    	 return;
	    }
	    try {
	    	String[] temp = s.split(",", 3);
	    	if(temp.length == 1) { //samo prezime studenta
	    		s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
	    		rf = RowFilter.regexFilter(s, 2);
	    	} else if(temp.length == 2){
	    			temp[0] = temp[0].substring(0,1).toUpperCase() + temp[0].substring(1).toLowerCase();
	    			rfs.add(RowFilter.regexFilter(temp[0], 2)); // filter za prezime
					temp[1] = temp[1].substring(0,1).toUpperCase() + temp[1].substring(1).toLowerCase();
	    			rfs.add(RowFilter.regexFilter(temp[1], 1)); // filter za ime
	    			rf = RowFilter.andFilter(rfs);
	    	}
	    	else if(temp.length==3){
	    		temp[0] = temp[0].toUpperCase();
    			rfs.add(RowFilter.regexFilter(temp[0], 0)); // filter za index
	    		temp[1] = temp[1].substring(0,1).toUpperCase() + temp[1].substring(1).toLowerCase();
    			rfs.add(RowFilter.regexFilter(temp[1], 2)); // filter za prezime
				temp[2] = temp[2].substring(0,1).toUpperCase() + temp[2].substring(1).toLowerCase();
    			rfs.add(RowFilter.regexFilter(temp[2], 1)); // filter za ime
    			
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

	public static TrenTab getTabIndex() {
		// TODO Auto-generated method stub
		return tabIndex;
	}

	public void updateComponent() {
		 this.setTitleAt(0, MainFrame.getInstance().getResourceBundle().getString("open_studenti"));
		 this.setTitleAt(1, MainFrame.getInstance().getResourceBundle().getString("open_profesori"));
		 this.setTitleAt(2, MainFrame.getInstance().getResourceBundle().getString("open_predmeti"));
		
	}
}
