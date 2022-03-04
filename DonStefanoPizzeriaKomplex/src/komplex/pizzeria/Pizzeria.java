package komplex.pizzeria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pizzeria extends JFrame implements ActionListener{ 
	
	private JPanel panel;
	private JButton btn_beolvas, btn_kilep, btn_torles, btn_legdragabb, btn_osszes, btn_dragabb, btn_akcios;
	private JTable tabla;
	private JScrollPane scrollPane;
	private ArrayList<Pizza>lista;
	private Object [][] obj;
	private String[] fejlec;
	private FajlBeolvas fb = new FajlBeolvas();
	private JLabel label;
	
	public Pizzeria() {
		init();
	}
	public void init() {
		this.setTitle("Don Stefano Pizzeria");
		this.setSize(800,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.panel = (JPanel)(this.getContentPane());
		// this.felulet = this.getContentPane();
		this.setLayout(null);
		
		this.btn_beolvas = new JButton("Fájl beolvas");
		this.btn_beolvas.setBounds(500, 350, 170, 30);
		this.btn_beolvas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				lista = fb.fajlBeolvas();
				objectKezeles();
				tablaKezeles();
				
				btn_torles.setEnabled(true);
			}
		});
		
		this.btn_kilep = new JButton("KILÉP");
		this.btn_kilep.setBounds(650, 500, 80, 30);
		this.btn_kilep.setBackground(Color.RED);
		this.btn_kilep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		this.btn_torles = new JButton("Hibás adat törlése");
		this.btn_torles.setBounds(500, 400, 170, 30);
		this.btn_torles.setEnabled(false);
		this.btn_torles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				btn_legdragabb.setEnabled(true);
				btn_osszes.setEnabled(true);
				btn_akcios.setEnabled(true);
				btn_dragabb.setEnabled(true);
				
				torles();
				
			}
		});
		
		this.btn_legdragabb = new JButton("Legdrágább pizza");
		this.btn_legdragabb.setBounds(100, 350, 170, 30);
		this.btn_legdragabb.setEnabled(false);
		this.btn_legdragabb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = legdragabb();
				JOptionPane.showMessageDialog(null,s);

				
			}
		});
		
	
		
		this.btn_osszes = new JButton("Összes bevétel FT");
		this.btn_osszes.setBounds(100, 400, 170, 30);
		this.btn_osszes.setEnabled(false);
		this.btn_osszes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				label = new JLabel();
				label.setBounds(290, 400, 170, 30);
				label.setBackground(Color.GREEN);
				String s = osszes();
				label.setText(s);
				panel.add(label);
				panel.repaint();
			}
		});
		
		this.btn_dragabb = new JButton("Drágább 2500-nál százalék");
		this.btn_dragabb.setBounds(100, 450, 170, 30);
		this.btn_dragabb.setEnabled(false);
		this.btn_dragabb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
			}
		});
		
		this.btn_akcios = new JButton("Akciósak fájlbaír");
		this.btn_akcios.setBounds(100, 500, 170, 30);
		this.btn_akcios.setEnabled(false);
		this.btn_akcios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.panel.add(btn_beolvas);
		this.panel.add(btn_kilep);
		this.panel.add(btn_torles);
		this.panel.add(btn_legdragabb);
		this.panel.add(btn_osszes);
		this.panel.add(btn_dragabb);
		this.panel.add(btn_akcios);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
				
		
	}
	
	private void objectKezeles() {
		obj= new Object[lista.size()][5];
		for (int i = 0; i < lista.size(); i++) {
			obj[i][0]=lista.get(i).getAzonosito();
			obj[i][1]= lista.get(i).getNev();
			obj[i][2]= lista.get(i).getEgysegAr();
			obj[i][3]= lista.get(i).getEladottDb();
			obj[i][4]= lista.get(i).getAkcios();
		}}
	
	private void tablaKezeles() {
		fejlec = new String []{"azonosito", "nev", "egyseg_ar", "eladott_db", "akcios"};
		tabla= new JTable(obj, fejlec);
		 scrollPane = new JScrollPane(tabla);
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
	// Törlés
	private void torles() {
		panel.remove(tabla);
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getAzonosito().length() != 9) {
				lista.remove(i);
				i--;				
			}			
		}
		objectKezeles();
		tablaKezeles();
	}
	
	// Legdrágább pizza
	private String legdragabb() {
		int legdragabb = 0;
		String azonosito = lista.get(0).getAzonosito();
		String nev = lista.get(0).getNev();
		for (Pizza item : lista) {
			if(legdragabb < item.getEgysegAr()) {
				legdragabb = item.getEgysegAr();
				azonosito = item.getAzonosito();
				nev = item.getNev();
			}
		}
		
		return "Legdrágább pizza: " + azonosito + ", név: " + nev + ", egységár: " + legdragabb;
		
				
	}
	
	// Összes bevétel
	private String osszes() {
		int osszes = 0;
		for (Pizza item : lista) {
			osszes += item.getEgysegAr() * item.getEladottDb(); 
		}
		
	return "" + osszes + " Ft";
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
