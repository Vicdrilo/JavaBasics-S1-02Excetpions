package n1exercici1;

import java.util.ArrayList;
import java.util.Collection;

public class Venda {
	private Collection<Producte> productes;
	private int preuTotal;
	
	public Venda() {
		productes = new ArrayList<>();
		this.preuTotal=0;
	}
	public Venda(Collection<Producte> productes) {
		this.productes = productes;
		this.preuTotal=0;
	}
	
	public void calcularTotal() throws VendaBuidaException, ArrayIndexOutOfBoundsException{
		
		if(productes==null || productes.size()==0) {
			throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
		}
		this.preuTotal = 0;
			
		for(Producte prod : productes) {
			this.setPreuTotal(this.getPreuTotal() + prod.getPreu());
		}
		
		
	}
	
	public void addProduct(Producte prod) {
		productes.add(prod);
	}
	public Collection<Producte> getProductes(){
		return productes;
	}

	public int getPreuTotal() {
		return preuTotal;
	}

	public void setPreuTotal(int preuTotal) {
		this.preuTotal = preuTotal;
	}
	
}
