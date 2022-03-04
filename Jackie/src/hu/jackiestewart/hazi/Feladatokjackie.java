package hu.jackiestewart.hazi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Feladatokjackie {

	// ArrayList létrehozása:
	ArrayList<Jackiestewart> lista = new ArrayList<>();

	// Feladatok meghívása, ami a main-ben teljesen meghívódik:

	public Feladatokjackie() {
		feladat2(); // -LocalDate-ben nem megy a beolvasás
		feladat3();
		feladat4();  // megnézni, eredetileg nem 1967-et adja ki eredményül, a legtöbb verseny akkor volt, 27 db
		feladat5(); 
		feladat6();

	}

	// 2. feladat - beolvasás
	private void feladat2() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("jackie.txt"));
			String fejlec = br.readLine();
			String sor = br.readLine();
			while (sor != null) {
				lista.add(new Jackiestewart(sor));
				sor = br.readLine();
			}
			for (Jackiestewart item : lista) {
				System.out.println(item);

			}
		} catch (FileNotFoundException hiba) {
			hiba.getMessage();
		} catch (IOException elemihiba) {
			elemihiba.getMessage();
		}
	}

	// 3. feladat - hány adatsor van
	private void feladat3() {
		System.out.println("------------------------------------------------");
		System.out.println("3. feladat: " + lista.size());
	}

	// 4. feladat - melyik évben indult el a legtöbb versenyen, nincs holtverseny
	private void feladat4() {
		/* int i = 0;
		int legtobbVerseny = 0;
		int legtobbVersenyEv = lista.get(0).getYear();
		while (i < lista.size() && legtobbVerseny < lista.get(i).getRaces()) {
			 legtobbVersenyEv = lista.get(i).getYear();
			 i++;
			}
		if(i<lista.size()) {
		System.out.println("4. feladat: " + legtobbVersenyEv);
		}
		*/
		int legtobbVerseny = lista.get(0).getRaces();
		int legtobbVersenyEv = lista.get(0).getYear();
		for (int i = 0; i < lista.size(); i++) {
			if(legtobbVerseny < lista.get(i).getRaces()) {
				legtobbVerseny = lista.get(i).getRaces();
				legtobbVersenyEv = lista.get(i).getYear();
			
			}
		}
		System.out.println("4. feladat: " + legtobbVersenyEv);
	}
	
	// 5. feladat - melyik évtized mennyire volt neki sikeres ('60-69: 60-as évek, '70-79: 70-es évek) 
	private void feladat5() {
		int hatvanasGyozelem = 0;
		int hetvenesGyozelem = 0;
		for (Jackiestewart item : lista) {
			if(item.getYear() >= 1960 && item.getYear() <= 1969) {
				hatvanasGyozelem = hatvanasGyozelem + item.getWins();
			}
			else if(item.getYear() >= 1970 && item.getYear() <= 1979) {
				hetvenesGyozelem = hetvenesGyozelem + item.getWins();
			}
		}
		System.out.println("5. feladat: " );
		System.out.println("\t70-es évek: " + hetvenesGyozelem + " megnyert verseny" );
		System.out.println("\t60-as évek: " + hatvanasGyozelem + " megnyert verseny" );
	}
	
	// 6. feladat - létrehozni jackie.html-t, minta szerint formázott táblázatba kiíratni az éveket, versenyeket, győzelmeket
	private void feladat6() {
		
		System.out.println("6. feladat: jackie.html" );
		try {
			FileWriter fw = new FileWriter("jackie2.html");
			fw.write("<!doctype html>\n" + 
			 "<html>\n" +
			 	"\t<head></head>" + 
			 	"\n<style>td { border: 1px solid black;}</style>" +
			 	"\n<body>" +
			 		"\n\t<h1>Jackie Stewart</h1>" +
			 		"\n\t<table>");
			for (Jackiestewart item : lista) {
				fw.write(String.format("<tr><td>%d</td><td>%d</td><td>%d</td></tr>", item.getYear(), item.getRaces(), item.getWins()));
				
			}
			fw.write("/n/t</table>" + 
					"/n/t</body>" +
					"/n/t</html>");
			fw.close();
		}
		catch(IOException hiba) {
			hiba.getMessage();
			
		}
	}
}
