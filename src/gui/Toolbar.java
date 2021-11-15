package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {
	
	public Toolbar() {

		super(SwingConstants.HORIZONTAL);
		JButton btnAdd = new JButton();
		btnAdd.setToolTipText("Dodaj");
		btnAdd.setIcon(new ImageIcon("ikonice/add copy.png"));
		add(btnAdd);

		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmeni");
		btnEdit.setIcon(new ImageIcon("ikonice/writing copy.png"));
		add(btnEdit);

		addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Izbriši");
		btnDelete.setIcon(new ImageIcon("ikonice/trash.png"));
		add(btnDelete);

		setFloatable(false);
		setBackground(Color.WHITE);
		
		JTextField txt = new JTextField(25);
		txt.setMaximumSize(new Dimension(170,20));
		add(txt);

		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Pretraži");
		btnSearch.setIcon(new ImageIcon("ikonice/search-2.png"));
		add(btnSearch);

	}
}
