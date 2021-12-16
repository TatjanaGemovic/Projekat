package controller;

import java.util.Date;

import gui.MainFrame;
import gui.ProfesoriJTable;
import model.Adresa;
import model.BazaProfesora;
import model.Profesor;

public class ProfesorKontroler {

	private static ProfesorKontroler instance = null;
	
	public static ProfesorKontroler getInstance() {
		if (instance == null) {
			instance = new ProfesorKontroler();
		}
		return instance;
	}
	
	public void dodajStudenta(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			Adresa adresa_kancelarije, String broj_licne_karte, String zvanje, int godine_staza) {
		
		BazaProfesora.getInstance().dodajProfesora(ime,prezime,datum_rodjenja,adresa,kontakt_tel,email,adresa_kancelarije,broj_licne_karte,zvanje,godine_staza);
		ProfesoriJTable.azurirajPrikaz();
	}
	
	public void izbrisiProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().izbrisiProfesora(profesor.getBroj_licne_karte());
		ProfesoriJTable.azurirajPrikaz();
	}
	
}
