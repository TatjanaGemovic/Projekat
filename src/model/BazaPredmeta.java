package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BazaPredmeta extends AbstractTableModel{

	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	public List<String> kolone;
	
	public BazaPredmeta() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj ESPB bodova");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");
		
		initPredmeti();
	}
	
	private void initPredmeti() {
		this.predmeti = new ArrayList<Predmet>();
	}
	
	
	@Override
	public int getColumnCount() {
		 return 5;
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}
	
	private List<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	@Override
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
			case 0:
				return predmet.getSifra_predmeta();
			case 1:
				return predmet.getNaziv();
			case 2:
				return Integer.toString(predmet.getEspb());
			case 3:
				return Integer.toString(predmet.getGodina_izvodjenja());
			case 4:
				return predmet.getSemestar().toString();
			default:
				return null;
		}
	}
	
	public void dodajPredmet(String sifra_predmeta, String naziv, Semestar semestar, int godina_izvodjenja, Profesor profesor, int espb) {
			this.predmeti.add(new Predmet(sifra_predmeta,naziv,semestar,godina_izvodjenja,profesor,espb));
	}

}