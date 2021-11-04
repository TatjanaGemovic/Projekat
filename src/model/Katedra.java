package model;

import java.util.ArrayList;

public class Katedra {
	private String sifra;
	private String naziv_katedre;
	private Osoba sef_katedre;
	private ArrayList<Profesor> profesori_na_katedri = new ArrayList<Profesor>();
	
	public Katedra(String sifra, String naziv_katedre, Osoba sef_katedre) {
		super();
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

}
