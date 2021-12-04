package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


public class Toolbar extends JToolBar {
	
	public Toolbar() {

		super(SwingConstants.HORIZONTAL);
		
		addSeparator();
		JButton btnAdd = new JButton();
		btnAdd.setToolTipText("Add");
		btnAdd.setIcon(new ImageIcon("ikonice/add copy.png"));
		add(btnAdd);

		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("ikonice/writing copy.png"));
		add(btnEdit);

		addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("ikonice/trash.png"));
		add(btnDelete);

		setFloatable(false);
		setBackground(Color.LIGHT_GRAY);
		
		add(Box.createHorizontalGlue());
		
		JTextField txt = new JTextField(16);
		txt.setMaximumSize(new Dimension(170,24));
		txt.setName("txtSearch");
		txt.setText("Search");
		txt.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		MyFocusListener focusListener = new MyFocusListener();
		txt.addFocusListener(focusListener);
		add(txt);
		
		addSeparator();

		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("ikonice/search-2.png"));
		add(btnSearch);

		addSeparator();

	}
}
