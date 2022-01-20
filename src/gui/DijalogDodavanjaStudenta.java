package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import controller.StudentKontroler;
import model.Adresa;

import model.BazaStudenata;

import model.Status_Studenta;
import model.Student;

public class DijalogDodavanjaStudenta extends JDialog {

		private static final long serialVersionUID = 1044721290558920630L;
		private boolean dobroime = false;
		private boolean dobroprezime = false;
		private boolean dobardatum = false;
		private boolean dobra_adresa = false;
		private boolean dobarbroj = false;
		private boolean dobarindex = false;
		private boolean dobarmail = false;
		private boolean dobragodina = false;
		public DijalogDodavanjaStudenta(Frame parent, String title, boolean modal) {
		super(parent, "Dodavanje Studenta", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*19/20);
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
	    final JTextField txtGodinaUpisa = new JTextField();
	    
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
				if((txtIme.getText()).matches("[A-ZČĆŠĐŽ][a-zčćžšđ]+")) {
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
				if((txtPrezime.getText()).matches("[A-ZČĆŠĐŽ][a-zčćžšđ]+")) {
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
				if((txtEmailAdresa.getText()).matches("[a-zA-Z0-9ČĆŠĐŽčćžšđ]+[.]?[a-zA-Z0-9ČĆŠĐŽčćžšđ]+[@]([a-z]+[.])+[a-z]+")) {
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
				if((txtTelefon.getText()).matches("[0][0-9]{8}|[0][0-9]{9}|[0-9]{3}/[0-9]{3,4}\\-[0-9]{3,4}")) {
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
				if((txtBrojIndeksa.getText()).matches("[A-Z][A-Z][ ][0-9]{1,3}[/][0-9][0-9][0-9][0-9]")) {
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
	    
	    potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da u bazu dodajete studenta sa unetim podacima?", "Potvrda unosa", dialogButton);

			    if (dialogResult == JOptionPane.YES_OPTION) {
			    	if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmailAdresa.getText().isEmpty() || txtBrojIndeksa.getText().isEmpty() || txtGodinaUpisa.getText().isEmpty()) {
			    		
			    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    	
			    	String brojIndexa = txtBrojIndeksa.getText();
			    	for(Student i : BazaStudenata.getInstance().getStudenti()) {
			    		if(i.getBroj_indeksa().equals(brojIndexa)) {
			    			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Vec postoji student sa indeksom: " + brojIndexa);
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
			    	String[] adresa_split = adresaStr.split(",");
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
			    	StudentKontroler.getInstance().dodajStudenta(ime, prezime, datumRodjenja, adresa, telefon, mail, br_indexa, god_upisa, tren_god, status);
			    	dispose();
			    }	
			}
			
		});
	}
	
}
