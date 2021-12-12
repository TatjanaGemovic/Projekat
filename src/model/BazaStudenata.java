package model;

import java.util.ArrayList;
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
		generator = 0;
		
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
	public int getRowCount() {
		return BazaStudenata.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		 return BazaStudenata.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

		
	
}
