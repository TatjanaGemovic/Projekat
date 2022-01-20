package gui;

import model.BazaKatedri;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class MyApp {

	public static void main(String[] args) {
		BazaStudenata.getInstance();
		BazaProfesora.getInstance();
		BazaPredmeta.getInstance();
		BazaKatedri.getInstance();
		MainFrame.getInstance();
	}
}
