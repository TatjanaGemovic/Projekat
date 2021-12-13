package gui;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class MyApp {

	public static void main(String[] args) {

		BazaStudenata.getInstance();
		BazaProfesora.getInstance();
		BazaPredmeta.getInstance();
		MainFrame.getInstance();
	}
}
