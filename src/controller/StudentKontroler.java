package controller;

import java.util.Date;

import gui.MainFrame;
import gui.StudentiJTable;
import model.Adresa;
import model.BazaStudenata;
import model.Status_Studenta;
import model.Student;


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
	
}
