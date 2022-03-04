package hu.ingatlanproject.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Példafeladat a pdf alapján:
		/*
		List<String> adat = Arrays.asList("sajt","krumpli","padlizsan","dinnye","sajt","paprika","paradicsom","sajt"); 
		List<String> adat2=adat.stream()
							.distinct()
							.filter(etel->etel.length()>3)
							.sorted()
							.map(etel -> "név: " + etel)
							.collect(Collectors.toList());
		
		for (String item : adat2) {
			System.out.println(item);
			
		}
		
		System.out.println(adat.stream()
							.distinct()
							.filter(etel->etel.length()>3)
							.sorted()
							.map(etel -> "név: " + etel)
							.count());
		List<Integer> szamok = Arrays.asList(1,5,4,1,5,4,7,8,3,9);
		
		System.out.println(szamok.stream()
										.distinct()
										.count());
		*/
		
		Feladatok f = new Feladatok();

	}

}
