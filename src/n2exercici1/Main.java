package n2exercici1;

import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean ok = false;
		while(!ok) {	
			try {
				Entrada.llegirByte("Introdueix la teva edat en Bytes: ");
				ok = true;
				
			}catch(InputMismatchException e) {
				System.out.println("ERROR: " + e.getMessage());
			}finally {
				Entrada.scan.nextLine();
			}
		}
		
		ok=false;
		while(!ok) {	
			try {
				Entrada.llegirInt("Introdueix la teva edat: ");
				ok = true;
				
			}catch(InputMismatchException e) {
				System.out.println("ERROR: " + e.getMessage());
			}finally {
				Entrada.scan.nextLine();
			}
		}
	}

}
