package Model;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
	List<Prenda> prendas = new ArrayList<>();
	
	public List<Prenda> getPrendas() {
		return prendas;
	}

	public Atuendo(List<Prenda> prendas){
		this.prendas = prendas;
	}
	
	

}
