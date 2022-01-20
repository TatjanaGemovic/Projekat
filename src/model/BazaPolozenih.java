package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;
import gui.StudentiJTable;

public class BazaPolozenih {
	private static BazaPolozenih instance = null;
	
	public static BazaPolozenih getInstance() {
		if(instance==null) {
			instance = new BazaPolozenih();
		}
		return instance;
	}
	
	private List<OcenaNaIspitu> polozeniIspiti;
	public List<String> kolone;
	
	public BazaPolozenih() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
	}
	
	public int getColumnCount() {
		 return 5;
	}

	public int getRowCount() {
		return 40;
	}
	
	public List<OcenaNaIspitu> getPolozeni() {
		return this.polozeniIspiti;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public OcenaNaIspitu getRow(int rowIndex) {
		return this.polozeniIspiti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
		this.polozeniIspiti = s.getPolozeni_ispiti();
		if(row < polozeniIspiti.size()) {
			OcenaNaIspitu ocena = this.polozeniIspiti.get(row);
			switch (column) {
			case 0:
				return ocena.getPredmet().getSifra_predmeta();
			case 1:
				return ocena.getPredmet().getNaziv();
			case 2:
				return Integer.toString(ocena.getPredmet().getEspb());
			case 3:
				switch(ocena.getVrednost_ocene()) {
				case sest: 
					return "6";
				case sedam: 
					return "7";
				case osam: 
					return "8";
				case devet: 
					return "9";	
				case deset: 
					return "10";
				default:
					return "6";
				}
			case 4: 
				DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");  
				String strDate = dateFormat.format(ocena.getDatum_polaganja());  
				return strDate;
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
	public void initKolone() {
		this.kolone = new ArrayList<String>();
		
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("sifra2"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("naziv2"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("espb2"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("ocena"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("datum"));
	}
}
