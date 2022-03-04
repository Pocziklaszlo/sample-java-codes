package hu.balkezesek.hazi.stream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Jatekos {
	
	// osztályváltozók
	// név;első;utolsó;súly;magasság
	
	private String nev;
	private LocalDate elso;
	private LocalDate utolso;
	private int suly;
	private int magassag;
	
	// konstruktorok
	public Jatekos(String sor) {
		String[] adatok = sor.split(";");
		this.nev = adatok[0];
		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.elso = LocalDate.parse(adatok[1], form);
		this.utolso = LocalDate.parse(adatok[2], form);
		this.suly = Integer.parseInt(adatok[3]);
		this.magassag = Integer.parseInt(adatok[4]);
	}

	// getterek
	public String getNev() {
		return nev;
	}
	
	public LocalDate getElso() {
		return elso;
	}
	
	public LocalDate getUtolso() {
		return utolso;
	}
	
	public int getSuly() {
		return suly;
	}
	
	public int getMagassag() {
		return magassag;
	}
	
	// toString
	@Override
	public String toString() {
		return nev + ", " +  elso + ", " + utolso + ", " + suly + ", " + magassag;
	}
	
	
	
	
	

}
