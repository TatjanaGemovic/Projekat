package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Katedra implements Serializable{

	private static final long serialVersionUID = 7920837647787869436L;

	private int id;
	private String sifra;
	private String naziv_katedre;
	private Profesor sef_katedre;
	private ArrayList<Profesor> profesori_na_katedri = new ArrayList<Profesor>();
	
	public Katedra(int id, String sifra, String naziv_katedre, Profesor sef_katedre) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.naziv_katedre = naziv_katedre;
		this.sef_katedre = sef_katedre;
	}

	public Katedra() {
		super();
	}
	
	public void dodaj_Profesora_na_katedru(Profesor p) {
		for(int i = 0; i< profesori_na_katedri.size(); i++) {
			if(profesori_na_katedri.get(i) == p) {
				return;
			}
		}
		profesori_na_katedri.add(p);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv_katedre() {
		return naziv_katedre;
	}

	public void setNaziv_katedre(String naziv_katedre) {
		this.naziv_katedre = naziv_katedre;
	}

	public Profesor getSef_katedre() {
		return sef_katedre;
	}

	public void setSef_katedre(Profesor sef_katedre) {
		this.sef_katedre = sef_katedre;
	}

	public ArrayList<Profesor> getProfesori_na_katedri() {
		return profesori_na_katedri;
	}

	public void setProfesori_na_katedri(ArrayList<Profesor> profesori_na_katedri) {
		this.profesori_na_katedri = profesori_na_katedri;
	}

	@Override
	public String toString() {
		return "Katedra => sifra:" + sifra + " || naziv katedre:" + naziv_katedre + " || sef katedre:" + sef_katedre
				+ " || profesori na katedri:" + profesori_na_katedri;
	}
	
}

