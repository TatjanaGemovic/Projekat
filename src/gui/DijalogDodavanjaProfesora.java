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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesorKontroler;
import model.Adresa;
import model.BazaProfesora;
import model.Profesor;

public class DijalogDodavanjaProfesora extends JDialog{
	
	private static final long serialVersionUID = 791224488161083459L;
	private boolean dobroime = false;
	private boolean dobroprezime = false;
	private boolean dobardatum = false;
	private boolean dobra_adresa = false;
	private boolean dobarbroj = false;
	private boolean dobarmail = false;
	private boolean dobra_adresa2 = false;
	private boolean dobarbrlicne = false;
	private boolean dobrozvanje = false;
	private boolean dobarstaz = false;
	
	
	public DijalogDodavanjaProfesora(Frame parent, String title, boolean modal) {
		super(parent, MainFrame.getInstance().getResourceBundle().getString("dodavanje_profesora"), modal);
		
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*19/20);
		setLocationRelativeTo(parent);
		
		JButton potvrda=new JButton(MainFrame.getInstance().getResourceBundle().getString("potvrda"));
		potvrda.setEnabled(false);
		JButton odustanak=new JButton(MainFrame.getInstance().getResourceBundle().getString("cancel"));

		odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			int dialogButton = JOptionPane.YES_NO_OPTION;
			           int dialogResult = JOptionPane.showConfirmDialog(null, MainFrame.getInstance().getResourceBundle().getString("siguran"), MainFrame.getInstance().getResourceBundle().getString("potvrda"), dialogButton);

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
	    
	    JLabel lblIme = new JLabel( MainFrame.getInstance().getResourceBundle().getString("ime"));
	    JLabel lblPrezime = new JLabel(MainFrame.getInstance().getResourceBundle().getString("prezime"));
	    JLabel lblDatumRodjenja = new JLabel(MainFrame.getInstance().getResourceBundle().getString("dat_rodjenja"));
	    JLabel lblAdresa = new JLabel(MainFrame.getInstance().getResourceBundle().getString("adresa_stan"));
	    JLabel lblTelefon = new JLabel(MainFrame.getInstance().getResourceBundle().getString("telefon"));
	    JLabel lblEmailAdresa = new JLabel(MainFrame.getInstance().getResourceBundle().getString("mail"));
	    JLabel lblAdresaKancelarije= new JLabel(MainFrame.getInstance().getResourceBundle().getString("adresa_kanc"));
	    JLabel lblBrLicneKarte = new JLabel(MainFrame.getInstance().getResourceBundle().getString("br_licne"));
	    JLabel lblZvanje = new JLabel(MainFrame.getInstance().getResourceBundle().getString("zvanje"));
	    JLabel lblGodineStaza = new JLabel(MainFrame.getInstance().getResourceBundle().getString("god_staza"));
	    
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
				if((txtIme.getText()).matches("[A-ZČĆŠĐŽ][a-zčćžšđ]+")) {
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
				if((txtPrezime.getText()).matches("[A-ZČĆŠĐŽ][a-zčćžšđ]+")) {
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
				if((txtTelefon.getText()).matches("[0][0-9]{8}|[0][0-9]{9}|[0-9]{3}/[0-9]{3,4}\\-[0-9]{3,4}")) {
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
				if((txtEmailAdresa.getText()).matches("[a-zA-Z0-9ČĆŠĐŽčćžšđ]+[.]?[a-zA-Z0-9ČĆŠĐŽčćžšđ]+[@]([a-z]+[.])+[a-z]+")) {
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
				if((txtBrLicneKarte.getText()).matches("[0-9]{9}")) {
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
				if((txtZvanje.getText()).matches("[a-zA-Z ]+")) {
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
	    
	    
	   
	    
	    potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    int dialogResult = JOptionPane.showConfirmDialog(null, MainFrame.getInstance().getResourceBundle().getString("param"), MainFrame.getInstance().getResourceBundle().getString("potvrda"), dialogButton);
			    	
			    if (dialogResult == JOptionPane.YES_OPTION) {
			    	if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmailAdresa.getText().isEmpty() || txtAdresaKancelarije.getText().isEmpty() || txtBrLicneKarte.getText().isEmpty() || txtZvanje.getText().isEmpty() || txtGodineStaza.getText().isEmpty()) {
			    		
			    		JOptionPane.showMessageDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("mora_popunjeno"), MainFrame.getInstance().getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    	
			    	String brojLicneKarte = txtBrLicneKarte.getText();
			    	for(Profesor i : BazaProfesora.getInstance().getProfesori()) {
			    		if(i.getBroj_licne_karte().equals(brojLicneKarte)) {
			    			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Postoji profesor sa istih brojm licne karte");
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
			    	adresaStr = txtAdresaKancelarije.getText();
			    	adresa_split = adresaStr.split(",");
			    	Adresa adresa2 = new Adresa(adresa_split[0], adresa_split[1], adresa_split[2], adresa_split[3]);
			    	String brLicneKarte = txtBrLicneKarte.getText();
			    	String zvanje = txtZvanje.getText();
			    	int god_staza = Integer.parseInt(txtGodineStaza.getText());
			    	ProfesorKontroler.getInstance().dodajProfesora(ime, prezime, datumRodjenja, adresa, telefon, mail, adresa2, brLicneKarte, zvanje, god_staza);
			    	dispose();
			    }	
			}
			
		});
	}
	
	
}
