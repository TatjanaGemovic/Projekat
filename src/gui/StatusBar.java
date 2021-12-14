package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class StatusBar extends JMenuBar {
	public static JLabel nazivTaba = new JLabel("- Studenti");
	public StatusBar() {
		JPanel nazivAplikacijePanel = new JPanel();
		nazivAplikacijePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel nazivApp = new JLabel("  Studentska služba");
		nazivAplikacijePanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
		nazivAplikacijePanel.add(nazivApp);
		nazivAplikacijePanel.add(nazivTaba);
		
		add(nazivAplikacijePanel);
		
		JPanel datumVremePanel = new JPanel();
		datumVremePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		DateFormat formatirano = new SimpleDateFormat("HH:mm        dd.MM.yyyy.        ");
		JLabel datumVreme = new JLabel();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		  public void run() {
			  Date date = new Date(System.currentTimeMillis());
			  datumVreme.setText(formatirano.format(date));;
		  }
		}, 0, 1000);

		datumVremePanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
		datumVremePanel.add(datumVreme);
		
		add(datumVremePanel);
		
	}
}