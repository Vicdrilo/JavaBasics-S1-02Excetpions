package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	static Scanner scan = new Scanner(System.in);
	
		
	public static byte llegirByte(String missatge) {
		
		byte b;
		while(true) {
			System.out.println(missatge);
			try {
				b = scan.nextByte();
				return b;
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("ERROR: " + e.getMessage());
			}
		}	
	}
	
	public static int llegirInt(String missatge) {
		
		int b;
		while(true) {
			System.out.println(missatge);
			try {
				b = scan.nextInt();
				return b;
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("ERROR: " + e.getMessage());
			}
		}
	}
	
	public static float llegirFloat(String missatge) {
		
		float b;
		while(true) {
			System.out.println(missatge);
			try {
				b = scan.nextFloat();
				return b;
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("ERROR: " + e.getMessage());
			}
		}
		
	}

	public static double llegirDouble(String missatge) {
		
		double b;
		while(true) {
			System.out.println(missatge);
			try {
				b = scan.nextDouble();
				return b;
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("ERROR: " + e.getMessage());
			}
		}
		
	}
	
	public static char llegirChar(String missatge) {
		
		String b;
		while(true) {
			System.out.println(missatge);
			try {
				b = scan.next();
				if(b.length() > 1) {
					throw new Exception("Ha de ser un sol caràcter.");
				}
				
				return b.charAt(0);
				
			}catch(Exception e) {
				scan.nextLine();
				System.out.println("ERROR: " + e.getMessage());
			}
		}
		
	}
	
	public static String llegirString(String missatge) {
		
		String b;
		while(true) {
			System.out.println(missatge);
			try {
				b = scan.next();
				if(!(b instanceof String)) {
					throw new Exception("Ha de ser una paraula.");
				}
				
				return b;
				
			}catch(Exception e) {
				scan.nextLine();
				System.out.println("ERROR: " + e.getMessage());
			}
		}
		
	}
	
	public static boolean llegirSiNo(String missatge) {
		
		String b;
		while(true) {
			System.out.println(missatge);
			try {
				b = scan.next();
				if(b.length() > 1) {
					throw new Exception("Ha de ser un sol caràcter.");
				}
				
				if(b.equalsIgnoreCase("s")) {
					return  true;
				}else if(b.equalsIgnoreCase("n")){
					return false;
				}else {
					throw new Exception("Ha de se 's' o 'n' la resposta.");
				}
				
			}catch(Exception e) {
				scan.nextLine();
				System.out.println("ERROR: " + e.getMessage());
			}
		}
	}
}
