package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


public class Toolbar extends JToolBar {
	
	public Toolbar(final JFrame parent) {

		super(SwingConstants.HORIZONTAL);
		
		addSeparator();
		JButton btnAdd = new JButton();
		btnAdd.setToolTipText("Add");
		btnAdd.setIcon(new ImageIcon("ikonice/add copy.png"));
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DijalogDodavanjaEntiteta dodajEntitet = new DijalogDodavanjaEntiteta(parent, "Dodavanje Entiteta", true);
				dodajEntitet.setVisible(true);
				
			}
		});
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
	
	public class MyFocusListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setText("");
			txt.setBackground(Color.WHITE);
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setBackground(Color.WHITE);
			txt.setText("Search");
		}
	}
}
