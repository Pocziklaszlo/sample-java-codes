package patakEtterem;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;

public class PatakEtterem extends JFrame implements ActionListener{
	 JPanel panel;
	
	 JButton btn_kilep, btn_beolvas, btn_legdragabb, btn_ossz, btn_szazalek, btn_ir, btn_torles;
	 JTable tabla;
	 JScrollPane scrollpane;
	 DefaultTableModel model;
	 FajlKezeles fk;
	 ArrayList<Etel> lista ;
	 
	
	public PatakEtterem() {
		fk = new FajlKezeles();
		init();
		
	}
	
	public void init() {
		this.setTitle("Patak Étterem");
		this.setSize(600,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.panel = (JPanel)(this.getContentPane());
		//this.felulet = this.getContentPane();
		this.setLayout(null);
		
		this.btn_legdragabb = new JButton("Legdrágább desszert");
		this.btn_legdragabb.setBounds(20, 400, 200, 30);
		this.btn_legdragabb.setEnabled(false);
		this.btn_legdragabb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = legdragabbDesszert();
				JOptionPane.showMessageDialog(null,s	);
			}
		});
		
		this.btn_ossz = new JButton("Heti összbevétel");
		this.btn_ossz.setBounds(20, 450, 200, 30);
		this.btn_ossz.setEnabled(false);
		
		this.btn_ossz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = hetiOsszbevetel();
				Label l= new Label();
				l.setBackground(Color.GREEN);
				l.setBounds(225, 450, 70, 30);
				l.setText(s);
				panel.add(l);
				
			}
		});
		
		this.btn_szazalek = new JButton("Ételek százalékosan");
		this.btn_szazalek.setBounds(20, 500, 200, 30);
		this.btn_szazalek.setEnabled(false);
		
		this.btn_szazalek.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = etelekSzazalek();
				JOptionPane.showMessageDialog(null,s);
			}
		});
		
		this.btn_ir = new JButton("Fájlba ír");
		this.btn_ir.setBounds(20, 550, 200, 30);
		this.btn_ir.setEnabled(false);
		
		this.btn_ir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				iras();
				JOptionPane.showMessageDialog(null, "Sikeres fájlbeírás!");
				
			}
		});
		

		this.btn_beolvas = new JButton("Fájl beolvas");
		this.btn_beolvas.setBounds(300, 400, 200, 30);
		
		this.btn_beolvas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TablaRajz();
				lista= fk.beolvas();
				tablaKezeles();
				btn_torles.setEnabled(true);
			}
		});
		

		this.btn_torles = new JButton("Hibás adat törlése");
		this.btn_torles.setBounds(300, 450, 200, 30);
		this.btn_torles.setEnabled(false);
		
		this.btn_torles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				torles();
				tablaKezeles();
				btn_legdragabb.setEnabled(true);
				btn_ossz.setEnabled(true);
				btn_szazalek.setEnabled(true);
				btn_ir.setEnabled(true);
			}
		});
		
		this.btn_kilep = new JButton("KILÉP");
		this.btn_kilep.setBounds(400, 700, 100, 30);
		this.btn_kilep.setBackground(Color.RED);
		this.btn_kilep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		
		
		this.panel.add(btn_legdragabb);
		this.panel.add(btn_ossz);
		this.panel.add(btn_szazalek);
		this.panel.add(btn_ir);
		
		this.panel.add(btn_beolvas);
		this.panel.add(btn_torles);
		this.panel.add(btn_kilep);
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void TablaRajz() {
	   tabla= new JTable();
		lista = fk.beolvas();
		//{""} a fejléc elemei
		model = new DefaultTableModel(new Object[] {"azonosito","nev","kategoria","egysegar","eladott mennyiseg"}, 0);
		//{} konkrét értékekkel feltöltjük a sorokat
		for (Etel item : lista) {
			model.addRow(new Object[] {item.getAzonosito(), item.getNev(), item.getKategoria_id(), item.getEgysegar(), item.getEladott_mennyiseg()});
		}
		tabla.setModel(model);
		
		// hozzáadjuk a táblát a panelhez
		
		// a táblát utána újrarajzoljuk
		panel.repaint();
		/*
		 model = new DefaultTableModel(
				new Object[] { "Azonosító", "Név", "Kategória", "Egységár (Ft)", "Eladott Mennyiség" }, 0);
		for (Etel item : lista) {
			model.addRow(new Object[] { item.getAzonosito(), item.getNev(),
					item.getKategoriaSzoveg(item.getKategoria_id()), item.getEgysegar(),
					item.getEladott_mennyiseg() });
		}

		tabla.setModel(model);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < model.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		*/
		panel.add(tabla);
	}
	private void tablaKezeles() {
		
		Object [] model = new Object[] { "Azonosító", "Név", "Kategória", "Egységár (Ft)", "Eladott Mennyiség" };
		Object [][] obj= new Object[lista.size()][model.length];
	
		for (int i = 0; i < lista.size(); i++) {
			obj[i][0]= lista.get(i).getAzonosito();
			obj[i][1]= lista.get(i).getNev();
			obj[i][2]= lista.get(i).getKategoriaSzoveg(lista.get(i).getKategoria_id());
			obj[i][3]= lista.get(i).getEgysegar();
			obj[i][4]= lista.get(i).getEladott_mennyiseg();
			
		}
	tabla= new JTable(obj, model);
	scrollpane = new JScrollPane(tabla);
	 tabla.setBounds(20,20,600,170);
	 tabla.setFillsViewportHeight(true);		
	 tabla.setAutoCreateRowSorter(true);
	tabla.setAutoResizeMode(10);
	tabla.setFillsViewportHeight(true);
	tabla.setAutoCreateRowSorter(true);
	panel.setLayout(new BorderLayout());
	panel.add(tabla.getTableHeader(), BorderLayout.PAGE_START);
	panel.add(tabla, BorderLayout.CENTER);
	panel.add(tabla);
	panel.repaint();
	}
	//grafikus felület
	

	// 4-es feladat: hibás adat törlése, nem 10 karakterhosszúságú az azonosító
	private void torles() {
		panel.remove(tabla);
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getAzonosito().length() != 10) {
				lista.remove(i);
				i--;				
			}			
		}
		tablaKezeles();
	}
	
	// Melyik a legdrágább desszert? Az eredményt felugró ablakban jelenítse meg (4-es mintakép)!
	
	private String legdragabbDesszert() {
		int i= 0;
		while(i < lista.size() && lista.get(i).getKategoria_id()!=3) {
			i++;
		}
		
		
		String legdragabbDesszertNev = lista.get(i).getNev();
		int legdragabbDesszertAr = lista.get(i).getEgysegar();
		for (Etel item : lista) {
			if(item.getKategoria_id() == 3 && legdragabbDesszertAr < item.getEgysegar()) {
				legdragabbDesszertNev = item.getNev();
				legdragabbDesszertAr = item.getEgysegar();
			}
		}
		return String.format("A legdrágább desszert neve/ egységára: %s/%dft", legdragabbDesszertNev, legdragabbDesszertAr);
	}

	// Mennyi volt a heti összbevétel? Az eredményt a gomb melletti címke komponensben jelenítse meg (5-ös mintakép)!
	
	private String hetiOsszbevetel() {
		int osszbevetel = 0;
		for (Etel item : lista) {
			osszbevetel += item.getEgysegar() * item.getEladott_mennyiseg();
		}
		//return String.format("%d Ft", osszbevetel);
		return osszbevetel+" Ft";
	}
	
	// 7. A rendelt ételek hány százaléka főétel, leves illetve desszert? Az eredményt kerekítés nélkül, 2 tizedes jegyig írjuk ki egy felugró ablakban!
	
	private String etelekSzazalek() {
		String s = "";
		s += String.format("leves : %.2f \n",adottEtelOssz(1)/lista.size() * 100);
		s += String.format("főétel : %.2f \n",adottEtelOssz(2)/lista.size() * 100);
		s += String.format("desszert : %.2f \n",adottEtelOssz(3)/lista.size() * 100);	
		
		return s;
	}
	private double adottEtelOssz(int kategoria_id) {
		double db = 0;
		for (Etel item : lista) {
			if(item.getKategoria_id() == kategoria_id) {
				db++;
			}
			
		}
		return db;
		
		
	}
	
	// 8. Írjuk ki külön fájlba (rendeles.csv) azokat az ételeket, amelyekből 90-nél is többet sikerült eladni! A fájl kódolása UTF-8 legyen és az adatok sorrendje, formátuma az eredeti fájlban lévővel meg kell egyeznie! Amennyiben a fájl létrehozása sikeres, egy felugró ablakban jelenítsük meg az erre vonatkozó üzenetet!
	
	private void iras() {
		try { 
			FileWriter fw = new FileWriter("rendeles.csv");
			for (Etel item : lista) {
				if(item.getEladott_mennyiseg() > 90) {
					fw.write(item.getNev() + "\n");
				}
			}
			fw.close();
		}
		catch(IOException hiba) {
			hiba.getMessage();
		}
	}
}

