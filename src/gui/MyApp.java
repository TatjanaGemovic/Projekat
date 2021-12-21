package gui;

import controller.PredmetKontroler;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class MyApp {

	public static void main(String[] args) {
		BazaStudenata.getInstance();
		BazaProfesora.getInstance();
		BazaPredmeta.getInstance();
		PredmetKontroler.getInstance();
		MainFrame.getInstance();
	}
}
