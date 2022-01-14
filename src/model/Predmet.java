package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Predmet implements Serializable{
	
	private static final long serialVersionUID = -992710973447456674L;
	private String sifra_predmeta;
	private String naziv;
	private Semestar semestar;
	private int godina_izvodjenja;
	private Profesor predmetni_profesor;
	private int espb;
	private ArrayList<Student> polozili = new ArrayList<Student>();
	private ArrayList<Student> nisu_polozili = new ArrayList<Student>();
	
	public Predmet(String sifra_predmeta, String naziv, int espb, Semestar semestar, int godina_izvodjenja, Profesor profesor) {
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

	public String getSifra_predmeta() {
		return sifra_predmeta;
	}

	public void setSifra_predmeta(String sifra_predmeta) {
		this.sifra_predmeta = sifra_predmeta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public int getGodina_izvodjenja() {
		return godina_izvodjenja;
	}

	public void setGodina_izvodjenja(int godina_izvodjenja) {
		this.godina_izvodjenja = godina_izvodjenja;
	}

	public Profesor getPredmetni_profesor() {
		return predmetni_profesor;
	}

	public void setPredmetni_profesor(Profesor predmetni_profesor) {
		this.predmetni_profesor = predmetni_profesor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public ArrayList<Student> getPolozili() {
		return polozili;
	}

	public void setPolozili(ArrayList<Student> polozili) {
		this.polozili = polozili;
	}

	public ArrayList<Student> getNisu_polozili() {
		return nisu_polozili;
	}

	public void setNisu_polozili(ArrayList<Student> nisu_polozili) {
		this.nisu_polozili = nisu_polozili;
	}

	@Override
	public String toString() {
		return "Predmet => sifra predmeta:" + sifra_predmeta + " || naziv:" + naziv + " || semestar:" + semestar
				+ " || godina izvodjenja:" + godina_izvodjenja + " || predmetni profesor:" + predmetni_profesor + " || espb:"
				+ espb + " || polozili:" + polozili + " || nisu polozili:" + nisu_polozili;
	}
	
	
}
