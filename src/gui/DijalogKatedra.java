package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		
		JButton dodajSefa = new JButton("Dodaj šefa");
		JButton dodajProfesora = new JButton("Dodaj profesora");
		JButton odustani = new JButton("Odustanak");
		JPanel panelZaDugme = new JPanel();
		panelZaDugme.add(dodajSefa);
		panelZaDugme.add(dodajProfesora);
		panelZaDugme.add(odustani);
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
				DijalogDodavanjaSefaKatedri dijalogDodavanja = new DijalogDodavanjaSefaKatedri(parent, "Dodavanje šefa", modal, BazaKatedri.getInstance().getKatedre().indexOf(katedra));
				
				
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
		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		this.setVisible(true);
	}
}

class DijalogDodavanjaSefaKatedri extends JDialog {
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
				String ime_prezime = BazaProfesora.getInstance().getValueAt3(PotencijalniSefoviJTable.rowSelectedIndex, 0);
				
				int i = 0;
				for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
					if(ime_prezime.contains(p.getIme()) && ime_prezime.contains(p.getPrezime())) {
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
		ProfesoriNaPredmetuJTable profesoriTable = new ProfesoriNaPredmetuJTable();
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

