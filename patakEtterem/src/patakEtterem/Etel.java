package patakEtterem;

public class Etel {

	//azonosito;nev;kategoria_id;egysegar;eladott_mennyiseg
	//osztályváltozók
	
	private String azonosito;
	private String nev;
	private int kategoria_id;
	private int egysegar;
	private int eladott_mennyiseg;

	//konstruktorok
	public Etel(String sor) {
	String[] adatok = sor.split(";");
		this.azonosito = adatok[0];
		this.nev = adatok[1];
		this.kategoria_id = Integer.parseInt(adatok[2]);
		this.egysegar = Integer.parseInt(adatok[3]);
		this.eladott_mennyiseg = Integer.parseInt(adatok[4]);
}
	
	//getKategoriaSzoveg() metódus
	public String getKategoriaSzoveg(int i) {
		String valasz = "";
		switch(this.kategoria_id) {
		
		case 1: valasz = "leves";
		break;
		case 2: valasz = "főétel";
		break;
		case 3: valasz = "desszert";
		break;
		default: valasz = "hiba";
		break;
		}
		return valasz;
	}
	/*
	private String getKategoriaSzovegMasodikMegoldas() {
		String [] lehetosegek= {"hiba","leves", "főétel", "desszert"};
	
		return (kategoria_id >0  && kategoria_id<= lehetosegek.length)? lehetosegek[kategoria_id]: lehetosegek[0];
	}*/
	//getterek

	public String getAzonosito() {
		return azonosito;
	}

	public String getNev() {
		return nev;
	}

	public int getKategoria_id() {
		return kategoria_id;
	}

	public int getEgysegar() {
		return egysegar;
	}

	public int getEladott_mennyiseg() {
		return eladott_mennyiseg;
	}

	//toString
	@Override
	public String toString() {
		return "Etel [azonosito=" + azonosito + ", nev=" + nev + ", kategoria_id=" + kategoria_id + ", egysegar="
				+ egysegar + ", eladott_mennyiseg=" + eladott_mennyiseg + "]";
	}
	
	
	
	
	
}
