package gui;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = -7863806568418316202L;

	public MenuBar() {

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem file_new = new JMenuItem("New");
		file_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		JMenuItem file_save = new JMenuItem("Save");
		file_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		JMenu file_open = new JMenu("Open");
		file_open.setMnemonic(KeyEvent.VK_O);
		JMenuItem open_studenti = new JMenuItem("Studenti");
		JMenuItem open_predmeti = new JMenuItem("Predmeti");
		JMenuItem open_profesori = new JMenuItem("Profesori");
		JMenuItem open_katedre = new JMenuItem("Katedre");
		file_open.add(open_studenti);
		file_open.addSeparator();
		file_open.add(open_predmeti);
		file_open.addSeparator();
		file_open.add(open_profesori);
		file_open.addSeparator();
		file_open.add(open_katedre);
		JMenuItem file_close = new JMenuItem("Close");
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
		JMenuItem edit_entity = new JMenuItem("Edit");
		edit_entity.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		JMenuItem delete_entity = new JMenuItem("Delete");
		delete_entity.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		edit.add(edit_entity);
		edit.addSeparator();
		edit.add(delete_entity);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem help_help = new JMenuItem("Help");
		help_help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		JMenuItem help_about = new JMenuItem("About");
		help_about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		help.add(help_help);
		help.addSeparator();
		help.add(help_about);
		
		add(file);
		add(edit);
		add(help);
	}
}
