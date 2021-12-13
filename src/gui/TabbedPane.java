package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TabbedPane extends JTabbedPane{
	
	public TabbedPane() {
		
		StudentiJTable studenti = new StudentiJTable();
		JScrollPane studentiPane = new JScrollPane(studenti);
		this.add("Studenti", studentiPane);
		
		ProfesoriJTable profesori = new ProfesoriJTable();
		JScrollPane profesoriPane = new JScrollPane(profesori);
		this.add("Profesori", profesoriPane);
		
		PredmetiJTable predmeti = new PredmetiJTable();
		JScrollPane predmetiPane = new JScrollPane(predmeti);
		this.add("Predmeti", predmetiPane);
		
	}

}
