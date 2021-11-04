package model;

import java.util.ArrayList;

public class Profesor extends Osoba {
	private Adresa adresa_kancelarije;
	private String broj_licne_karte;
	private String zvanje;
	private String godine_staza;
	private ArrayList<Predmet> profesor_na_predmetu = new ArrayList<Predmet>();
	
	public Profesor(String ime, String prezime, String datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			Adresa adresa_kancelarije, String broj_licne_karte, String zvanje, String godine_staza) {
		super(ime, prezime, datum_rodjenja, adresa, kontakt_tel, email);
		this.adresa_kancelarije = adresa_kancelarije;
		this.broj_licne_karte = broj_licne_karte;
		this.zvanje = zvanje;
		this.godine_staza = godine_staza;
	}
	
	public Profesor(String ime, String prezime, String datum_rodjenja, Adresa adresa, String kontakt_tel,
			String email) {
		super(ime, prezime, datum_rodjenja, adresa, kontakt_tel, email);
	}
}
