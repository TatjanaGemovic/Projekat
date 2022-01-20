package controller;

import java.util.Date;

import gui.MainFrame;
import gui.PolozeniIspitiJTable;
import gui.StudentiJTable;
import model.Adresa;
import model.BazaStudenata;
import model.OcenaNaIspitu;
import model.Predmet;
import model.Status_Studenta;
import model.Student;
import model.Vrednost_Ocene;


public class StudentKontroler {

	private static StudentKontroler instance = null;
	
	public static StudentKontroler getInstance() {
		if (instance == null) {
			instance = new StudentKontroler();
		}
		return instance;
	}
	
	public void dodajStudenta(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			String broj_indeksa, int god_upisa, int trenutna_god, Status_Studenta status) {
		
		BazaStudenata.getInstance().dodajStudenta(ime,prezime,datum_rodjenja,adresa,kontakt_tel,email,broj_indeksa,god_upisa,trenutna_god,status);
		StudentiJTable.azurirajPrikaz();		
	}
	public void izmeniStudenta(int rowSelectedIndex, String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			String broj_indeksa, int god_upisa, int trenutna_god, Status_Studenta status) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Student s = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izmeniStudenta(s, ime, prezime, datum_rodjenja, adresa, kontakt_tel, email, broj_indeksa, god_upisa, trenutna_god,  status);
		StudentiJTable.azurirajPrikaz();
	}
	
	public void izbrisiStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Student s = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izbrisiStudenta(s.getBroj_indeksa());
		StudentiJTable.azurirajPrikaz();

		}

	public void dodajNepolozeniIspit(int rowSelectedIndex, Predmet predmetKojiSeDodaje, Vrednost_Ocene pet) {
		Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
		OcenaNaIspitu noviNepolozeni = new OcenaNaIspitu(s, predmetKojiSeDodaje, Vrednost_Ocene.pet, null);
		s.getNepolozeni_ispiti().add(noviNepolozeni);
	}

	public void dodajPolozeniIspit(Student s, OcenaNaIspitu o1) {
		s.getPolozeni_ispiti().add(o1);
		PolozeniIspitiJTable.azurirajPrikaz();
	}
	
	
	
}
