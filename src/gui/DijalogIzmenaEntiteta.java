package gui;

import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JDialog;

public class DijalogIzmenaEntiteta extends JDialog {

	public DijalogIzmenaEntiteta(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*18/20);
		setLocationRelativeTo(parent);
	}
}
