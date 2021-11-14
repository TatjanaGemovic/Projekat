package gui;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = -7863806568418316202L;

	public MenuBar() {

		JMenu file = new JMenu("File");
		JMenuItem file_new = new JMenuItem("New");
		JMenuItem file_save = new JMenuItem("Save");
		JMenu file_open = new JMenu("Open");
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
		file.add(file_new);
		file.addSeparator();
		file.add(file_save);
		file.addSeparator();
		file.add(file_open);
		file.addSeparator();
		file.add(file_close);

		JMenu edit = new JMenu("Edit");
		JMenuItem edit_entity = new JMenuItem("Edit");
		JMenuItem delete_entity = new JMenuItem("Delete");
		edit.add(edit_entity);
		edit.addSeparator();
		edit.add(delete_entity);
		
		JMenu help = new JMenu("Help");
		JMenuItem help_help = new JMenuItem("Help");
		JMenuItem help_about = new JMenuItem("About");
		help.add(help_help);
		help.addSeparator();
		help.add(help_about);
		
		add(file);
		add(edit);
		add(help);
	}
}
