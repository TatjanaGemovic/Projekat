package gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

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
