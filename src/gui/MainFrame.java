package gui;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainFrame extends JFrame{

		private static final long serialVersionUID = -888790554862002427L;
		private static MainFrame instance = null;
		public static TabbedPane tabovi;
		public Toolbar toolbar;
		public MenuBar menu;
		public StatusBar statusBar;
		
		private ResourceBundle resourceBundle;
		
		
		private MainFrame() {
			Locale.setDefault(new Locale("sr", "RS"));
			resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
			
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
			toolbar = new Toolbar(this);
			add(toolbar, BorderLayout.NORTH);
		}
		
		private void createMenu() {
			menu = new MenuBar(this);
			this.setJMenuBar(menu);
		}
		
		private void createStatusBar() {
			statusBar = new StatusBar();
			add(statusBar, BorderLayout.SOUTH);
		}
		
		private void createTabbedPane() {
			JPanel leftDummy = new JPanel();
			JPanel rightDummy = new JPanel();
			leftDummy.setPreferredSize(new Dimension(40,100));
			rightDummy.setPreferredSize(new Dimension(40,100));
			add(leftDummy, BorderLayout.WEST);
			add(rightDummy, BorderLayout.EAST);
			tabovi = new TabbedPane();
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
			
			/*this.addWindowListener(new WindowAdapter() {
		    	
				
				@Override
				public void windowClosing(WindowEvent e) {
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
				    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);
	
				    if (dialogResult == JOptionPane.YES_OPTION) {
							
							ObjectOutputStream out = null;
							List<Student> listaStudenata=BazaStudenata.getInstance().getStudenti();
							try {
								out = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(MenuBar.fileStudenti)));
								out.writeObject(listaStudenata);
								
							} catch (Exception e1) {
								e1.printStackTrace();
						    } finally {
						        if(out != null){
						            try {
						                out.close();
						            } catch (Exception e1) {
						    			e1.printStackTrace();
						            }
						        }
						    }
							List<Profesor> listaProfesora=BazaProfesora.getInstance().getProfesori();
							try {
								out = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(MenuBar.fileProfesori)));
								
								 
								out.writeObject(listaProfesora);
								
							} catch (Exception e1) {
								e1.printStackTrace();
						    } finally {
						        if(out != null){
						            try {
						                out.close();
						            } catch (Exception e1) {
						    			e1.printStackTrace();
						            }
						        }
						    }
							List<Predmet> listaPredmeta=BazaPredmeta.getInstance().getPredmeti();
							try {
								out = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(MenuBar.filePredmeti)));
								
								 
								out.writeObject(listaPredmeta);
								
							} catch (Exception e1) {
								e1.printStackTrace();
						    } finally {
						        if(out != null){
						            try {
						                out.close();
						            } catch (Exception e1) {
						    			e1.printStackTrace();
						            }
						        }
						    }
							
							
							e.getWindow().dispose();
						}
						
				}
		    	
			});*/
		}
		
		public ResourceBundle getResourceBundle() {
			return resourceBundle;
		}

		public void changeLang() throws FileNotFoundException, ClassNotFoundException, IOException {
			resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
			setTitle(resourceBundle.getString("naslovAplikacije"));
			toolbar.updateComponent();
			menu.updateComponent();
			statusBar.updateComponent();
			tabovi.updateComponent();
		}
	
}
