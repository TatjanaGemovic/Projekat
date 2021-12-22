package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.KeyStroke;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -9132887326381921444L;

	public MenuBar(final JFrame parent) {

		ImageIcon icn = new ImageIcon("ikonice/new.png"); 
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem file_new = new JMenuItem("New", icn);
		file_new.setMnemonic(KeyEvent.VK_N);
		file_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		file_new.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (TabbedPane.tabIndex) {
					case Profesor:
						DijalogDodavanjaProfesora dodajEntitet1 = new DijalogDodavanjaProfesora(parent, "Dodavanje Profesora", true);
						dodajEntitet1.setVisible(true);
						break;
					case Predmet:
						DijalogDodavanjaPredmeta dodajEntitet2 = new DijalogDodavanjaPredmeta(parent, "Dodavanje Predmeta", true);
						dodajEntitet2.setVisible(true);
						break;
					default:
						DijalogDodavanjaStudenta dodajEntitet0 = new DijalogDodavanjaStudenta(parent, "Dodavanje Studenta", true);
						dodajEntitet0.setVisible(true);
				}
			}
		});
		
		
		icn = new ImageIcon("ikonice/save.png");
		JMenuItem file_save = new JMenuItem("Save", icn);
		file_save.setMnemonic(KeyEvent.VK_S);
		file_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		JMenu file_open = new JMenu("Open");
		icn = new ImageIcon("ikonice/24x24.png");
		file_open.setIcon(icn);
		file_open.setMnemonic(KeyEvent.VK_O);
		icn = new ImageIcon("ikonice/write.png");
		JMenuItem open_studenti = new JMenuItem("Studenti", icn);
		open_studenti.setMnemonic(KeyEvent.VK_M);
		open_studenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		icn = new ImageIcon("ikonice/bookshelf.png");
		JMenuItem open_predmeti = new JMenuItem("Predmeti", icn);
		open_predmeti.setMnemonic(KeyEvent.VK_J);
		open_predmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK));
		icn = new ImageIcon("ikonice/presentation.png");
		JMenuItem open_profesori = new JMenuItem("Profesori", icn);
		open_profesori.setMnemonic(KeyEvent.VK_L);
		open_profesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		icn = new ImageIcon("ikonice/customer.png");
		JMenuItem open_katedre = new JMenuItem("Katedre", icn);
		open_katedre.setMnemonic(KeyEvent.VK_K);
		open_katedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
		file_open.add(open_studenti);
		file_open.addSeparator();
		file_open.add(open_predmeti);
		file_open.addSeparator();
		file_open.add(open_profesori);
		file_open.addSeparator();
		file_open.add(open_katedre);
		icn = new ImageIcon("ikonice/close.png");
		JMenuItem file_close = new JMenuItem("Close", icn);
		file_close.setMnemonic(KeyEvent.VK_C);
		file_close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		file.add(file_new);
		file.addSeparator();
		file.add(file_save);
		file.addSeparator();
		file.add(file_open);
		file.addSeparator();
		file.add(file_close);

		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		icn = new ImageIcon("ikonice/writing copy.png");
		JMenuItem edit_entity = new JMenuItem("Edit", icn);
		edit_entity.setMnemonic(KeyEvent.VK_E);
		edit_entity.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		edit_entity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (TabbedPane.tabIndex) {
				case Profesor:
					if(ProfesoriJTable.rowSelectedIndex==-1 || ProfesoriJTable.rowSelectedIndex>=BazaProfesora.getInstance().getProfesori().size()) {
						
					} else {
						DijalogIzmenaProfesora izmeniProfesora = new DijalogIzmenaProfesora(parent, "Izmena Profesora", true);
						izmeniProfesora.setVisible(true);
					}
					break;
				case Predmet:
					if(PredmetiJTable.rowSelectedIndex==-1 || PredmetiJTable.rowSelectedIndex>=BazaPredmeta.getInstance().getPredmeti().size()) {
						
					} else {
						DijalogIzmenaPredmeta izmeniPredmet = new DijalogIzmenaPredmeta(parent, "Izmena Predmeta", true);
						izmeniPredmet.setVisible(true);
					}
					break;
				default:
					if(StudentiJTable.rowSelectedIndex==-1 || StudentiJTable.rowSelectedIndex>=BazaStudenata.getInstance().getStudenti().size()) {
						
					} else {
						DijalogIzmenaStudenta izmeniStudenta = new DijalogIzmenaStudenta(parent, "Izmena Studenta", true);
						izmeniStudenta.setVisible(true);
					}
			}
			}
		});
		icn = new ImageIcon("ikonice/trash.png");
		JMenuItem delete_entity = new JMenuItem("Delete", icn);
		delete_entity.setMnemonic(KeyEvent.VK_D);
		delete_entity.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		delete_entity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (TabbedPane.tabIndex) {
				case Profesor:
					if(ProfesoriJTable.rowSelectedIndex==-1 || ProfesoriJTable.rowSelectedIndex>=BazaProfesora.getInstance().getProfesori().size()) {
						
					} else {
						DijalogBrisanjaEntiteta obrisiEntitet = new DijalogBrisanjaEntiteta(parent, "Brisanje Profesora", true);
						obrisiEntitet.setVisible(true);
					}
					break;
				case Predmet:
					if(PredmetiJTable.rowSelectedIndex==-1 || PredmetiJTable.rowSelectedIndex>=BazaPredmeta.getInstance().getPredmeti().size()) {
						
					} else {
						DijalogBrisanjaEntiteta obrisiEntitet = new DijalogBrisanjaEntiteta(parent, "Brisanje Predmeta", true);
						obrisiEntitet.setVisible(true);
					}
					break;
				default:
					if(StudentiJTable.rowSelectedIndex==-1 || StudentiJTable.rowSelectedIndex>=BazaStudenata.getInstance().getStudenti().size()) {
						
					} else {
						DijalogBrisanjaEntiteta obrisiEntitet = new DijalogBrisanjaEntiteta(parent, "Brisanje Studenta", true);
						obrisiEntitet.setVisible(true);
					}
				}
			}
		});
		edit.add(edit_entity);
		edit.addSeparator();
		edit.add(delete_entity);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		icn = new ImageIcon("ikonice/help.png");
		JMenuItem help_help = new JMenuItem("Help", icn);
		help_help.setMnemonic(KeyEvent.VK_H);
		help_help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		icn = new ImageIcon("ikonice/info.png");
		JMenuItem help_about = new JMenuItem("About", icn);
		help_about.setMnemonic(KeyEvent.VK_A);
		help_about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		help.add(help_help);
		help.addSeparator();
		help.add(help_about);
		
		add(file);
		add(edit);
		add(help);
	}
}
