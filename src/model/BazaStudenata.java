package model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gui.MainFrame;
import gui.MenuBar;

public class BazaStudenata{

	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance() {
		if(instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	public List<Student> studenti;
	public List<String> kolone;
	
	public BazaStudenata() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
		
		initStudenti();
	}
	
	private void initStudenti() {
		this.studenti = new ArrayList<Student>();
		
		/*@SuppressWarnings("deprecation")
		Date datum = new Date(2000, 03, 16);
		Adresa adresa = new Adresa("Otona Zupancica", "9", "Novi Sad", "Srbija");
		Status_Studenta status = Status_Studenta.B;
		Student s = new Student("Tatjana", "Gemovic", datum, adresa, "0691519911", "gemovictatjana@gmail.com", "RA105/2019", 2019, 3, status);
		studenti.add(s);
		Date datum2 = new Date(2000, 05, 27);
		Adresa adresa2 = new Adresa("Rumenacki put", "1", "Novi Sad", "Srbija");
		Status_Studenta status2 = Status_Studenta.S;
		Student filip = new Student("Filip", "Stefanov", datum2, adresa2, "0652388403", "stefanovfilip@gmail.com", "RA102/2019", 2019, 1, status);
		studenti.add(filip);
		filip = new Student("Filip", "Stefanov", datum2, adresa2, "0652388403", "stefanovfilip@gmail.com", "RA108/2019", 2019, 2, status);
		studenti.add(filip);
		Profesor p = new Profesor("Milan", "Rapaic", datum, adresa2, "0693792839", "rapaicmilan@gmail.com", adresa2, "00081525", "Doktor", 15);
		Predmet pred = new Predmet("E2 105", "Analiza1", 9, Semestar.letnji, 1, p);
		Vrednost_Ocene vred = Vrednost_Ocene.devet;
		studenti.get(1).getPolozeni_ispiti().add(new OcenaNaIspitu(filip, pred, vred, datum));
		pred = new Predmet("E2 101", "MISS", 10, Semestar.letnji, 1, p);
		vred = Vrednost_Ocene.deset;
		studenti.get(1).getPolozeni_ispiti().add(new OcenaNaIspitu(filip, pred, vred, datum2));
		vred = Vrednost_Ocene.pet;
		pred = new Predmet("E2 100", "SPPuRV", 5, Semestar.zimski, 1, p);
		studenti.get(1).getNepolozeni_ispiti().add(new OcenaNaIspitu(filip, pred, vred, datum));*/
		
		//https://rollbar.com/blog/java-exceptions-hierarchy-explained/
		//Zasto Exception umesto IOException, FileNotFound i ClassNotFoundException
		ObjectInputStream inStudenti = null;
		try {
			inStudenti = new ObjectInputStream(new BufferedInputStream(new FileInputStream(MenuBar.fileStudenti)));
			ArrayList<Student> listaStudenata = (ArrayList<Student>) inStudenti.readObject();
			for(Student student : listaStudenata) {
				studenti.add(student);
			}	
		} catch (Exception e) {
			e.printStackTrace();
	    } finally {
	            try {
	            	inStudenti.close();
	            } catch (Exception e) {
	    			e.printStackTrace();
	            }
	    }
		
		
	}

	public int getColumnCount() {
		 return 6;
	}

	public int getRowCount() {
		return 40;
	}
	
	public List<Student> getStudenti() {
		return studenti;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		if(row < studenti.size()) {
			Student student = this.studenti.get(row);
			switch (column) {	
				case 0:
					return student.getBroj_indeksa();
				case 1:
					return student.getIme();
				case 2:
					return student.getPrezime();
				case 3:
					return Integer.toString(student.getTrenutna_god());
				case 4:
					return student.getStatus().toString();
				case 5:
					return Double.toString(student.getProsecna_ocena());
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
			case 5:
				return "";
			default:
				return null;
		}
		}
	}
	
	public void dodajStudenta(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			String broj_indeksa, int god_upisa, int trenutna_god, Status_Studenta status) {
		
		this.studenti.add(new Student(ime,prezime,datum_rodjenja,adresa,kontakt_tel,email,broj_indeksa,god_upisa,trenutna_god,status));
	}
	
	public void izmeniStudenta(Student student, String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			String broj_indeksa, int god_upisa, int trenutna_god, Status_Studenta status) {
		for(Student i : studenti) {
			if(i==student) {
				int index_list = studenti.indexOf(i);
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatum_rodjenja(datum_rodjenja);
				i.setAdresa(adresa);
				i.setKontakt_tel(kontakt_tel);
				i.setEmail(email);
				i.setBroj_indeksa(broj_indeksa);
				i.setGod_upisa(god_upisa);
				i.setTrenutna_god(trenutna_god);
				i.setStatus(status);
				studenti.set(index_list, i);
				break;
			}
		}
	}
	
	public void izbrisiStudenta(String naziv) {
		for (Student i : studenti) {
			if (i.getBroj_indeksa().equals(naziv)) {
				studenti.remove(i);
					break;
			}
		}
	}
	
	public void initKolone() {
		this.kolone = new ArrayList<String>();
		
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("index"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("ime"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("prezime"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("god_stud"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("status"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("prosek"));
	}
	
}