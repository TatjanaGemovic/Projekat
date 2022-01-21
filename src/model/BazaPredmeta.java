package model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;
import gui.MenuBar;
import gui.ProfesoriJTable;
import gui.StudentiJTable;
import gui.TabbedPane;
import gui.TrenTab;

public class BazaPredmeta{

	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<Predmet> potencijalni;
	public List<String> kolone;
	public String kolonaZaDodavanje;
	
	public BazaPredmeta() {
		 
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj ESPB bodova");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");
		
		this.kolonaZaDodavanje = "";
		
		initPredmeti();
	}
	
	private void initPredmeti() {
		this.predmeti = new ArrayList<Predmet>();
		
		/*Semestar semestar = Semestar.zimski;
		Date datum = new Date(1970, 25, 04);
		Adresa adresa1 = new Adresa("Futoska", "9", "Novi Sad", "Srbija");
		Adresa adresa2 = new Adresa("NTP", "kabinet 3", "Novi Sad", "Srbija");
		Profesor p = new Profesor("Milan", "Rapaic", datum, adresa1, "0693792839", "rapaicmilan@gmail.com", adresa2, "00081525", "Doktor", 15);
		predmeti.add(new Predmet("E2 105", "Analiza1", 9, semestar, 1, null));
		predmeti.add(new Predmet("E2 101", "Miss", 8, semestar, 1, null));
		predmeti.add(new Predmet("E2 103", "Sau", 10, semestar, 1, p));*/
		
		ObjectInputStream inPredmeti = null;
		try {
			inPredmeti = new ObjectInputStream(new BufferedInputStream(new FileInputStream(MenuBar.filePredmeti)));
			ArrayList<Predmet> listaPredmeta = (ArrayList<Predmet>) inPredmeti.readObject();
			for(Predmet predmet : listaPredmeta) {
				predmeti.add(predmet);
			}	
		} catch (Exception e) {
			e.printStackTrace();
	    } finally {
	            try {
	            	inPredmeti.close();
	            } catch (Exception e) {
	    			e.printStackTrace();
	            }
	    }
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
		potencijalni = new ArrayList<Predmet>();
		if(TabbedPane.tabIndex==TrenTab.Student) {
			Student student = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
			for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
				if(student.getTrenutna_god()<p.getGodina_izvodjenja()) continue;
				int pronadjen = 0;
				for(OcenaNaIspitu polozeni : student.getPolozeni_ispiti()) {
					if(p.getNaziv().equals(polozeni.getPredmet().getNaziv())) {
						pronadjen++;
					}
				}
				for(OcenaNaIspitu nepolozeni : student.getNepolozeni_ispiti()) {
					if(p.getNaziv().equals(nepolozeni.getPredmet().getNaziv())) {
						pronadjen++;
					}
				}
				if(pronadjen==0) this.potencijalni.add(p);
			}
		}
		else if(TabbedPane.tabIndex==TrenTab.Profesor) {
			Profesor profesor = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
			for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
				if(p.getPredmetni_profesor()==null)
					this.potencijalni.add(p);
			}
		}
		if(row < potencijalni.size()) {
			Predmet predmet = this.potencijalni.get(row);
			Predmet p2 = null;
			for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
				if(p.getSifra_predmeta().equals(predmet.getSifra_predmeta()) || p.getNaziv().equals(predmet.getNaziv())) {
					p2 = p;
				}
			}
			switch (column) {
			case 0:
				return p2.getSifra_predmeta() + " - " + p2.getNaziv();
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
			if(pred.getPredmetni_profesor()!=null && (pred.getPredmetni_profesor().getIme().equals(prof.getIme()) || pred.getPredmetni_profesor().getPrezime().equals(prof.getPrezime()))) {
				predmeti.add(pred);
			}
		}
		if(row < predmeti.size()) {
			Predmet predmet = predmeti.get(row);
			Predmet p2 = null;
			for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
				if(p.getSifra_predmeta().equals(predmet.getSifra_predmeta()) || p.getNaziv().equals(predmet.getNaziv())) {
					p2 = p;
				}
			}
			switch (column) {
			case 0:
				return p2.getSifra_predmeta();
			case 1:
				return p2.getNaziv();
			case 2:
				return Integer.toString(p2.getGodina_izvodjenja());
			case 3:
				return p2.getSemestar().toString();
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
			this.predmeti.add(new Predmet(sifra_predmeta,naziv,espb,semestar,godina_izvodjenja,profesor));
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

	public void initKolone() {
		this.kolone = new ArrayList<String>();
		
		
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("sifra2"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("naziv2"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("espb2"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("god2"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("semester2"));
	}
}