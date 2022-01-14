package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BazaKatedri{

	private static BazaKatedri instance = null;
	
	public static BazaKatedri  getInstance() {
		if(instance == null) {
			instance = new BazaKatedri();
		}
		return instance;
	}
	
	public List<Katedra> katedre;
	public List<String> kolone;
	
	public BazaKatedri() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Naziv katedre");
		this.kolone.add("Šef katedre");
		
		initKatedre();
	}
	
	private void initKatedre() {
		this.katedre = new ArrayList<Katedra>();
		Katedra k = new Katedra("k1", "Automatika", null);
		this.katedre.add(k);
		k = new Katedra("k2", "Fizika", null);
		this.katedre.add(k);
		k = new Katedra("k3", "Matematika", null);
		this.katedre.add(k);
	}

	public int getColumnCount() {
		 return 2;
	}

	public int getRowCount() {
		return 20;
	}
	
	public List<Katedra> getKatedre() {
		return katedre;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Katedra getRow(int rowIndex) {
		return this.katedre.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		if(row < katedre.size()) {
			Katedra katedra = this.katedre.get(row);
			switch (column) {	
				case 0:
					return katedra.getNaziv_katedre();
				case 1:
					if(katedra.getSef_katedre()==null)
						return "nema šefa";
					return katedra.getSef_katedre().getImeIPrezime();
				default:
					return null;
			}
		} else {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			default:
				return null;
		}
		}
	}
}