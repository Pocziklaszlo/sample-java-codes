package hu.balkezesek.hazi.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Feladatokbalkezesek {
	
	ArrayList<Jatekos> lista = new ArrayList<> ();
	private int bekertev;
	
	public Feladatokbalkezesek() {
		feladat2();
		feladat3();
		feladatstream3();
	    feladat4();
	//  feladatstream4();
		feladat5();
	//	feladatstream5();
	//  feladat6();
		feladatstream6();
	}
	
	// 2. feladat - beolvasás balkezesek.csv
	private void feladat2() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("balkezesek.csv"));
			String fejlec = br.readLine();
			String sor = br.readLine();
			while(sor != null) {
				lista.add(new Jatekos(sor));
				sor = br.readLine();
			}
			for (Jatekos item : lista) {
				System.out.println(item);
			}
		}
		catch(FileNotFoundException hiba) {
			hiba.getMessage();
		}
		catch(IOException elemihiba) {
			elemihiba.getMessage();
			
		}
		
	}
	
	// 3. feladat - Hány adatsor található az állományban
	private void feladat3() {
		System.out.println("================================================");
		System.out.println("3. feladat: " + lista.size());
	}
	private void feladatstream3() {
		long osszadat = lista.stream().count();
		System.out.println("3. feladat stream: " + osszadat);
	}
	
	// 4. feladat - Azoknak a játékosoknak a nevét + magasságát cm-ben 
		// 1 tizedesjegyre kerekítve (1 inch = 2,54 cm),
		// akik 1999 októberében léptek utoljára pályára
	 private void feladat4() {
		double inch = 2.54;
		//String jatekosNevOktober = lista.get(0).getNev();
		LocalDate d1= LocalDate.of(1999, 9, 30);
		LocalDate d2= LocalDate.of(1999, 11, 1);

		double jatekosCmOktober = lista.get(0).getMagassag() * inch;
		System.out.println("4. feladat: " );
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getUtolso().isAfter(d1) && lista.get(i).getUtolso().isBefore(d2)) {
				//System.out.println("\t" + lista.get(i).getNev() + ", " + lista.get(i).getMagassag() * inch + " cm");
				System.out.printf("\t %s, %.1f cm \n" , lista.get(i).getNev() ,lista.get(i).getMagassag() * inch);
			}
			
		}
		
	}
	 
	private void feladat5() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Kérek egy 1990 és 1999 közötti évszámot: ");
			bekertev = sc.nextInt();
			if(!(bekertev >= 1990 && bekertev <= 1999)) {
				System.out.print("Hibás adat! ");
			}
			
		}			
		while(!(bekertev >= 1990 && bekertev <= 1999)); //mikor kell megismételni a bekérést? 
	}
	
	private void feladatstream6() {
		long db = lista.stream()
						.filter(j -> j.getElso().getYear()<=bekertev && j.getUtolso().getYear() >= bekertev)
						.count();
		double osszegSuly = lista.stream()
				.filter(j -> j.getElso().getYear()<=bekertev && j.getUtolso().getYear() >= bekertev)
				.mapToInt(j -> j.getSuly())
				.sum();
		System.out.printf("6. feladat stream: %.2f font" , osszegSuly / db);
	}
	
	
	

}
