package n3exercici1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cine {
	Scanner scan = new Scanner(System.in);
	private int files;
	private int seients;
	private GestioButaques gestor;
	
	public Cine() {
		gestor = new GestioButaques();
		demanarDadesInicials();
	}
	
	public void demanarDadesInicials() {
		boolean ok = false;
		
			while(!ok) {
				System.out.println("Cuantes fileres té la sala del cinema?");
				try {
					if(scan.hasNextInt()) {
						this.files = scan.nextInt();
						ok = true;
					}else {
						throw new Exception("No has introduït un número.");
					}
				}catch(Exception e) {
					System.out.println("ERROR: "+e.getMessage());
					ok = false;
				}
				System.out.println("Cuantes butaques hi ha per filera?");
				try {
					if(scan.hasNextInt()) {
						this.seients = scan.nextInt();
						ok=true;
					}else {
						throw new Exception("No has introduït un número.");
					}
				}catch(Exception e) {
					System.out.println("ERROR: "+e.getMessage());
					ok=false;
				}
			}
		
	}
	
	public void inciar() {
		int opcio = -1;
		while(opcio != 0) {
		opcio = menu();
		
		switch(opcio) {
		case 1:
			mostrarButaques();
			break;
		case 2:
			mostrarButaquesPersona();
			break;
		case 3:
			reservarButaca();
			break;
		case 4:
			anularReserva();
			break;
		case 5:
			anularReservaPersona();
			break;
		case 0:
			scan.close();
			break;
		default:
			System.out.println("Només has d'introduir un número del 0 al 5.");
		}
		}
	}
	public int menu() {		
		
		while(true) {	
			System.out.println("MENÚ:____________________________________________________\r\n"
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
				scan.nextLine();
			}
						
		}
	}
	
	public void mostrarButaques() {
		int i = 1;
		System.out.println("Número de butaques reservades: "+ gestor.getButaques().size());
		for(Butaca butaca : gestor.getButaques()) {
			System.out.println(i+".- Fila: "+butaca.getFila()+" | Butaca: "+butaca.getSeient()+". \n\n");
			i++;
		}
	}
	
	public void mostrarButaquesPersona() {
		String client = introduirPersona();
		int i = 0;
		String text = "";
		
		for(Butaca butaca : gestor.getButaques()) {
			if(butaca.getClient().equalsIgnoreCase(client)) {
				i++;
				text += i+".- Fila: "+butaca.getFila()+" | Butaca: "+butaca.getSeient()+". \n\n";
			}
		}
		System.out.println("Número de butaques reservades pel client "+client+": "+ i + "\n\n" + text);
	}
	
	public void reservarButaca() {
		try {
			int fila = introduirFila();
			int seient = introduirSeient();
			String client = introduirPersona();
			Butaca b = new Butaca(fila, seient, client);
			for(Butaca butaca : gestor.getButaques()) {
				if (butaca.Equals(b)) {
					throw new ExcepcioButacaOcupada("La butaca "+seient+" de la fila "+fila+" ja és ocupada.");
				}
			}
			gestor.getButaques().add(b);
		}catch(ExcepcioButacaOcupada e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	
	public void anularReserva() {
		try {
			int fila = introduirFila();
			int seient = introduirSeient();
			Butaca b = null;
			for(Butaca butaca : gestor.getButaques()) {
				if(butaca.getFila() == fila && butaca.getSeient() == seient) {
					b = butaca;
				}
			}
			
			if(b != null) {
				gestor.getButaques().remove(b);
			}else {
				throw new ExcepcioButacaLliure("La butaca introduida ja es tobava lliure.");
			}
		}catch(ExcepcioButacaLliure e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	
	public void anularReservaPersona() {
		
		String client = introduirPersona();
		for (int i=0; i<gestor.getButaques().size(); i++) {
			Butaca b = gestor.getButaques().get(i);
			if(b.getClient().equalsIgnoreCase(client)) {
				System.out.println("S'ha anulat la butaca "+b.getSeient()+" de la fila "
						+b.getFila()+" a nom de "+b.getClient()+".");
				gestor.getButaques().remove(i);
				i--;
			}
		}
	}
	
	public String introduirPersona() {
		scan.nextLine();
		while(true) {
			System.out.println("Introdueix el nom de la persona: ");
			String nom = scan.nextLine();
				
			try {
				String[] aux = nom.split("");
				for(int i=0; i<aux.length; i++) {
					if(isNumber(aux[i])) {
						throw new ExcepcioNomPersonaIncorrecte("El format del nom no és correcte. Pot ser que hagis escrit algún número.");
					}
				}
				return nom;
			}catch(ExcepcioNomPersonaIncorrecte e) {
				System.out.println("ERROR: "+e.getMessage());
				scan.nextLine();
			}
			
		}
		
	}
	
	public int introduirFila() {
		while(true) {
			
			System.out.println("Introdueix el número de fila: ");
			int fila = scan.nextInt();
			
			try {
				if(fila>0 && fila<=files) {
					return fila;
				}else {
					throw new ExcepcioFilaIncorrecta("La filera que has d'indrouir ha de trobar-se entre 1 i "+files+".");
				}
				
			}catch(ExcepcioFilaIncorrecta e) {
				System.out.println("ERROR: "+e.getMessage());
				scan.nextLine();
			}
		}
	}
	
	public int introduirSeient() {
		while(true) {
			
			System.out.println("Introdueix el número de seient: ");
			int seient = scan.nextInt();
			
			try {
				if(seient>0 && seient<=seients) {
					return seient;
				}else {
					throw new ExcepcioSeientIncorrecte("El seient que has d'indrouir ha de trobar-se entre 1 i "+seients+".");
				}
					
			}catch(ExcepcioSeientIncorrecte e) {
				System.out.println("ERROR: "+e.getMessage());
				scan.nextLine();
			}
			
		}
	}
	
	
	//Mètode auxiliar
	public boolean isNumber(String letra) {
		try {
			Integer.parseInt(letra);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
