package model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import gui.MainFrame;
import gui.MenuBar;

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
	public int id;
	
	public BazaKatedri() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Naziv katedre");
		this.kolone.add("Šef katedre");
		id=0;
		
		initKatedre();
	}
	
	private void initKatedre() {
		this.katedre = new ArrayList<Katedra>();
		
		ObjectInputStream inKatedre = null;
		try {
			inKatedre = new ObjectInputStream(new BufferedInputStream(new FileInputStream(MenuBar.fileKatedre)));
			ArrayList<Katedra> listaKatedri = (ArrayList<Katedra>) inKatedre.readObject();
			for(Katedra katedra : listaKatedri) {
				katedre.add(katedra);
			}	
		} catch (Exception e) {
			e.printStackTrace();
	    } finally {
	            try {
	            	inKatedre.close();
	            } catch (Exception e) {
	    			e.printStackTrace();
	            }
	    }
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
						return "nema �efa";
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
	
	public void dodajKatedru(String sifra,String naziv) {
		Katedra k = new Katedra(id, sifra, naziv, null);
		id++;
		this.katedre.add(k);
	}

	public void initKolone() {
		this.kolone = new ArrayList<String>();
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("naz_kat"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("sef_kat"));
	}
}