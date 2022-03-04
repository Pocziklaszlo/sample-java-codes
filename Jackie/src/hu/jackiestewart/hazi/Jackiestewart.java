package hu.jackiestewart.hazi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Jackiestewart {
	
	// osztályváltozók
	// year		races	wins	podiums		poles	fastests -> tab az elválasztó
	
	// private LocalDate year;
	private int year;
	private int races;
	private int wins;
	private int poles;
	private int fastest;

	// konstruktorok
		public Jackiestewart(String sor) {
			String[] adatok = sor.split("\t");
		// DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy");
		// this.year = LocalDate.parse(adatok[0], form);
		this.year = Integer.parseInt(adatok[0]);
		this.races = Integer.parseInt(adatok[1]);
		this.wins = Integer.parseInt(adatok[2]);
		this.poles = Integer.parseInt(adatok[3]);
		this.fastest = Integer.parseInt(adatok[4]);
	}

	// getterek
	/*	public LocalDate getYear() {
			return year;
		}
		
	*/
		public int getYear() {
			return year;
		}
		public int getRaces() {
			return races;
		}
		
		public int getWins() {
			return wins;
		}
		
		public int getPoles() {
			return poles;
		}
		
		public int getFastest() {
			return fastest;
		}
		

		
		//toString:
		@Override
		public String toString() {
			return year + ", " + races + ", " + wins + ", " + poles +", " + fastest + ", ";
		}
		
		
		
	
	
	

}
