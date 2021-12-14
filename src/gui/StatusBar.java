package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class StatusBar extends JMenuBar {
	public static JLabel nazivTaba = new JLabel();
	public StatusBar() {
		JPanel nazivAplikacijePanel = new JPanel();
		nazivAplikacijePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel nazivApp = new JLabel("  Studentska slu�ba");
		nazivAplikacijePanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
		nazivAplikacijePanel.add(nazivApp);
		nazivAplikacijePanel.add(nazivTaba);
		
		add(nazivAplikacijePanel);
		
		JPanel datumVremePanel = new JPanel();
		datumVremePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		DateFormat formatirano = new SimpleDateFormat("HH:mm        dd.MM.yyyy.        ");;
		Date date = new Date();
		JLabel datumVreme = new JLabel(formatirano.format(date));
		datumVremePanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
		datumVremePanel.add(datumVreme);
		
		add(datumVremePanel);
		
	}
	void setTab(String s) {
		nazivTaba.setText(s);
	}
}