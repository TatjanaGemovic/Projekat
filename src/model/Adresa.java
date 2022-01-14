package model;

import java.io.Serializable;

public class Adresa implements Serializable{
	
	private static final long serialVersionUID = 4460400478496790994L;
	private String ulica;
	private String broj;
	private String grad;
	private String drzava;
	
	public Adresa(String ulica, String broj, String grad, String drzava) {
		super();
		this.ulica = ulica;
		this.broj = broj;
		this.grad = grad;
		this.drzava = drzava;
	}

	public Adresa() {
		super();
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrava() {
		return drzava;
	}

	public void setDrava(String drzava) {
		this.drzava = drzava;
	}

	@Override
	public String toString() {
		return "Adresa => ulica:" + ulica + " || broj:" + broj + " || grad:" + grad + " || drzava:" + drzava;
	}
	
	

}
