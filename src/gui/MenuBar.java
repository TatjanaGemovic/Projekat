package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.KeyStroke;

import model.BazaKatedri;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -9132887326381921444L;
	static File liste = new File("liste");
	public static File fileStudenti = new File(liste, "StudentiFile.txt");
	public static File fileProfesori = new File(liste, "ProfesoriFile.txt");
	public static File filePredmeti = new File(liste, "PredmetiFile.txt");
	public static File fileKatedre = new File(liste, "KatedreFile.txt");
	
	private JMenu file;
	private JMenuItem file_new;
	private JMenuItem file_save;
	private JMenu file_open;
	private JMenuItem open_studenti;
	private JMenuItem open_predmeti;
	private JMenuItem open_profesori;
	private JMenuItem open_katedre;
	private JMenuItem file_close;
	private JMenu edit;
	private JMenuItem edit_entity;
	private JMenuItem delete_entity;
	private JMenu help;
	private JMenuItem help_help;
	private JMenuItem help_about;
	private JMenu lang;
	private JCheckBoxMenuItem langSrp;
	private JCheckBoxMenuItem langEng;
	
	public MenuBar(final JFrame parent) {

		ImageIcon icn = new ImageIcon("ikonice/new.png"); 
		
		file = new JMenu("Fajl");
		file.setMnemonic(KeyEvent.VK_F);
		file_new = new JMenuItem("Novi", icn);
		file_new.setMnemonic(KeyEvent.VK_N);
		file_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		file_new.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (TabbedPane.getTabIndex()) {
					case Profesor:
						DijalogDodavanjaProfesora dodajEntitet1 = new DijalogDodavanjaProfesora(parent, "Dodavanje Profesora", true);
						dodajEntitet1.setVisible(true);
						break;
					case Predmet:
						DijalogDodavanjaPredmeta dodajEntitet2 = new DijalogDodavanjaPredmeta(parent, "Dodavanje Predmeta", true);
						dodajEntitet2.setVisible(true);
						break;
					default:
						DijalogDodavanjaStudenta dodajEntitet0 = new DijalogDodavanjaStudenta(parent, "Dodavanje Studenta", true);
						dodajEntitet0.setVisible(true);
				}
			}
		});
		
		
		icn = new ImageIcon("ikonice/save.png");
		file_save = new JMenuItem("Sacuvaj", icn);
		file_save.setMnemonic(KeyEvent.VK_S);
		file_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		file_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
						//https://rollbar.com/blog/java-exceptions-hierarchy-explained/
						//Zasto Exception umesto IOException, FileNotFound i ClassNotFoundException
						ObjectOutputStream outStudenti = null;
						try {
							outStudenti = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(MenuBar.fileStudenti)));
							outStudenti.writeObject(BazaStudenata.getInstance().getStudenti());
							
						} catch (Exception e1) {
							e1.printStackTrace();
					    } finally {
					            try {
					            	outStudenti.close();
					            } catch (Exception e1) {
					    			e1.printStackTrace();
					            }
					    }
						
						ObjectOutputStream outProfesori = null;
						try {
							outProfesori = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(MenuBar.fileProfesori)));
							outProfesori.writeObject(BazaProfesora.getInstance().getProfesori());
							
						} catch (Exception e1) {
							e1.printStackTrace();
					    } finally {
					            try {
					            	outProfesori.close();
					            } catch (Exception e1) {
					    			e1.printStackTrace();
					            }
					    }
						ObjectOutputStream outKatedre = null;
						try {
							outKatedre = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(MenuBar.fileKatedre)));
							outKatedre.writeObject(BazaKatedri.getInstance().getKatedre());
							
						} catch (Exception e1) {
							e1.printStackTrace();
					    } finally {
					            try {
					            	outKatedre.close();
					            } catch (Exception e1) {
					    			e1.printStackTrace();
					            }
					    }
						
						ObjectOutputStream outPredmeti = null;
						try {
							outPredmeti = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(MenuBar.filePredmeti)));
							outPredmeti.writeObject(BazaPredmeta.getInstance().getPredmeti());
							
						} catch (Exception e1) {
							e1.printStackTrace();
					    } finally {
					            try {
					            	outPredmeti.close();
					            } catch (Exception e1) {
					    			e1.printStackTrace();
					            }
					    }	
			}
			
			
		});
		
		file_open = new JMenu("Otvori");
		icn = new ImageIcon("ikonice/24x24.png");
		file_open.setIcon(icn);
		file_open.setMnemonic(KeyEvent.VK_O);
		icn = new ImageIcon("ikonice/write.png");
		open_studenti = new JMenuItem("Studenti", icn);
		open_studenti.setMnemonic(KeyEvent.VK_M);
		open_studenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		open_studenti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.tabovi.setSelectedIndex(0);
				StatusBar.nazivTaba.setText("- " + MainFrame.getInstance().getResourceBundle().getString("open_studenti"));
			}
		});
		icn = new ImageIcon("ikonice/bookshelf.png");
		open_predmeti = new JMenuItem("Predmeti", icn);
		open_predmeti.setMnemonic(KeyEvent.VK_J);
		open_predmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK));
		open_predmeti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.tabovi.setSelectedIndex(2);
				StatusBar.nazivTaba.setText("- " + MainFrame.getInstance().getResourceBundle().getString("open_predmeti"));
			}
		});
		icn = new ImageIcon("ikonice/presentation.png");
		open_profesori = new JMenuItem("Profesori", icn);
		open_profesori.setMnemonic(KeyEvent.VK_L);
		open_profesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		open_profesori.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.tabovi.setSelectedIndex(1);
				StatusBar.nazivTaba.setText("- " + MainFrame.getInstance().getResourceBundle().getString("open_profesori"));
			}
		});
		icn = new ImageIcon("ikonice/customer.png");
		open_katedre = new JMenuItem("Katedre", icn);
		open_katedre.setMnemonic(KeyEvent.VK_K);
		open_katedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
		open_katedre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DijalogKatedra dijalog = new DijalogKatedra(parent,MainFrame.getInstance().getResourceBundle().getString("open_katedre"), true);
			}
		});
		file_open.add(open_studenti);
		file_open.addSeparator();
		file_open.add(open_predmeti);
		file_open.addSeparator();
		file_open.add(open_profesori);
		file_open.addSeparator();
		file_open.add(open_katedre);
		icn = new ImageIcon("ikonice/close.png");
		file_close = new JMenuItem("Zatvori", icn);
		file_close.setMnemonic(KeyEvent.VK_C);
		file_close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		file_close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		file.add(file_new);
		file.addSeparator();
		file.add(file_save);
		file.addSeparator();
		file.add(file_open);
		file.addSeparator();
		file.add(file_close);

		edit = new JMenu("Izmeni");
		edit.setMnemonic(KeyEvent.VK_E);
		icn = new ImageIcon("ikonice/writing copy.png");
		edit_entity = new JMenuItem("Izmeni", icn);
		edit_entity.setMnemonic(KeyEvent.VK_E);
		edit_entity.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		edit_entity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (TabbedPane.tabIndex) {
				case Profesor:
					if(ProfesoriJTable.rowSelectedIndex==-1 || ProfesoriJTable.rowSelectedIndex>=BazaProfesora.getInstance().getProfesori().size()) {
						
					} else {
						DijalogIzmenaProfesora izmeniProfesora = new DijalogIzmenaProfesora(parent, "Izmena Profesora", true);
						izmeniProfesora.setVisible(true);
					}
					break;
				case Predmet:
					if(PredmetiJTable.rowSelectedIndex==-1 || PredmetiJTable.rowSelectedIndex>=BazaPredmeta.getInstance().getPredmeti().size()) {
						
					} else {
						DijalogIzmenaPredmeta izmeniPredmet = new DijalogIzmenaPredmeta(parent, "Izmena Predmeta", true);
						izmeniPredmet.setVisible(true);
					}
					break;
				default:
					if(StudentiJTable.rowSelectedIndex==-1 || StudentiJTable.rowSelectedIndex>=BazaStudenata.getInstance().getStudenti().size()) {
						
					} else {
						DijalogIzmenaStudenta izmeniStudenta = new DijalogIzmenaStudenta(parent, "Izmena Studenta", true);
						izmeniStudenta.setVisible(true);
					}
			}
			}
		});
		icn = new ImageIcon("ikonice/trash.png");
		delete_entity = new JMenuItem("Obrisi", icn);
		delete_entity.setMnemonic(KeyEvent.VK_D);
		delete_entity.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		delete_entity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (TabbedPane.tabIndex) {
				case Profesor:
					if(ProfesoriJTable.rowSelectedIndex==-1 || ProfesoriJTable.rowSelectedIndex>=BazaProfesora.getInstance().getProfesori().size()) {
						
					} else {
						DijalogBrisanjaEntiteta obrisiEntitet = new DijalogBrisanjaEntiteta(parent, "Brisanje Profesora", true);
						obrisiEntitet.setVisible(true);
					}
					break;
				case Predmet:
					if(PredmetiJTable.rowSelectedIndex==-1 || PredmetiJTable.rowSelectedIndex>=BazaPredmeta.getInstance().getPredmeti().size()) {
						
					} else {
						DijalogBrisanjaEntiteta obrisiEntitet = new DijalogBrisanjaEntiteta(parent, "Brisanje Predmeta", true);
						obrisiEntitet.setVisible(true);
					}
					break;
				default:
					if(StudentiJTable.rowSelectedIndex==-1 || StudentiJTable.rowSelectedIndex>=BazaStudenata.getInstance().getStudenti().size()) {
						
					} else {
						DijalogBrisanjaEntiteta obrisiEntitet = new DijalogBrisanjaEntiteta(parent, "Brisanje Studenta", true);
						obrisiEntitet.setVisible(true);
					}
				}
			}
		});
		edit.add(edit_entity);
		edit.addSeparator();
		edit.add(delete_entity);
		
		help = new JMenu("Pomoc");
		help.setMnemonic(KeyEvent.VK_H);
		icn = new ImageIcon("ikonice/help.png");
		help_help = new JMenuItem("Pomoc", icn);
		help_help.setMnemonic(KeyEvent.VK_H);
		help_help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		help_help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JDialog d = new JDialog(new JFrame(),"Pomoc");
				Dimension parentSize = parent.getSize();
				int diaWidth = parentSize.width;
				int diaHeight = parentSize.height;
				d.setSize(diaWidth*3/5, diaHeight); 
				d.setLocationRelativeTo(MainFrame.getInstance());
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setText("\n     Funkcionalnosti koje aplikacija poseduje:\n"
		                 +"     - Za cuvanje programa kliknite 'File'->'Save'\n"
		                 +"     - Za prikaz taba studenati kliknite 'Edit'->'Open'->'Students'\n"
		                 +"     - Za prikaz taba profesori kliknite 'Edit'->'Open'->'Profesors'\n"
		                 +"     - Za prikaz taba predmeti kliknite 'Edit'->'Open'->'Subjects'\n"
		                 +"     - Za prikaz katedri kliknite 'Edit'->'Open'->'Chairs'\n"
		                 +"     - Za gasenje programa kliknite 'File'->'Close'\n"
		                 +"     - Za dodavanje novog entiteta kliknite 'File'->'Add'\n"
		                 +"     - Za izmenu postojeceg entiteta kliknite 'Edit'->'Edit'\n"
						 +"     - Za brisanje postojeceg entiteta kliknite 'Edit'->'Delete'\n"
						 +"     - Za pomoc pri radu kliknite 'Help'->'Help'\n"
						 +"     - Za informacije o nama kliknite 'Help'->'About'\n"


						 +"\n    Precice koje aplikacija poseduje:\n"
		                 +"     - Za cuvanje podataka: (CTRL + S)\n"
		                 +"     - Za prikaz taba studenati: (CTRL + M)\n"
		                 +"     - Za prikaz taba profesori: (CTRL + L) \n"
		                 +"     - Za prikaz taba predmeti: (CTRL + J)\n"
		                 +"     - Za prikaz katedri: (CTRL + K)\n"
		                 +"     - Za gasenje programa: (CTRL + C)\n"
		                 +"     - Za dodavanje novog entiteta: (CTRL + N)\n"
		                 +"     - Za izmenu postojeceg entiteta: (CTRL + E)\n"
						 +"     - Za brisanje postojeceg entiteta: (CTRL + D)\n"
						 +"     - Za pomoc pri radu: (CTRL + H)\n"
						 +"     - Za informacije o nama: (CTRL + A) \n\n"
				
						 +"      Za pretragu Studenta: [Prezime], [Prezime,Ime], [Indeks,Ime,Prezime]\n"
						 +"      Za pretragu Profesora: [Prezime], [Prezime,Ime]\n"
						 +"      Za pretragu Predmeta: [Naziv], [Naziv,Sifra]\n"
						 +"\n   Napomena za unos [format]\n"
						 +"                       Datum: dd/mm/yyyy\n"
						 +"                       Adresa: Ulica, broj, grad, drzava\n"
						 +"                       Broj telefona: xxx/yyy-yyy\n"
						 +"\n     * Postoji mogucnost izmene jezika u programu na opciju 'Jezik' u MenuBar-u");
								
				d.add(textArea);
				d.setVisible(true);
				
			}
		});
		icn = new ImageIcon("ikonice/info.png");
		help_about = new JMenuItem("O nama", icn);
		help_about.setMnemonic(KeyEvent.VK_A);
		help_about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		help_about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog d = new JDialog(new JFrame(),"O Nama");
				Dimension parentSize = parent.getSize();
				int diaWidth = parentSize.width;
				int diaHeight = parentSize.height;
				d.setSize(diaWidth*2/4, diaHeight*10/20);
				d.setLocationRelativeTo(MainFrame.getInstance());
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setText("\n\n"
								+"     Autori:\n\n     Tatjana Gemovic\n"
								+"     - rodjena 16.03.2000. u Novom Sadu\n"
								+"     - zavrsila je gimnaziju 'Jovan Jovanovic Zmaj' u Novom Sadu\n"
								+"     - upisala je Fakultet tehnickih nauka 2019. godine\n"
								+"     - trenutno je 3. godina na smeru Racunarstvo i automatika (PRNI)\n"
								+"     - aktivno se bavi sportom - Odbojka\n"
								+ "\n\n     Filip Stefanov\n"
								+"     - rodjen 27.05.2000. u Pirotu\n"
								+"     - zavrsio je gimnaziju 'Jovan Jovanovic Zmaj' u Novom Sadu\n"
								+"     - upisao je Fakultet tehnickih nauka 2019. godine\n"
								+"     - trenutno je 3. godina na smeru Racunarstvo i automatika (PRNI)\n");
								
				d.add(textArea);
				d.setVisible(true);
				
			}
		});
		help.add(help_help);
		help.addSeparator();
		help.add(help_about);
		

		lang = new JMenu("Jezik");
		lang.setMnemonic(KeyEvent.VK_L);
	    langSrp = new JCheckBoxMenuItem("srpski");
		langEng = new JCheckBoxMenuItem("engleski");
		
		langSrp.setSelected(true);
		langSrp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("sr", "RS"));
				try {
					MainFrame.getInstance().changeLang();
					langEng.setSelected(false);
					
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}	
		});
		lang.add(langSrp);
		
		langEng.setSelected(false);
		langEng.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en", "US"));
				try {
					MainFrame.getInstance().changeLang();
					langSrp.setSelected(false);
					
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}	
		});
		lang.add(langEng);
		
		add(file);
		add(edit);
		add(help);
		add(lang);
	}

	public void updateComponent() {
		file.setText(MainFrame.getInstance().getResourceBundle().getString("file"));
		file_new.setText(MainFrame.getInstance().getResourceBundle().getString("file_new"));
		file_save.setText(MainFrame.getInstance().getResourceBundle().getString("file_save"));
		file_open.setText(MainFrame.getInstance().getResourceBundle().getString("file_open"));
		open_studenti.setText(MainFrame.getInstance().getResourceBundle().getString("open_studenti"));
		open_predmeti.setText(MainFrame.getInstance().getResourceBundle().getString("open_predmeti"));
		open_profesori.setText(MainFrame.getInstance().getResourceBundle().getString("open_profesori"));
		open_katedre.setText(MainFrame.getInstance().getResourceBundle().getString("open_katedre"));
		file_close.setText(MainFrame.getInstance().getResourceBundle().getString("file_close"));
		edit.setText(MainFrame.getInstance().getResourceBundle().getString("edit"));
		edit_entity.setText(MainFrame.getInstance().getResourceBundle().getString("edit"));
		delete_entity.setText(MainFrame.getInstance().getResourceBundle().getString("delete"));
		help.setText(MainFrame.getInstance().getResourceBundle().getString("help"));
		help_help.setText(MainFrame.getInstance().getResourceBundle().getString("help"));
		help_about.setText(MainFrame.getInstance().getResourceBundle().getString("about"));
		lang.setText(MainFrame.getInstance().getResourceBundle().getString("lang"));
		langSrp.setText(MainFrame.getInstance().getResourceBundle().getString("srpski"));
		langEng.setText(MainFrame.getInstance().getResourceBundle().getString("engleski"));
	}
}
