package controller;

import model.BazaPredmeta;
import model.Profesor;
import model.Semestar;

public class PredmetKontroler {

	private static PredmetKontroler instance = null;
	
	public static PredmetKontroler getInstance() {
		if (instance == null) {
			instance = new PredmetKontroler();
		}
		return instance;
	}
	
	public void dodajPredmet(String sifra_predmeta, String naziv, Semestar semestar, int godina_izvodjenja, Profesor profesor, int espb) {
		
		BazaPredmeta.getInstance().dodajPredmet(sifra_predmeta,naziv,semestar,godina_izvodjenja,profesor,espb);
		//MainFrame.getInstance().azurirajPrikaz();		
	}
	
}
