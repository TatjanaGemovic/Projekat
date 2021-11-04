package model;

import java.util.ArrayList;

enum Status_studenta {Budzet, Samofinansiranje}

public class Student extends Osoba {
	private String broj_indeksa;
	private String god_upisa;
	private String trenutna_god;
	private double prosecna_ocena;
	private Status_studenta status; 
	private ArrayList<OcenaNaIspitu> ocene = new ArrayList<OcenaNaIspitu>();
	private ArrayList<Predmet> polozeni_ispiti = new ArrayList<Predmet>();
	private ArrayList<Predmet> nepolozeni_ispiti = new ArrayList<Predmet>();
	
	public Student(String ime, String prezime, String datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			String broj_indeksa, String god_upisa, String trenutna_god, Status_studenta status) {
		super(ime, prezime, datum_rodjenja, adresa, kontakt_tel, email);
		this.broj_indeksa = broj_indeksa;
		this.god_upisa = god_upisa;
		this.trenutna_god = trenutna_god;
		this.status = status;
	}

	public Student(String ime, String prezime, String datum_rodjenja, Adresa adresa, String kontakt_tel, String email) {
		super(ime, prezime, datum_rodjenja, adresa, kontakt_tel, email);
	}
}
