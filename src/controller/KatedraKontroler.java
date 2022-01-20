package controller;

import gui.KatedreJTable;
import model.BazaKatedri;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Katedra;
import model.Profesor;


public class KatedraKontroler {
	private static KatedraKontroler instance = null;
	
	public static KatedraKontroler getInstance() {
		if (instance == null) {
			instance = new KatedraKontroler();
		}
		return instance;
	}
	
	public void dodajKatedru(String sifra, String naziv) {
		BazaKatedri.getInstance().dodajKatedru(sifra, naziv);
		KatedreJTable.azurirajPrikaz();	
	}
	
	public void dodajSefaKatedre(int i, Profesor sef, Katedra k, int index_katedre) {
		sef.setId_katedre(k.getId());
		BazaProfesora.getInstance().getProfesori().set(i, sef);
		k.setSef_katedre(sef);
		BazaKatedri.getInstance().getKatedre().set(index_katedre, k);
	}
	
	public void dodajProfesoraNaKatedru(int i, Profesor prof, Katedra k, int index_katedre) {
		prof.setId_katedre(k.getId());
		k.dodaj_Profesora_na_katedru(prof);
		BazaProfesora.getInstance().getProfesori().set(i, prof);
		BazaKatedri.getInstance().getKatedre().set(index_katedre, k);
	}
}
