package n3exercici1;

import java.util.Scanner;

public class Cine {
	private int files;
	private int seients;
	private GestioButaques gestor;
	
	public Cine() {
		gestor = new GestioButaques();
		demanarDadesInicials();
	}
	
	public void demanarDadesInicials() {
		boolean ok = false;
		try (Scanner scan = new Scanner(System.in)) {
			while(!ok) {
				System.out.println("Cuantes fileres té la sala del cinema?");
				try {
					if(scan.hasNextInt()) {
						this.files = scan.nextInt();
					}else {
						throw new Exception("No has introduït un número.");
					}
				}catch(Exception e) {
					System.out.println("ERROR: "+e.getMessage());
				}
				System.out.println("Cuantes butaques hi ha per filera?");
				try {
					if(scan.hasNextInt()) {
						this.seients = scan.nextInt();
					}else {
						throw new Exception("No has introduït un número.");
					}
				}catch(Exception e) {
					System.out.println("ERROR: "+e.getMessage());
				}
			}
		}
	}
	
	public void inciar() {
		int opcio;
		opcio = menu();
		
		switch(opcio) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 0:
		default:
		}
	}
	public int menu() {				
		try(Scanner scan = new Scanner(System.in)){
			while(true) {
				System.out.println("MENÚ:____________________________________________________"
						+ "1.- Mostrar totes les butaques reservades.\r\n"
						+ "\r\n"
						+ "2.- Mostrar les butaques reservades per una persona.\r\n"
						+ "\r\n"
						+ "3.- Reservar una butaca.\r\n"
						+ "\r\n"
						+ "4.- Anul·lar la reserva d’una butaca.\r\n"
						+ "\r\n"
						+ "5.- Anul·lar totes les reserves d’una persona.\r\n"
						+ "\r\n"
						+ "0.- Sortir.\r\n"
						+ "__________________________________________________");

				System.out.println("Escriu el número de la opció desitjada: ");
				try {
					if(scan.hasNextInt()) {
						return scan.nextInt();
					}else {
						throw new Exception("No has introduït un número.");
					}
				}catch(Exception e) {
					System.out.println("ERROR: "+e.getMessage());
				}
			}			
		}
	}
	
	public void mostrarButaques() {
		for()
	}
}
