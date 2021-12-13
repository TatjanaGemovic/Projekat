package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BazaStudenata extends AbstractTableModel{

	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance() {
		if(instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private List<Student> studenti;
	public List<String> kolone;
	private long generator;
	
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
	}

	@Override
	public int getColumnCount() {
		 return 6;
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}
	
	private List<Student> getStudenti() {
		return studenti;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	@Override
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
			case 0:
				return student.getIme();
			case 1:
				return student.getPrezime();
			case 2:
				return student.getBroj_indeksa();
			case 3:
				return Integer.toString(student.getTrenutna_god());
			case 4:
				return student.getStatus().toString();
			case 5:
				return Double.toString(student.getProsecna_ocena());
			default:
				return null;
		}
	}
	
	public void dodajStudenta(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			String broj_indeksa, int god_upisa, int trenutna_god, Status_Studenta status) {
		
		this.studenti.add(new Student(ime,prezime,datum_rodjenja,adresa,kontakt_tel,email,broj_indeksa,god_upisa,trenutna_god,status));
	}
	
}