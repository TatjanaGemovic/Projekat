package gui;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

public class MenuBar extends JMenuBar {

	public MenuBar() {

ImageIcon icn = new ImageIcon("ikonice/new.png"); 
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem file_new = new JMenuItem("New", icn);
		file_new.setMnemonic(KeyEvent.VK_N);
		file_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
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
		icn = new ImageIcon("ikonice/trash.png");
		JMenuItem delete_entity = new JMenuItem("Delete", icn);
		delete_entity.setMnemonic(KeyEvent.VK_D);
		delete_entity.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
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
