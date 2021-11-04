package model;

public class OcenaNaIspitu {

	private Student student_polozio;
	private Predmet predmet;
	public double vrednost_ocene; //enum
	private String datum_polaganja;
	
	public OcenaNaIspitu(Student student_polozio, Predmet predmet, int vrednost_ocene, String datum_polaganja) {
		super();
		this.student_polozio = student_polozio;
		this.predmet = predmet;
		this.vrednost_ocene = vrednost_ocene;
		this.datum_polaganja = datum_polaganja;
		//student_polozio.dodaj_polozen_ispit(this); mora da promeni ocenu u studentu
	}
	
}
