package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

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
	}
}
