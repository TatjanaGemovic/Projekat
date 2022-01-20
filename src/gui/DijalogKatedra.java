package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.KatedraKontroler;
import controller.PredmetKontroler;
import model.Adresa;
import model.BazaKatedri;
import model.BazaNepolozenihPredmeta;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Katedra;
import model.OcenaNaIspitu;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Student;
import model.Vrednost_Ocene;

public class DijalogKatedra extends JDialog {
	
	public DijalogKatedra(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*4/5);
		setLocationRelativeTo(parent);
		
		JButton dodajSefa = new JButton("Dodaj sefa");
		JButton dodajProfesora = new JButton("Dodaj profesora");
		JButton dodajKatedru = new JButton("Dodaj katedru");
		JPanel panelZaDugme = new JPanel();
		panelZaDugme.add(dodajKatedru);
		panelZaDugme.add(dodajSefa);
		panelZaDugme.add(dodajProfesora);
		add(panelZaDugme, BorderLayout.NORTH);
		
		KatedreJTable tabelaKatedri = new KatedreJTable();
		JScrollPane paneKatedre = new JScrollPane(tabelaKatedri);
		JPanel panelKatedre = new JPanel();
		panelKatedre.add(paneKatedre);
		add(panelKatedre, BorderLayout.CENTER);
		
		
		dodajSefa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(KatedreJTable.rowSelectedIndex>=0 && KatedreJTable.rowSelectedIndex<BazaKatedri.getInstance().getKatedre().size()) {
				String naziv_katedre = BazaKatedri.getInstance().getValueAt(KatedreJTable.rowSelectedIndex, 0);
				Katedra katedra = new Katedra();
				for(Katedra k : BazaKatedri.getInstance().getKatedre()) {
					if(naziv_katedre == k.getNaziv_katedre()) {
						katedra = k;
					}
				}
				DijalogDodavanjaSefaKatedri dijalogDodavanja = new DijalogDodavanjaSefaKatedri(parent, "Dodavanje sefa", modal, BazaKatedri.getInstance().getKatedre().indexOf(katedra));
				
				
				tabelaKatedri.azurirajPrikaz();
				}
			}
		});
		dodajProfesora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(KatedreJTable.rowSelectedIndex>=0 && KatedreJTable.rowSelectedIndex<BazaKatedri.getInstance().getKatedre().size()) {
					String naziv_katedre = BazaKatedri.getInstance().getValueAt(KatedreJTable.rowSelectedIndex, 0);
					Katedra katedra = new Katedra();
					for(Katedra k : BazaKatedri.getInstance().getKatedre()) {
						if(naziv_katedre == k.getNaziv_katedre()) {
							katedra = k;
						}
					}
					DijalogDodavanjaProfesoraKatedri dijalogDodavanja = new DijalogDodavanjaProfesoraKatedri(parent, "Dodavanje profesora", modal, BazaKatedri.getInstance().getKatedre().indexOf(katedra));
					
					
					ProfesoriJTable.azurirajPrikaz();
					}
				
			}
		});
		dodajKatedru.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DijalogDodavanjaKatedre dij = new DijalogDodavanjaKatedre(parent, "Dodavanje katedre", modal);
			}
		});
		this.setVisible(true);
	}
}

class DijalogDodavanjaKatedre extends JDialog {
	public DijalogDodavanjaKatedre(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*2/5, diaHeight*2/5);
		setLocationRelativeTo(parent);
		
		JButton dodajKatedru = new JButton("Dodaj");
		JButton odustani = new JButton("Odustani");
		JPanel panelZaDugme = new JPanel();
		panelZaDugme.add(dodajKatedru);
		panelZaDugme.add(odustani);
		add(panelZaDugme, BorderLayout.SOUTH);
		
		JPanel panelPotencijalni = new JPanel();
		panelPotencijalni.setLayout(new GridBagLayout());
		add(panelPotencijalni, BorderLayout.CENTER);
		
		JLabel lblSifra = new JLabel("Sifra katedre:");
		JLabel lblNaziv = new JLabel("Naziv katedre:");
		 
		final JTextField txtSifra = new JTextField();
		final JTextField txtNaziv = new JTextField();
		
		GridBagConstraints gbcLSifra = new GridBagConstraints();
		gbcLSifra.fill = GridBagConstraints.HORIZONTAL;
		gbcLSifra.gridx = 0;
		gbcLSifra.gridy = 0;
		gbcLSifra.insets = new Insets(20,40, 0,0);
		panelPotencijalni.add(lblSifra, gbcLSifra);
		 
		GridBagConstraints gbcLNaziv = new GridBagConstraints();
		gbcLNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcLNaziv.gridx = 0;
		gbcLNaziv.gridy = 1;
		gbcLNaziv.insets = new Insets(20,40, 0,0);
		panelPotencijalni.add(lblNaziv, gbcLNaziv);
		
		GridBagConstraints gbcTxtSifra = new GridBagConstraints();
		gbcTxtSifra .gridx = 1;
		gbcTxtSifra .gridy = 0;
		gbcTxtSifra .weightx = 100;
		gbcTxtSifra .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSifra .insets = new Insets(20,120, 0, 70);
		panelPotencijalni.add(txtSifra, gbcTxtSifra );
		
		GridBagConstraints gbcTxtNaziv = new GridBagConstraints();
		gbcTxtNaziv .gridx = 1;
		gbcTxtNaziv.gridy = 1;
		gbcTxtNaziv .weightx = 100;
		gbcTxtNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtNaziv .insets = new Insets(20, 120, 0, 70);
		panelPotencijalni.add(txtNaziv, gbcTxtNaziv );
		
		dodajKatedru.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda", dialogButton);

			    if (dialogResult == JOptionPane.YES_OPTION) {

			    	if(txtSifra.getText().isEmpty() || txtNaziv.getText().isEmpty()) {
			    		
			    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    	
			    	String sifra = txtSifra.getText();
			    	String naziv = txtNaziv.getText();
			    	
			    	KatedraKontroler.getInstance().dodajKatedru(sifra, naziv);
			    	dispose();
			    	
			    }
				
			}
			
		});
		
		this.setVisible(true);
	}
	
}

class DijalogDodavanjaSefaKatedri extends JDialog {

	private static final long serialVersionUID = -1626335475126520489L;

	public DijalogDodavanjaSefaKatedri(Frame parent, String title, boolean modal, int index_katedre) {
		super(parent, title, modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*4/5);
		setLocationRelativeTo(parent);
		
		JButton dodajSefa = new JButton("Dodaj");
		JButton odustani = new JButton("Odustani");
		JPanel panelZaDugme = new JPanel();
		panelZaDugme.add(dodajSefa);
		panelZaDugme.add(odustani);
		add(panelZaDugme, BorderLayout.NORTH);
		
		//JPanel panelzaDodavanje = new JPanel();
		PotencijalniSefoviJTable tabelaPotencijalnih = new PotencijalniSefoviJTable();
		JScrollPane panePotencijalni = new JScrollPane(tabelaPotencijalnih);
		JPanel panelPotencijalni = new JPanel();
		panelPotencijalni.add(panePotencijalni);
		add(panelPotencijalni, BorderLayout.CENTER);
		
		
		dodajSefa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(PotencijalniSefoviJTable.rowSelectedIndex>=0 && PotencijalniSefoviJTable.rowSelectedIndex<BazaProfesora.getInstance().getPotencijalni().size()) {
					String ime_prezime = BazaProfesora.getInstance().getValueAt3(PotencijalniSefoviJTable.rowSelectedIndex, 0);
					
					int i = 0;
					for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
						if(ime_prezime.contains(p.getIme()) && ime_prezime.contains(p.getPrezime())) {
						//if(ime_prezime.equals(p.getImeIPrezime())) {
							i = BazaProfesora.getInstance().getProfesori().indexOf(p);
						}
					}
					
					Profesor sef = BazaProfesora.getInstance().getProfesori().get(i);
					
					Katedra k = BazaKatedri.getInstance().getKatedre().get(index_katedre);
					sef.setId_katedre(k.getId());
					BazaProfesora.getInstance().getProfesori().set(i, sef);
					k.setSef_katedre(sef);
					BazaKatedri.getInstance().getKatedre().set(index_katedre, k);
					
					dispose();
				}
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

class DijalogDodavanjaProfesoraKatedri extends JDialog {
	public DijalogDodavanjaProfesoraKatedri(Frame parent, String title, boolean modal, int index_katedre) {
		super(parent, title, modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*4/5);
		setLocationRelativeTo(parent);
		
		JButton dodaj = new JButton("Dodaj");
		JButton odustani = new JButton("Odustani");
		JPanel panelZaDugme = new JPanel();
		panelZaDugme.add(dodaj);
		panelZaDugme.add(odustani);
		add(panelZaDugme, BorderLayout.NORTH);
		
		//JPanel panelzaDodavanje = new JPanel();
		ProfesoriNaKatedriJTable profesoriTable = new ProfesoriNaKatedriJTable();
		JScrollPane paneProfesora = new JScrollPane(profesoriTable);
		JPanel panelProfesora = new JPanel();
		panelProfesora.add(paneProfesora);
		add(panelProfesora, BorderLayout.CENTER);
		
		
		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ime_prezime = BazaProfesora.getInstance().getValueAt2(ProfesoriNaPredmetuJTable.rowSelectedIndex, 0);
				
				int i = 0;
				for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
					if(ime_prezime.contains(p.getIme()) && ime_prezime.contains(p.getPrezime())) {
						i = BazaProfesora.getInstance().getProfesori().indexOf(p);
					}
				}
				
				Profesor prof = BazaProfesora.getInstance().getProfesori().get(i);
				Katedra k = BazaKatedri.getInstance().getKatedre().get(index_katedre);
				prof.setId_katedre(k.getId());
				k.dodaj_Profesora_na_katedru(prof);
				BazaProfesora.getInstance().getProfesori().set(i, prof);
				BazaKatedri.getInstance().getKatedre().set(index_katedre, k);
				
				dispose();
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

