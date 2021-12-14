package controller;

import java.util.Date;
import model.Adresa;
import model.BazaProfesora;

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
		//MainFrame.getInstance().azurirajPrikaz();		
	}
	
}
