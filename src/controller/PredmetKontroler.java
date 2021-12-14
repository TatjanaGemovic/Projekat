package controller;

import gui.MainFrame;
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
	
	public void IzbrisiPredmet(int rowSelectedIndex) {
		if(rowSelectedIndex < 0) {
				return;
		}
	    Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifra_predmeta());
		PredmetiJTable.azurirajPrikaz();
	}
	
}
