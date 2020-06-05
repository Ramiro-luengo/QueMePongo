package Model;

import java.util.ArrayList;
import java.util.List;

public class Guardarropas{
	List<Prenda> prendas = new ArrayList<Prenda>();
	
	
	public List<Prenda> getPrendas() {
		return prendas;
	}
	
	public void agregarPrenda(Prenda prenda) {
		prendas.add(prenda);
		
	}
	
	public void removerPrenda(Prenda prenda) {
		prendas.remove(prenda);
	}

	public Guardarropas(List<Prenda> listaDePrendas) {
		this.prendas = listaDePrendas;
	}
}
