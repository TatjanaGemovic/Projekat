package model;

import java.util.ArrayList;
import java.util.List;

import gui.StudentiJTable;

public class BazaNepolozenihPredmeta {

	
	private static BazaNepolozenihPredmeta instance = null;
	
	public static BazaNepolozenihPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaNepolozenihPredmeta();
		}
		return instance;
	}
	
	public List<Predmet> nepolozeni_predmeti;
	public List<String> kolone;
	
	public BazaNepolozenihPredmeta() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		
	}


	public int getColumnCount() {
		 return 5;
	}

	public int getRowCount() {
		return 40;
	}
	
	public List<Predmet> getNepolozeniPredmeti() {
		return nepolozeni_predmeti;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.nepolozeni_predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		nepolozeni_predmeti = new ArrayList<Predmet>();
		Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
		ArrayList<OcenaNaIspitu> prom = s.getNepolozeni_ispiti();
		for(OcenaNaIspitu o : prom) {
			if(o.getVrednost_ocene()==Vrednost_Ocene.pet) {
					nepolozeni_predmeti.add(o.getPredmet());
			}
		}
		if(row < nepolozeni_predmeti.size()) {
			
			Predmet predmet = this.nepolozeni_predmeti.get(row);
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
		} else {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			case 3:
				return "";
			case 4:
				return "";
			default:
				return null;
		}
		}
	}
}
