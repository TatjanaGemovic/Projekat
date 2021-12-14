package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DijalogDodavanjaProfesora extends JDialog{

	public DijalogDodavanjaProfesora(Frame parent, String title, boolean modal) {
		super(parent, "Dodavanje Profesora", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*18/20);
		setLocationRelativeTo(parent);
		
		JPanel panelBottom = new JPanel();
		JButton potvrda=new JButton("Potvrdi");
		JButton odustanak=new JButton("Odustani");
		panelBottom.add(potvrda);
	    panelBottom.add(odustanak);
	    
	    this.add(panelBottom, BorderLayout.SOUTH);
		
	    JPanel panelCenter = new JPanel();
	    panelCenter.setLayout(new GridBagLayout());
	    this.add(panelCenter, BorderLayout.CENTER);
	    
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
	    
	    //Adresa adresa_kancelarije, String broj_licne_karte, String zvanje, int godine_staza
	    
	    GridBagConstraints gbcLblIme = new GridBagConstraints();
	    gbcLblIme.gridx = 0;
	    gbcLblIme.gridy = 0;
	    gbcLblIme.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblIme, gbcLblIme);


	    GridBagConstraints gbcLblPrezime = new GridBagConstraints();
	    gbcLblPrezime.gridx = 0;
	    gbcLblPrezime.gridy = 1;
	    gbcLblPrezime.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblPrezime, gbcLblPrezime);


	    GridBagConstraints gbcLbDatumRodjennja = new GridBagConstraints();
	    gbcLbDatumRodjennja.gridx = 0;
	    gbcLbDatumRodjennja.gridy = 2;
	    gbcLbDatumRodjennja.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblDatumRodjenja, gbcLbDatumRodjennja);


	    GridBagConstraints gbcLbAdresa = new GridBagConstraints();
	    gbcLbAdresa.gridx = 0;
	    gbcLbAdresa.gridy = 3;
	    gbcLbAdresa.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblAdresa, gbcLbAdresa);


	    GridBagConstraints gbcLbTelefon = new GridBagConstraints();
	    gbcLbTelefon.gridx = 0;
	    gbcLbTelefon.gridy = 4;
	    gbcLbTelefon.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblTelefon, gbcLbTelefon);
	    
	    GridBagConstraints gbcLblEmailAdresa = new GridBagConstraints();
	    gbcLblEmailAdresa.gridx = 0;
	    gbcLblEmailAdresa.gridy = 5;
	    gbcLblEmailAdresa.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblEmailAdresa, gbcLblEmailAdresa);
	    
	    GridBagConstraints gbcLblAdresaKancelarije = new GridBagConstraints();
	    gbcLblAdresaKancelarije.gridx = 0;
	    gbcLblAdresaKancelarije.gridy = 6;
	    gbcLblAdresaKancelarije.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblAdresaKancelarije, gbcLblAdresaKancelarije);
	    
	    GridBagConstraints gbcLblBrLicneKarte = new GridBagConstraints();
	    gbcLblBrLicneKarte.gridx = 0;
	    gbcLblBrLicneKarte.gridy = 7;
	    gbcLblBrLicneKarte.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblBrLicneKarte, gbcLblBrLicneKarte);
	    
	    GridBagConstraints gbcLblZvanje = new GridBagConstraints();
	    gbcLblZvanje.gridx = 0;
	    gbcLblZvanje.gridy = 8;
	    gbcLblZvanje.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblZvanje, gbcLblZvanje);
	    
	    GridBagConstraints gbcLblGodineStaza = new GridBagConstraints();
	    gbcLblGodineStaza.gridx = 0;
	    gbcLblGodineStaza.gridy = 9;
	    gbcLblGodineStaza.insets = new Insets(20, 40, 0,0);
	    panelCenter.add(lblGodineStaza, gbcLblGodineStaza);
	    
	    
	    
	    
	    GridBagConstraints gbcTxtIme = new GridBagConstraints();
	    gbcTxtIme .gridx = 1;
	    gbcTxtIme .gridy = 0;
	    gbcTxtIme .weightx = 100;
	    gbcTxtIme .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtIme .insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtIme, gbcTxtIme );

	    GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
	    gbcTxtPrezime .gridx = 1;
	    gbcTxtPrezime .gridy = 1;
	    gbcTxtPrezime .weightx = 100;
	    gbcTxtPrezime .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtPrezime .insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtPrezime, gbcTxtPrezime );

	    GridBagConstraints gbcTxtDatum = new GridBagConstraints();
	    gbcTxtDatum .gridx = 1;
	    gbcTxtDatum .gridy = 2;
	    gbcTxtDatum .weightx = 100;
	    gbcTxtDatum.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtDatum.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtDatumRodjenja, gbcTxtDatum );
	    
	    GridBagConstraints gbcTxtAdresa = new GridBagConstraints();
	    gbcTxtAdresa .gridx = 1;
	    gbcTxtAdresa .gridy = 3;
	    gbcTxtAdresa .weightx = 100;
	    gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtAdresa.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtAdresa, gbcTxtAdresa );
	    
	    GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
	    gbcTxtTelefon .gridx = 1;
	    gbcTxtTelefon .gridy = 4;
	    gbcTxtTelefon .weightx = 100;
	    gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtTelefon.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtTelefon, gbcTxtTelefon );
	    
	    GridBagConstraints gbcTxtEmailAdresa = new GridBagConstraints();
	    gbcTxtEmailAdresa .gridx = 1;
	    gbcTxtEmailAdresa .gridy = 5;
	    gbcTxtEmailAdresa .weightx = 100;
	    gbcTxtEmailAdresa .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtEmailAdresa .insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtEmailAdresa, gbcTxtEmailAdresa );
	    
	    GridBagConstraints gbcTxtAdresaKancelarije = new GridBagConstraints();
	    gbcTxtAdresaKancelarije .gridx = 1;
	    gbcTxtAdresaKancelarije .gridy = 6;
	    gbcTxtAdresaKancelarije .weightx = 100;
	    gbcTxtAdresaKancelarije.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtAdresaKancelarije.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtAdresaKancelarije, gbcTxtAdresaKancelarije );
	    
	    GridBagConstraints gbcTxtBrLicneKarte = new GridBagConstraints();
	    gbcTxtBrLicneKarte .gridx = 1;
	    gbcTxtBrLicneKarte .gridy = 7;
	    gbcTxtBrLicneKarte .weightx = 100;
	    gbcTxtBrLicneKarte.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtBrLicneKarte.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtBrLicneKarte, gbcTxtBrLicneKarte );
	    
	    GridBagConstraints gbcTxtZvanje = new GridBagConstraints();
	    gbcTxtZvanje .gridx = 1;
	    gbcTxtZvanje .gridy = 8;
	    gbcTxtZvanje .weightx = 100;
	    gbcTxtZvanje.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtZvanje.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtZvanje, gbcTxtZvanje );
	    
	    GridBagConstraints gbcTxtGodineStaza = new GridBagConstraints();
	    gbcTxtGodineStaza .gridx = 1;
	    gbcTxtGodineStaza .gridy = 9;
	    gbcTxtGodineStaza .weightx = 100;
	    gbcTxtGodineStaza.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtGodineStaza.insets = new Insets(20, 120, 0, 70);
	    panelCenter.add(txtGodineStaza, gbcTxtGodineStaza);
	}
	
}
