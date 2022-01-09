package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import gui.PredmetiJTable;
import gui.ProfesoriJTable;
import gui.StudentiJTable;

public class BazaPredmeta{

	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	public List<String> kolone;
	public String kolonaZaDodavanje;
	
	public BazaPredmeta() {
		 
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj ESPB bodova");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");
		
		this.kolonaZaDodavanje = "";
		
		initPredmeti();
	}
	
	private void initPredmeti() {
		this.predmeti = new ArrayList<Predmet>();
		Date datum = new Date(2000, 03, 16);
		Date datum2 = new Date(2000, 05, 27);
		Adresa adresa2 = new Adresa("Rumenacki put", "1", "Novi Sad", "Srbija");
		Profesor p1 = new Profesor("Nebojsa", "Ralevic", datum, adresa2, "0693792839", "nralevicn@gmail.com", adresa2, "00081526", "Doktor", 15);
		Predmet pred = new Predmet("E2 105", "Analiza1", Semestar.letnji, 1, p1, 9);
		this.predmeti.add(pred);
		Predmet pred1 = new Predmet("E2 103", "LPRS", Semestar.zimski, 2, p1, 5);
		this.predmeti.add(pred1);
		
		Profesor p2 = new Profesor("Milan", "Rapaic", datum, adresa2, "0693792839", "rapaicmilan@gmail.com", adresa2, "00081525", "Doktor", 15);
		Predmet pred2 = new Predmet("E2 101", "SAU", Semestar.letnji, 1, p2, 10);
		this.predmeti.add(pred2);
		Predmet pred3 = new Predmet("E2 107", "MISS", Semestar.zimski, 1, p2, 10);
		this.predmeti.add(pred3);
		Predmet pred4 = new Predmet("E2 100", "SPPuRV", Semestar.zimski, 1, p2, 5);
		this.predmeti.add(pred4);
	}
	
	
	public int getColumnCount() {
		 return 5;
	}

	public int getColumnCountZaDodavanje() {
		
		return 1;
	}
	
	public int getColumnCountProfPredaje() {
		// TODO Auto-generated method stub
		return 4;
	}
	
	public int getRowCount() {
		return 40;
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public String getColumnNameProfPredaje(int index) {
		if(index>=2)
			return this.kolone.get(index+1);
		else
			return this.kolone.get(index);
	}
	
	public String getColumnNameZaDodavanje(int index) {
		
		return this.kolonaZaDodavanje;
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		if(row < predmeti.size()) {
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
	
	public String getValueAtZaDodavanje(int row, int column) {
		List<Predmet> potencijalni = new ArrayList<Predmet>();
		Student student = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			if(student.getTrenutna_god()<p.getGodina_izvodjenja()) continue;
			int pronadjen = 0;
			for(OcenaNaIspitu polozeni : student.getPolozeni_ispiti()) {
				if(p.getNaziv() == polozeni.getPredmet().getNaziv()) {
					pronadjen++;
				}
			}
			for(OcenaNaIspitu nepolozeni : student.getNepolozeni_ispiti()) {
				if(p.getNaziv() == nepolozeni.getPredmet().getNaziv()) {
					pronadjen++;
				}
			}
			if(pronadjen==0) potencijalni.add(p);
		}
		if(row < potencijalni.size()) {
			Predmet predmet = potencijalni.get(row);
			switch (column) {
			case 0:
				return predmet.getSifra_predmeta() + " - " + predmet.getNaziv();
			default:
				return null;
			}
		} else {
			switch (column) {
			case 0: 
				return "";
			default:
				return null;
		}
		}
	}
	
	public String getValueAtProfesorPredaje(int row, int column) {
		Profesor prof = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
		List<Predmet> predmeti = new ArrayList<Predmet>();
		for(Predmet pred : BazaPredmeta.getInstance().getPredmeti()) {
			if(pred.getPredmetni_profesor().getIme()==prof.getIme() && pred.getPredmetni_profesor().getPrezime()==prof.getPrezime()) {
				System.out.printf("dodat na profesora %s\n", pred.getNaziv());
				predmeti.add(pred);
			}
		}
		if(row < predmeti.size()) {
			Predmet predmet = predmeti.get(row);
			switch (column) {
			case 0:
				return predmet.getSifra_predmeta();
			case 1:
				return predmet.getNaziv();
			case 2:
				return Integer.toString(predmet.getGodina_izvodjenja());
			case 3:
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
			default:
				return null;
		}
		}
	}
	
	public void dodajPredmet(String sifra_predmeta, String naziv, Semestar semestar, int godina_izvodjenja, Profesor profesor, int espb) {
			this.predmeti.add(new Predmet(sifra_predmeta,naziv,semestar,godina_izvodjenja,profesor,espb));
	}
	public void izmeniPredmet(Predmet p, String sifra_predmeta, String naziv, int espb, int godina, Semestar semestar, Profesor profesor) {
		for (Predmet i : predmeti) {
			if (i == p) {
				i.setSifra_predmeta(sifra_predmeta);
				int index = predmeti.indexOf(i);
				i.setNaziv(naziv);
				i.setEspb(espb);
				i.setGodina_izvodjenja(godina);
				i.setSemestar(semestar);
				i.setPredmetni_profesor(profesor);
				predmeti.set(index, i);
				break;
			}
		}
	}
	public void izbrisiPredmet(String sifra_predmeta) {
		for (Predmet i : predmeti) {
			if (i.getSifra_predmeta().equals(sifra_predmeta)) {
				predmeti.remove(i);
				break;
			}
		}
	}
}