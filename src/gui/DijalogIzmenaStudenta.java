package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.PredmetKontroler;
import controller.StudentKontroler;
import model.Adresa;
import model.BazaNepolozenihPredmeta;
import model.BazaPolozenih;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.OcenaNaIspitu;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Status_Studenta;
import model.Student;
import model.Vrednost_Ocene;

public class DijalogIzmenaStudenta extends JDialog {
	private boolean dobroime = true;
	private boolean dobroprezime = true;
	private boolean dobardatum = true;
	private boolean dobra_adresa = true;
	private boolean dobarbroj = true;
	private boolean dobarindex = true;
	private boolean dobarmail = true;
	private boolean dobragodina = true;
	public NepolozeniPredmetiJTable nep_predmeti = new NepolozeniPredmetiJTable();
	private static final DecimalFormat df = new DecimalFormat("0.00");
	static JLabel prosek = new JLabel();
	static JLabel espb = new JLabel();

	public DijalogIzmenaStudenta(Frame parent, String title, boolean modal) {
			super(parent, "Izmena Studenta", modal);
			
			Dimension parentSize = parent.getSize();
			int diaWidth = parentSize.width;
			int diaHeight = parentSize.height;
			setSize(diaWidth*3/5, diaHeight);
			setLocationRelativeTo(parent);
			
			JTabbedPane tabbedPane = new JTabbedPane();
			
			JPanel infoPanel = new JPanel();
			JButton potvrda=new JButton("Potvrdi");
			potvrda.setEnabled(true);
			GridBagConstraints gbcPotvrda = new GridBagConstraints();
			gbcPotvrda.fill = GridBagConstraints.HORIZONTAL;
			gbcPotvrda.gridx = 0;
			gbcPotvrda.gridy = 11;
			gbcPotvrda.insets = new Insets(20, 190, 0,0);
			
			JButton odustanak=new JButton("Odustani");
			GridBagConstraints gbcOdustanak = new GridBagConstraints();
			gbcOdustanak.fill = GridBagConstraints.HORIZONTAL;
			gbcOdustanak.gridx = 1;
			gbcOdustanak.gridy = 11;
			gbcOdustanak.insets = new Insets(20, 30, 0, 150);
			
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
			
			
		    JPanel panelCenter = new JPanel();
		    panelCenter.setLayout(new GridBagLayout());
		    
		    panelCenter.add(potvrda, gbcPotvrda);
		    panelCenter.add(odustanak, gbcOdustanak);
		    
		    JLabel lblIme = new JLabel("Ime:");
		    JLabel lblPrezime = new JLabel("Prezime:");
		    JLabel lblDatumRodjenja = new JLabel("Datum rodjenja:");
		    JLabel lblAdresa = new JLabel("Adresa stanovanja:");
		    JLabel lblTelefon = new JLabel("Broj telefona:");
		    JLabel lblEmailAdresa = new JLabel("Email adresa:");
		    JLabel lblBrojIndeksa = new JLabel("Broj indeksa:");
		    JLabel lblGodinaUpisa = new JLabel("Godina upisa:");
		    JLabel lblTrenutnaGodinaStudija = new JLabel("Trenutna godina studija:");
		    JLabel lblNacinFinansiranja = new JLabel("Nacin finansiranja:");


		    final JTextField txtIme = new JTextField();
		    final JTextField txtPrezime = new JTextField();
		    final JTextField txtDatumRodjenja = new JTextField();
		    final JTextField txtAdresa = new JTextField();
		    final JTextField txtTelefon = new JTextField();
		    final JTextField txtEmailAdresa = new JTextField();
		    final JTextField txtBrojIndeksa = new JTextField();
		    final JTextField txtTrenutnaGodinaStudija = new JTextField();
		    final JTextField txtGodinaUpisa = new JTextField();
		    final JTextField txtNacinFinansiranja = new JTextField();
		    
		    GridBagConstraints gbcLblIme = new GridBagConstraints();
		    gbcLblIme.fill = GridBagConstraints.HORIZONTAL;
		    gbcLblIme.gridx = 0;
		    gbcLblIme.gridy = 0;
		    gbcLblIme.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblIme, gbcLblIme);


		    GridBagConstraints gbcLblPrezime = new GridBagConstraints();
		    gbcLblPrezime.fill = GridBagConstraints.HORIZONTAL;
		    gbcLblPrezime.gridx = 0;
		    gbcLblPrezime.gridy = 1;
		    gbcLblPrezime.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblPrezime, gbcLblPrezime);


		    GridBagConstraints gbcLbDatumRodjennja = new GridBagConstraints();
		    gbcLbDatumRodjennja.fill = GridBagConstraints.HORIZONTAL;
		    gbcLbDatumRodjennja.gridx = 0;
		    gbcLbDatumRodjennja.gridy = 2;
		    gbcLbDatumRodjennja.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblDatumRodjenja, gbcLbDatumRodjennja);


		    GridBagConstraints gbcLbAdresa = new GridBagConstraints();
		    gbcLbAdresa.fill = GridBagConstraints.HORIZONTAL;
		    gbcLbAdresa.gridx = 0;
		    gbcLbAdresa.gridy = 3;
		    gbcLbAdresa.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblAdresa, gbcLbAdresa);


		    GridBagConstraints gbcLbTelefon = new GridBagConstraints();
		    gbcLbTelefon.fill = GridBagConstraints.HORIZONTAL;
		    gbcLbTelefon.gridx = 0;
		    gbcLbTelefon.gridy = 4;
		    gbcLbTelefon.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblTelefon, gbcLbTelefon);
		    
		    GridBagConstraints gbcLblEmailAdresa = new GridBagConstraints();
		    gbcLblEmailAdresa.fill = GridBagConstraints.HORIZONTAL;
		    gbcLblEmailAdresa.gridx = 0;
		    gbcLblEmailAdresa.gridy = 6;
		    gbcLblEmailAdresa.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblEmailAdresa, gbcLblEmailAdresa);

		    GridBagConstraints gbcLbBrojIndeksa = new GridBagConstraints();
		    gbcLbBrojIndeksa.fill = GridBagConstraints.HORIZONTAL;
		    gbcLbBrojIndeksa.gridx = 0;
		    gbcLbBrojIndeksa.gridy = 5;
		    gbcLbBrojIndeksa.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblBrojIndeksa, gbcLbBrojIndeksa);
		    
		    GridBagConstraints gbcLblGodinaUpisa = new GridBagConstraints();
		    gbcLblGodinaUpisa.fill = GridBagConstraints.HORIZONTAL;
		    gbcLblGodinaUpisa.gridx = 0;
		    gbcLblGodinaUpisa.gridy = 7;
		    gbcLblGodinaUpisa.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblGodinaUpisa, gbcLblGodinaUpisa);
		    
		    GridBagConstraints gbcLbTrenutnaGodinaStudija = new GridBagConstraints();
		    gbcLbTrenutnaGodinaStudija.fill = GridBagConstraints.HORIZONTAL;
		    gbcLbTrenutnaGodinaStudija.gridx = 0;
		    gbcLbTrenutnaGodinaStudija.gridy = 9;
		    gbcLbTrenutnaGodinaStudija.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblTrenutnaGodinaStudija, gbcLbTrenutnaGodinaStudija);
		    
		    GridBagConstraints gbcLbNacinFinansiranja = new GridBagConstraints();
		    gbcLbNacinFinansiranja.fill = GridBagConstraints.HORIZONTAL;
		    gbcLbNacinFinansiranja.gridx = 0;
		    gbcLbNacinFinansiranja.gridy = 10;
		    gbcLbNacinFinansiranja.insets = new Insets(20, 40, 0, 0);
		    panelCenter.add(lblNacinFinansiranja, gbcLbNacinFinansiranja);


		    GridBagConstraints gbcTxtIme = new GridBagConstraints();
		    gbcTxtIme .gridx = 1;
		    gbcTxtIme .gridy = 0;
		    gbcTxtIme .weightx = 100;
		    gbcTxtIme .fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtIme .insets = new Insets(20, 120, 0, 70);
		    panelCenter.add(txtIme, gbcTxtIme );
		    txtIme.addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					if((txtIme.getText()).matches("[A-Z][a-z]+")) {
						dobroime = true;
						if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobarindex && dobragodina)
							potvrda.setEnabled(true);
					}
					else {
							 dobroime = false;
							 potvrda.setEnabled(false);
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    } );


		    GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
		    gbcTxtPrezime .gridx = 1;
		    gbcTxtPrezime .gridy = 1;
		    gbcTxtPrezime .weightx = 100;
		    gbcTxtPrezime .fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtPrezime .insets = new Insets(20, 120, 0, 70);
		    panelCenter.add(txtPrezime, gbcTxtPrezime );
		    txtPrezime.addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					if((txtPrezime.getText()).matches("[A-Z][a-z]+")) {
						dobroprezime = true;
						if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobarindex && dobragodina)
							potvrda.setEnabled(true);
					}
					else {
							 dobroprezime = false;
							 potvrda.setEnabled(false);
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    } );



		    GridBagConstraints gbcTxtDatum = new GridBagConstraints();
		    gbcTxtDatum .gridx = 1;
		    gbcTxtDatum .gridy = 2;
		    gbcTxtDatum .weightx = 100;
		    gbcTxtDatum.fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtDatum.insets = new Insets(20, 120, 0, 70);
		    panelCenter.add(txtDatumRodjenja, gbcTxtDatum );
		    txtDatumRodjenja.addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					if((txtDatumRodjenja.getText()).matches("[0-3][0-9]/[0-1][0-9]/[12][0129][0-9][0-9]")) {
						dobardatum = true;
						if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobarindex && dobragodina)
							potvrda.setEnabled(true);
					}
					else {
							 dobardatum = false;
							 potvrda.setEnabled(false);
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    } );
		    
		    GridBagConstraints gbcTxtAdresa = new GridBagConstraints();
		    gbcTxtAdresa .gridx = 1;
		    gbcTxtAdresa .gridy = 3;
		    gbcTxtAdresa .weightx = 100;
		    gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtAdresa.insets = new Insets(20, 120, 0, 70);
		    panelCenter.add(txtAdresa, gbcTxtAdresa );
		    txtAdresa.addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					String[] splitovano = (txtAdresa.getText()).split(", ");
					if(splitovano.length==4) {
						dobra_adresa = true;
						if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobarindex && dobragodina)
							potvrda.setEnabled(true);
					}
					else {
							 dobra_adresa = false;
							 potvrda.setEnabled(false);
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    } );
		    
		    GridBagConstraints gbcTxtEmailAdresa = new GridBagConstraints();
		    gbcTxtEmailAdresa .gridx = 1;
		    gbcTxtEmailAdresa .gridy = 6;
		    gbcTxtEmailAdresa .weightx = 100;
		    gbcTxtEmailAdresa .fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtEmailAdresa .insets = new Insets(20, 120, 0, 70);
		    panelCenter.add(txtEmailAdresa, gbcTxtEmailAdresa );
		    txtEmailAdresa.addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					if((txtEmailAdresa.getText()).matches("[a-zA-Z0-9]+[.]?[a-zA-Z0-9]+[@]([a-z]+[.])+[a-z]+")) {
						dobarmail = true;
						if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobarindex && dobragodina)
							potvrda.setEnabled(true);
					}
					else {
							 dobarmail = false;
							 potvrda.setEnabled(false);
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    } );
		    
		    GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
		    gbcTxtTelefon .gridx = 1;
		    gbcTxtTelefon .gridy = 4;
		    gbcTxtTelefon .weightx = 100;
		    gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtTelefon.insets = new Insets(20, 120, 0, 70);
		    panelCenter.add(txtTelefon, gbcTxtTelefon );
		    txtTelefon.addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					if((txtTelefon.getText()).matches("[0][0-9]{8}|[0][0-9]{9}")) {
						dobarbroj = true;
						if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobarindex && dobragodina)
							potvrda.setEnabled(true);
					}
					else {
						 dobarbroj = false;
						 potvrda.setEnabled(false);
					}
						
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    } );
		    
		    GridBagConstraints gbcTxtBrojIndeksa = new GridBagConstraints();
		    gbcTxtBrojIndeksa .gridx = 1;
		    gbcTxtBrojIndeksa .gridy = 5;
		    gbcTxtBrojIndeksa .weightx = 100;
		    gbcTxtBrojIndeksa.fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtBrojIndeksa.insets = new Insets(20, 120, 0, 70);
		    panelCenter.add(txtBrojIndeksa, gbcTxtBrojIndeksa );
		    txtBrojIndeksa.addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					if((txtBrojIndeksa.getText()).matches("[A-Z][A-Z][0-9][0-9][0-9][/][0-9][0-9][0-9][0-9]")) {
						dobarindex = true;
						if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobarindex && dobragodina)
							potvrda.setEnabled(true);
					}
					else {
						 dobarindex = false;
						 potvrda.setEnabled(false);
					}
						
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    } );
		    
		    
		    GridBagConstraints gbcTxtGodinaUpisa = new GridBagConstraints();
		    gbcTxtGodinaUpisa .gridx = 1;
		    gbcTxtGodinaUpisa .gridy = 7;
		    gbcTxtGodinaUpisa .weightx = 100;
		    gbcTxtGodinaUpisa .fill = GridBagConstraints.HORIZONTAL;
		    gbcTxtGodinaUpisa .insets = new Insets(20, 120, 0, 70);
		    panelCenter.add(txtGodinaUpisa, gbcTxtGodinaUpisa );
		    txtGodinaUpisa.addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					if((txtGodinaUpisa.getText()).matches("[0-9]+")) {
						dobragodina = true;
						if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobarindex && dobragodina)
							potvrda.setEnabled(true);
					}
					else {
						 dobragodina = false;
						 potvrda.setEnabled(false);
					}
						
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    } );
		    
		    
		    String godinaStudija[]= {"I (Prva)","II (Druga)","III (Treca)","IV (Cetvrta)"};
		    JComboBox<String> godStud=new JComboBox<>(godinaStudija);
		    
		    GridBagConstraints grd1 = new GridBagConstraints();
		    grd1.gridx = 1;
		    grd1.gridy = 9;
		    grd1.weightx = 100;
		    grd1.fill = GridBagConstraints.HORIZONTAL;
		    grd1.insets = new Insets(20, 120, 0, 70);
		    
		    panelCenter.add(godStud,grd1);
		    
		    String status[]= {"Budzet","Samofinansiranje"};
		    JComboBox<String> NacinFinansiranja=new JComboBox<>(status);
		    
		    GridBagConstraints grd2 = new GridBagConstraints();
		    grd2.gridx = 1;
		    grd2.gridy = 10;
		    grd2.weightx = 100;
		    grd2.fill = GridBagConstraints.HORIZONTAL;
		    grd2.insets = new Insets(20, 120, 0, 70);
		    
		    panelCenter.add(NacinFinansiranja,grd2);
		    
		    infoPanel.add(panelCenter, BorderLayout.CENTER);
		    
			
	    	Student student = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
	    	txtIme.setText(student.getIme());
		    txtPrezime.setText(student.getPrezime());
		    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		    String strDate = dateFormat.format(student.getDatum_rodjenja());  
		    txtDatumRodjenja.setText(strDate);
		    String adresa_string = student.getAdresa().getUlica() + ", " + student.getAdresa().getBroj() + ", "  + student.getAdresa().getGrad() + ", " + student.getAdresa().getDrava(); 
		    txtAdresa.setText(adresa_string);;
		    txtTelefon.setText(student.getKontakt_tel());
		    txtEmailAdresa.setText(student.getEmail());;
		    txtBrojIndeksa.setText(student.getBroj_indeksa());;
		    txtGodinaUpisa.setText(Integer.toString(student.getGod_upisa()));
		    godStud.setSelectedIndex(student.getTrenutna_god()-1);
			int k=1;
			if(student.getStatus().equals(Status_Studenta.S)) {
				k=2;
			}
			NacinFinansiranja.setSelectedIndex(k-1);
	    	
			potvrda.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
				    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da postavite nove parametre?", "Potvrda izmene", dialogButton);
				    
				    

				    if (dialogResult == JOptionPane.YES_OPTION) {
				    	
				    	if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmailAdresa.getText().isEmpty() || txtBrojIndeksa.getText().isEmpty() || txtGodinaUpisa.getText().isEmpty()) {
				    		
				    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
				    		return;
				    	}
				    		
				    	String broj_index = txtBrojIndeksa.getText();
				    	for(Student s : BazaStudenata.getInstance().getStudenti()) {
				    		if(broj_index.equals(s.getBroj_indeksa()) && s!=student) {
				    			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Vec postoji student sa tim indeksom");
				    			return;
				    		}
				    	}
				    	String ime = txtIme.getText();
				    	String prezime = txtPrezime.getText();
				    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				    	Date datumRodjenja = new Date();
				    	try {
							datumRodjenja =  formatter.parse(txtDatumRodjenja.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
				    	String adresaStr = txtAdresa.getText();
				    	String[] adresa_split = adresaStr.split(", ");
				    	Adresa adresa = new Adresa(adresa_split[0], adresa_split[1], adresa_split[2], adresa_split[3]);
				    	String telefon = txtTelefon.getText();
				    	String mail = txtEmailAdresa.getText();
				    	String br_indexa = txtBrojIndeksa.getText();
				    	int god_upisa = Integer.parseInt(txtGodinaUpisa.getText());
				    	int tren_god = godStud.getSelectedIndex()+1;
				    	int status_pom = NacinFinansiranja.getSelectedIndex()+1;
				    	Status_Studenta status = null;
				    	if(status_pom == 2) {
				    		status = Status_Studenta.S;
				    	} else if (status_pom == 1){
				    		status = Status_Studenta.B;
				    	}
				    	StudentKontroler.getInstance().izmeniStudenta(StudentiJTable.rowSelectedIndex, ime, prezime, datumRodjenja, adresa, telefon, mail, br_indexa, god_upisa, tren_god, status);
				    	dispose();
				    	
				    }
					
				}
				
			});
		    
			
		    tabbedPane.add("Informacije", panelCenter);
		    
		    JPanel panel_polozenih = new JPanel();
		    JPanel panelDugmici2 = new JPanel();
		    panel_polozenih.setLayout(new BorderLayout());
		    JButton btn_ponistiOcenu = new JButton("Ponisti ocenu");
		    panelDugmici2.add(btn_ponistiOcenu);
		    panel_polozenih.add(panelDugmici2, BorderLayout.NORTH);
		    PolozeniIspitiJTable polozeni = new PolozeniIspitiJTable();
			JScrollPane polozeniPane = new JScrollPane(polozeni);
			panel_polozenih.add(polozeniPane, BorderLayout.CENTER);
			double prosecna_ocena = 0;
			int broj_predmeta = 0;
			int espb_ukupno=0;
			for(OcenaNaIspitu o : student.getPolozeni_ispiti()) {
				espb_ukupno += o.getPredmet().getEspb();
				broj_predmeta++;
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
				prosecna_ocena += ocena;
			}
			
			JPanel panelIspisa = new JPanel();
			if(prosecna_ocena==0) {
				prosek.setText("Prosecna ocena je 0");
			}else {
				prosecna_ocena/=broj_predmeta;
				prosek.setText("Prosecna ocena je " + df.format(prosecna_ocena));
			}
			espb.setText("Ukupan broj ESPB bodova je " + Integer.toString(espb_ukupno));
			JLabel espb2 = new JLabel();
			espb2.setText("");
			JLabel espb3 = new JLabel();
			espb3.setText("");
			panelIspisa.setLayout(new GridLayout(0, 1));
			panelIspisa.add(espb2);
			panelIspisa.add(prosek);
			panelIspisa.add(espb);
			panelIspisa.add(espb3);
			panel_polozenih.add(panelIspisa, BorderLayout.SOUTH);
		    tabbedPane.add("Polozeni", panel_polozenih);
		    
		    JPanel panelNepPred = new JPanel();
		    panelNepPred.setLayout(new BorderLayout());
		    JPanel panelDugmici = new JPanel();
		    
		    JButton dodaj = new JButton("Dodaj");
		    JButton obrisi = new JButton("Obrisi");
		    JButton polaganje = new JButton("Polaganje");
		    panelDugmici.add(polaganje);
		    
		    dodaj.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					JDialog dijalogDodavanjaNaStudenta = new JDialog(parent, "Dodavanje predmeta", modal);
					dijalogDodavanjaNaStudenta.setLocationRelativeTo(null);
					dijalogDodavanjaNaStudenta.setSize(diaWidth*2/5, diaHeight*3/5);
					dijalogDodavanjaNaStudenta.setVisible(true);
					
					PotencijalniJTable tabelaPotencijalnih = new PotencijalniJTable();
					dijalogDodavanjaNaStudenta.add(tabelaPotencijalnih);
					//omoguciti selekciju predmeta i dodavanje u nepolozene na klik dodaj
				}
				
			});
		    panelDugmici.add(dodaj);
		    panelDugmici.add(obrisi);
		    
		    polaganje.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(NepolozeniPredmetiJTable.rowSelectedIndex!=-1 && NepolozeniPredmetiJTable.rowSelectedIndex < BazaNepolozenihPredmeta.getInstance().getNepolozeniPredmeti().size()) {
						DijalogPolaganjePredmeta UnosOcene = new DijalogPolaganjePredmeta(parent, "Unos Ocene", true);
						UnosOcene.setVisible(true);
					}
					
				}
		    	
		    });
		    panelDugmici.add(polaganje);
		    
		    NepolozeniPredmetiJTable nep_predmeti = new NepolozeniPredmetiJTable();
			JScrollPane nep_predmetiPane = new JScrollPane(nep_predmeti);

			panelNepPred.add(panelDugmici, BorderLayout.NORTH);
			panelNepPred.add(nep_predmetiPane, BorderLayout.CENTER);
		    tabbedPane.add("Nepolozeni", panelNepPred);
		    
		    dodaj.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DijalogDodavanjaPredmetaStudentu dijalogDodavanja = new DijalogDodavanjaPredmetaStudentu(parent, "Dodavanje predmeta", modal, nep_predmeti);
				}
				
		    });
		    
		    obrisi.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Object[] options = {"Da",
	                "Ne"};
					int n = JOptionPane.showOptionDialog(parent,
							"Da li ste sigurni da zelita da uklonite predmet?",
							"Uklanjanje predmeta",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,     
							options,  
							options[0]);
					
					if(n==JOptionPane.YES_OPTION) {
						Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
						Predmet zaBrisanje = BazaNepolozenihPredmeta.getInstance().getRow(NepolozeniPredmetiJTable.rowSelectedIndex);
						OcenaNaIspitu trazena = new OcenaNaIspitu();
						for(OcenaNaIspitu o : s.getNepolozeni_ispiti()) {
							if(o.getPredmet().getSifra_predmeta()==zaBrisanje.getSifra_predmeta()) {
								trazena = o;
							}
						}
						s.getNepolozeni_ispiti().remove(trazena);
						nep_predmeti.azurirajPrikaz();
					}
				}
		    });
		    
		    this.add(tabbedPane);
		    
		    btn_ponistiOcenu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(PolozeniIspitiJTable.rowSelectedIndex < BazaPolozenih.getInstance().getPolozeni().size() && PolozeniIspitiJTable.rowSelectedIndex!=-1) {
				    	int dialogButton = JOptionPane.YES_NO_OPTION;
					    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da ponistite ocenu?", "Ponistavanje ocene", dialogButton);
					    
					    if (dialogResult == JOptionPane.YES_OPTION) {
					    	OcenaNaIspitu p = BazaPolozenih.getInstance().getRow(PolozeniIspitiJTable.rowSelectedIndex);
					    	Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
					    	p.setVrednost_ocene(Vrednost_Ocene.pet);
							s.getPolozeni_ispiti().remove(p);
							PolozeniIspitiJTable.azurirajPrikaz();
							s.getNepolozeni_ispiti().add(p);
							NepolozeniPredmetiJTable.azurirajPrikaz();
							double prosecna_ocena2 = 0;
							int broj_predmeta2 = 0;
							int espb_ukupno2=0;
							for(OcenaNaIspitu o : student.getPolozeni_ispiti()) {
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
								prosek.setText("Prosecna ocena je 0");
							}else {
								prosecna_ocena2/=broj_predmeta2;
								prosek.setText("Prosecna ocena je " + df.format(prosecna_ocena2));
							}
							espb.setText("Ukupan broj ESPB bodova je " + Integer.toString(espb_ukupno2));
					    }	
				    }
					NepolozeniPredmetiJTable.azurirajPrikaz();
 
				}
				
		    });
		    
		}
}


class DijalogDodavanjaPredmetaStudentu extends JDialog {
	public DijalogDodavanjaPredmetaStudentu(Frame parent, String title, boolean modal, NepolozeniPredmetiJTable nep_predmeti) {
		super(parent, title, modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*4/5);
		setLocationRelativeTo(parent);
		
		//JPanel panelzaDodavanje = new JPanel();
		PotencijalniJTable tabelaPotencijalnih = new PotencijalniJTable();
		JScrollPane panePotencijalni = new JScrollPane(tabelaPotencijalnih);
		JPanel panelPotencijalni = new JPanel();
		panelPotencijalni.add(panePotencijalni);
		add(panelPotencijalni, BorderLayout.CENTER);
		
		JButton dodajPredmet = new JButton("Dodaj");
		JPanel panelZaDugme = new JPanel();
		panelZaDugme.add(dodajPredmet);
		add(panelZaDugme, BorderLayout.SOUTH);
		dodajPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sifra_naziv_predmeta = BazaPredmeta.getInstance().getValueAtZaDodavanje(PotencijalniJTable.rowSelectedIndex, 0);
				Predmet predmetKojiSeDodaje = new Predmet();
				for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
					if(sifra_naziv_predmeta.contains(p.getSifra_predmeta())) {
						predmetKojiSeDodaje = p;
					}
				}

				Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
				OcenaNaIspitu noviNepolozeni = new OcenaNaIspitu(s, predmetKojiSeDodaje, Vrednost_Ocene.pet, new Date(2000, 05, 27));
				s.getNepolozeni_ispiti().add(noviNepolozeni);
				tabelaPotencijalnih.azurirajPrikaz();
				dispose();
				nep_predmeti.azurirajPrikaz();
			}
		});
		this.setVisible(true);
	}
}