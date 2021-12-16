package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane{
	
	static public TrenTab tabIndex = TrenTab.Student;
	
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
	            int tabIndex1 = (int) ((JTabbedPane) e.getComponent()).getSelectedIndex();
	            if(tabIndex1==0) {
	            	tabIndex = TrenTab.Student;
	            	StatusBar.nazivTaba.setText("- Studenti");
	            }
	            else if(tabIndex1==1) {
	            	tabIndex = TrenTab.Profesor;
	            	StatusBar.nazivTaba.setText("- Profesori");
	            }
	            else if(tabIndex1==2) {
	            	tabIndex = TrenTab.Predmet;
	            	StatusBar.nazivTaba.setText("- Predmeti");
	            }
	            
	        }
		});
	}
}
