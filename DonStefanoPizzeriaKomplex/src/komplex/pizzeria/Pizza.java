package komplex.pizzeria;

public class Pizza {
	
	// azonosito;nev;egyseg_ar;eladott_db;akcios
	//	osztályváltozók
	private String azonosito;
	private String nev;
	private int egysegAr;
	private int eladottDb;
	private int akcios;
	
	// Konstruktorok
	public Pizza(String sor) {
		String adatok[] = sor.split(";"); 
		this.azonosito = adatok[0];
		this.nev = adatok[1];
		this.egysegAr = Integer.parseInt(adatok[2]);
		this.eladottDb = Integer.parseInt(adatok[3]);
		this.akcios = Integer.parseInt(adatok[4]);
		
	}

	
	// Getterek
	public String getAzonosito() {
		return azonosito;
	}
	
	public String getNev() {
		return nev;
	}
	
	public int getEgysegAr() {
		return egysegAr;
	}
	
	public int getEladottDb() {
		return eladottDb;
	}
	
	public int getAkcios() {
		return akcios;
	}
	
	//toString
	@Override
	public String toString() {
		return "Pizza [azonosito=" + azonosito + ", nev=" + nev + ", egysegAr=" + egysegAr + ", eladottDb=" + eladottDb
				+ ", akcios=" + akcios + "]";
	}
	
	// getAkciosSzovegesen metódus
	public String getAkciosSzovegesen(int i) {
		String valasz = "";
		switch(this.akcios) {
			case 1: valasz = "igen";
			break;
			case 0: valasz = "nem";
			break;
			default: valasz = "hiba";
			break;
		}
		return valasz;
		
		
			
		
	}
	
	
	
	
	
	
	
	
	

}
