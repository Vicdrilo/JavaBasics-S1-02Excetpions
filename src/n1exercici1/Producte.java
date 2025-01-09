package n1exercici1;

public class Producte {
	private String nom;
	private int preu;
	
	public Producte(String nom, int preu) {
		this.nom=nom;
		this.preu=preu;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public int getPreu() {
		return this.preu;
	}
	public void setPreu(int preu) {
		this.preu=preu;
	}
}
