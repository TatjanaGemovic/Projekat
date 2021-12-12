package gui;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TabbedPane extends JTabbedPane{
	
	public TabbedPane() {
		
		JComponent studenti = new JTable();
		//JScrollPane studentiP = new JScrollPane(studenti);
		this.addTab("Studenti", studenti);
		
		JComponent profesori = new JTable();
		//JScrollPane profesoriP = new JScrollPane(profesori);
		this.addTab("Profesori", profesori);
		
		JComponent predmeti = new JTable();
		//JScrollPane predmetiP = new JScrollPane(predmeti);
		this.addTab("Predmeti", predmeti);
		
		
	}

}
