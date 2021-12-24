package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BazaStudenata{

	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance() {
		if(instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private List<Student> studenti;
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
		
		@SuppressWarnings("deprecation")
		Date datum = new Date(2000, 16, 03);
		Adresa adresa = new Adresa("Otona Zupancica", "9", "Novi Sad", "Srbija");
		Status_Studenta status = Status_Studenta.B;
		studenti.add(new Student("Tatjana", "Gemovic", datum, adresa, "0691519911", "gemovictatjana@gmail.com", "RA105/2019", 2019, 3, status));
		@SuppressWarnings("deprecation")
		Date datum2 = new Date(2000, 25, 05);
		Adresa adresa2 = new Adresa("Rumenacki put", "1", "Novi Sad", "Srbija");
		Status_Studenta status2 = Status_Studenta.S;
		studenti.add(new Student("Filip", "Stefanov", datum2, adresa2, "0652388403", "stefanovfilip@gmail.com", "RA102/2019", 2019, 3, status));
		
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

	
}