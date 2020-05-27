package Model;

import java.util.ArrayList;
import java.util.List;

import Exceptions.PrendaDeEsaCategoriaYaExisteException;
import Exceptions.PrendaIncompletaException;

public class BuilderAtuendo{
	List<Prenda> prendas = new ArrayList<Prenda>();
	
	
	public void agregarPrenda(Prenda prenda){
		if(prendas.stream().anyMatch(p -> p.getCategoria() == prenda.getCategoria()))
			throw new PrendaDeEsaCategoriaYaExisteException();
			
		prendas.add(prenda);
	}
	
	public void validarPrendaCompleta(){
		if(prendas.size() < 4)
			throw new PrendaIncompletaException();
	}
	
	public Atuendo crearAtuendo() {
		validarPrendaCompleta();
		
		return new Atuendo(prendas);
	}
	
	
}
