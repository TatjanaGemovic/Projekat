package controller;

import java.util.Date;

import gui.MainFrame;
import model.Adresa;
import model.BazaStudenata;
import model.Status_Studenta;


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
		//MainFrame.getInstance().azurirajPrikaz();		
	}
	
}
