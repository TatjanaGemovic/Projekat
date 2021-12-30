package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		
		initPolozeni();
	}

	private void initPolozeni() {
		/*private Student student_polozio;
		private Predmet predmet;
		private Vrednost_Ocene vrednost_ocene; 
		private Date datum_polaganja;*/
		this.polozeniIspiti = new ArrayList<OcenaNaIspitu>();
		Student s = BazaStudenata.getInstance().getRow(0);
		Predmet p = BazaPredmeta.getInstance().getRow(0);
		Vrednost_Ocene vocene = Vrednost_Ocene.devet;
		Date datum_polaganja = new Date(2020, 7, 23);
		OcenaNaIspitu ocena = new OcenaNaIspitu(s, p, vocene, datum_polaganja);
		this.polozeniIspiti.add(ocena);
		p = BazaPredmeta.getInstance().getRow(2);
		vocene = Vrednost_Ocene.deset;
		ocena = new OcenaNaIspitu(s, p, vocene, datum_polaganja);
		this.polozeniIspiti.add(ocena);
	}
	
	public int getColumnCount() {
		 return 5;
	}

	public int getRowCount() {
		return 20;
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
}
