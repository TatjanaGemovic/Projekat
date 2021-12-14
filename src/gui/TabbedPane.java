package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TabbedPane extends JTabbedPane{
	
	public TabbedPane() {
		
		StudentiJTable studenti = new StudentiJTable();
		JScrollPane studentiPane = new JScrollPane(studenti);
		this.addTab("Studenti", studentiPane);
		
		ProfesoriJTable profesori = new ProfesoriJTable();
		JScrollPane profesoriPane = new JScrollPane(profesori);
		this.addTab("Profesori", profesoriPane);
		
		PredmetiJTable predmeti = new PredmetiJTable();
		JScrollPane predmetiPane = new JScrollPane(predmeti);
		this.addTab("Predmeti", predmetiPane);
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
	            int tabIndex = (int) ((JTabbedPane) e.getComponent()).getSelectedIndex();
	            if(tabIndex==0) {
	            	System.out.println("0");
	            	StatusBar.nazivTaba.setText("- Studenti");
	            }
	            else if(tabIndex==1) {
	            	System.out.println("1");
	            	StatusBar.nazivTaba.setText("- Profesori");
	            }
	            else if(tabIndex==2) {
	            	System.out.println("2");
	            	StatusBar.nazivTaba.setText("- Predmeti");
	            }
	            
	        }
		});
		/*StudentiJTable studenti = new StudentiJTable();
		JScrollPane studentiPane = new JScrollPane(studenti);
		this.add("Studenti", studentiPane);
		
		ProfesoriJTable profesori = new ProfesoriJTable();
		JScrollPane profesoriPane = new JScrollPane(profesori);
		this.add("Profesori", profesoriPane);
		
		PredmetiJTable predmeti = new PredmetiJTable();
		JScrollPane predmetiPane = new JScrollPane(predmeti);
		this.add("Predmeti", predmetiPane);
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
	            int tabIndex = (int) ((JTabbedPane) e.getComponent()).getSelectedIndex();
	            if(tabIndex==0) System.out.println("studenti");
	            else if(tabIndex==0) System.out.println("profesori");
	            else if(tabIndex==0) System.out.println("predmeti");
	            
	        }
			
			
			
		});*/
	}
}
