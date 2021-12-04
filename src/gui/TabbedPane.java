package gui;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TabbedPane extends JTabbedPane{
	
	public TabbedPane() {
		
		JComponent studenti = new JPanel();
		//studenti.setBackground(new Color());
		this.addTab("Studenti", studenti);
		
		JComponent profesori = new JPanel();
		this.addTab("Profesori", profesori);
		
		JComponent predmeti = new JPanel();
		this.addTab("Predmeti", predmeti);
	}

}
