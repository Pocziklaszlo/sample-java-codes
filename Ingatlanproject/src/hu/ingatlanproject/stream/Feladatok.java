package hu.ingatlanproject.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Feladatok {
	private ArrayList<Ingatlan> ingatlanLista;
	public Feladatok() {
		Beolvas();
		feladat1();
		feladat2();
		feladat3();
		feladat4();
		feladat5();
		feladat5_2("SACRAMENTO");
		feladat5_3("SACRAMENTO");
		feladat6("SACRAMENTO");
		feladat7("SACRAMENTO");
		feladat8("RIO LINDA");
		feladat9();
		feladat10();
		feladat11();
		feladat12(5);
		feladat13kiiras();
	}
	
	   private void Beolvas() {
	        ingatlanLista= new ArrayList<>();
	    try{
	        BufferedReader r= new BufferedReader(new FileReader("realestatetransactions.csv"));
	        r.readLine();
	        String sor= r.readLine();
	        while(sor != null){
	            ingatlanLista.add(new Ingatlan(sor));
	            sor=r.readLine();
	        }
	      /*  for (Ingatlan item:ingatlanLista  ) {
	            System.out.println(item);
	        }
	        
	        */

	    }catch(IOException e){
	        e.getMessage();
	    }
	    
	   }
	   
	   private void feladat1() {
		   System.out.println("Az eladásra került ingatlanok száma: " + ingatlanLista.stream().count());
	   }
	 
	private void feladat2() {
		  int maximum= ingatlanLista.stream()
					.map(i -> i.getNegyzetMeter())
					.max(Integer::compareTo)
					.get();
		System.out.println("A legnagyobb területű ingatlan: " + maximum);																				
	}
	
	private void feladat3() {
		long osszAr = ingatlanLista.stream()
								.mapToInt(i -> i.getAr())
								.sum();
		System.out.println("Az ingatlaneladások összesített ára: " + osszAr);
	}
	
	private void feladat4() {
		long meretNelkuliek = ingatlanLista.stream()
										.filter(i -> i.getNegyzetMeter() == 0)
										.count();
		
		System.out.println("Ennyi ingatlannak nincs négyzetmétere feltüntetve: " + meretNelkuliek);
	}
	
	private void feladat5() {
		long darab = ingatlanLista.stream()
								.filter(i -> i.getVaros().equals("BUDAPEST"))
								.count();
		System.out.println("Budapest szerepel-e a felosrolt városok között: " + (darab == 0 ? "Nem szerepel" : "Igen, szerepel"  ));
	}
	
	private void feladat5_2(String keresettVaros) {
		long darab = ingatlanLista.stream()
								.filter(i -> i.getVaros().equals(keresettVaros))
								.count();
		System.out.println(keresettVaros + " szerepel-e a felosrolt városok között: " + (darab == 0 ? "Nem szerepel" : "Igen, szerepel"  ));
	}
	
	private void feladat5_3(String keresettVaros) {
		boolean van = ingatlanLista.stream()
									.anyMatch(i -> i.getVaros().equals(keresettVaros));
		
		System.out.println(keresettVaros + " szerepel-e a felosrolt városok között: " + (!van ? "Nem szerepel" : "Igen, szerepel"  ));
	}
	
	private void feladat6(String keresettVaros) {
		long eladasokSzama = ingatlanLista.stream()
										.filter(i -> i.getVaros().equals(keresettVaros))
										.mapToInt(i -> i.getAr())
										.count();
		
		System.out.println("A(z) " + keresettVaros + " összes eladás száma: " + eladasokSzama);
	}
	
	private void feladat7(String keresettVaros) {
		long eladasOssz = ingatlanLista.stream()
										.filter(i -> i.getVaros().equals(keresettVaros))
										.mapToInt(i -> i.getAr())
										.sum();
		
		System.out.println("A(z) " + keresettVaros + " összes eladás értéke: " + eladasOssz);
		
	}
	
	private void feladat8(String keresettVaros) {
		List<Ingatlan> ingatlanEladas = ingatlanLista.stream()
												.filter(i -> i.getVaros().equals(keresettVaros))
												.collect(Collectors.toList());
		for (Ingatlan item : ingatlanEladas) {
			System.out.println(item);
		}
	}
	
	private void feladat9() {
		
		List<String> varosok = ingatlanLista.stream()
								.map(i -> i.getVaros())
								.distinct()
								.sorted()
								.collect(Collectors.toList());
		for (String item : varosok) {
			System.out.println(item);
			
		}
	}
	
	private void feladat10() {
	List<String> ingatlanTipus = ingatlanLista.stream()
									.map(i -> i.getTipus())
									.distinct()
									.toList();
	for (String item : ingatlanTipus) {
		System.out.println(item);
		
	}
	}
	
	private void feladat11() {
		List<Ingatlan> ingatlanLegdragabb = ingatlanLista.stream()
													.sorted( (ing1, ing2) -> -Integer.compare(ing1.getAr(),ing2.getAr()))
													.limit(5)
													.collect(Collectors.toList());
		
		for (Ingatlan item : ingatlanLegdragabb) {
			System.out.println(item);
		}
	}
	
	private void feladat12(int db) {
		
		List<Ingatlan> ingatlanLegolcsobb = ingatlanLista.stream()
													.sorted( (ing1, ing2) -> Integer.compare(ing1.getAr(), ing2.getAr()) )
													.limit(db)
													.collect(Collectors.toList());
		System.out.println("------------------------------------------------------");
		for (Ingatlan item : ingatlanLegolcsobb) {
			System.out.println(item);
			
		}
	}
	private void feladat13kiiras() {
		System.out.println("------------------------------------------------------");
	for(Ingatlan item : ingatlanLista.stream()
						.sorted( (ing1, ing2) -> Integer.compare(ing1.getAr(), ing2.getAr()) )
						.limit(5)
						.toList()) {
		System.out.println(item);
	}
	

	}
}
