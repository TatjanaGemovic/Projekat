package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DijalogDodavanjaEntiteta extends JDialog {

	public DijalogDodavanjaEntiteta(Frame parent, String title, boolean modal) {
		super(parent, "Dodavanje Studenta", modal);
		
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
	    gbcLblIme.gridx = 0;
	    gbcLblIme.gridy = 0;
	    gbcLblIme.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblIme, gbcLblIme);


	    GridBagConstraints gbcLblPrezime = new GridBagConstraints();
	    gbcLblPrezime.gridx = 0;
	    gbcLblPrezime.gridy = 1;
	    gbcLblPrezime.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblPrezime, gbcLblPrezime);


	    GridBagConstraints gbcLbDatumRodjennja = new GridBagConstraints();
	    gbcLbDatumRodjennja.gridx = 0;
	    gbcLbDatumRodjennja.gridy = 2;
	    gbcLbDatumRodjennja.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblDatumRodjenja, gbcLbDatumRodjennja);


	    GridBagConstraints gbcLbAdresa = new GridBagConstraints();
	    gbcLbAdresa.gridx = 0;
	    gbcLbAdresa.gridy = 3;
	    gbcLbAdresa.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblAdresa, gbcLbAdresa);


	    GridBagConstraints gbcLbTelefon = new GridBagConstraints();
	    gbcLbTelefon.gridx = 0;
	    gbcLbTelefon.gridy = 4;
	    gbcLbTelefon.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblTelefon, gbcLbTelefon);
	    
	    GridBagConstraints gbcLblEmailAdresa = new GridBagConstraints();
	    gbcLblEmailAdresa.gridx = 0;
	    gbcLblEmailAdresa.gridy = 6;
	    gbcLblEmailAdresa.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblEmailAdresa, gbcLblEmailAdresa);

	    GridBagConstraints gbcLbBrojIndeksa = new GridBagConstraints();
	    gbcLbBrojIndeksa.gridx = 0;
	    gbcLbBrojIndeksa.gridy = 5;
	    gbcLbBrojIndeksa.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblBrojIndeksa, gbcLbBrojIndeksa);
	    
	    GridBagConstraints gbcLblGodinaUpisa = new GridBagConstraints();
	    gbcLblGodinaUpisa.gridx = 0;
	    gbcLblGodinaUpisa.gridy = 7;
	    gbcLblGodinaUpisa.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblGodinaUpisa, gbcLblGodinaUpisa);
	    
	    GridBagConstraints gbcLbTrenutnaGodinaStudija = new GridBagConstraints();
	    gbcLbTrenutnaGodinaStudija.gridx = 0;
	    gbcLbTrenutnaGodinaStudija.gridy = 9;
	    gbcLbTrenutnaGodinaStudija.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblTrenutnaGodinaStudija, gbcLbTrenutnaGodinaStudija);
	    
	    GridBagConstraints gbcLbNacinFinansiranja = new GridBagConstraints();
	    gbcLbNacinFinansiranja.gridx = 0;
	    gbcLbNacinFinansiranja.gridy = 10;
	    gbcLbNacinFinansiranja.insets = new Insets(20, 0, 0,0);
	    panelCenter.add(lblNacinFinansiranja, gbcLbNacinFinansiranja);


	    GridBagConstraints gbcTxtIme = new GridBagConstraints();
	    gbcTxtIme .gridx = 1;
	    gbcTxtIme .gridy = 0;
	    gbcTxtIme .weightx = 100;
	    gbcTxtIme .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtIme .insets = new Insets(20, 20, 0, 20);
	    panelCenter.add(txtIme, gbcTxtIme );


	    GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
	    gbcTxtPrezime .gridx = 1;
	    gbcTxtPrezime .gridy = 1;
	    gbcTxtPrezime .weightx = 100;
	    gbcTxtPrezime .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtPrezime .insets = new Insets(20, 20, 0, 20);
	    panelCenter.add(txtPrezime, gbcTxtPrezime );


	    GridBagConstraints gbcTxtDatum = new GridBagConstraints();
	    gbcTxtDatum .gridx = 1;
	    gbcTxtDatum .gridy = 2;
	    gbcTxtDatum .weightx = 100;
	    gbcTxtDatum.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtDatum.insets = new Insets(20, 20, 0, 20);
	    panelCenter.add(txtDatumRodjenja, gbcTxtDatum );
	    
	    GridBagConstraints gbcTxtAdresa = new GridBagConstraints();
	    gbcTxtAdresa .gridx = 1;
	    gbcTxtAdresa .gridy = 3;
	    gbcTxtAdresa .weightx = 100;
	    gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtAdresa.insets = new Insets(20, 20, 0, 20);
	    panelCenter.add(txtAdresa, gbcTxtAdresa );
	    
	    GridBagConstraints gbcTxtEmailAdresa = new GridBagConstraints();
	    gbcTxtEmailAdresa .gridx = 1;
	    gbcTxtEmailAdresa .gridy = 6;
	    gbcTxtEmailAdresa .weightx = 100;
	    gbcTxtEmailAdresa .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtEmailAdresa .insets = new Insets(20, 20, 0, 20);
	    panelCenter.add(txtEmailAdresa, gbcTxtEmailAdresa );
	    
	    GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
	    gbcTxtTelefon .gridx = 1;
	    gbcTxtTelefon .gridy = 4;
	    gbcTxtTelefon .weightx = 100;
	    gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtTelefon.insets = new Insets(20, 20, 0, 20);
	    panelCenter.add(txtTelefon, gbcTxtTelefon );
	    
	    GridBagConstraints gbcTxtBrojIndeksa = new GridBagConstraints();
	    gbcTxtBrojIndeksa .gridx = 1;
	    gbcTxtBrojIndeksa .gridy = 5;
	    gbcTxtBrojIndeksa .weightx = 100;
	    gbcTxtBrojIndeksa.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtBrojIndeksa.insets = new Insets(20, 20, 0, 20);
	    panelCenter.add(txtBrojIndeksa, gbcTxtBrojIndeksa );
	    
	    GridBagConstraints gbcTxtGodinaUpisa = new GridBagConstraints();
	    gbcTxtGodinaUpisa .gridx = 1;
	    gbcTxtGodinaUpisa .gridy = 7;
	    gbcTxtGodinaUpisa .weightx = 100;
	    gbcTxtGodinaUpisa .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtGodinaUpisa .insets = new Insets(20, 20, 0, 20);
	    panelCenter.add(txtGodinaUpisa, gbcTxtGodinaUpisa );
	    
	    String godinaStudija[]= {"I (Prva)","II (Druga)","III (Treca)","IV (Cetvrta)"};
	    JComboBox<String> godStud=new JComboBox<>(godinaStudija);
	    
	    GridBagConstraints grd1 = new GridBagConstraints();
	    grd1.gridx = 1;
	    grd1.gridy = 9;
	    grd1.weightx = 100;
	    grd1.fill = GridBagConstraints.HORIZONTAL;
	    grd1.insets = new Insets(20, 20, 0, 20);
	    
	    panelCenter.add(godStud,grd1);
	    
	    String status[]= {"Budzet","Samofinansiranje"};
	    JComboBox<String> NacinFinansiranja=new JComboBox<>(status);
	    
	    GridBagConstraints grd2 = new GridBagConstraints();
	    grd2.gridx = 1;
	    grd2.gridy = 10;
	    grd2.weightx = 100;
	    grd2.fill = GridBagConstraints.HORIZONTAL;
	    grd2.insets = new Insets(20, 20, 0, 20);
	    
	    panelCenter.add(NacinFinansiranja,grd2);
	}
	
}
