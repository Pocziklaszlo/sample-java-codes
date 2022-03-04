package patakEtterem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FajlKezeles {
	
	ArrayList<Etel> lista = new ArrayList<>();
	
	public ArrayList<Etel> beolvas() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("patak.csv"));
			String fejlec = br.readLine();
			String sor = br.readLine();
			while(sor!=null) {
				lista.add(new Etel(sor));
				sor = br.readLine();
			}
			
		}
		
		catch(IOException hiba) {
			System.err.println(hiba.getMessage());
		}
			return lista;
	
	}
	

}
