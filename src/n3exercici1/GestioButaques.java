package n3exercici1;

import java.util.ArrayList;
import java.util.List;

public class GestioButaques {
	private List<Butaca> butaques;
	
	public GestioButaques() {
		this.butaques = new ArrayList<>();
	}
	
	public List<Butaca> getButaques(){
		return this.butaques;
	}
	
	public void afegirButaca(Butaca butaca) { 
		try {
			int resposta = cercarButaca(butaca.getFila(), butaca.getSeient());
			
			if(resposta < 0) {
				this.butaques.add(butaca);
			}else {
				throw new ExcepcioButacaOcupada("La butaca ja es troba ocupada.");
			}
		}catch(ExcepcioButacaOcupada e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		
	}
	
	public void eliminarButaca(int fila, int seient) {
		try {
			int resposta = cercarButaca(fila, seient);
			
			if(resposta < 0) {
				throw new ExcepcioButacaLliure("La butaca ja es troba lliure.");
			}
			
			this.butaques.remove(resposta);
		}catch(ExcepcioButacaLliure e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	
	public int cercarButaca(int fila, int seient) {
		for (int i = 0; i < this.butaques.size(); i++) {
			Butaca butaca = this.butaques.get(i);
			
			if(butaca.getFila() == fila && butaca.getSeient() == seient) {
				return i;
			}
		}
		
		//no data was found
		return -1;
	}
}
