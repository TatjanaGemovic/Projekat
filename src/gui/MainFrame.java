package gui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame{

	
		public MainFrame() {
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			
			setSize(screenWidth / 4 * 3, screenHeight / 4 * 3);
			setTitle("Studentska sluzba");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			
			
			// menubar poziv
			MenuBar menu = new MenuBar();
			this.setJMenuBar(menu);
			
			
			// toolbar poziv
			Toolbar toolbar = new Toolbar();
			add(toolbar, BorderLayout.NORTH);
		}
}
