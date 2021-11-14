package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.*;  
import java.awt.event.*;  
import javax.swing.JTextField;

public class Toolbar extends JToolBar {
	
	public Toolbar() {

		super(SwingConstants.HORIZONTAL);
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

		//setFloatable(true);
		//setBackground(new Color(255, 255, 204));
		setBackground(Color.WHITE);
		
		
		JTextField tf1=new JTextField();
		tf1.setEditable(true);
		add(tf1);
		
		 JButton search_btn=new JButton(new ImageIcon("ikonice/search-2.png"));  
		 add(search_btn);

	}
}
