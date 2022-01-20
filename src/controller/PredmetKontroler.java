package controller;

import gui.PredmetiJTable;
import model.BazaPredmeta;
import model.Predmet;
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
		PredmetiJTable.azurirajPrikaz();	
	}
	
	public void izmeniPredmet(int rowSelectedIndex, String sifra, String naziv, Semestar semestar, int godina_izvodjenja, Profesor profesor, int espb) {
		if(rowSelectedIndex < 0) {
			return;
		}
		Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izmeniPredmet(predmet, sifra, naziv, espb, godina_izvodjenja, semestar, profesor);
		PredmetiJTable.azurirajPrikaz();	
	}
	
	public void izbrisiPredmet(int rowSelectedIndex) {
		if(rowSelectedIndex < 0) {
				return;
		}
	    Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifra_predmeta());
		PredmetiJTable.azurirajPrikaz();
	}
	
}
