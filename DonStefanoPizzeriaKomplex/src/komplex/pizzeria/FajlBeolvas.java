package komplex.pizzeria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FajlBeolvas {

	public ArrayList<Pizza> fajlBeolvas() {
		ArrayList<Pizza> etelLista = new ArrayList<>();

		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader("pizzeria.csv"));

		
			String fejlec = br.readLine();
			String sor= br.readLine();
			while (sor != null) {

				Pizza etelObj = new Pizza(sor);
				etelLista.add(etelObj);
				sor = br.readLine();
			}
			br.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return etelLista;
	}
}
