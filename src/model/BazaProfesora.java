package model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gui.KatedreJTable;
import gui.MainFrame;
import gui.MenuBar;


public class BazaProfesora{

	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private List<Profesor> profesori;
	private List<Profesor> potencijalni;
	public List<String> kolone;
	public List<String> kolone2;
	
	public BazaProfesora() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Zvanje");
		this.kolone.add("Email");
		
		this.kolone2 = new ArrayList<String>();
		this.kolone2.add(" ");
		
		initProfesori();
	}
	
	private void initProfesori() {
		this.profesori = new ArrayList<Profesor>();
		
		/*@SuppressWarnings("deprecation")
		Date datum = new Date(1970, 25, 04);
		Adresa adresa1 = new Adresa("Futoska", "9", "Novi Sad", "Srbija");
		Adresa adresa2 = new Adresa("NTP", "kabinet 3", "Novi Sad", "Srbija");
		profesori.add(new Profesor("Milan", "Rapaic", datum, adresa1, "0693792839", "rapaicmilan@gmail.com", adresa2, "00081525", "Doktor", 15));
		//profesori.add(new Profesor("Nebojsa", "Ralevic", datum, adresa1, "0693792839", "nralevicn@gmail.com", adresa2, "00081526", "Doktor", 15));
		//profesori.add(new Profesor("Zoran", "Jelicic", datum, adresa1, "0693792839", "zjelicic@gmail.com", adresa2, "00081527", "Doktor", 15));
		profesori.add(new Profesor("Nebojsa", "Ralevic", datum, adresa1, "0693792839", "nralevicn@gmail.com", adresa2, "00081526", "Vanredni", 15));
		profesori.add(new Profesor("Zoran", "Jelicic", datum, adresa1, "0693792839", "zjelicic@gmail.com", adresa2, "00081527", "Redovni", 15));*/
		
		
		ObjectInputStream inProfesori = null;
		try {
			inProfesori = new ObjectInputStream(new BufferedInputStream(new FileInputStream(MenuBar.fileProfesori)));
			ArrayList<Profesor> listaProfesora = (ArrayList<Profesor>) inProfesori.readObject();
			for(Profesor profesor : listaProfesora) {
				profesori.add(profesor);
			}	
		} catch (Exception e) {
			e.printStackTrace();
	    } finally {
	            try {
	            	inProfesori.close();
	            } catch (Exception e) {
	    			e.printStackTrace();
	            }
	    }

	}
	
	
	public int getColumnCount() {
		 return 4;
	}
	
	public int getColumnCount2() {
		 return 1;
	}

	public int getRowCount() {
		return 40;
	}
	
	public List<Profesor> getProfesori() {
		return profesori;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public String getColumnName2(int index) {
		return this.kolone2.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		if(row < profesori.size()) {
			Profesor profesor = this.profesori.get(row);
			switch (column) {
				case 0:
					return profesor.getIme();
				case 1:
					return profesor.getPrezime();
				case 2:
					return profesor.getZvanje();
				case 3:
					return profesor.getEmail();
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
	
	public String getValueAt2(int row, int column) {
		if(row < profesori.size()) {
			Profesor profesor = this.profesori.get(row);
			switch (column) {
				case 0:
					return profesor.getImeIPrezime();
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
	public String getValueAt4(int row, int column) {
		potencijalni = new ArrayList<Profesor>();
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getId_katedre()!=BazaKatedri.getInstance().getRow(KatedreJTable.rowSelectedIndex).getId())
				potencijalni.add(p);
		}
		if(row < potencijalni.size()) {
			Profesor profesor = this.potencijalni.get(row);
			switch (column) {
				case 0:
					return profesor.getImeIPrezime();
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
	public String getValueAt3(int row, int column) {
		potencijalni = new ArrayList<Profesor>();
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getGodine_staza()>=5 && (p.getZvanje().equals("Vanredni") || p.getZvanje().equals("Redovni")))
				potencijalni.add(p);
		}
		if(row < potencijalni.size()) {
			Profesor profesor = this.potencijalni.get(row);
			switch (column) {
				case 0:
					return profesor.getImeIPrezime();
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
	
	public List<Profesor> getPotencijalni() {
		return potencijalni;
	}
	
	public void dodajProfesora(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			Adresa adresa_kancelarije, String broj_licne_karte, String zvanje, int godine_staza) {
		
		this.profesori.add(new Profesor(ime,prezime,datum_rodjenja,adresa,kontakt_tel,email,adresa_kancelarije,broj_licne_karte,zvanje,godine_staza));
	}
	
	public void izmeniProfesora(Profesor p, String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			Adresa adresa_kancelarije, String broj_licne_karte, String zvanje, int godine_staza) {
		
		for (Profesor i : profesori) {
			if(i==p) {
				int index = profesori.indexOf(i);
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatum_rodjenja(datum_rodjenja);
				i.setAdresa(adresa);
				i.setKontakt_tel(kontakt_tel);
				i.setEmail(email);
				i.setAdresa_kancelarije(adresa_kancelarije);
				i.setBroj_licne_karte(broj_licne_karte);
				i.setZvanje(zvanje);
				i.setGodine_staza(godine_staza);
				profesori.set(index, i);
				break;
			}
		}
	}
	
	public void izbrisiProfesora(String licna_karta) {
		for (Profesor i : profesori) {
			if (i.getBroj_licne_karte().equals(licna_karta)) {
				profesori.remove(i);
				break;
			}
		}
	}

	public void initKolone() {
		this.kolone = new ArrayList<String>();
		
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("ime"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("prezime"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("title2"));
		this.kolone.add(MainFrame.getInstance().getResourceBundle().getString("mejl"));
	}

}
