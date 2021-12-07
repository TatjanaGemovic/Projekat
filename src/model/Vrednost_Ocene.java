package model;

public enum Vrednost_Ocene {
	pet(5), sest(6), sedam(7), osam(8), devet(9), deset(10);
	private final int vrednost;
		
	private Vrednost_Ocene(int vrednost ) {
		this.vrednost = vrednost;
	}
	public int getVrednost() {
		return this.vrednost;
	}
}
