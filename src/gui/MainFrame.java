package gui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame{

	
		private static MainFrame instance = null;
		
		private MainFrame() {
			this.createToolbar();
			this.createMenu();
			this.initPosition();
			//this.createStatusBar();
			this.createTabbedPane();
		}
		
		public static MainFrame getInstance() {
			if(instance == null) {
				instance = new MainFrame();
			}
			return instance;
		}
		
		private void createToolbar() {
			Toolbar toolbar = new Toolbar();
			add(toolbar, BorderLayout.NORTH);
		}
		
		private void createMenu() {
			MenuBar menu = new MenuBar();
			this.setJMenuBar(menu);
		}
		
		private void createStatusBar() {
			//StatusBar statusbar = new StatusBar();
			//add(statusBar, BorderLayout.SOUTH);
		}
		
		private void createTabbedPane() {
			TabbedPane tabovi = new TabbedPane();
			this.add(tabovi, BorderLayout.CENTER);
		}
		
		
		private void initPosition() {
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			
			this.setSize(screenWidth / 4 * 3, screenHeight / 4 * 3);
			this.setTitle("Studentska sluzba");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
}
