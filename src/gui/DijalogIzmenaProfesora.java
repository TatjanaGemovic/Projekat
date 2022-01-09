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
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.ProfesorKontroler;
import model.Adresa;
import model.BazaNepolozenihPredmeta;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.OcenaNaIspitu;
import model.Predmet;
import model.Profesor;
import model.Student;
import model.Vrednost_Ocene;

public class DijalogIzmenaProfesora extends JDialog {
	private boolean dobroime = true;
	private boolean dobroprezime = true;
	private boolean dobardatum = true;
	private boolean dobra_adresa = true;
	private boolean dobarbroj = true;
	private boolean dobarmail = true;
	private boolean dobra_adresa2 = true;
	private boolean dobarbrlicne = true;
	private boolean dobrozvanje = true;
	private boolean dobarstaz = true;
	public ProfesorPredajeJTable prof_predaje = new ProfesorPredajeJTable(); 
	public DijalogIzmenaProfesora(Frame parent, String title, boolean modal) {
		super(parent, "Izmena Profesora", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*19/20);
		setLocationRelativeTo(parent);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JButton potvrda=new JButton("Potvrdi");
		potvrda.setEnabled(true);
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
	    
		JPanel panelInformacije = new JPanel();
		
	    JPanel panelCenter = new JPanel();
	    panelCenter.setLayout(new GridBagLayout());
	    
	    JLabel lblIme = new JLabel("Ime:");
	    JLabel lblPrezime = new JLabel("Prezime:");
	    JLabel lblDatumRodjenja = new JLabel("Datum rodjenja:");
	    JLabel lblAdresa = new JLabel("Adresa stanovanja:");
	    JLabel lblTelefon = new JLabel("Broj telefona:");
	    JLabel lblEmailAdresa = new JLabel("Email adresa:");
	    JLabel lblAdresaKancelarije= new JLabel("Adresa kancelarije:");
	    JLabel lblBrLicneKarte = new JLabel("Broj Licne Karte:");
	    JLabel lblZvanje = new JLabel("Zvanje:");
	    JLabel lblGodineStaza = new JLabel("Godine staza:");
	    
	    final JTextField txtIme = new JTextField();
	    final JTextField txtPrezime = new JTextField();
	    final JTextField txtDatumRodjenja = new JTextField();
	    final JTextField txtAdresa = new JTextField();
	    final JTextField txtTelefon = new JTextField();
	    final JTextField txtEmailAdresa = new JTextField();
	    final JTextField txtAdresaKancelarije = new JTextField();
	    final JTextField txtBrLicneKarte = new JTextField();
	    final JTextField txtZvanje = new JTextField();
	    final JTextField txtGodineStaza = new JTextField();
	    
	    
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
	    gbcLbAdresa.insets = new Insets(20, 40, 0,0);
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
	    gbcLblEmailAdresa.gridy = 5;
	    gbcLblEmailAdresa.insets = new Insets(20, 40, 0, 0);
	    panelCenter.add(lblEmailAdresa, gbcLblEmailAdresa);
	    
	    GridBagConstraints gbcLblAdresaKancelarije = new GridBagConstraints();
	    gbcLblAdresaKancelarije.fill = GridBagConstraints.HORIZONTAL;
	    gbcLblAdresaKancelarije.gridx = 0;
	    gbcLblAdresaKancelarije.gridy = 6;
	    gbcLblAdresaKancelarije.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblAdresaKancelarije, gbcLblAdresaKancelarije);
	    
	    GridBagConstraints gbcLblBrLicneKarte = new GridBagConstraints();
	    gbcLblBrLicneKarte.fill = GridBagConstraints.HORIZONTAL;
	    gbcLblBrLicneKarte.gridx = 0;
	    gbcLblBrLicneKarte.gridy = 7;
	    gbcLblBrLicneKarte.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblBrLicneKarte, gbcLblBrLicneKarte);
	    
	    GridBagConstraints gbcLblZvanje = new GridBagConstraints();
	    gbcLblZvanje.fill = GridBagConstraints.HORIZONTAL;
	    gbcLblZvanje.gridx = 0;
	    gbcLblZvanje.gridy = 8;
	    gbcLblZvanje.insets = new Insets(20, 40, 0, 0);
	    panelCenter.add(lblZvanje, gbcLblZvanje);
	    
	    GridBagConstraints gbcLblGodineStaza = new GridBagConstraints();
	    gbcLblGodineStaza.fill = GridBagConstraints.HORIZONTAL;
	    gbcLblGodineStaza.gridx = 0;
	    gbcLblGodineStaza.gridy = 9;
	    gbcLblGodineStaza.insets = new Insets(20, 40, 0, 0);
	    panelCenter.add(lblGodineStaza, gbcLblGodineStaza);
	    
	    
	    
	    
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
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
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
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
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
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
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
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
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
				if((txtTelefon.getText()).matches("[0][0-9]{9}|[0][0-9]{8}")) {
					dobarbroj = true;
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
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
	    
	    
	    GridBagConstraints gbcTxtEmailAdresa = new GridBagConstraints();
	    gbcTxtEmailAdresa .gridx = 1;
	    gbcTxtEmailAdresa .gridy = 5;
	    gbcTxtEmailAdresa .weightx = 100;
	    gbcTxtEmailAdresa .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtEmailAdresa .insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtEmailAdresa, gbcTxtEmailAdresa );
	    txtEmailAdresa.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtEmailAdresa.getText()).matches("[a-zA-Z0-9]+[.]?[a-zA-Z0-9]+[@]([a-z]+[.])+[a-z]+")) {
					dobarmail = true;
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
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
	    
	    GridBagConstraints gbcTxtAdresaKancelarije = new GridBagConstraints();
	    gbcTxtAdresaKancelarije .gridx = 1;
	    gbcTxtAdresaKancelarije .gridy = 6;
	    gbcTxtAdresaKancelarije .weightx = 100;
	    gbcTxtAdresaKancelarije.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtAdresaKancelarije.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtAdresaKancelarije, gbcTxtAdresaKancelarije );
	    txtAdresaKancelarije.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				String[] splitovano = (txtAdresaKancelarije.getText()).split(", ");
				if(splitovano.length==4) {
					dobra_adresa2 = true;
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
						potvrda.setEnabled(true);
				}
				else {
						 dobra_adresa2 = false;
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
	    
	    GridBagConstraints gbcTxtBrLicneKarte = new GridBagConstraints();
	    gbcTxtBrLicneKarte .gridx = 1;
	    gbcTxtBrLicneKarte .gridy = 7;
	    gbcTxtBrLicneKarte .weightx = 100;
	    gbcTxtBrLicneKarte.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtBrLicneKarte.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtBrLicneKarte, gbcTxtBrLicneKarte );
	    
	    txtBrLicneKarte.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtBrLicneKarte.getText()).matches("[0-9]{8}")) {
					dobarbrlicne = true;
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
						potvrda.setEnabled(true);
				}
				else {
					 dobarbrlicne = false;
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
	    GridBagConstraints gbcTxtZvanje = new GridBagConstraints();
	    gbcTxtZvanje .gridx = 1;
	    gbcTxtZvanje .gridy = 8;
	    gbcTxtZvanje .weightx = 100;
	    gbcTxtZvanje.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtZvanje.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtZvanje, gbcTxtZvanje );
	    txtZvanje.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtZvanje.getText()).matches("[a-zA-Z]+")) {
					dobrozvanje = true;
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
						potvrda.setEnabled(true);
				}
				else {
					 dobrozvanje = false;
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
	    
	    GridBagConstraints gbcTxtGodineStaza = new GridBagConstraints();
	    gbcTxtGodineStaza .gridx = 1;
	    gbcTxtGodineStaza .gridy = 9;
	    gbcTxtGodineStaza .weightx = 100;
	    gbcTxtGodineStaza.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtGodineStaza.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtGodineStaza, gbcTxtGodineStaza);
	    txtGodineStaza.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if((txtGodineStaza.getText()).matches("[0-9]+")) {
					dobarstaz = true;
					if(dobroime && dobroprezime && dobardatum && dobra_adresa && dobarbroj && dobarmail && dobra_adresa2 && dobarbrlicne && dobrozvanje && dobarstaz)
						potvrda.setEnabled(true);
				}
				else {
					 dobarstaz = false;
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
	    
	    
	    
    	Profesor profesor = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
    	txtIme.setText(profesor.getIme());
	    txtPrezime.setText(profesor.getPrezime());
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = dateFormat.format(profesor.getDatum_rodjenja());  
	    txtDatumRodjenja.setText(strDate);
	    String adresa_string = profesor.getAdresa().getUlica() + ", " + profesor.getAdresa().getBroj() + ", "  + profesor.getAdresa().getGrad() + ", " + profesor.getAdresa().getDrava(); 
	    txtAdresa.setText(adresa_string);
	    adresa_string = profesor.getAdresa_kancelarije().getUlica() + ", " + profesor.getAdresa_kancelarije().getBroj() + ", "  + profesor.getAdresa_kancelarije().getGrad() + ", " + profesor.getAdresa_kancelarije().getDrava(); 
	    txtAdresaKancelarije.setText(adresa_string);
	    txtTelefon.setText(profesor.getKontakt_tel());
	    txtEmailAdresa.setText(profesor.getEmail());
	    txtZvanje.setText(profesor.getZvanje());
	    txtBrLicneKarte.setText(profesor.getBroj_licne_karte());
	    txtGodineStaza.setText(Integer.toString(profesor.getGodine_staza()));
	    
	    potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da postavite nove parametre?", "Potvrda izmene", dialogButton);
			    
			    

			    if (dialogResult == JOptionPane.YES_OPTION) {
			    	
			    	if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmailAdresa.getText().isEmpty() || txtAdresaKancelarije.getText().isEmpty() || txtBrLicneKarte.getText().isEmpty() || txtZvanje.getText().isEmpty() || txtGodineStaza.getText().isEmpty()) {
			    		
			    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    		
			    	String brojLicneKarte = txtBrLicneKarte.getText();
			    	for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			    		if(brojLicneKarte.equals(p.getBroj_licne_karte()) && p!=profesor) {
			    			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Vec postoji profesor sa unetim brojem licne karte");
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
			    	adresaStr = txtAdresaKancelarije.getText();
			    	adresa_split = adresaStr.split(", ");
			    	Adresa adresa2 = new Adresa(adresa_split[0], adresa_split[1], adresa_split[2], adresa_split[3]);
			    	String brLicneKarte = txtBrLicneKarte.getText();
			    	String zvanje = txtZvanje.getText();
			    	int god_staza = Integer.parseInt(txtGodineStaza.getText());
			    	ProfesorKontroler.getInstance().izmeniProfesora(ProfesoriJTable.rowSelectedIndex, ime, prezime, datumRodjenja, adresa, telefon, mail, adresa2, brLicneKarte, zvanje, god_staza);
			    	dispose();
			    }
			}
		});
	   panelInformacije.add(panelCenter, BorderLayout.CENTER);
	   panelInformacije.add(panelButton, BorderLayout.SOUTH);
	   tabbedPane.add("Informacije", panelInformacije); 
	   
	   
	   
	   JPanel panelPredmeta = new JPanel();
	   panelPredmeta.setLayout(new BorderLayout());
	   JPanel panelDugmici = new JPanel();
	    
	   JButton dodaj = new JButton("Dodaj predmet");
	   panelDugmici.add(dodaj);
	   JButton obrisi = new JButton("Ukloni predmet");
	   panelDugmici.add(obrisi);
	    
	  // ProfesorPredajeJTable profPredaje = new ProfesorPredajeJTable();
	   JScrollPane profPredajePane = new JScrollPane(prof_predaje);
	   
	   panelPredmeta.add(panelDugmici, BorderLayout.NORTH);
	   panelPredmeta.add(profPredajePane, BorderLayout.CENTER);
		
	   tabbedPane.add("Predmeti", panelPredmeta);
	   dodaj.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			DijalogDodavanjePredmetaProfesoru dijalogDodavanja = new DijalogDodavanjePredmetaProfesoru(parent, "Dodaj predmet", modal, prof_predaje);
		}
		   
	   });
	   obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Da",
               "Ne"};
				int n = JOptionPane.showOptionDialog(parent,
						"Da li ste sigurni?",
						"Uklanjanje predmeta",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,     
						options,  
						options[0]);
				
				if(n==JOptionPane.YES_OPTION) {
					String sifrapredmeta = BazaPredmeta.getInstance().getValueAtProfesorPredaje(ProfesorPredajeJTable.rowSelectedIndex, 0);
					Predmet predmetKojiSeBrise = new Predmet();
					int index = 0;
					for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
						if(sifrapredmeta==p.getSifra_predmeta()) {
							predmetKojiSeBrise = p;
							break;
						}
						index++;
					}
					Profesor prof = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
					prof.getProfesor_na_predmetu().remove(predmetKojiSeBrise);
					predmetKojiSeBrise.setPredmetni_profesor(null);
					BazaPredmeta.getInstance().getPredmeti().set(index, predmetKojiSeBrise);
					prof_predaje.azurirajPrikaz();
				}
			}
	    });
	    
	   this.add(tabbedPane);
	}
}

class DijalogDodavanjeProfesoraNaPredmet extends JDialog {
	
	public DijalogDodavanjeProfesoraNaPredmet(Frame parent, String title, boolean modal) {
		super(parent, "Odabir Profesora", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*2/5, diaHeight*10/20);
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
		
	    ProfesoriNaPredmetuJTable profesori = new ProfesoriNaPredmetuJTable();
		JScrollPane profesoriProzor = new JScrollPane(profesori);
		this.add(profesoriProzor, BorderLayout.CENTER);
		
		potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    
			    if(ProfesoriNaPredmetuJTable.rowSelectedIndex != -1 && ProfesoriNaPredmetuJTable.rowSelectedIndex < BazaProfesora.getInstance().getProfesori().size()) {
			    	
			    	int dialogButton = JOptionPane.YES_NO_OPTION;
			    	int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda", dialogButton);
			    	
			    	if (dialogResult == JOptionPane.YES_OPTION) {
			    		dispose();
			    		Profesor p = BazaProfesora.getInstance().getProfesori().get(ProfesoriNaPredmetuJTable.rowSelectedIndex);
			    		DijalogIzmenaPredmeta.profesorLista.setText(p.getImeIPrezime());
			    		DijalogIzmenaPredmeta.btnRemoveProfesor.setEnabled(true);
			    		DijalogIzmenaPredmeta.btnAddProfesor.setEnabled(false);
			    		
			    	}
			    }
			}
			
		});
	}
}


class DijalogBrisanjaProfesoraSaPredmeta extends JDialog {
	
	public DijalogBrisanjaProfesoraSaPredmeta(Frame parent, String title, boolean modal) {
		super(parent, "Ukloni Profesora", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*2/5, diaHeight*5/20);
		setLocationRelativeTo(parent);
		
		JButton potvrda=new JButton("Potvrdi");
		JButton odustanak=new JButton("Odustani");
		
		
	
		odustanak.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
	
				    dispose();
			             
				}
			});
		
		JPanel panelButton = new JPanel();
		panelButton.add(potvrda);
		panelButton.add(odustanak);
	    this.add(panelButton, BorderLayout.SOUTH);
		
	    JLabel labela = new JLabel("Da li ste sigurni?");
	    JPanel profesoriBrisanje = new JPanel();
	    profesoriBrisanje.add(labela, BorderLayout.SOUTH);
		this.add(profesoriBrisanje, BorderLayout.CENTER);
		
		potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    dispose();	
			    DijalogIzmenaPredmeta.profesorLista.setText(null);
			    DijalogIzmenaPredmeta.btnRemoveProfesor.setEnabled(false);
			    DijalogIzmenaPredmeta.btnAddProfesor.setEnabled(true);
			    
			}
			
		});
	}
}

class DijalogDodavanjePredmetaProfesoru extends JDialog {
	public DijalogDodavanjePredmetaProfesoru(Frame parent, String title, boolean modal, ProfesorPredajeJTable prof_predaje) {
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
		JButton odustani = new JButton("Odustani");
		JPanel panelZaDugme = new JPanel();
		panelZaDugme.add(dodajPredmet);
		panelZaDugme.add(odustani);
		add(panelZaDugme, BorderLayout.SOUTH);
		if(tabelaPotencijalnih.getValueAt(0,0).toString()=="")
			dodajPredmet.setEnabled(false);
		
		dodajPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sifra_naziv_predmeta = BazaPredmeta.getInstance().getValueAtZaDodavanje(PotencijalniJTable.rowSelectedIndex, 0);
				Predmet predmetKojiSeDodaje = new Predmet();
				Profesor prof = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
				int index = 0;
				for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
					if(sifra_naziv_predmeta.contains(p.getSifra_predmeta())) {
						predmetKojiSeDodaje = p;
						break;
					}
					index++;
				}
				predmetKojiSeDodaje.setPredmetni_profesor(prof);
				BazaPredmeta.getInstance().getPredmeti().set(index, predmetKojiSeDodaje);
				prof.getProfesor_na_predmetu().add(predmetKojiSeDodaje);
				tabelaPotencijalnih.azurirajPrikaz();
				dispose();
				prof_predaje.azurirajPrikaz();
			}
		});
		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		this.setVisible(true);
	}
}

