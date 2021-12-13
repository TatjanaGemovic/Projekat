package gui;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class DijalogIzmenaTabbedPane extends JTabbedPane{
	
	public DijalogIzmenaTabbedPane() {
		JScrollPane infoPane = new JScrollPane();
		JScrollPane polozeniPane = new JScrollPane();
		JScrollPane nepolozeniPane = new JScrollPane();
		this.add("Informacije", infoPane);
		this.add("Polozeni", polozeniPane);
		this.add("Nepolozeni", nepolozeniPane);
	}

}
