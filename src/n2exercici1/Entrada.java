package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	static Scanner scan = new Scanner(System.in);
	
		
	public static byte llegirByte(String missatge) throws  InputMismatchException {
		System.out.println(missatge);
		return scan.nextByte();
		
	}
	
	public static int llegirInt(String missatge) throws InputMismatchException {
		
		System.out.println(missatge);
		return scan.nextInt();
		
	}
	
	public static float llegirFloat(String missatge) throws InputMismatchException {
		
		System.out.println(missatge);
		return scan.nextFloat();
		
	}

	public static double llegirDouble(String missatge) throws InputMismatchException {
		
		System.out.println(missatge);
		return scan.nextDouble();
		
	}
	
	public static char llegirChar(String missatge) throws Exception {
		
		System.out.println(missatge);
		return scan.next().charAt(0);
		
	}
	
	public static String llegirString(String missatge) throws Exception {
		
		System.out.println(missatge);
		return scan.next();
		
	}
	
	public static boolean llegirSiNo(String missatge) throws Exception {
		
		System.out.println(missatge);
		String answere = scan.next();
		
		if(answere.equalsIgnoreCase("s")) {
			return  true;
		}else {
			return false;
		}
		
	}
}
