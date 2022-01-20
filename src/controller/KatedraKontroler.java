package controller;

import gui.KatedreJTable;
import model.BazaKatedri;
import model.BazaPredmeta;


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
}
