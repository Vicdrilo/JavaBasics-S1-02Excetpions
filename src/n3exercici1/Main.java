package n3exercici1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fileres = 0, butaques = 0;
		boolean ok = false;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Incialitzant aplicació...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		while(!ok) {
			System.out.println("Cuantes fileres té la sala del cinema?");
			try {
				if(scan.hasNextInt()) {
					fileres = scan.nextInt();
				}else {
					throw new Exception("No has introduït un número.");
				}
			}catch(Exception e) {
				System.out.println("ERROR: "+e.getMessage());
			}
			System.out.println("Cuantes butaques hi ha per filera?");
			try {
				if(scan.hasNextInt()) {
					butaques = scan.nextInt();
				}else {
					throw new Exception("No has introduït un número.");
				}
			}catch(Exception e) {
				System.out.println("ERROR: "+e.getMessage());
			}
		}
		
	}

}
