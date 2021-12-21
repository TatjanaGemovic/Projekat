package model;

import java.util.Date;

public class Osoba {
	
	protected String ime;
	protected String prezime;
	protected Date datum_rodjenja;
	protected Adresa adresa;
	protected String kontakt_tel;
	protected String email;
	
	public Osoba(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresa = adresa;
		this.kontakt_tel = kontakt_tel;
		this.email = email;
	}

	public Osoba() {
		super();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getImeIPrezime() {
		return ime+" "+prezime;
	}

	public Date getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(Date datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public String getKontakt_tel() {
		return kontakt_tel;
	}

	public void setKontakt_tel(String kontakt_tel) {
		this.kontakt_tel = kontakt_tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
