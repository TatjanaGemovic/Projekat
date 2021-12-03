package gui;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane{
	
	public TabbedPane() {
		JComponent studenti = new JPanel();
		this.addTab("Studenti", studenti);
		
		JComponent profesori = new JPanel();
		this.addTab("Profesori", profesori);
		
		JComponent predmeti = new JPanel();
		this.addTab("Predmeti", predmeti);
	}

}
