package n3exercici1;

public class Butaca {
	private int fila;
	private int seient;
	private String client;
	
	public Butaca(int fila, int seient, String client) {
		this.fila = fila;
		this.seient = seient;
		this.client = client;
	}
	
	//Getters & Setters
	public int getFila() {
		return this.fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	
	public int getSeient() {
		return this.seient;
	}
	public void setSeient(int seient) {
		this.seient = seient;
	}
	
	public String getClient() {
		return this.client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	
	//Methods
	public boolean Equals(Butaca b) {
		if (this.fila == b.fila && this.seient == b.seient){
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Fila: "+this.fila+", Seient: "+this.seient+", Persona: "+this.client+".";
	}
	
}
