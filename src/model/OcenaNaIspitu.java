package model;

import java.io.Serializable;
import java.util.Date;


public class OcenaNaIspitu implements Serializable{

	private static final long serialVersionUID = 7012912039507408942L;
	private Student student_polozio;
	private Predmet predmet;
	private Vrednost_Ocene vrednost_ocene; 
	private Date datum_polaganja;

	public OcenaNaIspitu(Student student_polozio, Predmet predmet, Vrednost_Ocene vrednost_ocene, Date datum_polaganja) {
		super();
		this.student_polozio = student_polozio;
		this.predmet = predmet;
		this.vrednost_ocene = vrednost_ocene;
		this.datum_polaganja = datum_polaganja;
	}

	public OcenaNaIspitu() {
		super();
	}

	public Student getStudent_polozio() {
		return student_polozio;
	}

	public void setStudent_polozio(Student student_polozio) {
		this.student_polozio = student_polozio;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Vrednost_Ocene getVrednost_ocene() {
		return vrednost_ocene;
	}

	public void setVrednost_ocene(Vrednost_Ocene vrednost_ocene) {
		this.vrednost_ocene = vrednost_ocene;
	}

	public Date getDatum_polaganja() {
		return datum_polaganja;
	}

	public void setDatum_polaganja(Date datum_polaganja) {
		this.datum_polaganja = datum_polaganja;
	}

	@Override
	public String toString() {
		return "OcenaNaIspitu => student polozio:" + student_polozio + " || predmet:" + predmet + " || vrednost ocene:"
				+ vrednost_ocene.getVrednost() + " || datum polaganja:" + datum_polaganja;
	}
	
	
}
