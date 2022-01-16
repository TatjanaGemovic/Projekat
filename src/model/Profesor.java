package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Profesor extends Osoba implements Serializable{

	private static final long serialVersionUID = 7282588916183751402L;
	private Adresa adresa_kancelarije;
	private String broj_licne_karte;
	private String zvanje;
	private int godine_staza;
	private int id_katedre;
	
	private ArrayList<Predmet> profesor_na_predmetu = new ArrayList<Predmet>();
	
	public Profesor(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			Adresa adresa_kancelarije, String broj_licne_karte, String zvanje, int godine_staza) {
		super(ime, prezime, datum_rodjenja, adresa, kontakt_tel, email);
		this.adresa_kancelarije = adresa_kancelarije;
		this.broj_licne_karte = broj_licne_karte;
		this.zvanje = zvanje;
		this.godine_staza = godine_staza;
	}
	
	public Profesor(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel,
			String email) {
		super(ime, prezime, datum_rodjenja, adresa, kontakt_tel, email);
	}
	
	public Profesor() {
		super();
	}

	public int getId_katedre() {
		return id_katedre;
	}

	public void setId_katedre(int id_katedre) {
		this.id_katedre = id_katedre;
	}

	public Adresa getAdresa_kancelarije() {
		return adresa_kancelarije;
	}

	public void setAdresa_kancelarije(Adresa adresa_kancelarije) {
		this.adresa_kancelarije = adresa_kancelarije;
	}

	public String getBroj_licne_karte() {
		return broj_licne_karte;
	}

	public void setBroj_licne_karte(String broj_licne_karte) {
		this.broj_licne_karte = broj_licne_karte;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public int getGodine_staza() {
		return godine_staza;
	}

	public void setGodine_staza(int godine_staza) {
		this.godine_staza = godine_staza;
	}

	public ArrayList<Predmet> getProfesor_na_predmetu() {
		return profesor_na_predmetu;
	}

	public void setProfesor_na_predmetu(ArrayList<Predmet> profesor_na_predmetu) {
		this.profesor_na_predmetu = profesor_na_predmetu;
	}

	@Override
	public String toString() {
		return "Profesor => adresa kancelarije:" + adresa_kancelarije + " || broj licne_karte:" + broj_licne_karte
				+ " || zvanje:" + zvanje + " || godine staza:" + godine_staza + " || profesor na predmetu:"
				+ profesor_na_predmetu + " || ime:" + ime + " || prezime:" + prezime + " || datum rodjenja:" + datum_rodjenja
				+ " || adresa:" + adresa + " || kontakt tel:" + kontakt_tel + " || email:" + email;
	}
	
	
}
