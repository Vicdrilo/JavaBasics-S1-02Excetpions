package n1exercici1;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
	public static void main(String[] args) {
		//Creem objectes Producte
		Producte escombra = new Producte("Escombra", 14);
		Producte catifa = new Producte("Catifa", 30);
		Producte planta = new Producte("Planta", 12);
		
		//Creem els objectes Vneda un amb contingut a "productes" i l'altre sense
		Venda client1 = new Venda();
		Venda client2 = new Venda();
		Venda client3 = new Venda();
		
		client1.addProduct(planta);
		client1.addProduct(catifa);
		
		client3.addProduct(escombra);
		client3.addProduct(planta);
		client3.addProduct(catifa);
		
		try {
			client1.calcularTotal();
			System.out.println("El preu total és: "+client1.getPreuTotal()+"€");
			client3.calcularTotal();
			System.out.println("El preu total és: "+client3.getPreuTotal()+"€");
			client2.calcularTotal();
			System.out.println("El preu total és: "+client2.getPreuTotal()+"€");
			client1.calcularTotal();
			System.out.println("El preu total és: "+client1.getPreuTotal()+"€");
		}catch(VendaBuidaException e) {
			System.out.println("ERROR: "+e.getMessage());
		}finally{
			try{
				ArrayList<Producte> llistat = (ArrayList<Producte>) client1.getProductes();
				llistat.get(5);
				
			}catch(IndexOutOfBoundsException e) {
				System.out.println("ERROR: "+e.getMessage());
			}
		}
		
		try {
			int[] arr = {1, 2, 3, 4};
			System.out.println("Mostra'm la posició número 5: "+arr[5]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}
