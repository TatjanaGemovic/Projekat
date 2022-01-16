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
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;


public class Toolbar extends JToolBar {

	private static final long serialVersionUID = 5574144676174518247L;

	public Toolbar(final JFrame parent) {
		
	
		super(SwingConstants.HORIZONTAL);
		
		addSeparator();
		JButton btnAdd = new JButton();
		btnAdd.setToolTipText("Add");
		btnAdd.setIcon(new ImageIcon("ikonice/add copy.png"));
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (TabbedPane.tabIndex) {
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
		add(btnAdd);

		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("ikonice/writing copy.png"));
		btnEdit.addActionListener(new ActionListener() {

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
		add(btnEdit);

		addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("ikonice/trash.png"));
		btnDelete.addActionListener(new ActionListener() {

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
		add(btnDelete);

		//setFloatable(true);
		//setBackground(new Color(255, 255, 204));
		setBackground(Color.WHITE);
		
		setFloatable(false);
		setBackground(Color.LIGHT_GRAY);
		
		add(Box.createHorizontalGlue());
		
		JTextField txt = new JTextField(16);
		txt.setMaximumSize(new Dimension(170,24));

		txt.setName("txtSearch");
		//txt.setText("Search");
		txt.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		//MyFocusListener focusListener = new MyFocusListener();
		//txt.addFocusListener(focusListener);
		add(txt);
		
		addSeparator();

		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("ikonice/search-2.png"));
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					switch (TabbedPane.tabIndex) {
					case Profesor:
						TabbedPane.filterProfesora(txt.getText());
						break;
					case Predmet:
						TabbedPane.filterPredmeta(txt.getText());
						break;
					default:
						TabbedPane.filterStudenata(txt.getText());
					}
			}
			
		});
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
