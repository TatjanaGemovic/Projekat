package model;

import java.util.ArrayList;

public class Predmet {
	
	private String sifra_predmeta;
	private String naziv;
	private String semestar;
	private String godina_izvodjenja;
	private Profesor predmetni_profesor;
	private int espb;
	private ArrayList<Student> polozili = new ArrayList<Student>();
	private ArrayList<Student> nisu_polozili = new ArrayList<Student>();
	
	public Predmet(String sifra_predmeta, String naziv, String semestar, String godina_izvodjenja, Profesor profesor, int espb) {
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina_izvodjenja = godina_izvodjenja;
		this.predmetni_profesor = profesor;
		this.espb = espb;
	}

	public Predmet() {
		super();
	}
}
