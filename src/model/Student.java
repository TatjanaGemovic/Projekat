package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Student extends Osoba implements Serializable {

	private static final long serialVersionUID = -5255677367858881770L;
	private String broj_indeksa;
	private int god_upisa;
	private int trenutna_god;
	private double prosecna_ocena;
	private Status_Studenta status; 
	//private ArrayList<OcenaNaIspitu> ocene = new ArrayList<OcenaNaIspitu>();
	private ArrayList<OcenaNaIspitu> polozeni_ispiti = new ArrayList<OcenaNaIspitu>();
	//private HashMap<Predmet, Vrednost_Ocene> polozeni_ispiti = new HashMap<Predmet, Vrednost_Ocene>();
	private ArrayList<OcenaNaIspitu> nepolozeni_ispiti = new ArrayList<OcenaNaIspitu>();
	
	public Student(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			String broj_indeksa, int god_upisa, int trenutna_god, Status_Studenta status) {
		super(ime, prezime, datum_rodjenja, adresa, kontakt_tel, email);
		this.broj_indeksa = broj_indeksa;
		this.god_upisa = god_upisa;
		this.trenutna_god = trenutna_god;
		this.status = status;
	}

	public Student(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email) {
		super(ime, prezime, datum_rodjenja, adresa, kontakt_tel, email);
	}

	public String getBroj_indeksa() {
		return broj_indeksa;
	}

	public void setBroj_indeksa(String broj_indeksa) {
		this.broj_indeksa = broj_indeksa;
	}

	public int getGod_upisa() {
		return god_upisa;
	}

	public void setGod_upisa(int god_upisa) {
		this.god_upisa = god_upisa;
	}

	public int getTrenutna_god() {
		return trenutna_god;
	}

	public void setTrenutna_god(int trenutna_god) {
		this.trenutna_god = trenutna_god;
	}

	public double getProsecna_ocena() {
		return prosecna_ocena;
	}

	public void setProsecna_ocena(double prosecna_ocena) {
		this.prosecna_ocena = prosecna_ocena;
	}

	public Status_Studenta getStatus() {
		return status;
	}

	public void setStatus(Status_Studenta status) {
		this.status = status;
	}

	public ArrayList<OcenaNaIspitu> getPolozeni_ispiti() {
		return polozeni_ispiti;
	}

	public void setPolozeni_ispiti(ArrayList<OcenaNaIspitu> polozeni_ispiti) {
		this.polozeni_ispiti = polozeni_ispiti;
	}

	public ArrayList<OcenaNaIspitu> getNepolozeni_ispiti() {
		return nepolozeni_ispiti;
	}

	public void setNepolozeni_ispiti(ArrayList<OcenaNaIspitu> nepolozeni_ispiti) {
		this.nepolozeni_ispiti = nepolozeni_ispiti;
	}

	@Override
	public String toString() {
		return "Student => broj indeksa:" + broj_indeksa + " || god upisa:" + god_upisa + " || trenutna god:" + trenutna_god
				+ " || prosecna ocena:" + prosecna_ocena + " || status:" + status 
				+ " || polozeni ispiti:" + polozeni_ispiti + " || nepolozeni ispiti:" + nepolozeni_ispiti + " || ime:" + ime
				+ " || prezime:" + prezime + " || datum rodjenja:" + datum_rodjenja + " || adresa:" + adresa
				+ " || kontakt tel:" + kontakt_tel + " || email:" + email;
	}
	
	
}
