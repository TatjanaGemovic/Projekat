package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetKontroler;
import model.BazaNepolozenihPredmeta;
import model.BazaPolozenih;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.OcenaNaIspitu;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Student;
import model.Vrednost_Ocene;

public class DijalogIzmenaPredmeta extends JDialog {
	
	private boolean dobarbroj = true;
	private boolean dobarnaziv = true;
	private boolean dobrasifra = true;
	static JTextField profesorLista = new JTextField();
	static JButton btnRemoveProfesor=new JButton("-");
	static JButton btnAddProfesor=new JButton("+");
	
	public DijalogIzmenaPredmeta(Frame parent, String title, boolean modal) {
		super(parent, "Izmena Predmeta", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*13/20);
		setLocationRelativeTo(parent);
		
		JButton potvrda=new JButton("Potvrdi");
		JButton odustanak=new JButton("Odustani");

		odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

					int dialogButton = JOptionPane.YES_NO_OPTION;
				    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);
	
				    if (dialogResult == JOptionPane.YES_OPTION) {
				    	dispose();
				    }
			             
				}
			});
		
		JPanel panelButton = new JPanel();
		panelButton.add(potvrda);
		panelButton.add(odustanak);
	    
	    this.add(panelButton, BorderLayout.SOUTH);
		
	    JPanel panelCenter = new JPanel();
	    panelCenter.setLayout(new GridBagLayout());
	    this.add(panelCenter, BorderLayout.CENTER);
	    
	    
	    JLabel lblSifra = new JLabel("Sifra predmeta:");
		JLabel lblNaziv = new JLabel("Naziv predmeta:");
		JLabel lblBrojESPB = new JLabel("Broj ESPB bodova:");
		JLabel lblGodina = new JLabel("Godina na kojoj se izvodi:");
		JLabel lblSemestar = new JLabel("Semestar:");
		JLabel lblProfesor = new JLabel("Profesor (ime i prezime):");
		 
		 
		final JTextField txtSifra = new JTextField();
		final JTextField txtNaziv = new JTextField();
		final JTextField txtBrojESPB = new JTextField();
		
		GridBagConstraints gbcLSifra = new GridBagConstraints();
		gbcLSifra.fill = GridBagConstraints.HORIZONTAL;
		gbcLSifra.gridx = 0;
		gbcLSifra.gridy = 0;
		gbcLSifra.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblSifra, gbcLSifra);
		 
		GridBagConstraints gbcLNaziv = new GridBagConstraints();
		gbcLNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcLNaziv.gridx = 0;
		gbcLNaziv.gridy = 1;
		gbcLNaziv.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblNaziv, gbcLNaziv);
		
		GridBagConstraints gbcLBrojESPB = new GridBagConstraints();
		gbcLBrojESPB.fill = GridBagConstraints.HORIZONTAL;
		gbcLBrojESPB.gridx = 0;
		gbcLBrojESPB.gridy = 2;
		gbcLBrojESPB.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblBrojESPB, gbcLBrojESPB);
		
		GridBagConstraints gbcLGodina = new GridBagConstraints();
		gbcLGodina.fill = GridBagConstraints.HORIZONTAL;
		gbcLGodina.gridx = 0;
		gbcLGodina.gridy = 3;
		gbcLGodina.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblGodina, gbcLGodina);
		
		GridBagConstraints gbcLSemestar = new GridBagConstraints();
		gbcLSemestar.fill = GridBagConstraints.HORIZONTAL;
		gbcLSemestar.gridx = 0;
		gbcLSemestar.gridy = 4;
		gbcLSemestar.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblSemestar, gbcLSemestar);
		
		GridBagConstraints gbcLProfesor = new GridBagConstraints();
		gbcLProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbcLProfesor.gridx = 0;
		gbcLProfesor.gridy = 5;
		gbcLProfesor.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblProfesor, gbcLProfesor);
			
		GridBagConstraints gbcTxtSifra = new GridBagConstraints();
		gbcTxtSifra .gridx = 1;
		gbcTxtSifra .gridy = 0;
		gbcTxtSifra .weightx = 100;
		gbcTxtSifra .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSifra .insets = new Insets(20,120, 0, 70);
		panelCenter.add(txtSifra, gbcTxtSifra );
		txtSifra.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtSifra.getText()).matches("[A-Z0-9 ]+")) {
	                dobrasifra = true;
	                if(dobarbroj && dobarnaziv && dobrasifra)
	                    potvrda.setEnabled(true);
	            }
	            else {
	                dobrasifra = false;
	                potvrda.setEnabled(false);
	            }
			}
				
        } );
		
		GridBagConstraints gbcTxtNaziv = new GridBagConstraints();
		gbcTxtNaziv .gridx = 1;
		gbcTxtNaziv.gridy = 1;
		gbcTxtNaziv .weightx = 100;
		gbcTxtNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtNaziv .insets = new Insets(20, 120, 0, 70);
		panelCenter.add(txtNaziv, gbcTxtNaziv );
		txtNaziv.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtNaziv.getText()).matches("[A-Z][a-z0-9]+")) {
	                dobarnaziv = true;
	                if(dobarbroj && dobarnaziv && dobrasifra)
	                    potvrda.setEnabled(true);
	            }
	            else {
	                dobarnaziv = false;
	                potvrda.setEnabled(false);
	            }
			}
				
        } );
		
		GridBagConstraints gbcTxtBrojESPB = new GridBagConstraints();
		gbcTxtBrojESPB .gridx = 1;
		gbcTxtBrojESPB.gridy = 2;
		gbcTxtBrojESPB .weightx = 100;
		gbcTxtBrojESPB.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtBrojESPB .insets = new Insets(20, 120, 0, 70);
		panelCenter.add(txtBrojESPB, gbcTxtBrojESPB );
		txtBrojESPB.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtBrojESPB.getText()).matches("[0-9]+")) {
	                dobarbroj = true;
	                if(dobarbroj && dobarnaziv && dobrasifra)
	                    potvrda.setEnabled(true);
	            }
	            else {
	                dobarbroj = false;
	                potvrda.setEnabled(false);
	            }
			}
				
        } );
		
		
		String godinaStudija[]= {"I (Prva)","II (Druga)","III (Treca)","IV (Cetvrta)"};
		JComboBox<String> godStud=new JComboBox<>(godinaStudija);
		   
		GridBagConstraints grdGodina = new GridBagConstraints();
		grdGodina.gridx = 1;
		grdGodina.gridy = 3;
		grdGodina.weightx = 100;
		grdGodina.fill = GridBagConstraints.HORIZONTAL;
		grdGodina.insets = new Insets(20, 120, 0, 70);
		panelCenter.add(godStud,grdGodina);
		
			
		
		String semestar[]= {"Letnji","Zimski"};
		JComboBox<String> semestarStud=new JComboBox<>(semestar);
		   
		GridBagConstraints grdSemestar= new GridBagConstraints();
		grdSemestar.gridx = 1;
		grdSemestar.gridy = 4;
	    grdSemestar.weightx = 100;
		grdSemestar.fill = GridBagConstraints.HORIZONTAL;
		grdSemestar.insets = new Insets(20, 120, 0, 70);
		panelCenter.add(semestarStud,grdSemestar);

		profesorLista.setEditable(false);
		profesorLista.setPreferredSize(new Dimension(178,25));
		
		btnAddProfesor.setPreferredSize(new Dimension(30,20));
		btnRemoveProfesor.setPreferredSize(new Dimension(30,20));
		JPanel panelButton2 = new JPanel();
		panelButton2.setLayout(new FlowLayout());
		panelButton2.add(btnRemoveProfesor, FlowLayout.LEFT);
		panelButton2.add(btnAddProfesor, FlowLayout.LEFT);
		panelButton2.add(profesorLista, FlowLayout.LEFT);
		
		GridBagConstraints gbcTxtProfesor = new GridBagConstraints();
		gbcTxtProfesor .gridx = 1;
		gbcTxtProfesor.gridy = 5;
		gbcTxtProfesor .weightx = 100;
		gbcTxtProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtProfesor .insets = new Insets(20, 120, 0, 70);
		panelCenter.add(panelButton2, gbcTxtProfesor);
		
		btnAddProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DijalogDodavanjeProfesoraNaPredmet OdabirProfesora = new DijalogDodavanjeProfesoraNaPredmet(parent, "Odaberi Profesora", true);
				OdabirProfesora.setVisible(true);
			}
			
		});
		
		btnRemoveProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DijalogBrisanjaProfesoraSaPredmeta BrisanjeProfesora = new DijalogBrisanjaProfesoraSaPredmeta(parent, "Ukloni Profesora", true);
				BrisanjeProfesora.setVisible(true);
			}
			
		});
		
		//ispis podataka za selektovani predmet
		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
    	Predmet predmet = BazaPredmeta.getInstance().getRow(PredmetiJTable.rowSelectedIndex);
    	txtSifra.setText(predmet.getSifra_predmeta());
		txtNaziv.setText(predmet.getNaziv());
		txtBrojESPB.setText(String.valueOf(predmet.getEspb()));
		godStud.setSelectedIndex(predmet.getGodina_izvodjenja()-1);
		int k=1;
		if(predmet.getSemestar().equals(Semestar.zimski)) {
			k=2;
		}
		semestarStud.setSelectedIndex(k-1);
		if(predmet.getPredmetni_profesor()!=null) {
			profesorLista.setText(predmet.getPredmetni_profesor().getImeIPrezime());
			btnRemoveProfesor.setEnabled(true);
			btnAddProfesor.setEnabled(false);
		} else{
			profesorLista.setText(null);
			btnRemoveProfesor.setEnabled(false);
			btnAddProfesor.setEnabled(true);
		}
		
		potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda", dialogButton);
			    
			    

			    if (dialogResult == JOptionPane.YES_OPTION) {
			    	
			    	if(txtNaziv.getText().isEmpty() || txtBrojESPB.getText().isEmpty() || txtSifra.getText().isEmpty()) {
			    		
			    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    		
			    	String sifra_new = txtSifra.getText();
			    	for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			    		if(sifra_new.equals(p.getSifra_predmeta()) && p!=predmet) {
			    			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Vec postoji predmet sa tom sifrom");
			    			return;
			    		}
			    	}
			    	String naziv = txtNaziv.getText();
			    	int brojEspb = Integer.parseInt(txtBrojESPB.getText());
			    	int semestar_pom = semestarStud.getSelectedIndex()+1;
			    	int god_izvodjenja = godStud.getSelectedIndex()+1;
			    	Semestar semestar = null;
			    	if(semestar_pom == 2) {
			    		semestar = Semestar.zimski;
			    	} else if (semestar_pom == 1){
			    		semestar = Semestar.letnji;
			    	}
		
			    	String profesor = profesorLista.getText(); 
			    	
			    	Profesor p = null;
			    	for (Profesor i : BazaProfesora.getInstance().getProfesori()) {
						if(i.getImeIPrezime().equals(profesor)) {
							p = i;
							break;
						}
					}
			    	PredmetKontroler.getInstance().izmeniPredmet(PredmetiJTable.rowSelectedIndex, sifra_new, naziv, semestar, god_izvodjenja, p, brojEspb);
			    	dispose();
			    	
			    }
				
			}
			
		});
	}
}

class DijalogPolaganjePredmeta extends JDialog {
	private boolean dobardatum = false;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public DijalogPolaganjePredmeta(Frame parent, String title, boolean modal) {
		super(parent, "Unos ocene", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*2/5, diaHeight*10/20);
		setLocationRelativeTo(parent);
		
		JButton potvrda=new JButton("Potvrdi");
		potvrda.setEnabled(false);
		JButton odustanak=new JButton("Odustani");
	
		odustanak.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
	
					int dialogButton = JOptionPane.YES_NO_OPTION;
				    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);
	
				    if (dialogResult == JOptionPane.YES_OPTION) {
				    	dispose();
				    }
			             
				}
			});
		
		JPanel panelButton = new JPanel();
		panelButton.add(potvrda);
		panelButton.add(odustanak);
	    
	    this.add(panelButton, BorderLayout.SOUTH);
		
	    JPanel panelCenter = new JPanel();
	    panelCenter.setLayout(new GridBagLayout());
	    this.add(panelCenter, BorderLayout.CENTER);
	    
	    JLabel lblSifra = new JLabel("Sifra:");
		JLabel lblNaziv = new JLabel("Naziv:");
		JLabel lblOcena = new JLabel("Ocena:");
		JLabel lblDatum = new JLabel("Datum:");
		 
		final JTextField txtSifra = new JTextField();
		final JTextField txtNaziv = new JTextField();
		final JTextField txtDatum = new JTextField();
		
		GridBagConstraints gbcLSifra = new GridBagConstraints();
		gbcLSifra.fill = GridBagConstraints.HORIZONTAL;
		gbcLSifra.gridx = 0;
		gbcLSifra.gridy = 0;
		gbcLSifra.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblSifra, gbcLSifra);
		 
		GridBagConstraints gbcLNaziv = new GridBagConstraints();
		gbcLNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcLNaziv.gridx = 0;
		gbcLNaziv.gridy = 1;
		gbcLNaziv.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblNaziv, gbcLNaziv);
		
		GridBagConstraints gbcLOcena = new GridBagConstraints();
		gbcLOcena.fill = GridBagConstraints.HORIZONTAL;
		gbcLOcena.gridx = 0;
		gbcLOcena.gridy = 2;
		gbcLOcena.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblOcena, gbcLOcena);
		
		GridBagConstraints gbcLDatum = new GridBagConstraints();
		gbcLDatum.fill = GridBagConstraints.HORIZONTAL;
		gbcLDatum.gridx = 0;
		gbcLDatum.gridy = 3;
		gbcLDatum.insets = new Insets(20,40, 0,0);
		panelCenter.add(lblDatum, gbcLDatum);
		
		GridBagConstraints gbcTxtSifra = new GridBagConstraints();
		gbcTxtSifra .gridx = 1;
		gbcTxtSifra .gridy = 0;
		gbcTxtSifra .weightx = 100;
		gbcTxtSifra .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSifra .insets = new Insets(20,100, 0, 70);
		panelCenter.add(txtSifra, gbcTxtSifra );

		GridBagConstraints gbcTxtNaziv = new GridBagConstraints();
		gbcTxtNaziv .gridx = 1;
		gbcTxtNaziv.gridy = 1;
		gbcTxtNaziv .weightx = 100;
		gbcTxtNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtNaziv .insets = new Insets(20, 100, 0, 70);
		panelCenter.add(txtNaziv, gbcTxtNaziv );
		
		String ocena[]= {"6","7", "8", "9", "10"};
		JComboBox<String> ocenaPred=new JComboBox<>(ocena);
		
		GridBagConstraints grdOcena= new GridBagConstraints();
		grdOcena.gridx = 1;
		grdOcena.gridy = 2;
		grdOcena.weightx = 100;
		grdOcena.fill = GridBagConstraints.HORIZONTAL;
		grdOcena.insets = new Insets(20, 100, 0, 70);
		panelCenter.add(ocenaPred,grdOcena);
		
		GridBagConstraints gbcTxtDatum = new GridBagConstraints();
		gbcTxtDatum .gridx = 1;
		gbcTxtDatum .gridy = 3;
		gbcTxtDatum .weightx = 100;
		gbcTxtDatum .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtDatum .insets = new Insets(20,100, 0, 70);
		panelCenter.add(txtDatum, gbcTxtDatum );
		txtDatum.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtDatum.getText()).matches("[0-3][0-9]/[0-1][0-9]/[12][0129][0-9][0-9]")) {
					dobardatum = true;
					if(dobardatum)
						potvrda.setEnabled(true);
				}
				else {
						 dobardatum = false;
						 potvrda.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
	    	
	    } );
		
		Predmet predmet = BazaNepolozenihPredmeta.getInstance().getRow(NepolozeniPredmetiJTable.rowSelectedIndex);
    	txtSifra.setText(predmet.getSifra_predmeta());
    	txtSifra.setEditable(false);
		txtNaziv.setText(predmet.getNaziv());
    	txtNaziv.setEditable(false);
    	
    	potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda", dialogButton);

			    if (dialogResult == JOptionPane.YES_OPTION) {
			    	if(txtDatum.getText().isEmpty()) {
			    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    		
			    	Predmet p = BazaNepolozenihPredmeta.getInstance().getRow(NepolozeniPredmetiJTable.rowSelectedIndex);
			    	Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
			    	
					for(OcenaNaIspitu o : s.getNepolozeni_ispiti()) {
						if(o.getPredmet().equals(p)) {
							s.getNepolozeni_ispiti().remove(o);
							break;
						}
					}
					NepolozeniPredmetiJTable.azurirajPrikaz();
					
					int vr_ocene = ocenaPred.getSelectedIndex();
					Vrednost_Ocene vred = null;
			    	if(vr_ocene == 0) {
			    		vred = Vrednost_Ocene.sest;
			    	} else if (vr_ocene == 1){
			    		vred = Vrednost_Ocene.sedam;
			    	} else if (vr_ocene == 2){
			    		vred = Vrednost_Ocene.osam;
			    	} else if (vr_ocene == 3){
			    		vred = Vrednost_Ocene.devet;
			    	} else {
			    		vred = Vrednost_Ocene.deset;
			    	}
			    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			    	Date datum = new Date();
			    	try {
						datum =  formatter.parse(txtDatum.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
			    	
					OcenaNaIspitu o1 = new OcenaNaIspitu(s, p, vred, datum);
					s.getPolozeni_ispiti().add(o1);
					PolozeniIspitiJTable.azurirajPrikaz();
					double prosecna_ocena2 = 0;
					int broj_predmeta2 = 0;
					int espb_ukupno2=0;
					for(OcenaNaIspitu o : s.getPolozeni_ispiti()) {
						espb_ukupno2 += o.getPredmet().getEspb();
						broj_predmeta2++;
						int ocena = 0;
						switch(o.getVrednost_ocene()) {
							case sest: 
								ocena = 6;
								break;
							case sedam: 
								ocena = 7;
								break;
							case osam: 
								ocena = 8;
								break;
							case devet: 
								ocena = 9;	
								break;
							case deset: 
								ocena = 10;
								break;
						}
						prosecna_ocena2 += ocena;
					}
					if(prosecna_ocena2==0) {
						DijalogIzmenaStudenta.prosek.setText("Prosecna ocena je 0");
					}else {
						prosecna_ocena2/=broj_predmeta2;
						DijalogIzmenaStudenta.prosek.setText("Prosecna ocena je " + df.format(prosecna_ocena2));
					}
					DijalogIzmenaStudenta.espb.setText("Ukupan broj ESPB bodova je " + Integer.toString(espb_ukupno2));
			    	
			    	dispose();
			    	
			    }
				
			}
			
		});

	}
}