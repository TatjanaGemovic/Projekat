package gui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class MainFrame extends JFrame{


		private static MainFrame instance = null;
		private static final long serialVersionUID = -888790554862002427L;
		
		private MainFrame() {
			this.createToolbar();
			this.createMenu();
			this.createStatusBar();
			this.createTabbedPane();
			this.initPosition();
		}
		
		public static MainFrame getInstance() {
			if(instance == null) {
				instance = new MainFrame();
			}
			return instance;
		}
			
		
		private void createToolbar() {
			Toolbar toolbar = new Toolbar(this);
			add(toolbar, BorderLayout.NORTH);
		}
		
		private void createMenu() {
			MenuBar menu = new MenuBar(this);
			this.setJMenuBar(menu);
		}
		
		private void createStatusBar() {
			StatusBar statusBar = new StatusBar();
			add(statusBar, BorderLayout.SOUTH);
		}
		
		private void createTabbedPane() {
			JPanel leftDummy = new JPanel();
			JPanel rightDummy = new JPanel();
			leftDummy.setPreferredSize(new Dimension(40,100));
			rightDummy.setPreferredSize(new Dimension(40,100));
			add(leftDummy, BorderLayout.WEST);
			add(rightDummy, BorderLayout.EAST);
			TabbedPane tabovi = new TabbedPane();
			tabovi.setBackground(Color.WHITE);
			this.add(tabovi);

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
