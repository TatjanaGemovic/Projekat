package model;

public class Osoba {
	
	protected String ime;
	protected String prezime;
	protected String datum_rodjenja;
	protected Adresa adresa;
	protected String kontakt_tel;
	protected String email;
	
	public Osoba(String ime, String prezime, String datum_rodjenja, Adresa adresa, String kontakt_tel, String email) {
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
}
