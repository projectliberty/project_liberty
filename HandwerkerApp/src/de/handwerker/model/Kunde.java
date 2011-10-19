package de.handwerker.model;

import java.io.Serializable;

public class Kunde implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2714222603966093876L;

	String name;
	
	String vorname;
	
	String strasse;
	
	String hausnummer;
	
	Integer plz;
	
	String ort;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public Integer getPlz() {
		return plz;
	}

	public void setPlz(Integer plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	

}
